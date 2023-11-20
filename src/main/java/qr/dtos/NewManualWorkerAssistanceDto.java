package qr.dtos;

public class NewManualWorkerAssistanceDto {

    private String rut;
    private Boolean arrival;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Boolean getArrival() {
        return arrival;
    }

    public void setArrival(Boolean arrival) {
        this.arrival = arrival;
    }
}
