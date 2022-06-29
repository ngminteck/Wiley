package com.example.demo;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


public class Student 
{
	private @Id @GeneratedValue Long id;
	private final String name;
    private final ArrayList<Subject> subjectsArr = new ArrayList<>();

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Subject> getSubjectsArr() {
        return subjectsArr;
    }

    public void AddSubject(String name, double score)
    {
        subjectsArr.add(new Subject(name,score));
    }
    
}

    
