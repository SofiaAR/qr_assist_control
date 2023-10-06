package qr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qr.dtos.UserDto;
import qr.entities.User;
import qr.mapper.MapperDto;
import qr.repositories.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private RolService rolService;

    @Override
    public UserDto findByIdDto(Long id) {
        Optional<User> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            User user = userEntity.get();
            return MapperDto.TransformUserEntityToUserDto(user);
        } else {
            return null;
        }
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public UserDto findByRutDto(String rut){
        Optional<User> userRut = userRepository.findByRut(rut);
        if (userRut.isPresent()){
            User user = userRut.get();
            return MapperDto.TransformUserEntityToUserDto(user);
        }else{
            return null;
        }
    }

    @Override
    public User findByRut(String rut) {
        return null;
    }

    @Override
    public List<UserDto> FindAll() {
        return null;
    }

    @Override

    public UserDto save(UserDto userDto) { //renombrar los saves cmo create ( por el crud)
        User user = new User();

        user.setRut(userDto.getRut());
        user.setDocumentNumber(userDto.getNumDocument());
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastName());
        user.setRol(rolService.findById(userDto.getRolDto().getId()));
        user.setContractdate(userDto.getContractDate());
        user.setDepartment(departmentService.findById(userDto.getDepartmentDto().getId()));

        /*
        Aqui el metodo save esta guardando el objeto user, y esta retornando una nuevo objeto que tiene los mismos datos del objeto user pero con el nuevo id
         */
        User userSaved = userRepository.save(user);

        userDto.setId(userSaved.getId());

        return userDto;
    }

    @Override
    public void update(UserDto dataForUpdate) { // y este es cmo guardar pero lo dejare igual como update

        //Ejecutar metodo del repositorio de ususario para obtener un ususario a traves de su id
        Optional<User> optionalUser = userRepository.findById(dataForUpdate.getId());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            user.setName(dataForUpdate.getName());
            user.setRut(dataForUpdate.getRut());
            user.setDocumentNumber(dataForUpdate.getNumDocument());
            user.setLastname(dataForUpdate.getLastName());
            //user.setRol(dataForUpdate.getRolDto());
            //user.setDepartment(dataForUpdate.getDepartmentDto());

            userRepository.save(user);
        }
    }

    @Override
    public void delete(Long id) {
        //se declara variable de tipo optional se carga con los datos que retorna el metodo finbyid
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = new User();
            user = optionalUser.get();
            userRepository.delete(user);
        }
    }

    @Override
    public void deactivateUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setActive(false);//desactiva el usuario
            userRepository.save(user); //Guarda cambios en la BD
        }else{
            throw new IllegalArgumentException("User not found");
        }
    }


}

