package com.project.doctorappointmentsystem.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Receipt {

	@Id
	@Column(name = "receipt_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long receiptId;
	
	@Column(name = "creation_date")
	private LocalDateTime creationDate;
	

	@OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;


	@Column(nullable = false)
    private BigDecimal amount;


	public Long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(Long receiptId) {
		this.receiptId = receiptId;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Receipt(Long receiptId, LocalDateTime creationDate, Appointment appointment, BigDecimal amount) {
		super();
		this.receiptId = receiptId;
		this.creationDate = creationDate;
		this.appointment = appointment;
		this.amount = amount;
	}	
	
	public Receipt(LocalDateTime creationDate, BigDecimal amount, Appointment appointment) {
		super();
		this.creationDate = creationDate;
		this.amount = amount;
		this.appointment = appointment;
	}

	
	public Receipt() {
		super();
	}

	
	
}
