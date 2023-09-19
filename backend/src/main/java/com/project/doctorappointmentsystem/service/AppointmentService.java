package com.project.doctorappointmentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.doctorappointmentsystem.entity.Appointment;
import com.project.doctorappointmentsystem.entity.Clinic;
import com.project.doctorappointmentsystem.entity.Feedback;
import com.project.doctorappointmentsystem.entity.Receipt;
import com.project.doctorappointmentsystem.exception.NotFoundException;
import com.project.doctorappointmentsystem.repository.AppointmentRepository;
import com.project.doctorappointmentsystem.repository.ReceiptRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private ReceiptService receiptService;

	public Appointment newAppointment(Appointment appointment) {
		Appointment apt = appointmentRepository.save(appointment);
		receiptService.generateReceipt(new Receipt(appointment.getAppointmentTime(),appointment.getAppointmentFees(),apt));
		return apt;
	}
	
	public List<Appointment> getAllAppointmentData() {
		Optional<List<Appointment>> appointments = Optional.ofNullable(appointmentRepository.findAll());
		if (!appointments.isPresent()) {
			throw new NotFoundException("No data found ");
		}
		return appointments.get();
	}

	public Appointment getAppointmentDataByAppointmentId(Long appointmentId) {
		Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);
		if (!appointment.isPresent()) {
			throw new NotFoundException("No data found ");
		}
		return appointment.get();
	}

	public Clinic getClinicDataByAppointmentId(Long appointmentId) {
		Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);
		if (!appointment.isPresent()) {
			throw new NotFoundException("No data found ");
		}
		return appointment.get().getClinic();
	}

	public Feedback getFeedbackDataByAppointmentId(Long appointmentId) {
		Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);
		if (!appointment.isPresent()) {
			throw new NotFoundException("No data found ");
		}
		return appointment.get().getFeedback();
	}

	public Receipt getReceiptByAppointmentId(Long appointmentId) {
		Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);
		if (!appointment.isPresent()) {
			throw new NotFoundException("No data found ");
		}
		return appointment.get().getReceipt();
	}
	
	public Appointment updateAppointment(Long appointmentId, Appointment appointment) {
		Optional<Appointment> appointmentdetails = appointmentRepository.findById(appointmentId);
		if (appointmentdetails.isPresent()) {
			Appointment apt = appointmentdetails.get();
			apt.setAppointmentDate(appointment.getAppointmentDate());
			apt.setAppointmentFees(appointment.getAppointmentFees());
			apt.setAppointmentStatus(appointment.getAppointmentStatus());
			apt.setAppointmentTime(appointment.getAppointmentTime());
			apt.setClinic(appointment.getClinic());
			apt.setFeedback(appointment.getFeedback());
			apt.setPaymentStatus(appointment.getPaymentStatus());
			apt.setReceipt(appointment.getReceipt());
			return appointmentRepository.save(apt);
		}
		throw new NotFoundException("No Appointment Found with id " + appointmentId);
	}

	public String cancelAppointmentByIAppointmentd(Long id) {
		Optional<Appointment> apt = appointmentRepository.findById(id);
		if (apt.isPresent()) {
			appointmentRepository.deleteById(id);
			return "Appointment is Cancelled Successfully";
		}
		throw new NotFoundException("No data found with this -" + id);

	}

}
