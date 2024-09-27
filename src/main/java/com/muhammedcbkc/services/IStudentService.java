package com.muhammedcbkc.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.muhammedcbkc.dto.DtoStudent;
import com.muhammedcbkc.dto.DtoStudentIU;
import com.muhammedcbkc.entities.Student;

public interface IStudentService {
	
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
	
	public List<DtoStudent> getAllStudent();
	
	public DtoStudent getStudentById(Integer id);
	
	public List<Student> getStudentWithParams(String firstName, String lastName);
	
	public List<Student> deleteStudentById(Integer id);
	
	public ResponseEntity<Student> updateStudent(Integer id, Student student);
}	
