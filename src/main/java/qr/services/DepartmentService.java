package qr.services;

import qr.Dtos.DepartmentDto;
import qr.entities.Department;

public interface DepartmentService {

    DepartmentDto findDtoById(Long id);

    Department findById(Long id);
}




