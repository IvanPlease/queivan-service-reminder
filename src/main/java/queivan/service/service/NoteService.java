package queivan.service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import queivan.service.mapper.NoteMapper;
import queivan.service.service.repository.NoteRepository;

@RequiredArgsConstructor
@Service
@Slf4j
public class NoteService {
    private final NoteRepository repository;
    private final NoteMapper mapper;
}
