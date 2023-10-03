package qr.services;

import qr.dtos.RolDto;
import qr.entities.Rol;

public interface RolService {

    RolDto findDtoById(Long id);

    Rol findById(Long id);
}
