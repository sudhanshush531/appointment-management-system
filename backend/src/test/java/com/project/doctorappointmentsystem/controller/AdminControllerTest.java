package com.project.doctorappointmentsystem.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.doctorappointmentsystem.entity.Appointment;
import com.project.doctorappointmentsystem.entity.Clinic;
import com.project.doctorappointmentsystem.entity.Doctor;
import com.project.doctorappointmentsystem.enums.AppointmentStatus;
import com.project.doctorappointmentsystem.repository.AppointmentRepository;
import com.project.doctorappointmentsystem.service.AdminService;
import com.project.doctorappointmentsystem.service.AppointmentService;

@WebMvcTest(AdminController.class)
@ContextConfiguration(classes = { AdminController.class })
@ActiveProfiles("test")
public class AdminControllerTest {

	private static final String BASE_URL = "/admins";

	@MockBean
	private AdminService adminService;

	@MockBean
	private AppointmentService appointmentService;
	
	@MockBean
	private AppointmentRepository appointmentRepository;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	private List<Appointment> appointments;
	private List<Clinic> clinics;
	private List<Doctor> doctors;

	@BeforeEach
	void setUp() {
		appointments = new ArrayList<>();
		Appointment appointment1 = new Appointment();
		appointment1.setAppointmentId(1L);
		appointment1.setAppointmentStatus(AppointmentStatus.COMPLETED);
		appointments.add(appointment1);

		clinics = new ArrayList<>();
		Clinic clinic1 = new Clinic();
		clinic1.setClinicId(1L);
		clinic1.setName("Test Clinic");
		clinics.add(clinic1);

		doctors = new ArrayList<>();
		Doctor doctor1 = new Doctor();
		doctor1.setDoctorId(1L);
		doctor1.setUserName("Test Doctor");
		doctors.add(doctor1);
	}

	@Test
	public void testCreateAppointment() throws Exception {
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(1L);
		appointment.setAppointmentStatus(AppointmentStatus.COMPLETED);

		when(appointmentService.newAppointment(appointment)).thenReturn(appointment);

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post(BASE_URL + "/new").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(appointment)))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String resultContent = result.getResponse().getContentAsString();
		Appointment resultAppointment = objectMapper.readValue(resultContent, Appointment.class);

		verify(appointmentService).newAppointment(appointment);

		assert appointment.getAppointmentId().equals(resultAppointment.getAppointmentId());
		assert appointment.getAppointmentStatus().equals(resultAppointment.getAppointmentStatus());
	}

	@Test
	public void testGetAllBookingDetails() throws Exception {
		when(appointmentService.getAllAppointmentData()).thenReturn(appointments);

		mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/all").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(appointments)));
	}

}