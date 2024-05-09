
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.security.auth.login.LoginException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gessi
 */
public class LoginManager {
    
    private static final String url = "jdbc:mysql://localhost:3306/debacca";  
    private static final String userName = "root";
    private static final String passwordDB = "";
    
    public static User login(String username, String password) throws LoginException {
        try (Connection connection = DriverManager.getConnection(url, userName, passwordDB)) {
            String sql = "SELECT * FROM login WHERE username =? AND password =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    // Login successful
                int id = resultSet.getInt("id");                    
                return new User(resultSet.getString("username"), id);
                    // You can add code here to open a new window or perform other actions after successful login              
                } else {
                    // Login failed
                throw new LoginException("Invalid username or password!");
                }
            } catch (SQLException ex) {
            throw new LoginException("Error");
            }                   
    } 
}
