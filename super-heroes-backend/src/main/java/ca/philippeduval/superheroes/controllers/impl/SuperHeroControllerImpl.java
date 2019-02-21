package ca.philippeduval.superheroes.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.philippeduval.superheroes.beans.SuperHero;
import ca.philippeduval.superheroes.controllers.SuperHeroController;
import ca.philippeduval.superheroes.services.SuperHeroService;
import ca.philippeduval.superheroes.services.exceptions.BadRequestException;
import ca.philippeduval.superheroes.services.exceptions.IllegalActionException;


@RestController()
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
	public ResponseEntity<SuperHero> create(@RequestBody SuperHero hero) {
		try {
			SuperHero heroCreated = service.create(hero);

			return ResponseEntity.ok(heroCreated);
		} catch(BadRequestException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@Override
    @RequestMapping(value = "/superhero/{id}", method = RequestMethod.PUT)
	public ResponseEntity<SuperHero> update(@PathVariable("id") Long id, @RequestBody SuperHero hero) {
		try {
			return ResponseEntity.ok(service.save(id, hero));
		} catch(BadRequestException e) {
			return new ResponseEntity<SuperHero>(HttpStatus.BAD_REQUEST);
		} 
		
	}	

	@Override
    @RequestMapping(value = "/superhero/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<SuperHero> delete(@PathVariable("id") Long id) {
		try {
			service.delete(id);
			return new ResponseEntity<SuperHero>(HttpStatus.OK);
		} catch(BadRequestException e) {
			return new ResponseEntity<SuperHero>(HttpStatus.BAD_REQUEST);
		} catch(IllegalActionException e ) {
			return new ResponseEntity<SuperHero>(HttpStatus.FORBIDDEN);
		}
	}

}
