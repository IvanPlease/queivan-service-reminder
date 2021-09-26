package queivan.service.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import queivan.service.domain.Client;
import queivan.service.domain.Logs;

import java.util.List;
import java.util.UUID;

@Repository
public interface LogsRepository extends JpaRepository<Logs, UUID>{
    @Query(value = "SELECT * FROM _logs ORDER BY exception_date DESC LIMIT ?1", nativeQuery = true)
    List<Logs> findAllLimit(Long limit);
}
