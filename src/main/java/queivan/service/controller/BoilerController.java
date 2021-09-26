package queivan.service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import queivan.service.domain.BoilerClosestDto;
import queivan.service.domain.BoilerCreateDto;
import queivan.service.domain.BoilerFetchedDto;
import queivan.service.facade.BoilerFacade;

import java.util.List;
import java.util.UUID;

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

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<BoilerClosestDto> getAll(){
        return facade.getAll();
    }

    @GetMapping(value = "/inspection", produces = APPLICATION_JSON_VALUE)
    public List<BoilerClosestDto> getClosest(){
        return facade.getClosest();
    }

    @PostMapping(value = "/{userId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public BoilerFetchedDto create(@RequestBody BoilerCreateDto boilerDto, @PathVariable UUID userId){
        return facade.create(boilerDto, userId);
    }

}