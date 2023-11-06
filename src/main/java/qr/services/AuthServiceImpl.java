package qr.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import qr.dtos.AuthDto;
import qr.entities.User;

@Service//anotación de spring ,construye una clase de servicio que conecta a varios repositoriosy agrupa su func.
public class AuthServiceImpl implements AuthService{

    @Autowired//anotación ,habilita la inyeccion automatica de dependencias.
    private UserService userService;

    @Value("${jwt_secret}")
    private String keySecret;

    @Override
    public String login(AuthDto authDto) { /*metodo publico del tipo string llamado login que recibe como parametro
    un objeto de tipo Authdto.
    */

        //String userName = authDto.getUsername(); se asigna a la variable username del tipo string el valor username del objeto authdto
        //String password = authDto.getPassword();

        User user = userService.findByRut(authDto.getUsername()); /*mediante el servicio de usuario que contiene el metodo encontrar por rut se obtiene el usuario
        el cual se asigna a la variable de tipo usario llamado user*/

        if (user == null) { // se crea la condicion que indica q si el usuario es nulo lance una exepcion.
            throw new RuntimeException("no existe");
        }

        if (!authDto.getPassword().equals(user.getPassword())) {// en esta condicion si el pass del authdtoes distinto al q se tiene en la base de datos se lanza la exepcion.
            throw new RuntimeException("invalid pass");
        }

        authDto.setId(user.getId());

       String token = generateToken(authDto);

        return token; // si el us y el pass son validos se retorna un token.

    }



   private String generateToken(AuthDto authDto) {

/*
      String gtoken = Jwts
              .builder()
              .setId(authDto.getId().toString())
              .setSubject(authDto.getUsername())
               .signWith(SignatureAlgorithm.HS512,keySecret.getBytes(StandardCharsets.UTF_8)).compact();
*/

       try {
           Algorithm algorithm = Algorithm.HMAC512(keySecret);
           String token = JWT.create()
                   .withKeyId(authDto.getId().toString())
                   .withSubject(authDto.getUsername())
                   .withIssuer("auth0")
                   .sign(algorithm);

           return token;

       } catch (JWTCreationException exception) {
           throw new RuntimeException("generate token is failed");
       }
   }

   public AuthDto verifyToken(String token){

       try {

           AuthDto authDto = new AuthDto();



           Algorithm algorithm = Algorithm.HMAC512(keySecret);
           JWTVerifier verifier = JWT.require(algorithm)
                   // specify an specific claim validations
                   .withIssuer("auth0")
                   // reusable verifier instance
                   .build();

           DecodedJWT verify = verifier.verify(token);
           authDto.setId(Long.valueOf(verify.getId()));

           return authDto;

       } catch (JWTVerificationException exception){
           throw new RuntimeException("Invalid signature");
       }
   }

}
