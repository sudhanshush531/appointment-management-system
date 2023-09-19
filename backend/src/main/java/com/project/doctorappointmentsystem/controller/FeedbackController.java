package com.project.doctorappointmentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.doctorappointmentsystem.entity.Feedback;
import com.project.doctorappointmentsystem.service.FeedbackService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = "/feedbacks")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;


	@Operation(summary = "Fetch All the Feedback Data", description = "This API will Fetch All the Feedback Data", parameters = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Doctor Details data Found Successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Feedback.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid data supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
			@ApiResponse(responseCode = "404", description = "Data not found", content = @Content) })
	@GetMapping("/all")
	public List<Feedback> getAllFeedbackDetails() {
		return feedbackService.getAllFeedbackData();
	}
}
