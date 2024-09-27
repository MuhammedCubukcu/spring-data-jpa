package com.muhammedcbkc.services.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.muhammedcbkc.dto.DtoStudent;
import com.muhammedcbkc.dto.DtoStudentIU;
import com.muhammedcbkc.entities.Student;
import com.muhammedcbkc.repository.StudentRepository;
import com.muhammedcbkc.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<DtoStudent> getAllStudent() {
		List<DtoStudent> dtoStudentList = new ArrayList<DtoStudent>();
		
		List<Student> studentList = studentRepository.findAll();
		
		for (Student student : studentList) {
			DtoStudent dto = new DtoStudent(); 
			BeanUtils.copyProperties(student, dto);
			dtoStudentList.add(dto);
		}
		return dtoStudentList;
	}

	@Override
	public DtoStudent getStudentById(Integer id) {
		DtoStudent dtoStudent = new DtoStudent();
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) {
			Student dbStudent = optional.get();
			BeanUtils.copyProperties(dbStudent, dtoStudent);
		}
		return dtoStudent;
	}
	
	@Override
	public DtoStudent saveStudent(@RequestBody DtoStudentIU dtoStudentIU) {
		DtoStudent response = new DtoStudent();
		Student student = new Student();
		BeanUtils.copyProperties(dtoStudentIU, student);
		
		Student dbStudent = studentRepository.save(student);
		BeanUtils.copyProperties(dbStudent, response);
		return response;
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
