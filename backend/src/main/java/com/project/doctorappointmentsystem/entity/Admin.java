package com.project.doctorappointmentsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import com.project.doctorappointmentsystem.enums.Roles;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="admin_id")
	int adminId;
	
	@Column(name="username")
	String username;
	
	@Column(name="email",unique = true)
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",
    message="email is invalid")
	String email;
	
	@Column(name="password")
	String password;
	
	@Column(name="role")
	Roles role = Roles.NURSE;
}
