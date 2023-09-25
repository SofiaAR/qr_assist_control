package qr.mapper;

import qr.Dtos.DepartmentDto;
import qr.Dtos.RolDto;
import qr.Dtos.UserDto;
import qr.entities.Department;
import qr.entities.Rol;
import qr.entities.User;

public class MapperDto {

    public static UserDto TransformUserEntityToUserDto(User user){
        if (user == null)
            return null;
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setRut(user.getRut());
        userDto.setNumDocument(user.getNumdocument());
        userDto.setName(user.getName());
        userDto.setLastName(user.getLastname());
        userDto.setRolDto(convertRolEntityToDto(user.getRol()));
        userDto.setContractDate(user.getContractdate());
       userDto.setDepartmentDto(convertDepDtoEntityToDto(user.getDepartment()));
        return userDto;

    }

    public static RolDto convertRolEntityToDto(Rol rol){
        RolDto rolDto = new RolDto();
        rolDto.setId(rol.getId());
        rolDto.setPosition(rol.getPosition());
        return rolDto;
    }

    public static DepartmentDto convertDepDtoEntityToDto(Department department){
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(departmentDto.getId());
        departmentDto.setDepartment(departmentDto.getDepartment());
        departmentDto.setIdaccount(departmentDto.getIdaccount());

        return departmentDto;
    }

}

