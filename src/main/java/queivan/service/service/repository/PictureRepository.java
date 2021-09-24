package queivan.service.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import queivan.service.domain.Picture;

import java.util.UUID;

@Repository
public interface PictureRepository extends JpaRepository<Picture, UUID>{
}

