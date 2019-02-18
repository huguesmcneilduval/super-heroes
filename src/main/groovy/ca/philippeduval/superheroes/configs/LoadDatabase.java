package ca.philippeduval.superheroes.configs;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import ca.philippeduval.superheroes.beans.Mission;
import ca.philippeduval.superheroes.beans.SuperHero;



@Configuration
public class LoadDatabase {
	final static Logger logger = Logger.getLogger(LoadDatabase.class);
	/*
	@Bean
	CommandLineRunner initDatabase(JpaRepository<SuperHero, Long> superHeroRepo, JpaRepository<Mission, Long> missionRepo) {
		
		Mission m1 = new Mission();
		m1.setMissionName("Kill Bad Guys");
		m1.setIsCompleted(false);
		m1.setIsdeleted(false);
			
		Mission m2 = new Mission();
		m2.setMissionName("Kill More Bad Guys");
		m2.setIsCompleted(false);
		m2.setIsdeleted(false);
			
		List<Mission> missions = new ArrayList<Mission>();
		
		missions.add(m1);
		missions.add(m2);
		
		SuperHero s1 = new SuperHero("Clark", "Kent", "superman", missions);
		SuperHero s2 = new SuperHero("Aqua", "Man", "aquaman", missions);

		
		return args -> {
			logger.info("Preloading " + missionRepo.save(m1));
			logger.info("Preloading " + missionRepo.save(m2));

			logger.info("Preloading " + superHeroRepo.save(s1));
			logger.info("Preloading " + superHeroRepo.save(s2));
		};
	*/
}
	