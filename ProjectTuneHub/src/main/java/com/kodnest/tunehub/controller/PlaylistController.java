package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodnest.tunehub.entity.Playlist;
import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.service.PlaylistService;
import com.kodnest.tunehub.service.SongService;

@CrossOrigin("*")
@RestController
public class PlaylistController {
	
	@Autowired
	SongService songService;
	
	@Autowired
	PlaylistService playlistService;
	
	@GetMapping("/createplaylists")
	public String createPlaylists(Model model) {
		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createplaylists";
	}
	
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute Playlist playlist) {
		//updating the playlist table
		playlistService.addplaylist(playlist);
	
		//updating the song table
		List<Song> songList = playlist.getSongs();
		for (Song s : songList) {
			s.getPlaylists().add(playlist);
			songService.updateSong(s);
			
		}
		return "adminhome";
	}
	
	@GetMapping("/viewplaylists")
	public String viewplaylists(Model model) {
		List<Playlist> allplaylist = playlistService.fetchAllPlaylists();
		
		model.addAttribute("allplaylist", allplaylist);
		return "displayplaylist";
	}

}














