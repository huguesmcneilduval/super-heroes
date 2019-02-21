package ca.philippeduval.superheroes.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.philippeduval.superheroes.beans.Mission;
import ca.philippeduval.superheroes.controllers.MissionController;
import ca.philippeduval.superheroes.services.MissionService;
import ca.philippeduval.superheroes.services.exceptions.BadRequestException;
import ca.philippeduval.superheroes.services.exceptions.IllegalActionException;

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
	public ResponseEntity<Mission> create(@RequestBody Mission mission) {
		try {
			return ResponseEntity.ok(service.create(mission));
		} catch(BadRequestException e) {
			return new ResponseEntity<Mission>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	@RequestMapping(value = "/mission/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Mission> update(@PathVariable("id") Long id, @RequestBody Mission mission) {
		try {
			return ResponseEntity.ok(service.save(id, mission));
		} catch(BadRequestException e) {
			return new ResponseEntity<Mission>(HttpStatus.FORBIDDEN);
		}
	}

	@Override
	@RequestMapping(value = "/mission/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Mission> delete(@PathVariable("id") Long id) {
		try {
			service.delete(id);
			return new ResponseEntity<Mission>(HttpStatus.OK);
		} catch(BadRequestException e) {
			return new ResponseEntity<Mission>(HttpStatus.FORBIDDEN);
		} catch(IllegalActionException e ) {
			return new ResponseEntity<Mission>(HttpStatus.FORBIDDEN);
		}
		
	}

}
