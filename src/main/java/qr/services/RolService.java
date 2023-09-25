package qr.services;

import qr.Dtos.DepartmentDto;
import qr.Dtos.RolDto;
import qr.entities.Department;
import qr.entities.Rol;

public interface RolService {

    RolDto findDtoById(Long id);

    Rol findById(Long id);
}
