package com.muhammedcbkc.entities;

import java.util.Date;



import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@Entity
@Table(name = "student")
@Data 	 		
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "first_name", nullable = false, length = 25)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length = 25)
	private String lastName;
	
	@Column(name = "date", nullable = true)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	
}
