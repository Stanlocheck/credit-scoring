package service.scoring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import service.scoring.entities.Credit;

public interface CreditRepository extends JpaRepository<Credit, Long> {
}
