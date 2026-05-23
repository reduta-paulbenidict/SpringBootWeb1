package com.pup.taguig.app.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentM {
	private Long id;
	private String firstName;
	private String lastName;
	private float midtermGrade;
	private float finalGrade;
	
	private Department department;
}
