package qr.services;

import org.springframework.stereotype.Service;
import qr.entities.RegistrationType;
import qr.entities.User;
import qr.entities.WorkerAssistance;
import qr.repositories.UserRepository;
import qr.repositories.WorkerAssistanceRepository;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;

// Se debe agregar la anotacion @Service para que spring reconozca el servicio

@Service
public class WorkerAssistanceImpl implements WorkerAssistanceService {


    private final RegistrationTypeService registrationTypeService;
    private final WorkerAssistanceRepository workerAssistanceRepository;
    private final UserRepository userRepository;

    public WorkerAssistanceImpl(
            RegistrationTypeService registrationTypeService,
            WorkerAssistanceRepository workerAssistanceRepository,
            UserRepository userRepository) {
        this.registrationTypeService = registrationTypeService;
        this.workerAssistanceRepository = workerAssistanceRepository;
        this.userRepository = userRepository;
    }

    //Si este metodo lo va a usar el controllador debe retornar un DTO

    public String save(String rut, String registrationType, Boolean arrival) {

        String message;

        Optional<User> optionalUser = userRepository.findByRut(rut);
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("usuario no encontrado por rut :" + rut);
        }
        RegistrationType registrationTypeFound = registrationTypeService.findByType(registrationType);
        if (registrationTypeFound == null) {
            throw new IllegalArgumentException("No se encuentra el tipo de registro por el tipo :" + registrationTypeFound);
        }

        // crear una variable de tipo Userentity que almacene el resultado del metodo findbyrut del user service
        //crear metodo que retorne una entidad

        WorkerAssistance workerAssistanceForSave;

        // variable que tiene asignada el valor que retorna el metodo findByUserAndStartIsNotNullAndEndIsNull
        WorkerAssistance workerAssistanceIsNotEnd = workerAssistanceRepository.findByUserAndEntranceIsNotNullAndOutIsNull(optionalUser.get());

        if (arrival) {
            if (workerAssistanceIsNotEnd != null) {
                throw new RuntimeException("Usuario tiene una entrada activa");
            }
            workerAssistanceForSave = new WorkerAssistance();
            workerAssistanceForSave.setEntrance(LocalDateTime.now());
            workerAssistanceForSave.setUser(optionalUser.get());
            workerAssistanceForSave.setRegistrationType(registrationTypeFound);
        } else {
            workerAssistanceForSave = workerAssistanceIsNotEnd;
            workerAssistanceForSave.setOut(LocalDateTime.now());
        }
        // falta agregar una propiedad de tipo WorkerAssitenceRepository

        workerAssistanceRepository.save(workerAssistanceForSave);

        if (arrival) {
            message = "Entrada de usuario registrada correctamente";
        } else {
            message = "Salida de usuario registrada correctamente";
        }

        return message;
    }

    @Override
    public Long getExtraHourOfUser(String rut) {

        long totalHours = 0L;
        Optional<User> user = userRepository.findByRut(rut);

        if (user.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime firstDayOfMonth = now.withDayOfMonth(1);

        List<WorkerAssistance> assistances = workerAssistanceRepository.findByUserAndEntranceBetween(user.get(), firstDayOfMonth, now);

        for (WorkerAssistance wa : assistances) {
            long hours = wa.getEntrance().until(wa.getOut(), ChronoUnit.HOURS);

            long difference = hours - 9L;

            if (difference > 0L) {
                totalHours = totalHours + difference;
            }
        }

        return totalHours;
    }

    @Override
    public Map<String, Integer> findAllWorkersByType() {
        try {
            Map<String, Integer> totalHoursMap = new HashMap<>();

            //LLAMAR TODOS LOS USUARIOS-ITERAR POR CADA USUARIO
            List<User> allUsers = userRepository.findAll();
            //ITERACION

            for (int i = 1; i <= 12; i++) {

                int totalHoursPerMonth = 0;

                LocalDateTime firstDayOfMonth = LocalDateTime.now().withMonth(i).withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
                LocalDateTime lastDayOfMonth = YearMonth.from(firstDayOfMonth).atEndOfMonth().atStartOfDay();

                for (User user : allUsers) {

                    int totalHoursForUser = 0;

                    if ("trabajador".equalsIgnoreCase(user.getRol().getName())) {
                        List<WorkerAssistance> workerAssistances = workerAssistanceRepository.findByUserAndEntranceBetween(user, firstDayOfMonth, lastDayOfMonth);
                        for (WorkerAssistance w : workerAssistances) {

                            if (w.getOut() == null) {
                                continue;
                            }

                            long hours = w.getEntrance().until(w.getOut(), ChronoUnit.HOURS); //total horas de una asistencia

                            totalHoursForUser = totalHoursForUser + (int) hours; //se acumulan las horas en la variable totalhours

                        }
                        totalHoursPerMonth = totalHoursPerMonth + totalHoursForUser;
                    }
                }
                String month = firstDayOfMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ES"));
                totalHoursMap.put(month, totalHoursPerMonth);
            }
            return totalHoursMap;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }


}


