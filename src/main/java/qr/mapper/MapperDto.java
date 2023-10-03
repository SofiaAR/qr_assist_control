package qr.mapper;

import qr.dtos.CompanyDto;
import qr.dtos.DepartmentDto;
import qr.dtos.RolDto;
import qr.dtos.UserDto;
import qr.entities.Company;
import qr.entities.Department;
import qr.entities.Rol;
import qr.entities.User;

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
        userDto.setContractDate(user.getContractdate());
        userDto.setDepartmentDto(convertDepartmentEntityToDto(user.getDepartment()));
        return userDto;

    }

    public static RolDto convertRolEntityToDto(Rol rol) {
        RolDto rolDto = new RolDto();
        rolDto.setId(rol.getId());
        rolDto.setPosition(rol.getPosition());
        return rolDto;
    }

    public static DepartmentDto convertDepartmentEntityToDto(Department department) {


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
}

