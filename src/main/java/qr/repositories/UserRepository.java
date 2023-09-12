package qr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qr.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
