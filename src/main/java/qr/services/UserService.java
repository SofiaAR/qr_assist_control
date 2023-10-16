package qr.services;

import qr.dtos.UserDto;
import qr.entities.User;

import java.util.List;


public interface UserService {


    UserDto findByIdDto(Long id);

    User findById(Long id);

    UserDto findByRutDto(String rut);

    User findByRut(String rut);

    List<UserDto> FindAll();

    UserDto save(UserDto newUser);

    void update (UserDto updateUser);

    void delete(Long id);

    void deactivateUser(Long userId);


}
