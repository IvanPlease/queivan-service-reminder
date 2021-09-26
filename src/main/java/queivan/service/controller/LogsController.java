package queivan.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import queivan.service.domain.ClientCreateDto;
import queivan.service.domain.ClientFetchedDto;
import queivan.service.domain.LogsDto;
import queivan.service.facade.ClientFacade;
import queivan.service.facade.LogsFacade;
import queivan.service.service.ServiceLogger;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogsController {

    private final LogsFacade facade;
    private final ServiceLogger log;

    @GetMapping("/check")
    public String deployCheck(){
        return String.format("%s check succeeded", this.getClass().getSimpleName());
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<LogsDto> getAll(){
        return facade.getAll();
    }

    @GetMapping(value ="/{limit}", produces = APPLICATION_JSON_VALUE)
    public List<LogsDto> getWithLimit(@PathVariable Long limit){
        return facade.getWithLimit(limit);
    }

}