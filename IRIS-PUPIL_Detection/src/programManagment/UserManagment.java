/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programManagment;

import dbc.DataBaseConnection;
import java.io.File;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import programManagment.ProgramManagment;

/**
 *
 * @author Aleksa
 */
public class UserManagment extends ProgramManagment{

    public UserManagment(DataBaseConnection dbc) {
        super(dbc);
    }

    @Override
    public void insertData(String firsName, String lastName, String address, String date, String gender, String mail, String phone, File slika) {
        dbc.insertData(firsName, lastName, address, date, gender, mail, phone, slika);
    }

    @Override
    public void showData(JTable table) {
        dbc.showData(table);
    }

    @Override
    public void displayTableData(JTable table, JTextField fn, JTextField ln, JTextField address, JTextField date, ButtonGroup bg, JRadioButton male, JRadioButton feMale, JTextField mail, JTextField phone) {
       dbc.displayTableData(table, fn, ln, address, date, bg, male, feMale, mail, phone);
    }

    @Override
    public void deleteData(JTable table) {
        dbc.deleteData(table);
    }

    @Override
    public void updateData(String firstName, String lastName, String address, String date, String gender, String mail, String phone, File slika, JTable table) {
       dbc.updateData(firstName, lastName, address, date, gender, mail, phone, slika, table);
    }

    @Override
    public void compareUsers(File f, JLabel userData) {
        dbc.compareUsers(f, userData);
    }

    
    
    
}
