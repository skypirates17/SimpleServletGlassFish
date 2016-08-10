package com.acss.service.impl;

import java.util.List;

import com.acss.dao.IStudentDao;
import com.acss.dao.impl.StudentDao;
import com.acss.model.Student;
import com.acss.service.IStudentService;

public class StudentService implements IStudentService {

	private IStudentDao studentDao = new StudentDao();
	
	@Override
	public void addStudentRecords(Student paramMap) {
		studentDao.insertStudentInfo(paramMap);
	}

	@Override
	public List<Student> retrieveStudentRecords(Student paramMap) {
		return studentDao.selectStudentInfo(paramMap);
	}


}
