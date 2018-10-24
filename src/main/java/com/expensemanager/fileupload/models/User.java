package com.expensemanager.fileupload.models;

import org.springframework.data.annotation.Id;

public class User {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String displayName;
	private double contribution;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public double getContribution() {
		return contribution;
	}
	public void setContribution(double contribution) {
		this.contribution = contribution;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", displayName=" + displayName
				+ ", contribution=" + contribution + "]";
	}
	
	
}
