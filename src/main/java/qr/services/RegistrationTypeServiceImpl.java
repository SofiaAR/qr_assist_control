package qr.services;

import org.springframework.stereotype.Service;
import qr.dtos.RegistrationTypeDto;
import qr.entities.RegistrationType;
import qr.repositories.RegistrationTypeRepository;

import java.util.Optional;

@Service
public class RegistrationTypeServiceImpl implements RegistrationTypeService {


    private final RegistrationTypeRepository registrationTypeRepository;

    public RegistrationTypeServiceImpl(RegistrationTypeRepository registrationTypeRepository) {
        this.registrationTypeRepository = registrationTypeRepository;
    }

    @Override
    public RegistrationTypeDto findByIdDto(Long id) {
        return null;
    }

    @Override
    public RegistrationType findById(Long id) {
        Optional<RegistrationType> registrationTypeEntity = registrationTypeRepository.findById(id);
        if (registrationTypeEntity.isPresent()) {
            return registrationTypeEntity.get();
        } else {
            return null;
        }
    }

    @Override
    public RegistrationType findByType(String type) {
        return registrationTypeRepository.findByType(type).orElse(null);
    }
}