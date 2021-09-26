package queivan.service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import queivan.service.domain.*;
import queivan.service.facade.ClientFacade;
import queivan.service.service.ServiceLogger;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientFacade facade;

    @GetMapping("/check")
    public String deployCheck(){
        return String.format("%s check succeeded", this.getClass().getSimpleName());
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<ClientFetchedDto> getAll(){
        return facade.getAll();
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ClientFetchedDto getById(@PathVariable UUID id){
        return facade.getById(id);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ClientFetchedDto create(@RequestBody ClientCreateDto clientDto){
        return facade.create(clientDto);
    }

}