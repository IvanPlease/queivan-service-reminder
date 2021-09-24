package queivan.service.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import queivan.service.service.NoteService;

@Component
@RequiredArgsConstructor
public class NoteFacade {
    private final NoteService service;
}