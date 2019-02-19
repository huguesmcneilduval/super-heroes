package ca.philippeduval.superheroes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.philippeduval.superheroes.beans.SuperHero;

public interface SuperHeroRepository extends JpaRepository<SuperHero, Long> {

}
