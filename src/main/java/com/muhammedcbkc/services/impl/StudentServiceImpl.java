package com.muhammedcbkc.services.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@Override	
	public List<Student> getStudentWithParams(String firstName, String lastName) {
		List<Student> newStudentList = new ArrayList<Student>();
		if (firstName == null && lastName == null) {
			return newStudentList;
		}
		for (Student student : studentRepository.findAll()) {
			if(firstName != null && lastName != null) {
				if(student.getFirstName().equalsIgnoreCase(firstName) && student.getLastName().equalsIgnoreCase(lastName)) {
					newStudentList.add(student);
				}
			}
			if(firstName != null && lastName == null) {
				if (student.getFirstName().equalsIgnoreCase(firstName)) {
					newStudentList.add(student);
				}
			}
			if (firstName == null && lastName != null) {
				if (student.getLastName().equalsIgnoreCase(lastName)) {
					newStudentList.add(student);
				}
			}
		}
		return newStudentList;
	}
	
	public List<Student> deleteStudentById(Integer id){
		for (Student student : studentRepository.findAll()) {
			if (student.getId().equals(id)) {
				studentRepository.deleteById(id);
			}
		}
		return studentRepository.findAll();
	}

	@Override
	public ResponseEntity<Student> updateStudent(Integer id, Student student) {
	
	    Optional<Student> optionalStudent = studentRepository.findById(id);
	    if (optionalStudent.isPresent()) {
	        Student existingStudent = optionalStudent.get(); 
	        
	        existingStudent.setFirstName(student.getFirstName());
	        existingStudent.setLastName(student.getLastName());
	        existingStudent.setBirthday(student.getBirthday());
	      
	        studentRepository.save(existingStudent);
	      
	        return ResponseEntity.ok(existingStudent);
	    } else {
	        
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}


}
