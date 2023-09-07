package qr.entities;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "historicoasist")
public class AssistHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String workerrut;
    private Integer workerdocument;
    private Date indate;
    private Date outdate;
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

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getOutdate() {
        return outdate;
    }

    public void setOutdate(Date outdate) {
        this.outdate = outdate;
    }

    public Float getOvertime() {
        return overtime;
    }

    public void setOvertime(Float overtime) {
        this.overtime = overtime;
    }
}
