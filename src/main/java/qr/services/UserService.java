package qr.services;
import qr.Dtos.UserDto;
import java.util.List;



public interface UserService {

    UserDto findById (Long id);
    List<UserDto> FindAll();
    UserDto save(UserDto newUser);
    void update (UserDto updateUser);
    void delete(Long id);



}
