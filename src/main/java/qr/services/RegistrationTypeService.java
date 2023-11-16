package qr.services;

import qr.dtos.RegistrationTypeDto;
import qr.entities.RegistrationType;

public interface RegistrationTypeService {

    RegistrationTypeDto findByIdDto(Long id);

    RegistrationType findById(Long id);

    RegistrationType findByType(String type);

}
