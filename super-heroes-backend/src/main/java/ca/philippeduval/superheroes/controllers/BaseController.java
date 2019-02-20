package ca.philippeduval.superheroes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;

import ca.philippeduval.superheroes.beans.SuperHero;

@RestController
public interface BaseController<T> {
	
	List<T> findAll();
	T findById(Long id);
	T create(T object);
	
	T update(Long id, T object);

}
