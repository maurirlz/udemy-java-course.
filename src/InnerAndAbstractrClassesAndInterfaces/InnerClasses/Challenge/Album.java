package InnerAndAbstractrClassesAndInterfaces.InnerClasses.Challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dev on 18/09/15.
 */

public class Album {

    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return this.songs.add(new Song(title, duration));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        Song checkedSong = this.songs.findSong(trackNumber);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }

        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = this.songs.findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }


    private class SongList {

        private List<Song> songs;

        public SongList() {


            this.songs = new ArrayList<>();
        }

        public boolean add(Song song) {

            if (this.songs.contains(song)) {
                return false;
            } else {

                this.songs.add(song);
                return true;
            }
        }

        private Song findSong(String title) {

            for (Song checkedSong : this.songs) {

                if (checkedSong.getTitle().equals(title)) {

                    return checkedSong;
                }
            }
            return null;
        }

        Song findSong(int trackNumber) {

            int index = trackNumber - 1;

            if (index > 0 && index < songs.size()) {

                return songs.get(index);
            }

            return null;
        }
    }
}