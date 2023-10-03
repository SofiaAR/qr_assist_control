package qr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.entities.OverTime;

public interface OvertimeRepository extends JpaRepository<OverTime ,Long> {

}
