package com.muhammedcbkc.dto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {
	
	@NotEmpty(message = "Bu alan boş bırakılamaz!")
	private String firstName;
	
	@NotEmpty(message = "Bu alan boş bırakılamaz!")
	private String lastName;
	
	private Date birthday;
}
