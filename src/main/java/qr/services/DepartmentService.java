package qr.services;

import qr.dtos.DepartmentDto;
import qr.dtos.UserDto;
import qr.entities.Department;

import java.util.List;

public interface DepartmentService {

    DepartmentDto findDtoById(Long id); //

    Department findById(Long id);

    List<DepartmentDto> FindAll();

    DepartmentDto save(DepartmentDto newDepartment);

    void update (DepartmentDto updateDepartment);

    void delete(Long id);


}




