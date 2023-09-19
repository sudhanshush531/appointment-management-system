package com.project.doctorappointmentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.doctorappointmentsystem.entity.Appointment;
import com.project.doctorappointmentsystem.entity.Receipt;
import com.project.doctorappointmentsystem.exception.NotFoundException;
import com.project.doctorappointmentsystem.repository.ReceiptRepository;

@Service
public class ReceiptService {

	@Autowired
	private ReceiptRepository receiptRepository;
	
	public Receipt generateReceipt(Receipt receipt) {
		return receiptRepository.save(receipt);
	}
	
	public List<Receipt> getAllReceiptData() {
		Optional<List<Receipt>> receipts = Optional.ofNullable(receiptRepository.findAll());
		if (!receipts.isPresent()) {
			throw new NotFoundException("No data found ");
		}
		return receipts.get();
	}
	
	public Receipt getAllReceiptDataByReceiptId(Long receiptId) {
		Optional<Receipt> receipts = receiptRepository.findById(receiptId);
		if (!receipts.isPresent()) {
			throw new NotFoundException("No data found ");
		}
		return receipts.get();
	}
	
	public Appointment getAllAppointmentDataByReceiptId(Long receiptId) {
		Optional<Receipt> receipts = receiptRepository.findById(receiptId);
		if (!receipts.isPresent()) {
			throw new NotFoundException("No data found ");
		}
		return receipts.get().getAppointment();
	}
}
