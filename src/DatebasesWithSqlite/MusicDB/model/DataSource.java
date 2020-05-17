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

    public static final String QUERY_ALBUMS_BY_ARTIST_SORT =
            "' COLLATE NOCASE" + " ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME;

    public static final String QUERY_ARTIST_FOR_SONG_START = "SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK + " FROM " + TABLE_SONGS +
            " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
            " INNER JOIN " + TABLE_ARTISTS + " ON " +  TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
            " WHERE " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " = '";

    public static final String QUERY_ARTIST_FOR_SONG_SORT =
            "' COLLATE NOCASE " + "ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME;

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

    public List<String> queryAlbumFromArtist(String artistName, int sortOrder) throws NullPointerException {

        StringBuilder sb = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
        sb.append(artistName);

        determineSortOrder(sb, QUERY_ALBUMS_BY_ARTIST_SORT, sortOrder);

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

    public List<SongArtist> queryArtistForSong(String songName, int sortOrder)  throws  NullPointerException {

        StringBuilder sb = new StringBuilder(QUERY_ARTIST_FOR_SONG_START);
        sb.append(songName);

        determineSortOrder(sb, QUERY_ARTIST_FOR_SONG_SORT, sortOrder);

        try (Statement statement = _connect.createStatement();
        ResultSet results = statement.executeQuery(sb.toString())) {

            List<SongArtist> songArtists = new ArrayList<>();

            while (results.next()) {

                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumName(results.getString(2));
                songArtist.setTrack(results.getInt(3));

                songArtists.add(songArtist);
            }

            return songArtists;
        } catch (SQLException e) {


            System.out.println("Query failed " + e.getMessage());
            return null;
        }
    }

    private void determineSortOrder(StringBuilder sb, String sortString, int sortOrder) {

        if (sortOrder != ORDER_BY_NONE) {

            sb.append(sortString);

            if (sortOrder == ORDER_BY_DESC) {

                sb.append(" DESC");
            } else {

                sb.append(" ASC");
            }
        }

        if (sortOrder == ORDER_BY_NONE) {

            sb.append("' COLLATE NOCASE");
        }
    }

    public void querySongsMetadata() {

        String sql = "SELECT * FROM " + TABLE_SONGS;

        try (Statement statement = _connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {

            ResultSetMetaData meta = resultSet.getMetaData();

            int numColumns = meta.getColumnCount();

            for (int i = 1; i < numColumns; i++) {

                System.out.format("Column %d in the songs table is named %s\n", i, meta.getColumnName(i));
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public int getCount(String table) {

        String sql = "SELECT COUNT(*) AS count FROM " + table;

        try (Statement statement = _connect.createStatement();
        ResultSet results = statement.executeQuery(sql)) {

            int count = results.getInt("count");
            System.out.format("Count = %d\n", count);

            return count;
        } catch (SQLException e) {

            System.out.println("Something bad happened: " + e.getMessage());
            return -1;
        }
    }
}
