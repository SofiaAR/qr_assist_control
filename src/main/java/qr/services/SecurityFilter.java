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
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

@Component//anotación de spring ,construye una clase de servicio que conecta a varios repositoriosy agrupa su func.
public class SecurityFilter extends OncePerRequestFilter {


    @Value("${jwt_secret}")
    private String keySecret;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        AuthDto authDto = null;
        try {
            authDto = verifyToken(request);
            if (authDto != null) { //

            } else {
                //no autorizado
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        filterChain.doFilter(request, response);
    }


    public String generateToken(AuthDto authDto) {
        try {
            Algorithm algorithm = getAlgorithm();
            String token = JWT.create()
                    .withKeyId(authDto.getId().toString())
                    .withSubject(authDto.getUsername())
                    .withIssuer("auth0")
                    .sign(algorithm);

            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("generate token is failed");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public AuthDto verifyToken(HttpServletRequest request) throws Exception {

        AuthDto authDto = new AuthDto();

        String tokenFromHeader = request.getHeader("Authorization");
        if (tokenFromHeader != null) {
            String token = tokenFromHeader.replace("Bearer ", "");
            Algorithm algorithm = getAlgorithm();
            JWTVerifier verifier = JWT.require(algorithm)
                    // specify an specific claim validations
                    .withIssuer("auth0")
                    // reusable verifier instance
                    .build();

            DecodedJWT verify = verifier.verify(token);
            authDto.setId(Long.valueOf(verify.getId()));

            return authDto;

        } else {
            return null;
        }

    }

    public Algorithm getAlgorithm() throws Exception {

        File rsaPvt = new File("src/main/resources/id_rsa.key");
        File rsaPub = new File("src/main/resources/id_rsa.pub");


        return Algorithm.RSA256(readX509PublicKey(rsaPub), readPKCS8PrivateKey(rsaPvt));
    }

    public static RSAPublicKey readX509PublicKey(File file) throws Exception {
        KeyFactory factory = KeyFactory.getInstance("RSA");

        try (FileReader keyReader = new FileReader(file);
             PemReader pemReader = new PemReader(keyReader)) {

            PemObject pemObject = pemReader.readPemObject();
            byte[] content = pemObject.getContent();
            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(content);
            return (RSAPublicKey) factory.generatePublic(pubKeySpec);
        }
    }

    public RSAPrivateKey readPKCS8PrivateKey(File file) throws Exception {
        KeyFactory factory = KeyFactory.getInstance("RSA");

        try (FileReader keyReader = new FileReader(file);
             PemReader pemReader = new PemReader(keyReader)) {

            PemObject pemObject = pemReader.readPemObject();
            byte[] content = pemObject.getContent();
            PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(content);
            return (RSAPrivateKey) factory.generatePrivate(privKeySpec);
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");

        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();

        Key pub = kp.getPublic();
        Key pvt = kp.getPrivate();

        String outFile = "src/main/resources/rsa";
        FileOutputStream out = new FileOutputStream(outFile + ".key");
        out.write(pvt.getEncoded());
        out.close();

        out = new FileOutputStream(outFile + ".pub");
        out.write(pub.getEncoded());
        out.close();


    }

}
