import java.sql.Connection;
import java.sql.DriverManager;


public class MariaDBConnection {
        private static final String DB_URL = "jdbc:mariadb://localhost:3306/clinica";
        private static final String USER = "root";
        private static final String PASS = "";
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
