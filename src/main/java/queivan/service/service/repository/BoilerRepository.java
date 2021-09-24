package queivan.service.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import queivan.service.domain.Boiler;

import java.util.UUID;

@Repository
public interface BoilerRepository extends JpaRepository<Boiler, UUID> {
    boolean existsBySerialNumber(String serialNumber);
}

