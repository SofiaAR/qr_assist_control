package qr.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "user_app")
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
    private Rol rol;
    private LocalDate contractdate;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

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

    public LocalDate getContractdate() {
        return contractdate;
    }

    public void setContractdate(LocalDate contractdate) {
        this.contractdate = contractdate;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
