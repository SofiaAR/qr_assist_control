package qr.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qr.Dtos.UserDto;
import qr.entities.User;
import qr.mapper.UsermapperDto;
import qr.repositories.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto findById(Long id) {
        Optional<User> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            User user = userEntity.get();
            return UsermapperDto.TransformEntityToDto(user);
        } else {
            return null;
        }
    }

    @Override
    public List<UserDto> FindAll() {
        return null;
    }

    @Override

    public UserDto save(UserDto userDto) {
        User user = new User();

        user.setRut(userDto.getRut());
        user.setNumdocument(userDto.getNumdocument());
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setRol(userDto.getRol());
        user.setContractdate(userDto.getContractdate());
        user.setIddepartment(userDto.getIddepartment());

        /*
        Aqui el metodo save esta guardando el objeto user, y esta retornando una nuevo objeto que tiene los mismos datos del objeto user pero con el nuevo id
         */
        User userSaved = userRepository.save(user);

        userDto.setId(userSaved.getId());

        return userDto;
    }

    @Override
    public void update(UserDto updateUser) {

    }

    @Override
    public void delete(Long id) {

    }


}
