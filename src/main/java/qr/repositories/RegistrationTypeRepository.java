package qr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.entities.RegistrationType;

import java.util.Optional;

public interface RegistrationTypeRepository extends JpaRepository<RegistrationType, Long> {

    Optional<RegistrationType> findByType(String type);

}
