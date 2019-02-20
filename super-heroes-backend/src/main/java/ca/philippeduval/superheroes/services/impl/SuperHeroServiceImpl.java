package ca.philippeduval.superheroes.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.philippeduval.superheroes.beans.SuperHero;
import ca.philippeduval.superheroes.repositories.SuperHeroRepository;
import ca.philippeduval.superheroes.services.SuperHeroService;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {
	@Autowired
	SuperHeroRepository repo;

	@Override
	public List<SuperHero> findAll() {
		return repo.findAll();
	}

	@Override
	public SuperHero findById(Long id) {

		Optional<SuperHero> hero = repo.findById(id);

		if (hero.isPresent()) {
			return hero.get();
		} else {
			return null;
		}

	}


}
