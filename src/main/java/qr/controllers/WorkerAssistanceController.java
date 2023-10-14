package qr.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qr.dtos.NewWorkerAssistanceDto;
import qr.dtos.WorkerAssistanceDto;
import qr.entities.WorkerAssistance;
import qr.services.WorkerAssistanceService;


@RestController
@RequestMapping("/workerAssistance")
public class WorkerAssistanceController {

    @Autowired
    private WorkerAssistanceService workerAssistanceService;

    @PostMapping("/save")
    public ResponseEntity<WorkerAssistanceDto> saveWorkerAssistance(
            @RequestBody NewWorkerAssistanceDto newWorkerAssistanceDto
    ) {
        WorkerAssistanceDto savedWorkerAssistance = workerAssistanceService.save(newWorkerAssistanceDto.getRut(),newWorkerAssistanceDto.getRegistrationTypeDto().getId(),newWorkerAssistanceDto.getArrival());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedWorkerAssistance);
    }

}

// MODIFICAR ASISTENCIA

