package qr.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import qr.dtos.WorkerAssistanceDto;
import qr.entities.WorkerAssistance;
import qr.services.WorkerAssistanceService;

@RestController
public class WorkerAssistanceController {

    @Autowired
    private WorkerAssistanceService workerAssistanceService;

    @PostMapping("/save")
    public ResponseEntity<WorkerAssistanceDto> saveWorkerAssistance(
            @RequestParam String rut,
            @RequestParam Long registrationTypeId
    ) {
        WorkerAssistanceDto savedWorkerAssistance = workerAssistanceService.save(rut, registrationTypeId);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedWorkerAssistance);
    }

}
