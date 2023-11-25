package qr.mapper;

import qr.dtos.*;
import qr.entities.*;

import java.util.ArrayList;
import java.util.List;

public class MapperDto {

    public static UserDto TransformUserEntityToUserDto(User user) {
        if (user == null)
            return null;
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setRut(user.getRut());
        userDto.setNumDocument(user.getDocumentNumber());
        userDto.setName(user.getName());
        userDto.setLastName(user.getLastname());
        userDto.setRolDto(convertRolEntityToDto(user.getRol()));
        userDto.setContractDate(user.getContractDate());
        userDto.setDepartmentDto(convertDepartmentEntityToDto(user.getDepartment()));
        return userDto;

    }

    public static RolDto convertRolEntityToDto(Rol rol) {
        if (rol == null) {
            return null;
        }
        RolDto rolDto = new RolDto();
        rolDto.setId(rol.getId());
        rolDto.setName(rol.getName());
        return rolDto;
    }

    public static DepartmentDto convertDepartmentEntityToDto(Department department) {
        if (department == null) {
            return null;
        }
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setName(department.getName());
        return departmentDto;
    }

    public static CompanyDto convertCompanyEntityToDto(Company company) {


        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        companyDto.setRut(company.getRut());
        companyDto.setTurn(company.getTurn());

        return companyDto;

    }

    public static RegistrationTypeDto convertRegistrationTypeEntityToDto(RegistrationType registrationType) {
        RegistrationTypeDto registrationTypeDto = new RegistrationTypeDto();

        registrationTypeDto.setId(registrationTypeDto.getId());
        registrationTypeDto.setType(registrationTypeDto.getType());
        registrationTypeDto.setDescription(registrationTypeDto.getDescription());

        return registrationTypeDto;
    }

    public static WorkerAssistanceDto TransformWorkerAssistanceEntityToDto(WorkerAssistance workerAssistance) {

        WorkerAssistanceDto workerAssistanceDto = new WorkerAssistanceDto();
        workerAssistanceDto.setId(workerAssistance.getId());
        workerAssistanceDto.setDateRecord(workerAssistanceDto.getDateRecord());
        workerAssistanceDto.setUserDto(TransformUserEntityToUserDto(workerAssistance.getUser()));
        workerAssistanceDto.setRegistrationTypeDto(convertRegistrationTypeEntityToDto(workerAssistance.getRegistrationType()));//crear mapper de registrationtype

        return workerAssistanceDto;

    }

    public static List<UserDto> TransformListUserToListUserDto(List<User> allUsers) {

        List<UserDto> users = new ArrayList<>(); //lista vacia
        for (User u : allUsers) {
            UserDto userDto = TransformUserEntityToUserDto(u);
            users.add(userDto);
        }

        return users;
    }

}

