package com.project.doctorappointmentsystem.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.doctorappointmentsystem.enums.Department;
import com.project.doctorappointmentsystem.enums.Roles;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "doctor_id")
	private Long doctorId;

	@Column(name = "user_name")
	private String userName; 
	
	@Column(name = "email", unique = true)
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "email is invalid")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "department")
	@Enumerated(EnumType.STRING)
	private Department department;
	
	@OneToMany(mappedBy = "doctor")
	private Set<Appointment> appointments;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clinic_id")
	private Clinic clinic;

	
	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Doctor() {
		super();
	}

	public Doctor(Long doctorId, String userName,
			@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "email is invalid") String email,
			String phone, Department department, Set<Appointment> appointments, Clinic clinic) {
		super();
		this.doctorId = doctorId;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.department = department;
		this.appointments = appointments;
		this.clinic = clinic;
	}

	
	
}
