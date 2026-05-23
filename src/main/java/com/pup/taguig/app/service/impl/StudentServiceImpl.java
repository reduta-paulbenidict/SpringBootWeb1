package com.pup.taguig.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pup.taguig.app.dto.DepartmentResponseDTO;
import com.pup.taguig.app.dto.StudentRequestDTO;
import com.pup.taguig.app.dto.StudentResponseDTO;
import com.pup.taguig.app.model.StudentM;
import com.pup.taguig.app.repositoryM.StudentMapper;
import com.pup.taguig.app.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	private static final Logger LOGGER = LogManager.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentMapper studentMapper;
	
	private StudentResponseDTO toDTO(StudentM student) {
		StudentResponseDTO responseDTO = new StudentResponseDTO(
				student.getId(),
				student.getFirstName(),
				student.getLastName(),
				student.getMidtermGrade(),
				student.getFinalGrade()
		);
		
		if (student.getDepartment() != null) {
			DepartmentResponseDTO deptDTO = new DepartmentResponseDTO();
			deptDTO.setId(student.getDepartment().getId());
			deptDTO.setName(student.getDepartment().getName());
			deptDTO.setDisplayName(student.getDepartment().getDisplayName());
			
			responseDTO.setDepartment(deptDTO);
		}
		
		return responseDTO;
	}
	
	@Override
	public StudentResponseDTO getUserById(Long id) {
		LOGGER.debug("Enter getUserById with id: {}", id);
		StudentM student = studentMapper.findUserById(id);
		LOGGER.debug("Exit getUserById with student: {}", student);
	
		return this.toDTO(student);
	}

	@Override
	public List<StudentResponseDTO> retrieveAllStudents() {
		List<StudentM> students = studentMapper.retrieveAllStudents();
		List<StudentResponseDTO> response = new ArrayList<StudentResponseDTO>();
		
		for(StudentM student : students) {
			StudentResponseDTO dto = new StudentResponseDTO(
					student.getId(),
					student.getFirstName(),
					student.getLastName(),
					student.getMidtermGrade(),
					student.getFinalGrade()
			);
			response.add(dto);
		}
		return response;
	}

	@Override
	public Long insertStudent(StudentRequestDTO request) {
		StudentM student = new StudentM();
		
		student.setFirstName(request.getFirstName());
		student.setLastName(request.getLastName());
		student.setMidtermGrade(request.getMidtermGrade());
		student.setFinalGrade(request.getFinalGrade());
		
		Long id = studentMapper.insertStudent(student);
		return id;
	}

	@Override
	public Boolean deleteStudentById(Long id) {
		boolean response = false;
		try {
			if(studentMapper.deleteStudentById(id) > 0) {
				response = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return response;
	}
	
}
