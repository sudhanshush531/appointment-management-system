package com.project.doctorappointmentsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.doctorappointmentsystem.entity.MyUserDetails;
import com.project.doctorappointmentsystem.entity.User;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		final User user = userService.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException(username + "Not found");
		}
		return new MyUserDetails(user);
	}

}