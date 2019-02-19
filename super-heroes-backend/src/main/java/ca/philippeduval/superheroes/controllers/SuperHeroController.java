package ca.philippeduval.superheroes.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.philippeduval.superheroes.IServices.IService;
import ca.philippeduval.superheroes.beans.SuperHero;


@RestController
public class SuperHeroController {
    
    @Autowired
    private IService<SuperHero> service;

    @RequestMapping("/greeting")
    public List<SuperHero> greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return service.findAll();
    }
}
