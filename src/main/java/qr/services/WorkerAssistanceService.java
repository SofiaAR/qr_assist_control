package qr.services;

import qr.dtos.WorkAssistanceDto;

public interface WorkerAssistanceService {

    WorkAssistanceDto save(String rut, Long registrationTypeId);


}
