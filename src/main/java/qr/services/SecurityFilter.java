package qr.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.codec.binary.Base64;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import qr.dtos.AuthDto;
import qr.entities.User;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.List;

@Component//anotación de spring ,construye una clase de servicio que conecta a varios repositoriosy agrupa su func.
public class SecurityFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            if (!request.getMethod().equals(HttpMethod.OPTIONS.name())
                    && !(request.getRequestURI().equals("/worker-assistance/save")
                    || request.getRequestURI().equals("/auth/login"))
            ) {
                String token = getTokenFromRequest(request);
                verifyToken(token);
                filterChain.doFilter(request, response);
                return;
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static String generateToken(AuthDto authDto) {
        try {
            Algorithm algorithm = getAlgorithm();
            return JWT.create()
                    .withKeyId(authDto.getId().toString())
                    .withSubject(authDto.getUsername())
                    .withIssuer("auth0")
                    .withExpiresAt(new Date((new Date()).getTime() + 3600000))
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("generate token is failed");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getTokenFromRequest(HttpServletRequest request) {
        String tokenFromHeader = request.getHeader("Authorization");
        if (tokenFromHeader != null) {
            return tokenFromHeader.replace("Bearer ", "");
        } else {
            return null;
        }
    }


    public static AuthDto verifyToken(String token) throws Exception {

        AuthDto authDto = new AuthDto();

        Algorithm algorithm = getAlgorithm();
        JWTVerifier verifier = JWT.require(algorithm)
                // specify an specific claim validations
                .withIssuer("auth0")
                // reusable verifier instance
                .build();

        DecodedJWT verify = verifier.verify(token);
        authDto.setId(Long.valueOf(verify.getKeyId()));

        return authDto;


    }

    public static Algorithm getAlgorithm() throws Exception {
        return Algorithm.RSA256(loadRsaPublicKey(), loadRsaPrivateKey());
    }

    public static RSAPublicKey loadRsaPublicKey() throws Exception {
        File rsaPub = new File("src/main/resources/key.pub");
        byte[] publicKeyBytes = Files.readAllBytes(rsaPub.toPath());
        KeyFactory publicKeyFactory = KeyFactory.getInstance("RSA");
        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        PublicKey publicKey = publicKeyFactory.generatePublic(publicKeySpec);
        return (RSAPublicKey) publicKey;
    }

    public static RSAPrivateKey loadRsaPrivateKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        File privateKeyFile = new File("src/main/resources/key");
        byte[] privateKeyBytes = Files.readAllBytes(privateKeyFile.toPath());

        KeyFactory privateKeyFactory = KeyFactory.getInstance("RSA");
        EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        return (RSAPrivateKey) privateKeyFactory.generatePrivate(privateKeySpec);
    }


    public static void main(String[] args) throws Exception {
        List<String> ar = List.of(args);

        for (String value : ar) {
            System.out.println(value);
        }

        AuthDto authDto = new AuthDto();
        authDto.setId(2L);
        authDto.setUsername("174613311");

        String generateToken = generateToken(authDto);
        System.out.println(generateToken);


        AuthDto authDtos = verifyToken(generateToken);
        System.out.println(authDtos.getId());
    }

}
