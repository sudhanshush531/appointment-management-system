package com.project.doctorappointmentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.doctorappointmentsystem.entity.User;
import com.project.doctorappointmentsystem.exception.NotFoundException;
import com.project.doctorappointmentsystem.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User save(final User userData) {
		User userModel = populateUserData(userData);
		return userRepository.save(userModel);
	}
	
	public User findByEmail(String email) {
		Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
		if (user.isPresent()) {
			return user.get();
		}
		throw new NotFoundException("No data found with this -" + email);
	}


	private User populateUserData(final User userData) {
		User user = new User();
		user.setUsername(userData.getUsername());
		user.setEmail(userData.getEmail());
		user.setPassword(passwordEncoder.encode(userData.getPassword()));
		user.setRole(userData.getRole());
		return user;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	
	public boolean login(User user) {
		System.out.println("login service");
		int counter = 0;
		
		List<User> users = (List<User>)userRepository.findAll();
		for(User myUser:users) {
			if(myUser.getEmail().equals(user.getEmail()) 
					&& myUser.getPassword().equals(user.getPassword())){
				counter++;
				break;
			}
		}
		if(counter>0) {
			return true ;
		}
		else {
			return false;
		}
	}

	public boolean register(User user) {
		User myUser = userRepository.save(user);
		if(myUser.getEmail().equals(user.getEmail())) {
			return true;
		}
		else {
			return false;
		}
	  }
}
