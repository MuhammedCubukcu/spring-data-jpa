package com.muhammedcbkc.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhammedcbkc.controller.IStudentController;
import com.muhammedcbkc.entities.Student;
import com.muhammedcbkc.services.IStudentService;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {
	
	@Autowired
	private IStudentService studentService;
	
	@GetMapping("/list")
	@Override
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}
	
	@GetMapping("/list/{id}")
	@Override
	public Student getStudentById(@PathVariable(name="id", required = true) Integer id) {
		return studentService.getStudentById(id);
	}
	
	
	@PostMapping("/save")
	@Override
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}


	
	
	
}
