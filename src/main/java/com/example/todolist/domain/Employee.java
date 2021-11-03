package com.example.todolist.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "employee")
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Empty first_name")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "Empty last_name")
	@Column(name = "last_name")
	private String lastName;

	@NotBlank(message = "Empty country")
	@Column(name = "country")
	private String country;

	@NotBlank(message = "address")
	@Column(name = "address")
	private String address;

	@NotBlank(message = "phone_number")
	@Column(name = "phone_number")
	private String phoneNumber;
}
