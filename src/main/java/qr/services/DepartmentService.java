package qr.services;

import qr.dtos.DepartmentDto;
import qr.entities.Department;

import java.util.List;

public interface DepartmentService {

    DepartmentDto findDtoById(Long id); //

    Department findById(Long id);

    //BUSCAR TODOS//
    List<DepartmentDto> findAll();

    List<DepartmentDto>findByCompanyId(Long id);

    DepartmentDto save(DepartmentDto newDepartment);

    void update (DepartmentDto updateDepartment);

    void delete(Long id);







}




