package com.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Model.Game;

public class GameDao {

	private Game game;

	List<String> guessResultList = new ArrayList<>();
	
	@Autowired
	private JdbcTemplate jdbc;
	

	public GameDao() {
		String number = GenerateUniqueFourDigitsNumber();
		game= new Game(number);
	}
	
	private String GenerateUniqueFourDigitsNumber()
	{
		List<String> numberList = new ArrayList<>();
		
		if(numberList.size()<= 10000)
		{
			System.out.println("Reach Number Limit!.");
			return GenerateFourDigitsNumber();
		}
		else
		{
			String number;
		
			do
			{
				number = GenerateFourDigitsNumber();
			}
			while(CheckNumberAlreadyInDatabase(number, numberList));
		
			return number;
		}
		
	}
	
   
	private String GenerateFourDigitsNumber()
	{
		Random rand = null;
		int number = rand.nextInt((10001 - 0) + 1) + 0;
		return String.format("%04d", number);
	}
	
	private Boolean CheckNumberAlreadyInDatabase(String number, List<String> numberList)
	{
		
		for (String no : numberList) {
		   if(no.compareTo(number)== 0)
			   return true;
		}
		
		return false;
	}
	
	
	
}
