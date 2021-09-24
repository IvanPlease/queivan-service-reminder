package queivan.service.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import queivan.service.domain.Note;

import java.util.UUID;

@Repository
public interface NoteRepository extends JpaRepository<Note, UUID>{
}

