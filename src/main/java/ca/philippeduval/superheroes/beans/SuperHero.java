package ca.philippeduval.superheroes.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SuperHero {
	
	@Id
	@GeneratedValue
	private Long id;
	private String content;

	public SuperHero() {
	}

	public SuperHero(String content) {
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	
	
}
