package ca.philippeduval.superheroes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ca.philippeduval.superheroes.IServices.IService;
import ca.philippeduval.superheroes.beans.SuperHero;

@Service
public class SuperHeroService implements IService<SuperHero> {
	@Autowired
	JpaRepository<SuperHero, Long> repo;
	
	@Override
	public List<SuperHero> findAll() {
		return repo.findAll();
	}
}
