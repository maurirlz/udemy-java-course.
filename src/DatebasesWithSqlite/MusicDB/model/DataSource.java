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

    public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";

    // SELECT artist, album, track FROM artist_list WHERE title = 'Go Your Own Way' COLLATE NOCASE

    public static final String QUERY_VIEW_SONG_INFO = "SELECT " + COLUMN_ALBUM_ARTIST + ", " + COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK +
            " FROM " + TABLE_ARTIST_SONG_VIEW + " WHERE " + COLUMN_SONG_TITLE + " = '";

    public static final String QUERY_VIEW_SONG_ORDER = "' COLLATE NOCASE " + "ORDER BY " +
            COLUMN_ALBUM_ARTIST + ", " + COLUMN_SONG_ALBUM +
            ", " + COLUMN_SONG_TRACK;

    public static final String QUERY_VIEW_SONG_PREP = "SELECT " + COLUMN_ALBUM_ARTIST + ", " + COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK +
            " FROM " + TABLE_ARTIST_SONG_VIEW + " WHERE " + COLUMN_SONG_TITLE + " = ?";

    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS +
            '(' + COLUMN_ARTIST_NAME + ") VALUES(?)";

    public static final String INSERT_ALBUM = "INSERT INTO " + TABLE_ALBUMS +
            '(' + COLUMN_ALBUM_NAME + ", " + COLUMN_ALBUM_ARTIST + ") VALUES (?. ?)";

    public static final String INSERT_SONG = "INSERT INTO " + TABLE_SONGS +
            '(' + COLUMN_SONG_TRACK + ", " + COLUMN_SONG_TITLE + ", " + COLUMN_SONG_ALBUM +
            ") VALUES (?,?,?)";

    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " +
            TABLE_ARTISTS + " WHERE " + COLUMN_ARTIST_NAME + " = ?";

    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID + " FROM " +
            TABLE_ALBUMS + " WHERE " + COLUMN_ALBUM_NAME + " = ?";

    private Connection _connect;
    private PreparedStatement querySongInfoView;
    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;
    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;

    public boolean open() {
        try {

            _connect = DriverManager.getConnection(JDBCURL);

            querySongInfoView = _connect.prepareStatement(QUERY_VIEW_SONG_PREP);
            insertIntoArtists = _connect.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = _connect.prepareStatement(INSERT_ALBUM, Statement.RETURN_GENERATED_KEYS);
            insertIntoSongs = _connect.prepareStatement(INSERT_SONG);
            queryArtist = _connect.prepareStatement(QUERY_ARTIST);
            queryAlbum = _connect.prepareStatement(QUERY_ALBUM);

            return true;
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }

    public boolean close() {
        try {
            if (_connect != null) {

                querySongInfoView.close();
                _connect.close();
                return true;
            }

            if (insertIntoArtists != null) insertIntoArtists.close();
            if (insertIntoAlbums != null) insertIntoAlbums.close();
            if (insertIntoSongs != null) insertIntoSongs.close();
            if (queryArtist != null) queryArtist.close();
            if (queryAlbum != null) queryAlbum.close();

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

            return fillListWithSongArtist(results, songArtists);
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

    public List<SongArtist> querySongInfoView(String title) {

        try {

            querySongInfoView.setString(1, title);
            ResultSet results = querySongInfoView.executeQuery();
            List<SongArtist> songArtists = new ArrayList<>();

            return fillListWithSongArtist(results, songArtists);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    List<SongArtist> fillListWithSongArtist(ResultSet set, List<SongArtist> list) {

        try {

            while (set.next()) {
                SongArtist artist = new SongArtist();
                artist.setArtistName(set.getString(1));
                artist.setAlbumName(set.getString(2));
                artist.setTrack(set.getInt(3));

                list.add(artist);
            }
        } catch (SQLException e) {

            e.printStackTrace();
            return null;
        }

        return list;
    }

    private int insertArtist(String name) throws SQLException {

        queryArtist.setString(1, name);
        ResultSet results = queryArtist.executeQuery();

        if (results.next()) {

            return results.getInt(1);
        } else {

            // insert the artist because it isn't present in the table..

            insertIntoArtists.setString(1, name);
            int affectedRows = insertIntoArtists.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert artist.");
            }
        }

        ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();

        if (generatedKeys.next()) {

            return generatedKeys.getInt(1);
        } else {

            throw new SQLException("Couldn't get _id for artist.");
        }
    }

    private int insertAlbum(String name, int artistId) throws SQLException {

        queryAlbum.setString(1, name);
        ResultSet results = queryAlbum.executeQuery();

        if (results.next()) {

            return results.getInt(1);
        } else {

            // insert the album because it isn't present in the table..

            insertIntoAlbums.setString(1, name);
            insertIntoAlbums.setInt(2, artistId);
            int affectedRows = insertIntoAlbums.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert album.");
            }
        }

        ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();

        if (generatedKeys.next()) {

            return generatedKeys.getInt(1);
        } else {

            throw new SQLException("Couldn't get _id for album.");
        }
    }

    public void insertSong(String title, String artist, String album, int track) {

        try {

            _connect.setAutoCommit(false);

            int artistId = insertArtist(artist);
            int albumId = insertAlbum(album, artistId);

            insertIntoSongs.setInt(1, track);
            insertIntoSongs.setString(2, title);
            insertIntoSongs.setInt(3, albumId);

            int affectedRows = insertIntoSongs.executeUpdate();

            if (affectedRows == 1) {

                _connect.commit();
            } else {
                throw new SQLException("Song insertion failed");
            }

        } catch (Exception e) {

            System.out.println("Insert song exception: " + e.getMessage());

            try {
                System.out.println("Performing rollback");
                _connect.rollback();
            } catch (SQLException e2) {

                System.out.println("Oh boy..." + e2.getMessage());
            }
        } finally {

            try {

                System.out.println("Resetting default commit behaviour");
                _connect.setAutoCommit(true);
            } catch (SQLException e) {

                System.out.println("Couldn't reset auto commit back again. " + e.getMessage());
            }
        }
    }
}
