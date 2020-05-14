package DatebasesWithSqlite.MusicDB;

import DatebasesWithSqlite.MusicDB.model.DataSource;

public class Main {

    public static void main(String[] args) {

        DataSource datasource = new DataSource();

        if (!datasource.open()) {
            System.out.println("Can't open datasource.");
        }
    }
}

