
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gessi
 */
public class NewMenu extends JFrame {
    private User user;

    public NewMenu(User user) {
        this.user = user;
        // Initialize the menu with the user's details
    }

    public void displayUserName() {
        System.out.println("Welcome, " + user.getUsername() + "!");
    }
}