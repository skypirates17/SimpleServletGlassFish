package com.acss.service;

import java.util.List;

import com.acss.model.Student;

public interface IStudentService {
	
	void addStudentRecords (Student paramMap);
	
	List<Student> retrieveStudentRecords (Student paramMap);
}
