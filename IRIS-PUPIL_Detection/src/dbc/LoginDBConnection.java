/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Aleksa
 */
public class LoginDBConnection {
    
    // db comunication
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public LoginDBConnection() {
    
        connectToDB();
    }
    
    
    public void connectToDB(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iris-pupil_detection", "root", "root");
            JOptionPane.showMessageDialog(null, "Connection is succesefull");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public boolean aproveUser(String nick, String mail, String pass){
        
        boolean aproveRightHim = false;
        
        try {
            ps = conn.prepareStatement("select * from legit_user");
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                String nickForCompare = rs.getString("nick");
                String mailForCompare = rs.getString("e-mail");
                String passForCompare = rs.getString("password");
                
                if(isItHim(nick, mail, pass, nickForCompare, mailForCompare, passForCompare)){
                    aproveRightHim = true;
                }
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return aproveRightHim;
        
    }
    
    private boolean isItHim(String nick, String mail, String pass, String nickForCompare, String mailForCompare, String passForCompare){
        
        if(nick.equals(nickForCompare) && pass.equals(passForCompare) && mail.equals(mailForCompare)){
            return true;
        }
        return false;
    }
    
    
    
    
    
    
}
