package com.project.doctorappointmentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.doctorappointmentsystem.entity.Appointment;
import com.project.doctorappointmentsystem.entity.Receipt;
import com.project.doctorappointmentsystem.service.ReceiptService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = "/receipts")
public class ReceiptController {

	@Autowired
	private ReceiptService receiptService;


	@Operation(summary = "Fetch All the Receipt Data", description = "This API will Fetch All the Receipt Data", parameters = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Patient data Found Successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Receipt.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid data supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
			@ApiResponse(responseCode = "404", description = "Data not found", content = @Content) })
	@GetMapping("/all")
	public List<Receipt> getAllReceiptDetails() {
		return receiptService.getAllReceiptData();
	}
	
	@Operation(summary = "Fetch the Receipt Data by receiptId", description = "This API will Fetch Receipt Data by receiptId", parameters = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Receipt data Found Successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Receipt.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid data supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
			@ApiResponse(responseCode = "404", description = "Data not found", content = @Content) })
	@GetMapping("/all/{receiptId}")
	public Receipt getReceiptDetailsByReceiptId(@PathVariable Long receiptid) {
		return receiptService.getAllReceiptDataByReceiptId(receiptid);
	}
	
	@Operation(summary = "Fetch the Appointments Data by receiptId", description = "This API will Fetch the Appointments Data by receiptId", parameters = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Appointment details Found Successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Receipt.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid data supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
			@ApiResponse(responseCode = "404", description = "Data not found", content = @Content) })
	@GetMapping("/appointment/{receiptId}")
	public Appointment getAppointmentDetailsByReceiptId(@PathVariable Long receiptId) {
		return receiptService.getAllAppointmentDataByReceiptId(receiptId);
	}
}
