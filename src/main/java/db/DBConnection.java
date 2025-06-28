package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/nhom7_project?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";          // đổi theo user của bạn
    private static final String PASS = "160804"; // đổi theo pass của bạn

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Driver MySQL 8+
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
