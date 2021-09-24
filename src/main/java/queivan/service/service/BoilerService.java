package queivan.service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import queivan.service.domain.Boiler;
import queivan.service.domain.BoilerCreateDto;
import queivan.service.domain.Client;
import queivan.service.domain.ClientFetchedDto;
import queivan.service.exceptions.BoilerExistsException;
import queivan.service.mapper.BoilerMapper;
import queivan.service.service.repository.BoilerRepository;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class BoilerService {
    private final BoilerRepository repository;
    private final BoilerMapper mapper;
    private final ClientService clientService;

    public BoilerCreateDto create(BoilerCreateDto boilerDto, UUID userId) {
        isBoilerExisting(boilerDto.getSerialNumber());
        ClientFetchedDto target = clientService.getByUserId(userId);
        Boiler entity = mapper.mapToBoiler(boilerDto);
        Boiler returned = repository.save(entity);
        target.getBoilers().add(mapper.mapToBoilerClientDto(returned));
        clientService.update(target);
        return mapper.mapToBoilerCreateDto(returned);
    }

    private void isBoilerExisting(String serialNumber) {
        try{
            if(repository.existsBySerialNumber(serialNumber)){
                throw new BoilerExistsException();
            }
        } catch (BoilerExistsException e) {
            log.error(e.getMessage());
        }
    }
}
