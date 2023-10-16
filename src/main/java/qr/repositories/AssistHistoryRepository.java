package qr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.entities.AssistHistory;

public interface AssistHistoryRepository extends JpaRepository<AssistHistory,Long> {
}
