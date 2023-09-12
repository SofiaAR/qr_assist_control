package qr.mapper;

import qr.Dtos.UserDto;
import qr.entities.User;

public class UsermapperDto {

    public static UserDto TransformEntityToDto (User user){
        if (user == null)
            return null;
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setRut(user.getRut());
        userDto.setNumdocument(user.getNumdocument());
        userDto.setName(user.getName());
        userDto.setLastname(user.getLastname());
        userDto.setRol(user.getRol());
        userDto.setContractdate(user.getContractdate());
        userDto.setIddepartment(user.getIddepartment());
        return userDto;


    }
}
