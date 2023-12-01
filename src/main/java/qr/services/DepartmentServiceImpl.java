package qr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qr.dtos.DepartmentDto;
import qr.entities.Department;
import qr.mapper.MapperDto;
import qr.repositories.DepartmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private CompanyService companyService;

    @Override
    public DepartmentDto findDtoById(Long id) {
        Optional<Department> departmentEntity = departmentRepository.findById(id);
        if (departmentEntity.isPresent()) {
            Department department = departmentEntity.get();
            return MapperDto.convertDepartmentEntityToDto(department);
        } else {
            return null;
        }
    }

    @Override
    public Department findById(Long id) {
        Optional<Department> departmentEntity = departmentRepository.findById(id);
        if (departmentEntity.isPresent()) {
            Department department = departmentEntity.get();
            return department;
        } else {
            return null;
        }
    }

    //BUSCAR TODOS//
    @Override
    public List<DepartmentDto> findAll() {
    return departmentRepository.findAll().stream().map(MapperDto::convertDepartmentEntityToDto)
            .collect(Collectors.toList());
    };

    //BUSCAR POR ID DE COMPAÑIA

    @Override
    public List<DepartmentDto>findByCompanyId(Long id ){
        List<Department> departments = departmentRepository.findAllByCompanyId(id);
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        for (Department departmentEntity : departments){
            DepartmentDto departmentDto = MapperDto.convertDepartmentEntityToDto(departmentEntity);
            departmentDtos.add(departmentDto);
        }
        return departmentDtos;
    }

    //GUARDAR//
    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {
        Department department = new Department();

        department.setId(departmentDto.getId());
        department.setName(department.getName());
        // Asigna la compañía correspondiente a partir del DTO
        department.setCompany(companyService.findById(departmentDto.getCompanyDto().getId()));

        // Guarda la entidad en el repositorio

        Department savedDepartment = departmentRepository.save(department);

        // actualiza la entidad en el repo
        departmentDto.setId(savedDepartment.getId());

        return departmentDto;

    }


    //ACTUALIZAR//

    @Override
    public void update(DepartmentDto departmentDto) {
        Optional<Department> existingDepartment = departmentRepository.findById(departmentDto.getId());
        if (existingDepartment.isPresent()) {
            Department updateDepartment = existingDepartment.get();
            updateDepartment.setName(departmentDto.getName());
            //no creo que deba ir esta linea, a nivel de negocio, para que le asignaría al departamento una nueva compañia?
            //updateDepartment.setCompany(companyService.findById(departmentDto.getCompanyDto().getId()));

            departmentRepository.save(updateDepartment);
        }
    }


    //BORRAR//
        @Override
        public void delete (Long id){
            //se declara variable de tipo optional se carga con los datos que retorna el metodo finbyid
            Optional<Department> optionalUser = departmentRepository.findById(id);

            if (optionalUser.isPresent()) {
                Department department = new Department();
                department = optionalUser.get();
                departmentRepository.delete(department);
            }
        }



}

