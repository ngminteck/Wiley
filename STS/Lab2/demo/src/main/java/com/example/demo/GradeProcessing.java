package com.example.demo;

import java.util.ArrayList;

public class GradeProcessing {

	public static String ProcessGrade(String studentName , ArrayList<Subject> subjectArrayList)
    {

        double grade = 0.0;

        for (Subject subject : subjectArrayList) {
            grade += subject.getScore();
        }

        if(subjectArrayList.size() > 0)
            grade /= subjectArrayList.size();

        if(grade >= 90)
            return "Gratz " + studentName + " !! you got A!!!";
        else if (grade >= 80 )
            return "Good job " + studentName + " ! you got B!!";
        else if (grade >= 70 )
            return "Not bad " + studentName +" ! you got C!!";
        else
            return "So Sorry " + studentName + " , you failed the module. Digipen college sad life... =(";
    }
}
