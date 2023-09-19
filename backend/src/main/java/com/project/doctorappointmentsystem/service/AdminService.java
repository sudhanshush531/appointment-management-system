package com.project.doctorappointmentsystem.service;

import java.util.List;
import java.util.Optional;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.doctorappointmentsystem.entity.Appointment;
import com.project.doctorappointmentsystem.entity.Clinic;
import com.project.doctorappointmentsystem.entity.Doctor;
import com.project.doctorappointmentsystem.entity.Feedback;
import com.project.doctorappointmentsystem.entity.Receipt;
import com.project.doctorappointmentsystem.exception.NotFoundException;
import com.project.doctorappointmentsystem.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private ReceiptService receiptService;
	
	@Autowired
	private FeedbackService feedbackService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private ClinicService clinicService;
	
	
	public List<Appointment> getAllAppointmentData() {
		
		return appointmentService.getAllAppointmentData();
	}

	public Appointment getAppointmentDataByAppointmentId(Long appointmentId) {
		return appointmentService.getAppointmentDataByAppointmentId(appointmentId);
	}

	public Clinic getClinicDataByAppointmentId(Long appointmentId) {
		return appointmentService.getClinicDataByAppointmentId(appointmentId);
	}

	public Feedback getFeedbackDataByAppointmentId(Long appointmentId) {
		return appointmentService.getFeedbackDataByAppointmentId(appointmentId);
	}

	public Receipt getReceiptByAppointmentId(Long appointmentId) {	
		return appointmentService.getReceiptByAppointmentId(appointmentId);
	}
	
	public Appointment updateAppointment(Long appointmentId, Appointment appointment) {
		return appointmentService.updateAppointment(appointmentId, appointment);
	}

	public String cancelAppointmentByIAppointmentd(Long id) {
		appointmentService.cancelAppointmentByIAppointmentd(id);
		return "Appointment with Id "+id+" deleted successfully.";
	}
	
	public Appointment getAllAppointmentDataByReceiptId(Long receiptId) {
		return appointmentService.getAppointmentDataByAppointmentId(receiptId);
	}

	public List<Appointment> getAppointmentsByClinicId(Long clinicId) {	
		return clinicService.getAllAppointByClinicId(clinicId);
	}
	
	public List<Doctor> getAllDoctorsData() {
		return doctorService.getAllDoctorData();
	}

	public List<Clinic> getAllClinicsData() {	
		return clinicService.getAllClinicData();
	}
	
}
