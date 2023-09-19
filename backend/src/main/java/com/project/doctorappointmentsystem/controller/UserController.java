package com.project.doctorappointmentsystem.controller;

import java.util.List;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.doctorappointmentsystem.entity.Receipt;
import com.project.doctorappointmentsystem.entity.User;
import com.project.doctorappointmentsystem.service.ReceiptService;
import com.project.doctorappointmentsystem.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = "/users")
@Log4j2
public class UserController {

	@Autowired
	private UserService userService;


	@Operation(summary = "Fetch All the Users Data", description = "This API will Fetch All the Users Data", parameters = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Patient data Found Successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Receipt.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid data supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
			@ApiResponse(responseCode = "404", description = "Data not found", content = @Content) })
	@GetMapping("/all")
	public List<User> getAllReceiptDetails() {
		return userService.getAllUsers();
	}
	
	@Operation(summary = "User Login", description = "This API will authenticate the user", parameters = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "User data Found Successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Receipt.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid data supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
			@ApiResponse(responseCode = "404", description = "Data not found", content = @Content) })
	@PostMapping("/login")
	public boolean loginUser(@RequestBody User user) {
		log.info("User logged in successfully with userName {}",user.getUsername());
		return userService.login(user);
	}

	@Operation(summary = "User Registration", description = "This API will help registering the user", parameters = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "User data Found Successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Receipt.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid data supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
			@ApiResponse(responseCode = "404", description = "Data not found", content = @Content) })
	@PostMapping("/register")
	public boolean regitserUser(@RequestBody User user) {
		log.info("New user is created with details {}",user);
		return userService.register(user);
	}
}
