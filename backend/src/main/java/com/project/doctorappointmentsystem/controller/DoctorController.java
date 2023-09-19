package com.project.doctorappointmentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.doctorappointmentsystem.entity.Doctor;
import com.project.doctorappointmentsystem.service.DoctorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = "/doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;


	@Operation(summary = "Fetch All the Doctors Data", description = "This API will Fetch All the Doctors Data", parameters = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Doctor Details data Found Successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Doctor.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid data supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
			@ApiResponse(responseCode = "404", description = "Data not found", content = @Content) })
	@GetMapping("/all")
	public List<Doctor> getAllDoctorDetails() {
		return doctorService.getAllDoctorData();
	}
}
