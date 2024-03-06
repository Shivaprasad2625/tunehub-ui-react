package com.kodnest.tunehub.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.repository.UserRepository;
import com.kodnest.tunehub.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	public String addUser(User user) {
		userRepository.save(user);
		return "User added succussfully";
	}

	//To check the duplicate entries
	public boolean emailExists(String email) {

		if(userRepository.findByEmail(email)!=null) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean validateUser(String email, String password) {
		User user = userRepository.findByEmail(email);

		String dbpwd = user.getPassword();
		if(password.equals(dbpwd)) {
			return true;
		}
		else {
			return false;			
		}

	}

	public String getRole(String email) {
		
		User user = userRepository.findByEmail(email);
		return user.getRole();
		
	}
	
	@Override
	public User getUser(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}

}




