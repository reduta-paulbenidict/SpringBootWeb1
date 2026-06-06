package com.pup.taguig.app.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StudentResponseDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private float midtermGrade;
	private float finalGrade;
	
	private DepartmentResponseDTO department;

	public StudentResponseDTO(Long id, String firstName, String lastName, float midtermGrade, float finalGrade) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.midtermGrade = midtermGrade;
		this.finalGrade = finalGrade;
	}
	
	public DepartmentResponseDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentResponseDTO department) {
		this.department = department;
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
	
}
