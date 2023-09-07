package qr.entities;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "asistencias")
public class WorkerAssistance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rutworker;
    private Integer numdocument;
    private Date daterecord;
    private Integer day;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "registration_type_id")
    private RegistrationType registrationType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRutworker() {
        return rutworker;
    }

    public void setRutworker(String rutworker) {
        this.rutworker = rutworker;
    }

    public Integer getNumdocument() {
        return numdocument;
    }

    public void setNumdocument(Integer numdocument) {
        this.numdocument = numdocument;
    }

    public Date getDaterecord() {
        return daterecord;
    }

    public void setDaterecord(Date daterecord) {
        this.daterecord = daterecord;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public RegistrationType getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(RegistrationType registrationType) {
        this.registrationType = registrationType;
    }
}

