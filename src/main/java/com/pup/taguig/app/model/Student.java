package com.pup.taguig.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String firstName;
	
	@Column(nullable=false, insertable=true, updatable=false)
	private String lastName;
	
	@Column(nullable=true)
	private float midtermGrade;
	
	@Column(nullable=true)
	private float finalGrade;
	
	public Student() {
		
	}
	
	public Student(String firstName, String lastName, float midtermGrade, float finalGrade) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.midtermGrade = midtermGrade;
		this.finalGrade = finalGrade;
	}
	
	public float getMidtermGrade() {
		return midtermGrade;
	}

	public void setMidtermGrade(float midtermGrade) {
		this.midtermGrade = midtermGrade;
	}

	public float getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(float finalGrade) {
		this.finalGrade = finalGrade;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
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
	
	public float compute () {
		return (midtermGrade + finalGrade) / 2;
	}
	
	public String evaluate() {
		float average = this.compute();
		if (average >= 75) {
			return "Passed";
			}else {
				return "Failed";
		}
	}
}
