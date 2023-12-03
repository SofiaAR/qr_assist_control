package qr.services;

import qr.dtos.NewUserRequestDto;
import qr.dtos.UserDto;
import qr.entities.User;

import java.util.List;


public interface UserService {


    UserDto findByIdDto(Long id);

    User findById(Long id);

    UserDto findByRutDto(String rut);

    User findByRut(String rut);

    List<UserDto> FindAll();

    void save(NewUserRequestDto userDto);

    void update (NewUserRequestDto dataForUpdate);

    void delete(Long id);

    void deactivateUser(Long userId);


}
