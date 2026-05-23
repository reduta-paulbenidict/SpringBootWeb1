package com.pup.taguig.app.repositoryM;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pup.taguig.app.model.StudentM;

@Mapper
public interface StudentMapper {
	public StudentM findUserById(Long id);
	public List<StudentM> retrieveAllStudents();
	public Long insertStudent(StudentM request);
	public int deleteStudentById(Long id);
}
