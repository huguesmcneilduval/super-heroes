package ca.philippeduval.superheroes.services;

import java.util.List;

import ca.philippeduval.superheroes.services.exceptions.BadRequestException;
import ca.philippeduval.superheroes.services.exceptions.IllegalActionException;

public interface BaseService<T> {

	List<T> findAll();

	T findById(Long id);
	T create(T object) throws BadRequestException;
	
	T save(Long id, T object) throws BadRequestException;

	void delete(Long id) throws IllegalActionException, BadRequestException;


}
