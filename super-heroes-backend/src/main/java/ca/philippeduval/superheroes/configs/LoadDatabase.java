package ca.philippeduval.superheroes.configs;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ca.philippeduval.superheroes.beans.Mission;
import ca.philippeduval.superheroes.beans.SuperHero;
import ca.philippeduval.superheroes.repositories.MissionRepository;
import ca.philippeduval.superheroes.repositories.SuperHeroRepository;



@Configuration
public class LoadDatabase {
	final static Logger logger = Logger.getLogger(LoadDatabase.class);

	@Autowired
	SuperHeroRepository heroRepo;

	@Autowired
	MissionRepository missionRepo;
	
	@Bean
	CommandLineRunner initDatabase() {
			
		Mission m1 = new Mission();
		m1.setMissionName("Kill Bad Guys");
		m1.setCompleted(false);
		m1.setDeleted(false);
			
		Mission m2 = new Mission();
		m2.setMissionName("Kill More Bad Guys");
		m2.setCompleted(false);
		m2.setDeleted(false);

		
		List<Mission> missions = new ArrayList<Mission>();
		
		missions.add(m1);
		missions.add(m2);
		
		List<SuperHero> heroes = new ArrayList<SuperHero>();

		SuperHero s1 = new SuperHero("Clark", "Kent", "superman", missions);
		SuperHero s2 = new SuperHero("Aqua", "Man", "aquaman", missions);
		
		heroes.add(s1);
		heroes.add(s2);


		return args -> {
			// logger.info("Preloading " + missionRepo.save(m1));
			// logger.info("Preloading " + missionRepo.save(m2));

			// logger.info("Preloading " + heroRepo.save(s1));
			// logger.info("Preloading " + heroRepo.save(s2));
			// logger.info("Preloading " + heroRepo.save(s2));

		};
	}
}
	