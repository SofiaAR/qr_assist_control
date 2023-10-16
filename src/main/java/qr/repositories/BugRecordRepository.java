package qr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.entities.BugRecord;

public interface BugRecordRepository extends JpaRepository<BugRecord,Long> {

}
