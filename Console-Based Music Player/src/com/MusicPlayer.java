package com;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
	public List<Song> allSongs;
	public List<Playlist> playlists;
	
	public MusicPlayer() {
		allSongs = new ArrayList<>();
		playlists = new ArrayList<>();
	}
	
	public void addSong(Song song) {
		allSongs.add(song);
	}
	public void updateSong(String title, Song updatedSong) {
		for(Song song : allSongs) {
			if(song.getTitle().equalsIgnoreCase(title)) {
				song.setTitle(updatedSong.getTitle());
				song.setArtist(updatedSong.getArtist());
				song.setDuration(updatedSong.getDuration());
				return;
			}			
		}
	}
	public void deleteSong(String title) {
		allSongs.removeIf(s -> s.getTitle().equalsIgnoreCase(title));
	}
	public void displayAllSongs() {
		System.out.println("Displaying all Songs: ");
		for(Song song : allSongs) {
			System.out.println(song);
		}
	}
	public void createPlayList(int id, String name) {
		playlists.add(new Playlist(id, name));
	}
	public void addSongToPlayList(String playListName, Song song) {
		for(Playlist p1 : playlists) {
			if(p1.getPlayListName().equalsIgnoreCase(playListName)) {
				p1.addSong(song);
				return;
			}
		}
	}
	public void deletePlayList(String name) {
		playlists.removeIf(s -> s.getPlayListName().equalsIgnoreCase(name));
	}
	public void playPlayList(String playListName) {
		Playlist playlist = getPlayList(playListName);
		if(playlist != null) {
			System.out.println("Playing PlayList: " + playListName );
			for(Song song : playlist.getSongs()) {	
				System.out.println("Playing: " + song);
		}
		}	else {
			System.out.println("PlayList not found!");
			}
	}
	public Playlist getPlayList(String name) {
			for(Playlist p1 : playlists) {
				if(p1.getPlayListName().equalsIgnoreCase(name)) {
					return p1;
				}
			}
			return null;
	}
	public void displayAllPlayLists() {
		System.out.println("=====ALL PLAYLISTS=====");
		for(Playlist p1 : playlists) {
			System.out.println(p1.getPlayListName());
		}
	}
}
