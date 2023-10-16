package qr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qr.dtos.RolDto;
import qr.entities.Rol;
import qr.mapper.MapperDto;
import qr.repositories.RolRepository;

import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public RolDto findDtoById(Long id) {
        Optional<Rol> rolEntity = rolRepository.findById(id);
        if (rolEntity.isPresent()) {
            Rol rol = rolEntity.get();
            return MapperDto.convertRolEntityToDto(rol);
        } else {
            return null;
        }
    }

    @Override
    public Rol findById(Long id) {
        Optional<Rol> rolEntity = rolRepository.findById(id);
        if (rolEntity.isPresent()) {
            Rol rol = rolEntity.get();
            return rol;
        } else {
            return null;
        }
    }
}
