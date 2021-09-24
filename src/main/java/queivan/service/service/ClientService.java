package queivan.service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import queivan.service.domain.Client;
import queivan.service.domain.ClientFetchedDto;
import queivan.service.exceptions.BoilerExistsException;
import queivan.service.exceptions.ClientExistsException;
import queivan.service.exceptions.ClientNotFoundException;
import queivan.service.mapper.ClientMapper;
import queivan.service.service.repository.ClientRepository;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class ClientService {
    private final ClientRepository repository;
    private final ClientMapper mapper;

    public List<ClientFetchedDto> getAll() {
        return mapper.mapToClientFetchedDtoList(repository.findAll());
    }

    public ClientFetchedDto getByUserId(UUID userId) {
        try {
            Client fetched = repository.findById(userId).orElseThrow(ClientNotFoundException::new);
            return mapper.mapToClientFetchedDto(fetched);
        } catch (ClientNotFoundException e) {
            log.error(e.getMessage());
        }
        return ClientFetchedDto.builder().build();
    }

    public ClientFetchedDto create(ClientFetchedDto dto){
        Client mapped = mapper.mapToClient(dto);
        Client fetched = repository.save(mapped);
        return mapper.mapToClientFetchedDto(fetched);
    }

    public ClientFetchedDto update(ClientFetchedDto dto) {
        isClientExisting(dto.getId());
        Client mapped = mapper.mapToClient(dto);
        Client fetched = repository.save(mapped);
        return mapper.mapToClientFetchedDto(fetched);
    }

    private void isClientExisting(UUID id) {
        try{
            if(repository.existsById(id)){
                throw new ClientExistsException();
            }
        } catch (ClientExistsException e) {
            log.error(e.getMessage());
        }
    }
}
