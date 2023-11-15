package qr.services;

import qr.dtos.AuthDto;

public interface AuthenticationService {

    String login(AuthDto authDto);
}
