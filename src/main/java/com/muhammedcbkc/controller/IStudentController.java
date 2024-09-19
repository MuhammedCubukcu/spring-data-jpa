package com.muhammedcbkc.controller;

import java.util.List;

import com.muhammedcbkc.entities.Student;

public interface IStudentController {
	
	public Student saveStudent(Student student);
	
	public List<Student> getAllStudent();
	
	public Student getStudentById(Integer id);
}
