package com.project.doctorappointmentsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.doctorappointmentsystem.entity.Appointment;
import com.project.doctorappointmentsystem.entity.Clinic;
import com.project.doctorappointmentsystem.entity.Doctor;
import com.project.doctorappointmentsystem.repository.AppointmentRepository;
import com.project.doctorappointmentsystem.service.AdminService;
import com.project.doctorappointmentsystem.service.AppointmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = "/admins")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Operation(summary = "Create new Appointment", description = "This API will create new Appointment", parameters = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Appointment Details data Found Successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Appointment.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid data supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
			@ApiResponse(responseCode = "404", description = "Data not found", content = @Content) })
	@PostMapping("/new")
	public Appointment createAppointment(@Valid @RequestBody Appointment appointment) {
		return appointmentService.newAppointment(appointment);
	}
	
	@Operation(summary = "Fetch All the Appointment Data", description = "This API will Fetch All the Appointment Data", parameters = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Appointment Details data Found Successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Appointment.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid data supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
			@ApiResponse(responseCode = "404", description = "Data not found", content = @Content) })
	@GetMapping("/all")
	public List<Appointment> getAllBookingDetails() {
		return appointmentService.getAllAppointmentData();
	}
	
	@Operation(summary = "Fetch All the Appointment Data of a specific Clinic", description = "This API will Fetch All the Appointment Data of a specific Clinic", parameters = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Appointment Details data Found Successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Appointment.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid data supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
			@ApiResponse(responseCode = "404", description = "Data not found", content = @Content) })
	
	@GetMapping("/appointments/{clinicId}")
	public List<Appointment> showAppointmentsByClinicId(@PathVariable Long clinicId) {
	     return adminService.getAppointmentsByClinicId(clinicId);
	}
	
	@Operation(summary = "Fetch All the Clinic Data", description = "This API will Fetch All the Clinic Data", parameters = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Clinics data Found Successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Clinic.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid data supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
			@ApiResponse(responseCode = "404", description = "Data not found", content = @Content) })
	@GetMapping("/clinics")
	public List<Clinic> showClinics() {
		return adminService.getAllClinicsData();
	}
	
	@Operation(summary = "Fetch All the Doctors Data", description = "This API will Fetch All the Doctors Data", parameters = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Doctors data Found Successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Clinic.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid data supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
			@ApiResponse(responseCode = "404", description = "Data not found", content = @Content) })
	@GetMapping("/doctors")
	public List<Doctor> showDoctors() {
		return adminService.getAllDoctorsData();
	}
	
}
