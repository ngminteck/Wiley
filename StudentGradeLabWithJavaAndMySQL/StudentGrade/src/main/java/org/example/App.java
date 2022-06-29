package org.example;

import java.sql.*;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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

    private final int id;
    private final String name;
    private final ArrayList<Subject> subjectsArr = new ArrayList<>();

    public Student(int id, String name) {
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

@SpringBootApplication
public class App 
{
    public static void main( String[] args ) throws SQLException {

        SpringApplication.run(DemoApplication.class, args);

        String url = "jdbc:mysql://localhost:3306/studentgradelab";
        String user = "root";
        String password = "[901f]";
        Connection conn = DriverManager.getConnection(url, user, password);

        /*
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery("select * from employees");

        while(result.next()){
            System.out.println(result.getString("first_name")+" "+result.getString("salary"));
        }
        */

        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery("select * from student");

        while (result.next()) {
            System.out.println(result.getString("StudentID") + " " + result.getString("Name"));


            Student student = new Student(result.getInt("StudentID"),result.getString("Name") );

            Statement st1 = conn.createStatement();
            ResultSet grade = st1.executeQuery("select * from grade where StudentID =" + result.getString("StudentID") );

            while (grade.next()) {

                student.AddSubject(grade.getString("Subject2_Name"),grade.getInt("Subject2_Score"));
                student.AddSubject(grade.getString("Subject3_Name"),grade.getInt("Subject3_Score"));
                student.AddSubject(grade.getString("Subject1_Name"),grade.getInt("Subject1_Score"));
                student.AddSubject(grade.getString("Subject4_Name"),grade.getInt("Subject4_Score"));
            }

            System.out.println(GradeProcessing.ProcessGrade(student.getName(),student.getSubjectsArr()));


        }
    }
}
