package queivan.service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import queivan.service.domain.Client;
import queivan.service.domain.ClientCreateDto;
import queivan.service.domain.ClientFetchedDto;
import queivan.service.exceptions.ClientDontExistsException;
import queivan.service.exceptions.ClientExistsException;
import queivan.service.mapper.ClientMapper;
import queivan.service.service.repository.ClientRepository;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final ClientRepository repository;
    private final ClientMapper mapper;
    private final ServiceLogger log;

    public List<ClientFetchedDto> getAll() {
        return mapper.mapToClientFetchedDtoList(repository.findAll());
    }

    public ClientFetchedDto getByUserId(UUID userId) {
        try {
            Client fetched = repository.findById(userId).orElseThrow(ClientDontExistsException::new);
            return mapper.mapToClientFetchedDto(fetched);
        } catch (ClientDontExistsException e) {
            log.error(e.getMessage());
        }
        return ClientFetchedDto.builder().build();
    }

    public ClientFetchedDto create(ClientCreateDto dto){
        try {
            isClientExisting(dto.getPhoneNumber());
            Client mapped = mapper.mapToClient(dto);
            Client fetched = repository.save(mapped);
            log.info(String.format("Użytkownik o id: %s, został poprawnie stworzony", fetched.getId()));
            return mapper.mapToClientFetchedDto(fetched);
        } catch (ClientExistsException e) {
            log.error(e.getMessage());
        }
        return ClientFetchedDto.builder().build();
    }

    private void isClientExisting(int phoneNumber) {
        if(repository.existsByPhoneNumber(phoneNumber)){
            throw new ClientExistsException(phoneNumber);
        }
    }
}
