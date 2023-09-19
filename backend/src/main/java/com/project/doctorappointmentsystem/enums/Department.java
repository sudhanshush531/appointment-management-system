package com.project.doctorappointmentsystem.enums;

public enum Department {

PHYSICIAN("physician"), RADIOLOGY("Radiology"), NEUROLOGY("Neurology");
	
	private String name;

	Department(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return name;
    }
}
