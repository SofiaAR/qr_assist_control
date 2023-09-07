package qr.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Entity
@Table(name= "cuentas")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String user;
    private String password;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "type_account_id")
    private TypeAccount typeAccount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TypeAccount getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(TypeAccount typeAccount) {
        this.typeAccount = typeAccount;
    }
}
