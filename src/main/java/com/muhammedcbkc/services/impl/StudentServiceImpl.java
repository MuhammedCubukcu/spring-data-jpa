package com.muhammedcbkc.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muhammedcbkc.entities.Student;
import com.muhammedcbkc.repository.StudentRepository;
import com.muhammedcbkc.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Integer id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);

	}



}
