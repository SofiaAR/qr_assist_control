package qr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qr.dtos.AuthDto;
import qr.entities.User;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired//anotación ,habilita la inyeccion automatica de dependencias.
    private UserService userService;

    @Autowired
    SecurityFilter securityFilter;

    @Override
    public String login(AuthDto authDto) { /*metodo publico del tipo string llamado login que recibe como parametro
    un objeto de tipo Authdto.
    */

        //String userName = authDto.getUsername(); se asigna a la variable username del tipo string el valor username del objeto authdto
        //String password = authDto.getPassword();

        User user = userService.findByRut(authDto.getUsername()); /*mediante el servicio de usuario que contiene el metodo encontrar por rut se obtiene el usuario
        el cual se asigna a la variable de tipo usario llamado user*/

        if (user == null) { // se crea la condicion que indica q si el usuario es nulo lance una exepcion.
            throw new RuntimeException("usuario no existe");
        }

        if (!authDto.getPassword().equals(user.getPassword())) {// en esta condicion si el pass del authdtoes distinto al q se tiene en la base de datos se lanza la exepcion.
            throw new RuntimeException("invalid pass");
        }

        authDto.setId(user.getId());

        String token = securityFilter.generateToken(authDto);

        return token; // si el us y el pass son validos se retorna un token.

    }


}
