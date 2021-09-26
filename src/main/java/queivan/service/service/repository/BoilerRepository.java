package queivan.service.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import queivan.service.domain.Boiler;

import java.util.List;
import java.util.UUID;

@Repository
public interface BoilerRepository extends JpaRepository<Boiler, UUID> {
    boolean existsBySerialNumber(String serialNumber);
    @Query(value = "SELECT * FROM _boilers WHERE inspection_date IS NOT NULL ORDER BY inspection_date LIMIT 5", nativeQuery = true)
    List<Boiler> getClosest();
}

