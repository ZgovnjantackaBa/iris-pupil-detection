/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbc;

import iris.pupil_detection.CompareImage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.ir.Statement;

/**
 *
 * @author Aleksa
 */
public class DataBaseConnection {
    
    private Connection conn;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private byte[] image;

    public DataBaseConnection() {
    
    connectToDB();
    }
    
    private void connectToDB(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iris-pupil_detection", "root", "root");
            JOptionPane.showMessageDialog(null, "Connection is succesefull");
            
            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    public void insertData(String firsName, String lastName, String address, String date, String gender, String mail, String phone, File slika){
        
        Random r = new Random();
        int jmbg = r.nextInt(255);
       
        try {
            FileInputStream fis = new FileInputStream(slika);
            ps = conn.prepareStatement("INSERT INTO `dosije`(`jmbg`, `first_name`, `last_name`, `address`, `date`, `gender`, `mail`, `phone`, `eye`) VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, jmbg);
            ps.setString(2, firsName);
            ps.setString(3, lastName);
            ps.setString(4, address);
            ps.setString(5, date);
            ps.setString(6, gender);
            ps.setString(7, mail);
            ps.setInt(8, Integer.valueOf(phone));
            ps.setBlob(9, fis);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data inserted succesefull!!!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void showData(JTable table){
        
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       model.setRowCount(0);
        try {
            ps = conn.prepareStatement("select * from dosije");
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                Object[] o = {rs.getInt("jmbg"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("address")
                , rs.getString("date"), rs.getString("gender"), rs.getInt("phone"), rs.getString("mail")};
                model.addRow(o);
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        
        
    }
    
    public void displayTableData(JTable table, JTextField fn, JTextField ln, JTextField address, JTextField date, ButtonGroup bg, JRadioButton male, JRadioButton feMale, JTextField mail, JTextField phone){
        
        int selectedRow = table.getSelectedRow();
        
        fn.setText(table.getValueAt(selectedRow, 1).toString());
        ln.setText(table.getValueAt(selectedRow, 2).toString());
        address.setText(table.getValueAt(selectedRow, 3).toString());
        date.setText(table.getValueAt(selectedRow, 4).toString());
        String sex = table.getValueAt(selectedRow, 5).toString();
        
        if(sex.equals("Male")){
           male.setSelected(true);
        }else if(sex.equals("Female"));
        
        mail.setText(table.getValueAt(selectedRow, 7).toString());
        phone.setText(table.getValueAt(selectedRow, 6).toString());
        
        
    }
    
    public void deleteData(JTable table){
        
        int selectedRow = table.getSelectedRow();
        String fullName = table.getValueAt(selectedRow, 1).toString() + " " + table.getValueAt(selectedRow, 2).toString();
        
        try {
            ps = conn.prepareStatement("delete from dosije where jmbg = " + table.getValueAt(selectedRow, 0).toString());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data deleted succesefull for user: " +fullName);
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
        }   
    }
    
    public void updateData(String firstName, String lastName, String address, String date, String gender, String mail, String phone, File slika, JTable table){
        
        int selectedRow = table.getSelectedRow();
        
        try {
            FileInputStream fis = new FileInputStream(slika);
            ps = conn.prepareStatement("update dosije set first_name = ?, last_name = ?, address = ?, date = ?, gender = ?,"
                    + " phone = ?, mail = ?, eye = ? where jmbg = " + Integer.valueOf(table.getValueAt(selectedRow, 0).toString()));
            
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, address);
            ps.setString(4, date);
            ps.setString(5, gender);
            ps.setString(6, mail);
            ps.setString(7, phone);
            ps.setBlob(8, fis);
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data updated succesefull");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (FileNotFoundException ex) {
             JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void compareUsers(File f, JLabel userData){
        
        boolean dataMached = false;
        
        try {
            ps = conn.prepareStatement("select * from dosije");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Blob test = rs.getBlob("eye");
                InputStream is = (InputStream) test.getBinaryStream();
               
                BufferedImage imageUser = ImageIO.read(is);
                BufferedImage imageTest = ImageIO.read(f);
                
                if(CompareImage.isKnown(imageUser, imageTest)){
                    userData.setText("Data matched for user: " + rs.getInt("jmbg") + " " + rs.getString("first_name") + " " + rs.getString("last_name")
                     + " " + rs.getString("address") + " " + rs.getString("gender") + " " + rs.getString("phone") + " " + rs.getString("mail"));
                    dataMached = true;
                }
                
            }
            
            if(!dataMached){
                userData.setText("Not matched data, try another image!!!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
