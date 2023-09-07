package qr.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;


@Entity
@Table(name = "empresa")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String namecompany;
    private String rutcompany;
    private String turn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamecompany() {
        return namecompany;
    }

    public void setNamecompany(String namecompany) {
        this.namecompany = namecompany;
    }

    public String getRutcompany() {
        return rutcompany;
    }

    public void setRutcompany(String rutcompany) {
        this.rutcompany = rutcompany;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }
}
