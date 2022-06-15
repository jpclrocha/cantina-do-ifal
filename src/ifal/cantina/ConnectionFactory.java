package ifal.cantina;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() throws SQLException {
        final String url = "jdbc:mysql://localhost/jdbc";
        final String username = "root";
        final String password = "";
        Connection con = DriverManager.getConnection(url,username,password);
        return con;
    }
}
