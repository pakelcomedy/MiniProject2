package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Config {
    private static final Logger LOGGER = Logger.getLogger(Config.class.getName());
    private static Connection mysqlconfig;

    public static Connection configDB() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3307/mahasiswa";
            String user = "root";
            String pass = "1234";

            if (mysqlconfig == null || mysqlconfig.isClosed()) {
                mysqlconfig = DriverManager.getConnection(url, user, pass);
                LOGGER.log(Level.INFO, "Connected to the database.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Koneksi gagal: " + e.getMessage(), e);
            throw new SQLException("Failed to connect to the database", e);
        }
        return mysqlconfig;
    }
}