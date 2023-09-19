package com.project.doctorappointmentsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Doctor Appointment Management System", version = "1.0", description = "API Documentation for Doctor Appointment Management System"))
public class DoctorAppointmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorAppointmentSystemApplication.class, args);
		System.out.println("Swagger UI URL -"+" http://localhost:8080/swagger-ui.html");
	}
	
}
