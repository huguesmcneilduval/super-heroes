package ca.philippeduval.superheroes.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class SuperHero {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String firstname;
	private String lastname;
	private String superheroname;
	
	@ManyToMany
	private List<Mission> missions;

	public SuperHero() {
	}
	
	public SuperHero(String firstname, String lastname, String superheroname, List<Mission> missions) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.superheroname = superheroname;
		this.missions = missions;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getSuperheroname() {
		return superheroname;
	}


	public void setSuperheroname(String superheroname) {
		this.superheroname = superheroname;
	}


	public List<Mission> getMissions() {
		return missions;
	}


	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}


}
