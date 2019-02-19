package ca.philippeduval.superheroes.configs;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ca.philippeduval.superheroes.beans.SuperHero;
import ca.philippeduval.superheroes.repositories.SuperHeroRepository;



@Configuration
public class LoadDatabase {
	final static Logger logger = Logger.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(SuperHeroRepository repository) {
		return args -> {
			logger.info("Preloading " + repository.save(new SuperHero("Bilbo Baggins")));
			logger.info("Preloading " + repository.save(new SuperHero("Frodo Baggins")));
		};
	}
}
	