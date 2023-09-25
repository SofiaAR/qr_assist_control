package qr.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qr.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}


