package qr.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class AssistHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String workerrut;
    private Integer workerdocument;
    private LocalDate indate;
    private LocalDate outdate;
    private Float overtime;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuttrabajador() {
        return workerrut;
    }

    public void setRuttrabajador(String ruttrabajador) {
        this.workerrut = ruttrabajador;
    }

    public Integer getNumerodocumento() {
        return workerdocument;
    }

    public void setNumerodocumento(Integer numerodocumento) {
        this.workerdocument = numerodocumento;
    }

    public String getWorkerrut() {
        return workerrut;
    }

    public void setWorkerrut(String workerrut) {
        this.workerrut = workerrut;
    }

    public Integer getWorkerdocument() {
        return workerdocument;
    }

    public void setWorkerdocument(Integer workerdocument) {
        this.workerdocument = workerdocument;
    }

    public LocalDate getIndate() {
        return indate;
    }

    public void setIndate(LocalDate indate) {
        this.indate = indate;
    }

    public LocalDate getOutdate() {
        return outdate;
    }

    public void setOutdate(LocalDate outdate) {
        this.outdate = outdate;
    }

    public Float getOvertime() {
        return overtime;
    }

    public void setOvertime(Float overtime) {
        this.overtime = overtime;
    }
}
