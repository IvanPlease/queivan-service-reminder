package queivan.service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import queivan.service.mapper.ClientMapper;
import queivan.service.service.repository.ClientRepository;

@RequiredArgsConstructor
@Service
@Slf4j
public class ClientService {
    private final ClientRepository repository;
    private final ClientMapper mapper;
}
