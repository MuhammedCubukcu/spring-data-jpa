package com.muhammedcbkc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muhammedcbkc.entities.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	

}
