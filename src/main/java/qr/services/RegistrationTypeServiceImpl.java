package qr.services;

import org.springframework.stereotype.Service;
import qr.dtos.RegistrationTypeDto;
import qr.dtos.UserDto;
import qr.entities.RegistrationType;
import qr.entities.User;

@Service
public class RegistrationTypeServiceImpl implements RegistrationTypeService {


    @Override
    public RegistrationTypeDto findByIdDto(Long id) {
        return null;
    }

    @Override
    public RegistrationType findById(Long id) {
        return null;
    }
}
