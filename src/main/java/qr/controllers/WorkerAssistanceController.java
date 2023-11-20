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
@RequestMapping("/worker-assistance")
public class WorkerAssistanceController {

    @Autowired
    private WorkerAssistanceService workerAssistanceService;

    @PostMapping("/save")
    public ResponseEntity<String> saveWorkerAssistance(
            @RequestBody NewWorkerAssistanceDto newWorkerAssistanceDto
    ) {
        return ResponseEntity.ok(workerAssistanceService.save(
                newWorkerAssistanceDto.getRut(),
                newWorkerAssistanceDto.getRegistrationType(),
                newWorkerAssistanceDto.getArrival()
        ));
    }

    @PostMapping("/save/manual")
    public ResponseEntity<String> saveManualWorkerAssistance(
            @RequestBody NewWorkerAssistanceDto newWorkerAssistanceDto
    ) {
        return ResponseEntity.ok(workerAssistanceService.save(
                newWorkerAssistanceDto.getRut(),
                newWorkerAssistanceDto.getRegistrationType(),
                newWorkerAssistanceDto.getArrival()
        ));
    }

    @GetMapping("/extra-hours/{rut}")
    public ResponseEntity<Long> saveWorkerAssistance(@PathVariable String rut) {
        return ResponseEntity.ok(workerAssistanceService.getExtraHourOfUser(rut));
    }

}

// MODIFICAR ASISTENCIA

