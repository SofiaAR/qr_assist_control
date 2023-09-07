package qr.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import javax.xml.crypto.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "registroerrores")
public class BugRecord {

    private Long id;
    private String bugdescription;
    private Data bugdate;

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

    public Data getBugdate() {
        return bugdate;
    }

    public void setBugdate(Data bugdate) {
        this.bugdate = bugdate;
    }
}
