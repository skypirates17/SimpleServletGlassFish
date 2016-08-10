package com.acss.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseProcess {
	private Connection con;
	private ResultSet rs;
	private Statement statement;
	private PreparedStatement preStatement;
	
	// connection properties
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	public DatabaseProcess() {
		this.driverClassName = "org.postgresql.Driver";
		this.url = "jdbc:postgresql://172.16.138.203:5432/afisvn_sample";
		this.username = "postgres";
		this.password = "postgres";
	}
	
	// For Selecting data
	public ResultSet getResult(String sql) {

		try {
			Class.forName(this.driverClassName);
			con = DriverManager.getConnection(this.url, this.username, this.password);
			statement = con.createStatement();
			rs = statement.executeQuery(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void closeConnection() {
		try {
			rs.close();
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// For Inserting Data
	public PreparedStatement getPreparedStatement(String sql) {

		try {
			Class.forName(this.driverClassName);
			con = DriverManager.getConnection(this.url, this.username, this.password);
			preStatement = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return preStatement;
	}

	public void closeInsertConnection() {
		try {
			preStatement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
