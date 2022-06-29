package com.example.demo;

import java.util.Objects;

public class Subject {
	
	 private final String name;
	    private final double score;
	    Subject(String _name, double _score)
	    {
	        name =_name;
	        score =_score;
	    }

	    public String getName() {
	        return name;
	    }

	    public double getScore() {
	        return score;
	    }
	

}
