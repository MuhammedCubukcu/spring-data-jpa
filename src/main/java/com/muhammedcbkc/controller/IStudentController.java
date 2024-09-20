package com.muhammedcbkc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.muhammedcbkc.entities.Student;

public interface IStudentController {
	
	public Student saveStudent(Student student);
	
	public List<Student> getAllStudent();
	
	public Student getStudentById(Integer id);
	
	public List<Student> getStudentWithParams(String firstName, String lastName);
	
	public List<Student> deleteStudentById(Integer id);
	
	public ResponseEntity<Student> updateStudent(Integer id, Student student);
}
