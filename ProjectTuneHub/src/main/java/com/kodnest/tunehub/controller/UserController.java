package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.model.LoginData;
import com.kodnest.tunehub.service.SongService;
import com.kodnest.tunehub.serviceimpl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@CrossOrigin("*")
@RestController
public class UserController {

	@Autowired
	UserServiceImpl serviceImpl;

	@Autowired
	SongService songService;

	@PostMapping("/register")
	public String addUser(@RequestBody User user) 
	{
		//email taken from registration form
		String email = user.getEmail();

		//checking if the email as entered in registration  form 
		// is present in DB or not.
		boolean status = serviceImpl.emailExists(email);

		if(status == false) {
			serviceImpl.addUser(user);
			System.out.println("User added");
		}
		else {
			System.out.println("User already exists");
		}

		return "login";
	}


	@PostMapping("/validate")
	public String validate(@RequestBody LoginData data, HttpSession session, Model model) {

		if(serviceImpl.validateUser(data.getEmail(), data.getPassword()) == true){

			String role = serviceImpl.getRole(data.getEmail());

			session.setAttribute("email", data.getEmail());

			if(role.equals("admin")) {
				System.out.println(data);
				return "adminhome";
			}
			else {
				System.out.println(data);

				User user = serviceImpl.getUser(data.getEmail());
				boolean userstatus = user.isIspremium();
				List<Song> fetchAllSongs = songService.fetchAllSongs();
				model.addAttribute("songs", fetchAllSongs);

				model.addAttribute("ispremium", userstatus);
				return "customerhome";
			}
		}	
		else {
			return "login";
		}	
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}


	@GetMapping("/exploresongs")
	public String exploresongs(String email) {
		return email;


	}


}







