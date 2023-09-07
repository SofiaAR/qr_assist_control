package qr.Dtos;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import qr.entities.Department;
import qr.entities.Rol;

import java.util.Date;

public class UserDto {
    private Long id;
    private String rut;
    private Integer numdocument;
    private String name;
    private String lastname;
    private Rol rol;
    private Date contractdate;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Date getContractdate() {
        return contractdate;
    }

    public void setContractdate(Date contractdate) {
        this.contractdate = contractdate;
    }

    public Department getIddepartment() {
        return iddepartment;
    }

    public void setIddepartment(Department iddepartment) {
        this.iddepartment = iddepartment;
    }
}
