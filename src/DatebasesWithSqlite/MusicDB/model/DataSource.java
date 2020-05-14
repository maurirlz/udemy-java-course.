package DatebasesWithSqlite.MusicDB.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";

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
}
