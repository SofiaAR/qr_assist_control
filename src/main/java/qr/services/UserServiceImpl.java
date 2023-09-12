package qr.services;

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
    public UserDto findById(Long id){
       Optional<User> userEntity = userRepository.findById(id);
       if (userEntity.isPresent()){
           User user = userEntity.get();
           return UsermapperDto.TransformEntityToDto(user);
       }
       else {
           return null;
       }
    }

    @Override
    public List<UserDto> FindAll() {
        return null;
    }

    @Override
    public UserDto save(UserDto newUser) {
        return null;
    }

    @Override
    public void update(UserDto updateUser) {

    }

    @Override
    public void delete(Long id) {

    }


}
