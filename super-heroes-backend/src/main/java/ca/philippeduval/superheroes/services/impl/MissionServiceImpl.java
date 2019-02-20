package ca.philippeduval.superheroes.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.philippeduval.superheroes.beans.Mission;
import ca.philippeduval.superheroes.repositories.MissionRepository;
import ca.philippeduval.superheroes.services.MissionService;

@Service
public class MissionServiceImpl implements MissionService {
	@Autowired
	MissionRepository repo;

	@Override
	public List<Mission> findAll() {
		return repo.findAll();
	}

	@Override
	public Mission findById(Long id) {

		Optional<Mission> mission = repo.findById(id);
		if (mission.isPresent()) {
			return mission.get();
		} else {
			return null;
		}

	}

	@Override
	public Mission create(Mission mission) {
		return repo.save(mission);
	}

	@Override
	public Mission save(Long id, Mission mission) {
		return repo.save(mission);
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
