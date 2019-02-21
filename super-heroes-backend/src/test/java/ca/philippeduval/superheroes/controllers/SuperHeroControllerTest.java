package ca.philippeduval.superheroes.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.philippeduval.superheroes.beans.Mission;
import ca.philippeduval.superheroes.beans.SuperHero;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SuperHeroControllerTest  {

	@Autowired
	SuperHeroController controller;

	Mission m1;
	Mission m2;
	SuperHero s1;
	SuperHero s2;

	@Before
	public void before() {
		m1 = new Mission();
		m1.setMissionName("Kill Bad Guys");
		m1.setCompleted(false);
		m1.setDeleted(false);
			
		m2 = new Mission();
		m2.setMissionName("Kill More Bad Guys");
		m2.setCompleted(false);
		m2.setDeleted(false);

		
		List<Mission> missions = new ArrayList<Mission>();
		
		missions.add(m1);
		missions.add(m2);
		
		s1 = new SuperHero("Clark", "Kent", "superman", new ArrayList<Mission>());
		s2 = new SuperHero("Aqua", "Man", "aquaman", missions);
		
	}

    @Test
    @Transactional
	public void testCreate_oneValidHero_shouldPass() {

		// Arrange

		// Act
		controller.create(s1);


		// Assert
		List<SuperHero> allHeroes = controller.findAll();

		assertEquals("Findall return list of 1 SuperHero", 1, allHeroes.size());
		assertEquals("Find the hero just created", s1.getFirstname(), allHeroes.get(0).getFirstname());
	}

    // @Test
    // @Transactional
	// public void testCreate_oneInValidHero_didntSavedMissionFirst() {

	// 	// Arrange

	// 	// Act
	// 	ResponseEntity<SuperHero> response = controller.create(s2);


	// 	// Assert
	// 	System.out.println(response);
	// 	int respValue = response.getStatusCodeValue();
		
    //     System.out.println();
        
    //     ResponseEntity<SuperHero> resp = new ResponseEntity<SuperHero>(HttpStatus.BAD_REQUEST);
	// 	assertEquals("HTTP response is 400", HttpStatus.BAD_REQUEST, resp.getStatusCode());
	// 	assertEquals("HTTP response is 400", 400, response.getStatusCodeValue());
	// }


}
