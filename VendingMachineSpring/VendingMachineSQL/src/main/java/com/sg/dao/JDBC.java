package com.sg.dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import com.sg.dto.Item;
import com.sg.dto.ItemWrapper;

public class JDBC {

	static final String DB_URL = "jdbc:mysql://localhost:3306/vendingmachine";
	static final String USER = "root";
	static final String PASS = "[901f]";

	public  void SaveItem(ArrayList<ItemWrapper> items)
	{
		 try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement()
		 )
		 	 {
				 String sql = "DROP TABLE IF EXISTS Items";
		         stmt.executeUpdate(sql);
				 sql = "CREATE TABLE Items (ItemsID INT PRIMARY KEY,`Name` VARCHAR(100),Price DECIMAL(6,2),Stock Int);";
		         stmt.executeUpdate(sql);

				 int counter = 1;
				 for ( ItemWrapper i : items) {

					 sql = "INSERT INTO Items VALUES(" + counter  + ",'" + i.getItem().getName() + "'," + i.getItem().getCost() + "," + i.getStock() + ")";
					 stmt.executeUpdate(sql);
                     ++counter;
				 }

		         

		         
		         System.out.println("Database save successfully.");
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
	}

	public void ReadItem(ArrayList<ItemWrapper> items)
	{
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Items;");
		)
		{
			while(rs.next())
			{
				items.add(new ItemWrapper(new Item(rs.getString("Name"), rs.getBigDecimal("Price")), rs.getInt("Stock")));
			}
			System.out.println("DataBase Load successfully.");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
}
