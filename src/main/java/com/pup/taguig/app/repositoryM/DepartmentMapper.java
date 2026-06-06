package com.pup.taguig.app.repositoryM;

import org.apache.ibatis.annotations.Mapper;

import com.pup.taguig.app.model.Department;

@Mapper
public interface DepartmentMapper {
	public Department getDepartmentAndStudentById(Long id);
}
