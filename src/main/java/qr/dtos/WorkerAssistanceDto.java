package qr.dtos;

import java.time.LocalDateTime;

public class WorkerAssistanceDto {

    private Long id;
    private LocalDateTime dateRecord;
    private UserDto userDto;
    private RegistrationTypeDto registrationTypeDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateRecord() {
        return dateRecord;
    }

    public void setDateRecord(LocalDateTime dateRecord) {
        this.dateRecord = dateRecord;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public RegistrationTypeDto getRegistrationTypeDto() {
        return registrationTypeDto;
    }

    public void setRegistrationTypeDto(RegistrationTypeDto registrationTypeDto) {
        this.registrationTypeDto = registrationTypeDto;
    }
}
