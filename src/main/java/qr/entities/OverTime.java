package qr.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class OverTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rutWorker;
    private Integer documentNum;
    private LocalDate date;
    private Float amountOvertime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRutWorker() {
        return rutWorker;
    }

    public void setRutWorker(String rutWorker) {
        this.rutWorker = rutWorker;
    }

    public Integer getDocumentNum() {
        return documentNum;
    }

    public void setDocumentNum(Integer documentNum) {
        this.documentNum = documentNum;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Float getAmountOvertime() {
        return amountOvertime;
    }

    public void setAmountOvertime(Float amountOvertime) {
        this.amountOvertime = amountOvertime;
    }
}
