package com.kodnest.tunehub.service;

import java.util.List;

import com.kodnest.tunehub.entity.Song;

public interface SongService {

	public void addSong(Song song);

	public List<Song> fetchAllSongs();

	public boolean songExists(String name);

	public void updateSong(Song s);

}
