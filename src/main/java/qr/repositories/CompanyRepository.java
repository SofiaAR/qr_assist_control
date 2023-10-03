package qr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.entities.Company;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
