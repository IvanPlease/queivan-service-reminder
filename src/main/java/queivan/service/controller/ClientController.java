package queivan.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import queivan.service.domain.BoilerCreateDto;
import queivan.service.domain.ClientFetchedDto;
import queivan.service.facade.ClientFacade;

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

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ClientFetchedDto create(@RequestBody ClientFetchedDto clientDto){
        return facade.create(clientDto);
    }

}