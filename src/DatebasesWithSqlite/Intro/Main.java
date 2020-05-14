package DatebasesWithSqlite.Intro;

import java.sql.*;

public class Main {

    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:";
    public static final String DB_PATH = "/home/maaush/git/udemy-java-course./Files/";
    public static final String JDBCURL = CONNECTION_STRING + DB_PATH + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";
    public static final String INSERT = TABLE_CONTACTS +
            " (" + COLUMN_NAME + ", " +
            COLUMN_PHONE + ", " +
            COLUMN_EMAIL + " )";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(JDBCURL)){

            try (Statement statement = connection.createStatement()) {

                statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

                statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                        " (" + COLUMN_NAME + " TEXT, " +
                               COLUMN_PHONE + " INTEGER," +
                               COLUMN_EMAIL + " TEXT)");

                insertContact(statement, "Mauricio", 54365512, "mauribenitez95@gmail.com");

                insertContact(statement, "Tim", 543322111, "timtest@gmail.com");

                insertContact(statement, "Joe", 542211332, "joetest@gmail.com");

                insertContact(statement, "Jane", 482233552, "janetest@gmail.com");

                insertContact(statement, "Fido", 4000000, "dog@gmail.com");

                statement.execute("UPDATE " + TABLE_CONTACTS + " SET "
                                 + COLUMN_PHONE + "=1122334455"
                                 + " WHERE " + COLUMN_NAME + "= 'Jane'");

                statement.execute("DELETE FROM " + TABLE_CONTACTS +
                        " WHERE " + COLUMN_NAME + "= 'Joe'" + " COLLATE NOCASE");

                ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);

                while (results.next()) {

                    System.out.println(results.getString(COLUMN_NAME) + " "
                            + results.getInt(COLUMN_PHONE) + " "
                            + results.getString(COLUMN_EMAIL));
                }
            }
        } catch (SQLException e) {

            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {

        // VALUES ('Fido', 4000000, 'dog@gmail.com')

        statement.execute("INSERT INTO " + INSERT + " VALUES ("
                + "' " + name
                + "', " + phone
                + ", '" + email + "')");
    }
}
