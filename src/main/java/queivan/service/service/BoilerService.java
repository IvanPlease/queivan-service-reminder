package queivan.service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import queivan.service.domain.*;
import queivan.service.exceptions.BoilerDontExistsException;
import queivan.service.exceptions.BoilerExistsException;
import queivan.service.exceptions.ClientDontExistsException;
import queivan.service.mapper.BoilerMapper;
import queivan.service.mapper.ClientMapper;
import queivan.service.service.repository.BoilerRepository;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BoilerService {
    private final BoilerRepository repository;
    private final BoilerMapper mapper;
    private final ClientService clientService;
    private final ServiceLogger log;

    public List<BoilerClosestDto> getAll() {
        return mapper.mapToBoilerClosestDtoList(repository.findAll());
    }

    public BoilerEditDto getById(UUID userId) {
        try {
            Boiler fetched = repository.findById(userId).orElseThrow(BoilerDontExistsException::new);
            return mapper.mapToBoilerEditDto(fetched);
        } catch (BoilerDontExistsException e) {
            log.error(e.getMessage());
        }
        return BoilerEditDto.builder().build();
    }

    public BoilerFetchedDto create(BoilerCreateDto boilerDto, UUID userId) {
        try{
            isBoilerExisting(boilerDto.getSerialNumber());
            ClientFetchedDto client = clientService.getById(userId);
            boilerDto.setClient(client);
            Boiler entity = mapper.mapToBoiler(boilerDto);
            Boiler returned = repository.saveAndFlush(entity);
            log.debug(String.format("Bojler o id: %s, został pomyślnie przypisany do użytkownika o id: %s", returned.getId(), userId));
            return mapper.mapToBoilerFetchedDto(returned);
        }catch(BoilerExistsException e){
            log.error(e.getMessage());
        }
        return BoilerFetchedDto.builder().build();
    }

    private void isBoilerExisting(String serialNumber) {
        if(repository.existsBySerialNumber(serialNumber)){
            throw new BoilerExistsException(serialNumber);
        }
    }

    public List<BoilerClosestDto> getClosest() {
        return mapper.mapToBoilerClosestDtoList(repository.getClosest());
    }
}
