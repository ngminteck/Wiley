package com.Dao;

import java.util.List;

import com.Object.Teacher;

public interface TeacherDao {
	 	Teacher getTeacherById(int id);
	    List<Teacher> getAllTeachers();
	    Teacher addTeacher(Teacher teacher);
	    void updateTeacher(Teacher teacher);
	    void deleteTeacherById(int id);
}
