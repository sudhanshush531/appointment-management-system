package com.project.doctorappointmentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.doctorappointmentsystem.entity.Doctor;
import com.project.doctorappointmentsystem.exception.NotFoundException;
import com.project.doctorappointmentsystem.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	public List<Doctor> getAllDoctorData() {
		Optional<List<Doctor>> doctorDetails = Optional.ofNullable(doctorRepository.findAll());
		if (!doctorDetails.isPresent()) {
			throw new NotFoundException("No data found ");
		}
		return doctorDetails.get();
	}
}
