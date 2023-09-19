package com.project.doctorappointmentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.doctorappointmentsystem.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

}
