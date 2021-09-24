package queivan.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import queivan.service.domain.BoilerCreateDto;
import queivan.service.facade.BoilerFacade;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/boiler")
@RequiredArgsConstructor
public class BoilerController {

    private final BoilerFacade facade;

    @GetMapping("/check")
    public String deployCheck(){
        return String.format("%s check succeeded", this.getClass().getSimpleName());
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public BoilerCreateDto create(@RequestBody BoilerCreateDto boilerDto){
        return facade.create(boilerDto);
    }

}