package ca.philippeduval.superheroes.configs;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.philippeduval.superheroes.beans.Mission;
import ca.philippeduval.superheroes.beans.SuperHero;


public class SetupTest {

	public SuperHero s1;
	public SuperHero s2;
	public Mission m1;
	public Mission m2;

	@Before
	public void before() {

		m1 = new Mission();
		m1.setMissionName("Kill Bad Guys");
		m1.setIsCompleted(false);
		m1.setIsdeleted(false);

		
		m2 = new Mission();
		m2.setMissionName("Kill More Bad Guys");
		m2.setIsCompleted(false);
		m2.setIsdeleted(false);

		List<Mission> missions = new ArrayList<Mission>();

		missions.add(m1);
		missions.add(m2);

		s1 = new SuperHero("Clark", "Kent", "superman", missions);
		s2 = new SuperHero("Aqua", "Man", "aquaman", missions);

	}
	
}
