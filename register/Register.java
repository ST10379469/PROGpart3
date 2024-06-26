/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.register;
import javax.swing.JOptionPane;

/**
 *
 * @author lab_services_student
 */
class Register {
    private String firstName;
    private String lastName;
    private String registerUser;
    private String registerPass;
    private String username;
    private String password;

    public void registerUser() {
        firstName = JOptionPane.showInputDialog(null, "Enter Your First Name");
        lastName = JOptionPane.showInputDialog(null, "Enter Your Last Name");
        registerUser = JOptionPane.showInputDialog(null, "Create Username", "Enter Your Username: ");
        registerPass = JOptionPane.showInputDialog(null, "Create Password", "Enter Your Password: ");
        username = registerUser;
        password = registerPass;
        JOptionPane.showMessageDialog(null, "Registration Successful! You can now login.");
        Login login = new Login();
        login.menu();
    }
}

   
   
        
        
        
        
        
        
   