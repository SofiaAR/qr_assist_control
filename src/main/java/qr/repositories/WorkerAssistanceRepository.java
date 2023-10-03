package qr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.dtos.WorkAssistanceDto;
import qr.entities.WorkerAssistance;

public interface WorkerAssistanceRepository extends JpaRepository<WorkerAssistance,Long> {

}
