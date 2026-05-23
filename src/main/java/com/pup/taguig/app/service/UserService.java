package com.pup.taguig.app.service;

import java.util.List;

import com.pup.taguig.app.dto.StudentRequestDTO;
import com.pup.taguig.app.dto.StudentResponseDTO;


public interface UserService {

	public Long addUser (StudentRequestDTO student);
	public List <StudentResponseDTO> retrieveAllStudents();
	public StudentResponseDTO retrieveStudentbyId(Long id);
	public List <StudentResponseDTO> searchStudentByName(String firstName, String lastName);
	public boolean deleteStudent(Long id);
}

