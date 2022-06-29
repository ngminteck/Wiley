package com.sg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sg.dto.ItemWrapper;

public class JDBC {

	static final String DB_URL = "jdbc:mysql://localhost:3306/vendingmachine";
	static final String USER = "root";
	static final String PASS = "[901f]";
	   
	private final String dropTable = "DROP TABLE IF EXISTS Items"; 
	
	private final String createTable = "CREATE TABLE Items (ItemsID INT AUTO_INCREMENT PRIMARY KEY,`Name` VARCHAR(100),Price DECIMAL(6,2),Stock Int);"; 
	
	public  void SaveItem(ArrayList<ItemWrapper> items)
	{
		 try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		     ) 
		 	 {		      
		         String sql = dropTable;
		         stmt.executeUpdate(sql);
		         sql = createTable;
		         stmt.executeUpdate(sql);
		         
		         items.forEach(i -> {
		             					String query = "INSERT INTO Items VALUES(" + i.getItem().getName() + "," + i.getItem().getCost() + "," + i.getStock() + ")";
		             					try 
		             					{
		             						Statement stmt2 = conn.createStatement();
		             						stmt2.executeUpdate(query);
		             					} 
		             					catch (SQLException e) 
		             					{
		             						System.out.println("e");
						
		             					}
		          					} );
		         
		         System.out.println("Database save successfully.");
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
	}
	
	
}
