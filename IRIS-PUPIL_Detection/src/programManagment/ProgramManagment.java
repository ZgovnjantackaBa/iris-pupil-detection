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

/**
 *
 * @author Aleksa
 */
abstract public class ProgramManagment {
    
    protected DataBaseConnection dbc;

    public ProgramManagment(DataBaseConnection dbc) {
        this.dbc = dbc;
    }
    
    abstract public void insertData(String firsName, String lastName, String address, String date, String gender, String mail, String phone, File slika);
    abstract public void showData(JTable table);
    abstract public void displayTableData(JTable table, JTextField fn, JTextField ln, JTextField address, JTextField date, ButtonGroup bg, JRadioButton male, JRadioButton feMale, JTextField mail, JTextField phone);
    abstract public void deleteData(JTable table);
    abstract public void updateData(String firstName, String lastName, String address, String date, String gender, String mail, String phone, File slika, JTable table);
    abstract public void compareUsers(File f, JLabel userData);
}
