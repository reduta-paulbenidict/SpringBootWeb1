package com.pup.taguig.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pup.taguig.app.dto.StudentRequestDTO;
import com.pup.taguig.app.dto.StudentResponseDTO;
import com.pup.taguig.app.service.StudentService;
import com.pup.taguig.app.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private UserService userService;

	@GetMapping("/all")
	public List<StudentResponseDTO> getAllUsers() {
		return studentService.retrieveAllStudents();
	}

	@GetMapping("/find/{id}")
	public StudentResponseDTO getUserById(@PathVariable Long id) {
//		return userService.retrieveStudentbyId(id);
		return studentService.getUserById(id);
	}
	
	@PostMapping("/add")
	public Long addStudent(@RequestBody StudentRequestDTO student) {
		return studentService.insertStudent(student);
	} 
	
	@GetMapping("/filter")
	public List<StudentResponseDTO> searchByName(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
		return userService.searchStudentByName(firstName, lastName);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteStudent(@PathVariable Long id) {
		return studentService.deleteStudentById(id);
	}
}
