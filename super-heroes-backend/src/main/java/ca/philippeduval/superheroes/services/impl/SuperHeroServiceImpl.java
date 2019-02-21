package ca.philippeduval.superheroes.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.philippeduval.superheroes.beans.Mission;
import ca.philippeduval.superheroes.beans.SuperHero;
import ca.philippeduval.superheroes.repositories.SuperHeroRepository;
import ca.philippeduval.superheroes.services.SuperHeroService;
import ca.philippeduval.superheroes.services.exceptions.BadRequestException;
import ca.philippeduval.superheroes.services.exceptions.IllegalActionException;

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

		Optional<SuperHero> optHero = repo.findById(id);

		if (optHero.isPresent()) {
			SuperHero hero = optHero.get();
			hero.setMissions(
					hero.getMissions().stream().filter(mission -> !mission.isDeleted()).collect(Collectors.toList()));
			return hero;
		} else {
			return null;
		}
	}

	@Override
	public SuperHero create(SuperHero hero) throws BadRequestException {
		try {
			return repo.save(hero);

		} catch (Exception e) {
			throw new BadRequestException();
		}

	}

	private boolean removingCompletedMission(List<Mission> fromBD, List<Mission> fromReq) {
		return fromBD.stream().filter(el -> fromReq.stream().noneMatch(el2 -> el.getId() == el2.getId())).filter(el -> el.isCompleted())
				.collect(Collectors.toList()).size() > 0;
	}

	@Override
	public SuperHero save(Long id, SuperHero hero) throws BadRequestException {
		Optional<SuperHero> optHero = repo.findById(id);

		if (optHero.isPresent()) {
			SuperHero dbHero = optHero.get();

			List<Mission> fromBD = dbHero.getMissions();
			List<Mission> fromReq = hero.getMissions();
			if (removingCompletedMission(fromBD, fromReq)) {
				throw new BadRequestException();
			}
			dbHero.setFirstname(hero.getFirstname());
			dbHero.setLastname(hero.getLastname());
			dbHero.setSuperheroname(hero.getSuperheroname());
			dbHero.setMissions(hero.getMissions());
			return repo.save(dbHero);
		} else {
			return null;
		}
	}

	@Override
	public void delete(Long id) throws IllegalActionException, BadRequestException {
		repo.deleteById(id);
	}

	public void setRepository(SuperHeroRepository repo) {
		this.repo = repo;
	}

}
