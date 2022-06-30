package com.Dao;

import java.util.List;

import com.Object.Course;
import com.Object.Student;
import com.Object.Teacher;

public interface CourseDao {
	 Course getCourseById(int id);
	 List<Course> getAllCourses();
	 Course addCourse(Course course);
	 void updateCourse(Course course);
	 void deleteCourseById(int id);
	    
	 List<Course> getCoursesForTeacher(Teacher teacher);
	 List<Course> getCoursesForStudent(Student student);
}
