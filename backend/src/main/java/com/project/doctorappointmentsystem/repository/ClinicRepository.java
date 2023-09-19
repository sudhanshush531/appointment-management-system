package com.project.doctorappointmentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.doctorappointmentsystem.entity.Clinic;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long>{

}
