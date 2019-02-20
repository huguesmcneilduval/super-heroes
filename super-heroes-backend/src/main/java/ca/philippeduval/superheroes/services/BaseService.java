package ca.philippeduval.superheroes.services;

import java.util.List;

import ca.philippeduval.superheroes.beans.SuperHero;

public interface BaseService<T> {

	List<T> findAll();

	T findById(Long id);
	T create(T object);


}
