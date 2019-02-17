package ca.philippeduval.superheroes.IServices;

import java.util.List;


public interface IService<T> {

	List<T> findAll();
	
	
	
}
