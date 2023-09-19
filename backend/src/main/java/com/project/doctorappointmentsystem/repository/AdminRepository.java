package com.project.doctorappointmentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.doctorappointmentsystem.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

}
