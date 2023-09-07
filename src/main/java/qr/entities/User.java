package qr.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
@Table(name = "trabajadores")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String rut;
    private Integer numdocument;
    private String name;
    private String lastname;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_type_id")
    private Integer workertype;
    private Date contractdate;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department iddepartment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Integer getNumdocument() {
        return numdocument;
    }

    public void setNumdocument(Integer numdocument) {
        this.numdocument = numdocument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getContractdate() {
        return contractdate;
    }

    public void setContractdate(Date contractdate) {
        this.contractdate = contractdate;
    }

    public Integer getWorkertype() {
        return workertype;
    }

    public void setWorkertype(Integer workertype) {
        this.workertype = workertype;
    }

    public Department getIddepartment() {
        return iddepartment;
    }

    public void setIddepartment(Department iddepartment) {
        this.iddepartment = iddepartment;
    }
}
