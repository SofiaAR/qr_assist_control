package qr.services;

public interface WorkerAssistanceService {

    String save(String rut, String registrationType, Boolean arrival);


    Long getExtraHourOfUser(String rut);
}
