package ca.philippeduval.superheroes.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mission {
	
	@Id
	@GeneratedValue
	private Long id;
	private String missionName;

	private boolean isCompleted;
	private boolean isDeleted;
	
	public Mission() {
	}

	public String getMissionName() {
		return missionName;
	}

	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}

	public Mission(String missionName) {
		super();
		this.missionName = missionName;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public Mission(String missionName, boolean isCompleted, boolean isDeleted) {
		super();
		this.missionName = missionName;
		this.isCompleted = isCompleted;
		this.isDeleted = isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	
	
	
	
}
