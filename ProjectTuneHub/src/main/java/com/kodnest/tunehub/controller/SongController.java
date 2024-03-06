package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.service.SongService;

@CrossOrigin("*")
@RestController
public class SongController {

	@Autowired
	SongService songService;

	@PostMapping("/addsong")
	public String addsong(@ModelAttribute Song song){

		System.out.println(song.getArtist());
		boolean songStatus = songService.songExists(song.getName());
		if(songStatus==false) {
			songService.addSong(song);	
			System.out.println("Song added Successfully");
		}
		else {
			System.out.println("Song already exists");
		}
		return "adminhome";
	}

	@GetMapping("/viewsongs")
	public String viewsongs(Model model) {
		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "displaysongs";
	}

	@GetMapping("/playsongs")
	public String playsongs(Model model) {
		boolean premium = false;
		if(premium) {
			List<Song> songList = songService.fetchAllSongs();
			model.addAttribute("songs", songList);
			return "displaysongs";
		}else {
			return "subscriptionform";
		}
	}



}










