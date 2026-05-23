package com.pup.taguig.app.service.impl;

import com.pup.taguig.app.repository.StudentRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pup.taguig.app.dto.StudentRequestDTO;
import com.pup.taguig.app.dto.StudentResponseDTO;
import com.pup.taguig.app.model.Student;
import com.pup.taguig.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Long addUser(StudentRequestDTO request) {
		
		Student student = new Student(
				request.getFirstName(),
				request.getLastName(),
				request.getMidtermGrade(),
				request.getFinalGrade()
		);
		
		student = studentRepository.save(student);
		return student.getId();
	}
	
	@Override
	public StudentResponseDTO retrieveStudentbyId(Long id) {

		Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		
		
		return new StudentResponseDTO(
				student.getId(),
				student.getFirstName(),
				student.getLastName(),
				student.getMidtermGrade(),
				student.getFinalGrade()
		);
	}

	@Override
	public List<StudentResponseDTO> retrieveAllStudents() {
//		return students;
		List<Student> students = studentRepository.findAll();
		List<StudentResponseDTO> response = new ArrayList<StudentResponseDTO>();
		
		for (Student student : students) {
			StudentResponseDTO dto = new StudentResponseDTO(
					student.getId(),
					student.getFirstName(),
					student.getLastName(),
					student.getMidtermGrade(),
					student.getFinalGrade()
			);
			
			response.add(dto);
		};
		
		return response;
	}

	@Override
	public List<StudentResponseDTO> searchStudentByName(String firstName, String lastName) {

		List<Student> students = studentRepository.findByFirstNameAndLastName(firstName, lastName);
		
		
		return students.stream().map(
			student -> new StudentResponseDTO(
					student.getId(),
					student.getFirstName(),
					student.getLastName(),
					student.getMidtermGrade(),
					student.getFinalGrade()
				)
			).toList();
	}

	@Override
	public boolean deleteStudent(Long id) {
		
		if(studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
