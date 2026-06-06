package com.pup.taguig.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pup.taguig.app.dto.DepartmentResponseDTO;
import com.pup.taguig.app.dto.StudentResponseDTO;
import com.pup.taguig.app.model.Department;
import com.pup.taguig.app.model.StudentM;
import com.pup.taguig.app.repositoryM.DepartmentMapper;
import com.pup.taguig.app.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentMapper deptRepository;

	@Override
	public DepartmentResponseDTO getDepartmentAndStudentsById(Long id) {
		DepartmentResponseDTO result = new DepartmentResponseDTO();
		
		try {
			Department dept = deptRepository.getDepartmentAndStudentById(id);
			
			if(Objects.nonNull(dept)) {
				result.setId(dept.getId());
				result.setName(dept.getName());
				result.setDisplayName(dept.getDisplayName());
				
				if(Objects.nonNull(dept.getStudents())) {
					List<StudentResponseDTO> studDtoList = new ArrayList<StudentResponseDTO>();
					
					for(StudentM student : dept.getStudents()) {
						StudentResponseDTO studResp = new StudentResponseDTO(
							student.getId(),
							student.getFirstName(),
							student.getLastName(),
							student.getMidtermGrade(),
							student.getFinalGrade()
						);
						studDtoList.add(studResp); 
					}
					
					result.setStudents(studDtoList);
				}
			}
			
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

}
