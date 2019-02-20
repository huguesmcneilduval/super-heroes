package ca.philippeduval.superheroes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.philippeduval.superheroes.beans.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {

}
