package qr.dtos;

public class NewWorkerAssistanceDto {

    private String rut;
    private RegistrationTypeDto registrationTypeDto;
    private Boolean arrival;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public RegistrationTypeDto getRegistrationTypeDto() {
        return registrationTypeDto;
    }

    public void setRegistrationTypeDto(RegistrationTypeDto registrationTypeDto) {
        this.registrationTypeDto = registrationTypeDto;
    }

    public Boolean getArrival() {
        return arrival;
    }

    public void setArrival(Boolean arrival) {
        this.arrival = arrival;
    }
}
