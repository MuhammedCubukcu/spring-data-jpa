package com.muhammedcbkc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.muhammedcbkc.dto.DtoStudent;
import com.muhammedcbkc.dto.DtoStudentIU;
import com.muhammedcbkc.entities.Student;

public interface IStudentController {
	
	public DtoStudent saveStudent(DtoStudentIU student);
	
	public List<DtoStudent> getAllStudent();
	
	public DtoStudent getStudentById(Integer id);
	
	public List<Student> getStudentWithParams(String firstName, String lastName);
	
	public List<Student> deleteStudentById(Integer id);
	
	public ResponseEntity<Student> updateStudent(Integer id, Student student);
}
