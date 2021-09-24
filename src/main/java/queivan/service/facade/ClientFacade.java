package queivan.service.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import queivan.service.service.ClientService;

@Component
@RequiredArgsConstructor
public class ClientFacade {
    private final ClientService service;
}