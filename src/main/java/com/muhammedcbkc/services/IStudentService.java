package com.muhammedcbkc.services;

import java.util.List;

import com.muhammedcbkc.entities.Student;

public interface IStudentService {
	
	public Student saveStudent(Student student);
	
	public List<Student> getAllStudent();
	
	public Student getStudentById(Integer id);
}	
