package ca.philippeduval.superheroes.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Where;

@Entity
@Where(clause="is_deleted=0")
public class Mission {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String missionName;

	private boolean isCompleted;

	@Column(name="is_deleted")
	private boolean isDeleted;

	
	public Mission() {
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the missionName
	 */
	public String getMissionName() {
		return missionName;
	}

	/**
	 * @param missionName the missionName to set
	 */
	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}

	/**
	 * @return the isCompleted
	 */
	public boolean isCompleted() {
		return isCompleted;
	}

	/**
	 * @param isCompleted the isCompleted to set
	 */
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	/**
	 * @return the isDeleted
	 */
	public boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}
