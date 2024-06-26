/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.register;
import javax.swing.JOptionPane;
import java.util.*;
/**
 *
 * @author lab_services_student
 */
public class Login {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String registerUser;
    private String registerPass;

    public Login() {
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.menu();
    }

    public void menu() {
        String[] options = {"Register", "Login", "Exit"};
        String choice = (String) JOptionPane.showInputDialog(null, "Login Management System Menu", "Menu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        switch (choice) {
            case "Register":
                Register register = new Register();
                register.registerUser();
                break;
            case "Login":
                adminLogin();
                break;
            case "Exit":
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                menu();
                break;
        }
    }

    private void adminLogin() {
        String inputUsername = JOptionPane.showInputDialog(null, "Enter Your Username:");
        String inputPassword = JOptionPane.showInputDialog(null, "Enter Your Password:");
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            JOptionPane.showMessageDialog(null, "Welcome " + firstName + " " + lastName + "! It Is Great To See You Again.");
            boolean keepRunning = true;
            while (keepRunning) {
                String[] loggedInOptions = {"Add Tasks", "Show Task Status", "Quit"};
                String loggedInChoice = (String) JOptionPane.showInputDialog(null, "Logged In Menu", "Menu", JOptionPane.PLAIN_MESSAGE, null, loggedInOptions, loggedInOptions[0]);
                switch (loggedInChoice) {
                    case "Add Tasks":
                        Task task = new Task();
                        task.addTasks(lastName);
                        break;
                    case "Show Task Status":
                        Task taskStatus = new Task();
                        taskStatus.showTaskStatus();
                        break;
                    case "Quit":
                        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Quit", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            keepRunning = false;
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                        break;
                }
            }
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
            menu();
        }
    }
}


