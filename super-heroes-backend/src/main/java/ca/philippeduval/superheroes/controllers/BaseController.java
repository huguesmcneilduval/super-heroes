package ca.philippeduval.superheroes.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface BaseController<T> {
	
	List<T> findAll();
	T findById(Long id);

	ResponseEntity<T> create(T object);

	ResponseEntity<T> update(Long id, T object);

	ResponseEntity<T> delete(Long id);

}
