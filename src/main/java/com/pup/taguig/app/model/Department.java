package com.pup.taguig.app.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	private Long id;
	private String name;
	private String displayName;
	
	private List<StudentM> students;
}
