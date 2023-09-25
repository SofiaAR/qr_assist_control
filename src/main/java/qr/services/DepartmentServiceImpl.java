package qr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qr.Dtos.DepartmentDto;
import qr.entities.Department;
import qr.mapper.MapperDto;
import qr.repositories.DepartmentRepository;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto findDtoById(Long id){
        Optional<Department> departmentEntity = departmentRepository.findById(id);
        if (departmentEntity.isPresent()){
            Department department =departmentEntity.get();
            return MapperDto.convertDepDtoEntityToDto(department);
        }else {
            return null;
        }
    }
    @Override
    public Department findById(Long id){
        Optional<Department> departmentEntity = departmentRepository.findById(id);
        if (departmentEntity.isPresent()){
            Department department =departmentEntity.get();
            return department;
        }else {
            return null;
        }
    }
}

