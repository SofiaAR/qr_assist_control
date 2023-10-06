package qr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.entities.RegistrationType;

public interface RegistrationTypeRepository extends JpaRepository<RegistrationType ,Long> {

}
