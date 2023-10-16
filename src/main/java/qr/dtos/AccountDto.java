package qr.dtos;

import qr.entities.TypeAccount;

public class AccountDto {

    private Long id;
    private String name;
    private String password;
    private TypeAccountDto typeAccountDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TypeAccountDto getTypeAccountDto() {
        return typeAccountDto;
    }

    public void setTypeAccountDto(TypeAccountDto typeAccountDto) {
        this.typeAccountDto = typeAccountDto;
    }
}
