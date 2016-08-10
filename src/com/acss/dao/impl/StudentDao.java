package com.acss.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.acss.dao.IStudentDao;
import com.acss.model.Student;
import com.acss.utility.DatabaseProcess;

public class StudentDao implements IStudentDao {

	@Override
	public void insertStudentInfo(Student paramMap) {
		DatabaseProcess dbProc = new DatabaseProcess();
		String sql = "INSERT INTO STUDENT_INFO "
				+ "(STUDENT_NAME, STUDENT_AGE, STUDENT_ADDRESS) "
				+ "VALUES (?,?,?)";
		
		try {
			PreparedStatement prepState = dbProc.getPreparedStatement(sql);
			prepState.setString(1, paramMap.getStudentName());
			prepState.setString(2, paramMap.getStudentAge());
			prepState.setString(3, paramMap.getStudentAddress());
			prepState.executeUpdate();
			
			dbProc.closeInsertConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> selectStudentInfo(Student paramMap) {
		List<Student> studentList = new ArrayList<>();
		
		DatabaseProcess dbProc = new DatabaseProcess();
		String sql = "SELECT STUDENT_ID, STUDENT_NAME, STUDENT_AGE, STUDENT_ADDRESS "
		+ "FROM STUDENT_INFO";
		
		try {
			ResultSet resultSet = dbProc.getResult(sql);
			while(resultSet.next()){
				Student stud = new Student();
				stud.setStudentId(resultSet.getString("STUDENT_ID"));
				stud.setStudentName(resultSet.getString("STUDENT_NAME"));
				stud.setStudentAge(resultSet.getString("STUDENT_AGE"));
				stud.setStudentAddress(resultSet.getString("STUDENT_ADDRESS"));
				
				studentList.add(stud);
			}
			dbProc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		 return studentList;
		
		
	}

	
}
