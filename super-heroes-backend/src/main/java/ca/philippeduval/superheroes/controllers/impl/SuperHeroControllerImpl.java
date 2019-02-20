package ca.philippeduval.superheroes.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.philippeduval.superheroes.beans.SuperHero;
import ca.philippeduval.superheroes.controllers.SuperHeroController;
import ca.philippeduval.superheroes.services.SuperHeroService;


@RestController
public class SuperHeroControllerImpl implements SuperHeroController {
    
    @Autowired
    private SuperHeroService service;

	@Override
    @RequestMapping(value = "/superhero", method = RequestMethod.GET)
	public List<SuperHero> findAll() {
		return service.findAll();
	}

	@Override
    @RequestMapping(value = "/superhero/{id}", method = RequestMethod.GET)
	public SuperHero findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@Override
    @RequestMapping(value = "/superhero", method = RequestMethod.POST)
	public SuperHero create(@RequestBody SuperHero hero) {
		return service.create(hero);
	}

}
