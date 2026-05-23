package com.pup.taguig.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pup.taguig.app.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	List<Student> findByFirstNameAndLastName(String firstName, String lastName);
	
}
	