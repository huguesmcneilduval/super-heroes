package ca.philippeduval.superheroes.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.philippeduval.superheroes.beans.Mission;
import ca.philippeduval.superheroes.controllers.MissionController;
import ca.philippeduval.superheroes.services.MissionService;

@RestController
public class MissionControllerImpl implements MissionController {

	@Autowired
	private MissionService service;

	@Override
	@RequestMapping(value = "/mission", method = RequestMethod.GET)
	public List<Mission> findAll() {
		return service.findAll();
	}

	@Override
	@RequestMapping(value = "/mission/{id}", method = RequestMethod.GET)
	public Mission findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@Override
	@RequestMapping(value = "/mission", method = RequestMethod.POST)
	public Mission create(@RequestBody Mission mission) {
		return service.create(mission);
	}

	@Override
	@RequestMapping(value = "/mission/{id}", method = RequestMethod.PUT)
	public Mission update(@PathVariable("id") Long id, @RequestBody Mission mission) {
		return service.save(id, mission);
	}

	@Override
	@RequestMapping(value = "/mission/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
