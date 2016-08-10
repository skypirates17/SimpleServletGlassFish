package com.acss.dao;

import java.util.List;

import com.acss.model.Student;

public interface IStudentDao {
	void insertStudentInfo(Student paramMap);
	
	List<Student> selectStudentInfo(Student paramMap);
}
