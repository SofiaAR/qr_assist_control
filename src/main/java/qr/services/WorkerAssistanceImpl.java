package qr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qr.dtos.WorkerAssistanceDto;
import qr.entities.RegistrationType;
import qr.entities.User;
import qr.entities.WorkerAssistance;
import qr.mapper.MapperDto;
import qr.repositories.UserRepository;
import qr.repositories.WorkerAssistanceRepository;

import java.time.LocalDateTime;

// Se debe agregar la anotacion @Service para que spring reconozca el servicio

@Service
public class WorkerAssistanceImpl implements WorkerAssistanceService {

    @Autowired
    private UserService userService;
    @Autowired
    private RegistrationTypeService registrationTypeService;
    @Autowired
    private WorkerAssistanceRepository workerAssistanceRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentService departmentService;

    //Si este metodo lo va a usar el controllador debe retornar un DTO

    public String save(String rut, String registrationType, Boolean arrival) {

        String message;

        User user = userService.findByRut(rut);
        if (user == null) {
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
        WorkerAssistance workerAssistanceIsNotEnd = workerAssistanceRepository.findByUserAndEntranceIsNotNullAndOutIsNull(user);

        if (arrival) {

            if (workerAssistanceIsNotEnd != null) {
                throw new RuntimeException("Usuario tiene una entrada activa");
            }
            workerAssistanceForSave = new WorkerAssistance();
            workerAssistanceForSave.setEntrance(LocalDateTime.now());
            workerAssistanceForSave.setUser(user);
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
}
