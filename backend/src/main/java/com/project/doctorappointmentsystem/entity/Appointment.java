package com.project.doctorappointmentsystem.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

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
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.doctorappointmentsystem.enums.AppointmentStatus;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "appointment_id")
	private Long appointmentId;

	@NotNull
	@Column(name = "appointment_date")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date appointmentDate;

	@NotNull
	@Column(name = "appointmnet_time")
	private LocalDateTime appointmentTime;

	@Column(name = "appointment_fees")
	private BigDecimal appointmentFees = BigDecimal.valueOf(500);

	@Column(name = "payment_status")
	private int paymentStatus;

	@Column(name = "appointment_status")
	@Enumerated(EnumType.STRING)
	private AppointmentStatus appointmentStatus;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "clinic_id")
	private Clinic clinic;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@JsonIgnore
	@OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
	private Feedback feedback;

	@JsonIgnore
	@OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
	private Receipt receipt;

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public LocalDateTime getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(LocalDateTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public BigDecimal getAppointmentFees() {
		return appointmentFees;
	}

	public void setAppointmentFees(BigDecimal appointmentFees) {
		this.appointmentFees = appointmentFees;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(Long appointmentId, Date appointmentDate, LocalDateTime appointmentTime,
			BigDecimal appointmentFees, int paymentStatus, AppointmentStatus appointmentStatus, User user,
			Doctor doctor, Feedback feedback, Clinic clinic, Receipt receipt) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.appointmentFees = appointmentFees;
		this.paymentStatus = paymentStatus;
		this.appointmentStatus = appointmentStatus;
		this.user = user;
		this.doctor = doctor;
		this.feedback = feedback;
		this.clinic = clinic;
		this.receipt = receipt;
	}

}
