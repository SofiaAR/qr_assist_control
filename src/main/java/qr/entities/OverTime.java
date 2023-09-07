package qr.entities;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "calhorasextras")
public class OverTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rutworker;
    private Integer documentnum;
    private Date date;
    private Float amountovertime;

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

    public Integer getDocumentnum() {
        return documentnum;
    }

    public void setDocumentnum(Integer documentnum) {
        this.documentnum = documentnum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getAmountovertime() {
        return amountovertime;
    }

    public void setAmountovertime(Float amountovertime) {
        this.amountovertime = amountovertime;
    }
}
