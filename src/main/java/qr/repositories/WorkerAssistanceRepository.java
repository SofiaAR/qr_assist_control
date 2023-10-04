package qr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.entities.WorkerAssistance;

public interface WorkerAssistanceRepository extends JpaRepository<WorkerAssistance,Long> {

}
