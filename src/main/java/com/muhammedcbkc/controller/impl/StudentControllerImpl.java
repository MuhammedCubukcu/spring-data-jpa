package com.muhammedcbkc.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.muhammedcbkc.controller.IStudentController;
import com.muhammedcbkc.dto.DtoStudent;
import com.muhammedcbkc.dto.DtoStudentIU;
import com.muhammedcbkc.entities.Student;
import com.muhammedcbkc.services.IStudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {
	
	@Autowired
	private IStudentService studentService;
	
	
	@GetMapping("/list")
	@Override
	public List<DtoStudent> getAllStudent() {
		return studentService.getAllStudent();
	}
	
	@GetMapping("/list/{id}")
	@Override
	public DtoStudent getStudentById(@PathVariable(name="id", required = true) Integer id) {
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/with-params")
	@Override
	public List<Student> getStudentWithParams(@RequestParam(name = "firstName", required = false) String firstName,
										@RequestParam(name = "lastName" ,required = false) String lastName) {
		return studentService.getStudentWithParams(firstName, lastName);
	}
	
	
	@PostMapping("/save")
	@Override
	public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU dtoStudentIU) {
		return studentService.saveStudent(dtoStudentIU);
	}


	@DeleteMapping("/delete/{id}")
	@Override
	public List<Student> deleteStudentById(@PathVariable(name="id", required = true) Integer id) {
		return studentService.deleteStudentById(id);
	}
	
	@PutMapping("/update/{id}")
	@Override
	public ResponseEntity<Student> updateStudent(@PathVariable(name = "id", required = true) Integer id, 
								 @RequestBody Student student) {
		
		return studentService.updateStudent(id, student);
	}


	

	



	
	
	
}
