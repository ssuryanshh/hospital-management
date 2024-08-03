package project;
import java.sql.*;

/**
 *
 * @author surya
 */
public class ConnectionProvider {
    
    public static Connection getCon(){
        
        String url = "jdbc:mysql://localhost:3306/project";
        String username = "root";
        String password = "123456789";
                
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            throw new RuntimeException("Failed to establish a database connection", e);
        }
    }
}
