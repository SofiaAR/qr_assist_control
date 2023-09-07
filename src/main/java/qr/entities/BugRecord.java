package qr.entities;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class BugRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bugdescription;
    private LocalDate bugdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBugdescription() {
        return bugdescription;
    }

    public void setBugdescription(String bugdescription) {
        this.bugdescription = bugdescription;
    }

    public LocalDate getBugdate() {
        return bugdate;
    }

    public void setBugdate(LocalDate bugdate) {
        this.bugdate = bugdate;
    }

}
