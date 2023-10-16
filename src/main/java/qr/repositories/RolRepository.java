package qr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.entities.Rol;

public interface  RolRepository extends JpaRepository<Rol,Long> {
}
