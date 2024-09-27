package com.muhammedcbkc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.muhammedcbkc.entities.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	// Buraya kendi özel querylerimizi yazabiliriz.
	
	// HQL -> Hibernate query lanuguage
	// Java Class ile işlem yapuyoruz burda hql query
	@Query(value = "from Student", nativeQuery = false)
	List<Student> findAllStudents();
	
	
	// SQL -> tablo ismi ve tablo içerisindeki kolon isimleri ile sorgular yazılır. 
	@Query(value = "from Student s Where s.id= :studentId")
	Student getStudentById(String studentId);
	

}
