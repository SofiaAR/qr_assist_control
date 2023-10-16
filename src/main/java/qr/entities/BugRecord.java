package qr.entities;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class BugRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bugDescription;
    private LocalDate bugDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBugDescription() {
        return bugDescription;
    }

    public void setBugDescription(String bugDescription) {
        this.bugDescription = bugDescription;
    }

    public LocalDate getBugDate() {
        return bugDate;
    }

    public void setBugDate(LocalDate bugDate) {
        this.bugDate = bugDate;
    }

}
