package qr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qr.entities.WorkerAssistance;
import qr.repositories.UserRepository;
import qr.repositories.WorkerAssistanceRepository;

import java.time.LocalDateTime;

// Se debe agregar la anotacion @Service para que spring reconozca el servicio

@Service

public class WorkerAssistanceImpl {

    @Autowired
    private UserService userService;
    @Autowired
    private RegistrationTypeService registrationTypeService;
    @Autowired
    private WorkerAssistanceRepository workerAssistanceRepository;
    @Autowired
    private UserRepository userRepository;

    //Si este metodo lo va a usar el controllador debe retornar un DTO

    public WorkerAssistance save(String rut, Long registrationTypeId) {

        // crear una variable de tipo Userentity que almacene el resultado del metodo findbyrut del user service
        //crear metodo que retorne una entidad

        WorkerAssistance workerAssistance = new WorkerAssistance();
        workerAssistance.setUser(userService.findByRut(rut));
        workerAssistance.setDateRecord(LocalDateTime.now());
        workerAssistance.setRegistrationType(registrationTypeService.findById(registrationTypeId));

        // falta agregar una propiedad de tipo WorkerAssitenceRepository

        workerAssistanceRepository.save(workerAssistance);

        return workerAssistance;
    }


}
