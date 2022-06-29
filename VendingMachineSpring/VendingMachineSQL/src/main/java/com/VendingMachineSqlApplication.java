package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

/*
@SpringBootApplication
public class VendingMachineSqlApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(VendingMachineSqlApplication.class, args);
	}

	

}
*/
/*
@SpringBootApplication
public class VendingMachineSqlApplication implements CommandLineRunner {

	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(VendingMachineSqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO items (Name ,Price, Stock ) VALUES (? ,? ,?)";
		
		int result = jdbcTemplate.update(sql, "Coke", 1.20, 10);
		
		if(result > 0 )
		{
			System.out.println("Item inserted");
		}
	}

}
*/