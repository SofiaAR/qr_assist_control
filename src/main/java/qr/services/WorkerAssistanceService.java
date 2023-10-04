package qr.services;

import qr.dtos.WorkerAssistanceDto;

public interface WorkerAssistanceService {

    WorkerAssistanceDto save(String rut, Long registrationTypeId);


}
