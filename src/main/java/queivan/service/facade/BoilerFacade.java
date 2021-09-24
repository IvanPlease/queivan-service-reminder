package queivan.service.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import queivan.service.domain.BoilerCreateDto;
import queivan.service.service.BoilerService;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BoilerFacade {
    private final BoilerService service;

    public BoilerCreateDto create(BoilerCreateDto boilerDto, UUID userId) {
        return service.create(boilerDto, userId);
    }
}