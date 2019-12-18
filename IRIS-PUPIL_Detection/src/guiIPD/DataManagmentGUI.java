/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiIPD;

import dbc.DataBaseConnection;
import java.awt.Color;
import java.io.File;
import javax.swing.table.DefaultTableCellRenderer;
import programManagment.ProgramManagment;

/**
 *
 * @author Aleksa
 */
public class DataManagmentGUI extends javax.swing.JFrame {

    private ProgramManagment pm;
    
    public DataManagmentGUI(ProgramManagment pm) {
        initComponents();
        table.setOpaque(false);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        table.setShowGrid(true);
        this.pm = pm;
        showData();
    }


    private void showData(){
        
        pm.showData(table);
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel9 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ln = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        male = new javax.swing.JRadioButton();
        fm = new javax.swing.JRadioButton();
        mail = new javax.swing.JTextField();
        insert = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        date = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 74, 130, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("first name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 68, -1, 30));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("last name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 112, -1, 20));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("address");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 158, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("date");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 212, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("gender");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 251, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("e-mail");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 292, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("phone");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));
        getContentPane().add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 112, 130, -1));
        getContentPane().add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 158, 130, -1));

        male.setText("Male");
        getContentPane().add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 251, -1, -1));

        fm.setText("Female");
        getContentPane().add(fm, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 251, -1, -1));
        getContentPane().add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 292, 130, -1));

        insert.setText("Insert");
        insert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertMouseClicked(evt);
            }
        });
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        getContentPane().add(insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 338, -1, -1));

        jButton2.setText("Update");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 338, -1, -1));

        jButton3.setText("Delete");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 338, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(204, 0, 0));
        jScrollPane1.setForeground(new java.awt.Color(255, 0, 51));
        jScrollPane1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "jmbg", "first_name", "last_name", "address", "date", "gender", "phone", "e-mail"
            }
        ));
        table.setGridColor(new java.awt.Color(240, 240, 240));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 11, 627, 310));
        getContentPane().add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 209, 130, -1));
        getContentPane().add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 130, -1));

        jButton1.setText("refresh");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 338, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/12116602-eye-close-up-with-technology-background.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 970, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertActionPerformed

    private void insertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertMouseClicked
        String gender = null;
        
        if(male.isSelected()){
            gender = "Male";
        }else if(fm.isSelected()){
            gender = "Female";
        }

        pm.insertData(fn.getText().toString(), ln.getText().toString(), address.getText().toString(),
                date.getText().toString(), gender, mail.getText().toString(), phone.getText().toString()
                , new File("image.jpg"));
    }//GEN-LAST:event_insertMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        showData();
    }//GEN-LAST:event_jButton1MouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
       pm.displayTableData(table, fn, ln, address, date, buttonGroup1, male, fm,mail, phone);
    }//GEN-LAST:event_tableMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
       
        pm.deleteData(table);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
      
        String sex = "";
        
        if(male.isSelected()){
            sex = "Male";
        }else if(fm.isSelected()){
            sex = "Female";
        }
  
        pm.updateData(fn.getText().toString(), ln.getText().toString(), address.getText().toString(), 
                date.getText().toString(), sex, phone.getText().toString(), mail.getText().toString(), new File("image.jpg"), table);
        
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField date;
    private javax.swing.JRadioButton fm;
    private javax.swing.JTextField fn;
    private javax.swing.JButton insert;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField ln;
    private javax.swing.JTextField mail;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField phone;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
