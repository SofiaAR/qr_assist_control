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

    public WorkerAssistanceDto save(String rut, Long registrationTypeId, Boolean arrival) {

        User user = userService.findByRut(rut);
        if (user == null) {
            throw new IllegalArgumentException("usuario no encontrado por rut :" + rut);
        }
        RegistrationType registrationType = registrationTypeService.findById(registrationTypeId);
        if (registrationType == null) {
            throw new IllegalArgumentException("No se encuentra el tipo de registro por el id :" + registrationTypeId);
        }

        // crear una variable de tipo Userentity que almacene el resultado del metodo findbyrut del user service
        //crear metodo que retorne una entidad

        WorkerAssistance workerAssistanceForSave;

        // variable que tiene asignada el valor que retorna el metodo findByUserAndStartIsNotNullAndEndIsNull
        WorkerAssistance workerAssistanceIsNotEnd = workerAssistanceRepository.findByUserAndEntranceIsNotNullAndOutIsNull(user);

        if (arrival) {

            if (workerAssistanceIsNotEnd != null) {
                throw new RuntimeException("Usuario tiene una sesión activa");
            }
            workerAssistanceForSave = new WorkerAssistance();
            workerAssistanceForSave.setEntrance(LocalDateTime.now());
            workerAssistanceForSave.setUser(user);
            workerAssistanceForSave.setRegistrationType(registrationTypeService.findById(registrationTypeId));
        } else {
            workerAssistanceForSave = workerAssistanceIsNotEnd;
            workerAssistanceForSave.setOut(LocalDateTime.now());
        }
        // falta agregar una propiedad de tipo WorkerAssitenceRepository

        workerAssistanceRepository.save(workerAssistanceForSave);

        return MapperDto.TransformWorkerAssistanceEntityToDto(workerAssistanceForSave);
    }
}
