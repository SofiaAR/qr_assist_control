package qr.dtos;

import java.time.LocalDate;

public class AssistHistoryDto {

    private Long id;
    private String workerRut;
    private Integer workerDocument;
    private LocalDate inDate;
    private LocalDate outDate;
    private Float overTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkerRut() {
        return workerRut;
    }

    public void setWorkerRut(String workerRut) {
        this.workerRut = workerRut;
    }

    public Integer getWorkerDocument() {
        return workerDocument;
    }

    public void setWorkerDocument(Integer workerDocument) {
        this.workerDocument = workerDocument;
    }

    public LocalDate getInDate() {
        return inDate;
    }

    public void setInDate(LocalDate inDate) {
        this.inDate = inDate;
    }

    public LocalDate getOutDate() {
        return outDate;
    }

    public void setOutDate(LocalDate outDate) {
        this.outDate = outDate;
    }

    public Float getOverTime() {
        return overTime;
    }

    public void setOverTime(Float overTime) {
        this.overTime = overTime;
    }
}
