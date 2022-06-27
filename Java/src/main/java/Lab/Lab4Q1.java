package main.java.Lab;

import java.util.ArrayList;
import java.util.Scanner;

class Subject
{
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

class Student
{

    private final String name;
    private final ArrayList<Subject> subjectsArr = new ArrayList<>();
    Student(String _name)
    {
        name = _name;
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

class GradeProcessing
{
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


public class Lab4Q1
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in).useDelimiter("\n");
        int numberOfStudent = -1;

        do {
            System.out.println("How many student?");
            if(userInput.hasNextInt())
                numberOfStudent = userInput.nextInt();
            else
                userInput.next();
        }
        while (numberOfStudent < 0);

        for(int i = 0; i <= numberOfStudent ; ++i)
        {
            int no = i + 1;
            System.out.println("Lab.Student " + no + " name");
            Student student = new Student(userInput.next());
            System.out.println("Please enter the student" + no + " module name, follow by space and the score");
            String[] data = userInput.next().split(" ");

            for(int j = 0; j < data.length ; j+= 2)
            {
                if( j + 1 > data.length)
                    break;

                double score = -1.0;
                try
                {
                    score = Double.parseDouble(data[j + 1]);
                }
                catch(NumberFormatException ignored)
                {

                }

                if(score < 0)
                    continue;

                student.AddSubject(data[j],score);
                System.out.println("Lab.Subject Name:" + data[j] + " score:" +score);
            }

            System.out.println(GradeProcessing.ProcessGrade(student.getName(),student.getSubjectsArr()));

        }

    }
}
