package DatebasesWithSqlite.MusicDB.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static final String DB_NAME = "musicJava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:";
    public static final String DB_PATH = "/home/maaush/git/udemy-java-course./Files/";
    public static final String JDBCURL = CONNECTION_STRING + DB_PATH + DB_NAME;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID  = 1;
    public static final int INDEX_SONG_TRACK  = 2;
    public static final int INDEX_SONG_TITLE  = 3;
    public static final int INDEX_SONG_ALBUM  = 4;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    public static final String QUERY_ALBUMS_BY_ARTIST_START =
            "SELECT " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " FROM " + TABLE_ALBUMS +
                    " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
                    " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
                    " WHERE " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + " = '";

    // SELECT albums.name FROM albums
    //INNER JOIN artists ON albums.artist = artists._id
    //WHERE artists.name = 'pink floyd' COLLATE NOCASE
    //ORDER BY albums.name;

    public static final String QUERY_ALBUMS_BY_ARTIST_SORT =
            " COLLATE NOCASE" + " ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME;

    private Connection _connect;

    public boolean open() {
        try {

            _connect = DriverManager.getConnection(JDBCURL);
            return true;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }

    public boolean close() {
        try {
            if (_connect != null) {

                _connect.close();
                return true;
            }
            return true;
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }

    public List<Artist> queryArtists(int sortOrder) throws NullPointerException {

        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);

        if (sortOrder != ORDER_BY_NONE) {
            sb.append(" ORDER BY ");
            sb.append(COLUMN_ARTIST_NAME);
            sb.append(" COLLATE NOCASE ");

            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        try (Statement statement = _connect.createStatement();
            ResultSet results = statement.executeQuery(sb.toString())) {

            List<Artist> artists = new ArrayList<>();

            while (results.next()) {

                Artist artist = new Artist();
                artist.setId(results.getInt(INDEX_ARTIST_ID));
                artist.setName(results.getString(INDEX_ARTIST_NAME));
                artists.add(artist);
            }

            return artists;
        } catch (SQLException e) {

            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<String> queryAlbumFromArtist(String artistName, int sortOrder) {

        // SELECT albums.name FROM albums
        //INNER JOIN artists ON albums.artist = artists._id
        //WHERE artists.name = 'pink floyd' COLLATE NOCASE
        //ORDER BY albums.name;

        StringBuilder sb = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
        sb.append(artistName).append("'");

        if (sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_ALBUMS_BY_ARTIST_SORT);

            if (sortOrder == ORDER_BY_DESC) {

                sb.append(" DESC");
            } else {
                sb.append(" ASC");
            }
        }

        System.out.println("SQL STATEMENT = " + sb.toString());

        try (Statement statement = _connect.createStatement();
        ResultSet results = statement.executeQuery(sb.toString())) {


            List<String> albums = new ArrayList<>();

            while (results.next()) {
                albums.add(results.getString(1));
            }

            return albums;
        } catch (SQLException e) {

            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }
}
