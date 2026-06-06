package com.pup.taguig.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentM {
	private Long id;
	private String firstName;
	private String lastName;
	private float midtermGrade;
	private float finalGrade;
	
	private Department department;
}
