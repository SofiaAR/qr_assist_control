package qr.services;

import java.util.Map;

public interface WorkerAssistanceService {

    String save(String rut, String registrationType, Boolean arrival);

    Long getOverTimeOfUserInCurrentMonth(String rut);

    Map<String,Integer> findAllWorkersByType();

    Map<String, Integer> findAllWorkersByTypeAndWeek();

    Map<String, Integer> getTotalWorkerAssistance();

    Map<String, Integer> getTotalOverTime();
}
