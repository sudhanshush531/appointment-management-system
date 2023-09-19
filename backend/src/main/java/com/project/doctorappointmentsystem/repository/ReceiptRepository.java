package com.project.doctorappointmentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.doctorappointmentsystem.entity.Receipt;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long>{

}
