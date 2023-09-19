package com.project.doctorappointmentsystem.enums;

public enum AppointmentStatus {

	CONFIRMED("Confirmed"), CANCELLED("Cancelled"), COMPLETED("Completed");
	
	private String status;

	AppointmentStatus(String status) {
        this.status = status;
    }

    public String getAppointmentStatus() {
        return status;
    }
}
