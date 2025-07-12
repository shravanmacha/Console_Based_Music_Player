package com;

import java.util.Scanner;

public class Menu_Driver_App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MusicPlayer music = new MusicPlayer();
		int choice;
		
		 do {
	            System.out.println("\n========= MUSIC PLAYER MENU =========");
	            System.out.println("1. Add New Song");
	            System.out.println("2. Update Existing Song");
	            System.out.println("3. Delete Song");
	            System.out.println("4. Display All Songs");
	            System.out.println("5. Create New Playlist");
	            System.out.println("6. Add Song to Playlist");
	            System.out.println("7. Display All Playlists");
	            System.out.println("8. Display Songs in Playlist");
	            System.out.println("9. Play Song in Playlist");
	            System.out.println("10. Pause Song in Playlist");
	            System.out.println("11. Stop Song in Playlist");
	            System.out.println("12. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            sc.nextLine();
	            
	            switch(choice) {
	            case 1 -> {
	            	System.out.println("SongId: ");
	            	int id = sc.nextInt();
	            	sc.nextLine();
	            	System.out.println("Title: ");
	            	String title = sc.nextLine();
	            	System.out.println("Artist: ");
	            	String artist = sc.nextLine();
	            	System.out.println("Duration: ");
	            	double duration = sc.nextDouble();
	            	music.addSong(new Song(id, title, artist, duration));
	            }
	            case 2 -> {
	            	System.out.println("Enter title of song to update: ");
	            	String title = sc.nextLine();
	            	System.out.println("Enter new title: ");
	            	String newTitle = sc.nextLine();
	            	System.out.println("Enter new Artist: ");
	            	String newArtist = sc.nextLine();
	            	System.out.println("Enter new duration: ");
	            	double newDuration = sc.nextDouble();
	            	music.updateSong(title, new Song(0, newTitle, newArtist, newDuration));   	
	            }
	            case 3 -> {
	            	System.out.println("Enter title to delete the song: ");
	            	String title = sc.nextLine();
	            	music.deleteSong(title);
	            }
	            case 4 -> music.displayAllSongs();
	            case 5 -> {
	            	System.out.println("Enter PlayList id:");
	            	int pid = sc.nextInt();
	            	sc.nextLine();
	            	System.out.println("Enter PlayList name: ");
	            	String pName = sc.nextLine();
	            	music.createPlayList(pid, pName);
	            }
	            case 6 -> {
	            	System.out.println("Enter PlayList Name: ");
	            	String pName = sc.nextLine();
	        	    System.out.println("Enter Song Id: ");
	            	int sid = sc.nextInt();
	            	sc.nextLine();
	            	for(Song s : music.allSongs) {
	            		if(s.getSongId() == sid) {
	            			music.addSongToPlayList(pName, s);
	            			break;
	            		}
	            	}
	            }
	            case 7 -> music.displayAllPlayLists();
	            case 8 -> {
	            	System.out.println("Enter playList name: ");
	            	String pName = sc.nextLine();
	            	Playlist p1 = music.getPlayList(pName);
	            	if(p1 != null) p1.displaySongs();
	            	else System.out.println("PlayList not found!");
	            }
	            case 9 -> {
	            	System.out.println("Enter playList name: ");
	            	String pName = sc.nextLine();
	            	System.out.println("Enter Song Title: ");
	            	String sName = sc.nextLine();
	            	Playlist p1 = music.getPlayList(pName);
	            	if(p1 != null) p1.play(sName);
	            }
	            case 10 -> {
	            	System.out.println("Enter playList name: ");
	            	String pName = sc.nextLine();
	            	System.out.println("Enter Song Title: ");
	            	String sName = sc.nextLine();
	            	Playlist p1 = music.getPlayList(pName);
	            	if(p1 != null) p1.pause(sName);
	            }
	            case 11 -> {
	            	System.out.println("Enter playList name: ");
	            	String pName = sc.nextLine();
	            	System.out.println("Enter Song Title: ");
	            	String sName = sc.nextLine();
	            	Playlist p1 = music.getPlayList(pName);
	            	if(p1 != null) p1.stop(sName);
	            }
	            case 12 -> System.out.println("Exiting music player!");
	            default -> System.out.println("Invalid choice!");
	            }
		 }while(choice != 12);
		 sc.close();
	}
}
