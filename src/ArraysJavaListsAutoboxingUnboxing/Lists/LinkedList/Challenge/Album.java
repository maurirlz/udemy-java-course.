package ArraysJavaListsAutoboxingUnboxing.Lists.LinkedList.Challenge;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    // Create a program that implements a playlist for songs
    // Create a Song class having Title and Duration for a song.
    // The program will have an Album class containing a list of songs.
    // The albums will be stored in an ArrayList
    // Songs from different albums can be added to the playlist and will appear in the list in the order
    // they are added.
    // Once the songs have been added to the playlist, create a menu of options to:-
    // Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
    // List the songs in the playlist
    // A song must exist in an album before it can be added to the playlist (so you can only play songs that
    // you own).
    // Hint:  To replay a song, consider what happened when we went back and forth from a city before we
    // started tracking the direction we were going.
    // As an optional extra, provide an option to remove the current song from the playlist
    // (hint: listiterator.remove()

    private String albumTitle;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String albumTitle) {

        this.albumTitle = albumTitle;
        this.songs = new ArrayList<>();
    }

    public boolean addSongToAlbum(String title, String duration) {

        if (duration.matches("[0-9]+") && !containsSong(title)) {

            this.songs.add(Song.createNewSong(title, duration));
            return true;
        } else if (containsSong(title)) {

            System.out.println("Song already on playlist, cannot have duplicate titles in song.");
            return false;
        } else {

            System.out.println("Invalid duration, duration cannot have any letters or special characters.");
            return false;
        }
    }

    public Song removeSong(String title) {

        if (containsSong(title)) {

            Song removedSong = findSong(title);
            int index = findIndexOfSong(title);

            this.songs.remove(index);

            return removedSong;
        } else {

            System.out.println("Song not in playlist.");
            return null;
        }
    }

    private int findIndexOfSong(String title) {

        if (containsSong(title)) {

            return this.songs.indexOf(findSong(title));
        } else {

            System.out.println("Song not in song.");
            return -1;
        }
    }

    public Song findSong(String title) {

        if (title == null) {

            System.out.println("Invalid title, returning null");
            return null;
        } else if (!containsSong(title)) {

            System.out.println("Song not in song.");
            return null;
        } else {

            Song desiredSong = new Song( title);

            for (Song song : this.songs) {

                if (song.getTitle().equals(desiredSong.getTitle())) {

                    return song;
                }
            }
        }
        return null;
    }

    private boolean containsSong(Song song) {

        return this.songs.contains(song);
    }

    private boolean containsSong(String title) {

        if (title != null) {
            Song song = new Song(title);

            return containsSong(song);
        }

        return false;
    }

    public boolean isAlbumEmpty() {

        return songs.size() <= 0;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> song) {
        this.songs = song;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("Album title: ").append(this.albumTitle).append("\n");
        sb.append("Artist name: ").append(this.artist).append("\n");
        sb.append("Songs in album: ");

        this.songs.forEach(System.out::println);

        return sb.toString();
    }
}
