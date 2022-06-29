package com.example.demo;

import java.sql.*;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class Controller {
	
	
	@RequestMapping("/{name}")
	@ResponseBody
	String helloStudent(@PathVariable String name) 
	{
		 String url = "jdbc:mysql://localhost:3306/studentgradelab";
	        String user = "root";
	        String password = "[901f]";
	        
	        String msg = "Result not found!";
	        
	        try
	        {
	        	Connection conn = DriverManager.getConnection(url, user, password);

	        	Statement st = conn.createStatement();
	        	ResultSet result = st.executeQuery("select * from student where Name =" + name);

	        	while (result.next())
	        	{
	        		System.out.println(result.getString("StudentID") + " " + result.getString("Name"));
	        		Student student = new Student(result.getInt("StudentID"),result.getString("Name") );

	        		Statement st1 = conn.createStatement();
	        		ResultSet grade = st1.executeQuery("select * from grade where StudentID =" + result.getString("StudentID") );

	        		while (grade.next()) 
	        		{

	        			student.AddSubject(grade.getString("Subject1_Name"),grade.getInt("Subject1_Score"));
	        			student.AddSubject(grade.getString("Subject2_Name"),grade.getInt("Subject2_Score"));
	        			student.AddSubject(grade.getString("Subject3_Name"),grade.getInt("Subject3_Score"));
	        			student.AddSubject(grade.getString("Subject4_Name"),grade.getInt("Subject4_Score"));
	        			
	        			msg = grade.getString("Subject1_Name") + " " + grade.getInt("Subject1_Score") + "\n"
	        				+ grade.getString("Subject2_Name") + " " + grade.getInt("Subject2_Score") + "\n"
	        				+ grade.getString("Subject3_Name") + " " + grade.getInt("Subject3_Score") + "\n"
	        				+ grade.getString("Subject4_Name") + " " + grade.getInt("Subject4_Score") + "\n";
	        		}
	        		
	        		msg += GradeProcessing.ProcessGrade(student.getName(),student.getSubjectsArr());
	        	}
	        }
	        catch(SQLException e)
	        {
	        	msg = name + "Unable to connect";
	        }
	          
	        
	  
	      return msg;
	}

}
