package com;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements Playable{
	
	private int playListId;
	private String playListName;
	private List<Song> songs;
	
	public Playlist(int playListId, String playListName) {
		this.playListId = playListId;
		this.playListName = playListName;
		this.songs = new ArrayList<>();
	}
	
	public List<Song> getSongs() {
		return songs;
	}
	public String getPlayListName() {
		return playListName;
	}
	
	public void addSong(Song song) {
		songs.add(song);
	}
	public void removeSong(String title) {
		songs.removeIf(s -> s.getTitle().equalsIgnoreCase(title));
	}
	public void removeSong(int songId) {
		songs.removeIf(s -> s.getSongId() == songId);
	}
	public void displaySongs() {
		System.out.println("Songs in PlayList: " + playListName);
		for(Song song : songs) {
			System.out.println(song);
		}
	}
	@Override
	public void play(String title) {
		songs.stream()
			 .filter(s -> s.getTitle().equalsIgnoreCase(title))
			 .forEach(s -> System.out.println("Playing :" + s));
	}
	@Override
	public void play(int songId) {
		songs.stream()
			 .filter(s -> s.getSongId() == songId)
			 .forEach(s -> System.out.println("Playing :" + s));
	}
	@Override
	public void pause(String title) {
		System.out.println("Pausing the " + title);
	}
	@Override
	public void pause(int songId) {
		System.out.println("Pausing the " + songId);
	}
	@Override
	public void stop(String title) {
		System.out.println("Stopping the " + title);
	}
	@Override
	public void stop(int songId) {
		System.out.println("Stopping the " + songId);
	}	
}
