package queivan.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import queivan.service.domain.*;
import queivan.service.mapper.LogsMapper;
import queivan.service.service.repository.LogsRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LogsService {
    private final LogsRepository repository;
    private final LogsMapper mapper;

    public List<LogsDto> getAll() {
        return mapper.mapToLogsDtoList(repository.findAll());
    }

    public List<LogsDto> getWithLimit(Long limit) {
        return mapper.mapToLogsDtoList(repository.findAllLimit(limit));
    }

    public void create(LogsDto dto){
        Logs mapped = mapper.mapToLogs(dto);
        repository.save(mapped);
    }
}
