package DatebasesWithSqlite.MusicDB;

import DatebasesWithSqlite.MusicDB.model.Artist;
import DatebasesWithSqlite.MusicDB.model.DataSource;
import DatebasesWithSqlite.MusicDB.model.SongArtist;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DataSource datasource = new DataSource();

        if (!datasource.open()) {
            System.out.println("Can't open datasource.");
        }

//        List<Artist> artists = datasource.queryArtists(1);
//
//        if (artists == null) {
//            System.out.println("No artists.");
//        } else {
//
//            artists.forEach(artist -> {
//                System.out.println("Artist id: " + artist.getId()
//                + "\n\tArtist name: " + artist.getName());
//            });
//        }
//
//        List<String> albumForArtist = datasource.queryAlbumFromArtist("carole king", DataSource.ORDER_BY_ASC);
//
//        albumForArtist.forEach(System.out::println);

        List<SongArtist> songArtists = datasource.querySongInfoView("heartless");

        if (songArtists == null) {

            System.out.println("Couldn't find the artist for the song.");
        }

        songArtists.forEach(songArtist -> {
            System.out.println("Artist name: " + songArtist.getArtistName() +
                    "\nAlbum name: " + songArtist.getAlbumName() +
                    "\nTrack: " + songArtist.getTrack());
        });

        datasource.querySongsMetadata();
        System.out.println("Number of songs in database: " + datasource.getCount(DataSource.TABLE_SONGS));;
        datasource.close();
    }
}

