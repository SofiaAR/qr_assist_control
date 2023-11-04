package qr.services;

import qr.dtos.AuthDto;

//solo los metodos publicos
public interface AuthService {

    String login(AuthDto authDto);


}
