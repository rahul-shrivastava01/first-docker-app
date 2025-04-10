package com.local.first_docker_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class DockerRestRequestController {

    private final PersonsRepository personsRepository;

    @Autowired
    public DockerRestRequestController(PersonsRepository personsRepository){
        this.personsRepository = personsRepository;
    }

    @GetMapping(value = "/home")
    public String displayMessage(){
        return "Hello";
    }

    @GetMapping(value = "/person")
    public String display(){
        Optional<Persons> byId = personsRepository.findById(12345);
        return byId.isPresent()?byId.get().getFirstName():"none";
    }

    @GetMapping(value = "/all")
    public List<Persons> displayAll(){
        List<Persons> result = new ArrayList<>();
        Iterable<Persons> all = personsRepository.findAll();
        for(Persons p : all){
           result.add(p);
        }
        return result;
    }

}
