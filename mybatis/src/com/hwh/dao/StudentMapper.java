package com.hwh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hwh.model.Student;

public interface StudentMapper {

	Student getStudent(int id);

	List<Student> getStudents(int id);

	void insertStudent(Student student);

	void updateStudent(Student student);

	void deleteStudent(int id);

}
