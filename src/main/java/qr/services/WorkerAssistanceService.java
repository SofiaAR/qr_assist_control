package qr.services;

import java.util.Map;

public interface WorkerAssistanceService {

    String save(String rut, String registrationType, Boolean arrival);

    Long getExtraHourOfUser(String rut);

    Map<String,Integer> findAllWorkersByType();
}
