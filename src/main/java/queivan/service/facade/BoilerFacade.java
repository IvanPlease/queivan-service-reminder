package queivan.service.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import queivan.service.domain.BoilerCreateDto;
import queivan.service.domain.BoilerFetchedDto;
import queivan.service.service.BoilerService;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BoilerFacade {
    private final BoilerService service;

    public BoilerCreateDto create(BoilerCreateDto boilerDto, UUID userId) {
        return service.create(boilerDto, userId);
    }

    public List<BoilerFetchedDto> getAll() {
        return service.getAll();
    }
}