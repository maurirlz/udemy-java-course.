package DatebasesWithSqlite.MusicDB;

import DatebasesWithSqlite.MusicDB.model.Artist;
import DatebasesWithSqlite.MusicDB.model.DataSource;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DataSource datasource = new DataSource();

        if (!datasource.open()) {
            System.out.println("Can't open datasource.");
        }

        List<Artist> artists = datasource.queryArtists(1);

        if (artists == null) {
            System.out.println("No artists.");
        } else {

            artists.forEach(artist -> {
                System.out.println("Artist id: " + artist.getId()
                + "\n\tArtist name: " + artist.getName());
            });
        }

        List<String> albumForArtist = datasource.queryAlbumFromArtist("iron maiden", DataSource.ORDER_BY_ASC);

        albumForArtist.forEach(System.out::println);
    }
}

