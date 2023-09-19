package com.project.doctorappointmentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.doctorappointmentsystem.entity.Feedback;
import com.project.doctorappointmentsystem.exception.NotFoundException;
import com.project.doctorappointmentsystem.repository.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;
	
	public List<Feedback> getAllFeedbackData() {
		Optional<List<Feedback>> feedbacks = Optional.ofNullable(feedbackRepository.findAll());
		if (!feedbacks.isPresent()) {
			throw new NotFoundException("No data found ");
		}
		return feedbacks.get();
	}
}
