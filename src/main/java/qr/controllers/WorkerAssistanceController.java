package qr.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qr.dtos.NewWorkerAssistanceDto;
import qr.services.WorkerAssistanceService;

import java.util.Map;


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
        return ResponseEntity.ok(workerAssistanceService.getOverTimeOfUserInCurrentMonth(rut));
    }

    @GetMapping("total-hours")
    public ResponseEntity<Map<String,Integer>> totalHourByMonth(){
        Map<String, Integer> allWorkersByType = workerAssistanceService.findAllWorkersByType();
        return ResponseEntity.ok(allWorkersByType);
    }

    @GetMapping("total-over-time")
    public ResponseEntity<Map<String,Integer>> totalOverTime(){
        Map<String, Integer> allWorkersByType = workerAssistanceService.getTotalOverTime();
        return ResponseEntity.ok(allWorkersByType);
    }

    @GetMapping("total-worker-assistance")
    public ResponseEntity<Map<String,Integer>> totalHour(){
        Map<String, Integer> allWorkersByType = workerAssistanceService.getTotalWorkerAssistance();
        return ResponseEntity.ok(allWorkersByType);
    }

}

// MODIFICAR ASISTENCIA

