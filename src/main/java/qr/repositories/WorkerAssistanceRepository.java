package qr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.entities.User;
import qr.entities.WorkerAssistance;

import java.time.LocalDateTime;
import java.util.List;

public interface WorkerAssistanceRepository extends JpaRepository<WorkerAssistance, Long> {

    WorkerAssistance findByUserAndEntranceIsNotNullAndOutIsNull(User user);

    List<WorkerAssistance> findByUserAndEntranceBetween(User user, LocalDateTime from, LocalDateTime until);

}
