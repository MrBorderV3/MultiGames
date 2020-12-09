package me.border.multigamesserver.database;

import me.border.utilities.storage.IMySQLDB;

public class MySQLDB extends IMySQLDB {
    public MySQLDB(String host, String database, String username, String password, int port) {
        super(host, database, username, password, port);
    }
}
