package queivan.service.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import queivan.service.domain.ClientCreateDto;
import queivan.service.domain.ClientFetchedDto;
import queivan.service.domain.LogsDto;
import queivan.service.service.ClientService;
import queivan.service.service.LogsService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LogsFacade {
    private final LogsService service;

    public List<LogsDto> getAll() {
        return service.getAll();
    }

    public List<LogsDto> getWithLimit(Long limit) {
        return service.getWithLimit(limit);
    }
}
