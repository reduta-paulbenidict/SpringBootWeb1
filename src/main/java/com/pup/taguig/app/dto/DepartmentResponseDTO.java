package com.pup.taguig.app.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DepartmentResponseDTO {
	private Long id;
	private String name;
	private String displayName;
	
	private List<StudentResponseDTO> students;
}
