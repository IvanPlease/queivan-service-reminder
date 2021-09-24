package queivan.service.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import queivan.service.domain.ClientCreateDto;
import queivan.service.domain.ClientFetchedDto;
import queivan.service.service.ClientService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClientFacade {
    private final ClientService service;

    public ClientFetchedDto create(ClientCreateDto clientDto) {
        return service.create(clientDto);
    }

    public List<ClientFetchedDto> getAll() {
        return service.getAll();
    }
}