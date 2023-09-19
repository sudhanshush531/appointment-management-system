package com.project.doctorappointmentsystem.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Clinic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "clinic_id")
	private Long clinicId;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "name")
	private String name;	

	@OneToMany(mappedBy = "clinic")
	private Set<Appointment> appointments;
	
	@OneToMany(mappedBy = "clinic")
	private Set<Doctor> doctors;

	public Long getClinicId() {
		return clinicId;
	}

	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Clinic() {
		super();
	}

	public Clinic(Long clinicId, String location, String name, Set<Appointment> appointments, Set<Doctor> doctors) {
		super();
		this.clinicId = clinicId;
		this.location = location;
		this.name = name;
		this.appointments = appointments;
		this.doctors = doctors;
	}
	
}
