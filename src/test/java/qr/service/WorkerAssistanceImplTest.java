package qr.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import qr.entities.RegistrationType;
import qr.entities.User;
import qr.repositories.RegistrationTypeRepository;
import qr.repositories.UserRepository;
import qr.repositories.WorkerAssistanceRepository;
import qr.services.RegistrationTypeService;
import qr.services.RegistrationTypeServiceImpl;
import qr.services.WorkerAssistanceImpl;
import qr.services.WorkerAssistanceService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = WorkerAssistanceService.class)
public class WorkerAssistanceImplTest {


    @MockBean
    WorkerAssistanceRepository workerAssistanceRepository;
    @MockBean
    UserRepository userRepository;
    @MockBean
    RegistrationTypeRepository registrationTypeRepository;

    WorkerAssistanceImpl service;

    @BeforeEach
    void init() {
        RegistrationTypeService registrationTypeService = new RegistrationTypeServiceImpl(registrationTypeRepository);
        service = new WorkerAssistanceImpl(
                registrationTypeService,
                workerAssistanceRepository,
                userRepository
        );
    }


    @Test
    public void SaveIsOk() {
        User user = new User();
        user.setRut("123456789");
        user.setName("test");
        user.setLastName("test");
        user.setId(1L);

        RegistrationType registrationType = new RegistrationType();
        registrationType.setId(1L);
        registrationType.setType("QR");

        when(userRepository.findByRut("123456789")).thenReturn(Optional.of(user));
        when(registrationTypeRepository.findByType("QR")).thenReturn(Optional.of(registrationType));
        when(workerAssistanceRepository.findByUserAndEntranceIsNotNullAndOutIsNull(user)).thenReturn(null);

        String result = service.save(user.getRut(), "QR", true);

        assertEquals("Entrada de usuario registrada correctamente", result);
    }

    @Test
    public void RegistrationTypeNotFound() {
        User user = new User();
        user.setRut("123456789");
        user.setName("test");
        user.setLastName("test");
        user.setId(1L);

        when(userRepository.findByRut("123456789")).thenReturn(Optional.of(user));

        when(workerAssistanceRepository.findByUserAndEntranceIsNotNullAndOutIsNull(user)).thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> service.save(user.getRut(), "QR", true));
    }


}
