package qr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.entities.Account;

public interface AccountRepository extends JpaRepository <Account,Long> {

}
