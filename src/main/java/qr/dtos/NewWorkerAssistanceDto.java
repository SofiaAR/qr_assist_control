package qr.dtos;

public class NewWorkerAssistanceDto {

    private String rut;
    private String registrationType;
    private Boolean arrival;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    public Boolean getArrival() {
        return arrival;
    }

    public void setArrival(Boolean arrival) {
        this.arrival = arrival;
    }
}
