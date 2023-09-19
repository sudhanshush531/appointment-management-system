package com.project.doctorappointmentsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "f_id")
	private Long fId;
	
	@Column(name = "message")
	private String message;
	
	@OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

	public Long getfId() {
		return fId;
	}

	public void setfId(Long fId) {
		this.fId = fId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Feedback() {
		super();
	}

	public Feedback(Long fId, String message, Appointment appointment) {
		super();
		this.fId = fId;
		this.message = message;
		this.appointment = appointment;
	}

	
	
}
