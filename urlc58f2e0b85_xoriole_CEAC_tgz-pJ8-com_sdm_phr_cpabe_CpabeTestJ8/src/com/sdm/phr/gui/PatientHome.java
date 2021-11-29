/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdm.phr.gui;

import com.sdm.phr.CipherKeyPair;
import com.sdm.phr.DatabaseClient;
import com.sdm.phr.KeyConfig;
import com.sdm.phr.Session;
import com.sdm.phr.WriterH;
import com.sdm.phr.cpabe.AESCoder;
import com.sdm.phr.cpabe.Cpabe;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author phoenix
 */
public class PatientHome extends javax.swing.JPanel {
    Main parent;
    /**
     * Creates new form PatientHome
     */
    public PatientHome() {
        initComponents();
    }
    public PatientHome(Main parent) {
        initComponents();
        this.parent = parent;
    }
    
    public void update() {
        // update name
        this.jPatientName.setText("Welcome "+Session.getInstance().getPatientName());

        Object[] colNames = {"sid", "pid", "author_id", "policy"};
        Object[][] data = {
            {1, 1, "hello"}
        };
        jTable1.setModel(DatabaseClient.getInstance().retrieveSection());

        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
//                System.out.println(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                if (jTable1.getRowCount() < 1) {
                    return;
                }
//                if (jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString().isEmpty()) {
//                    return;
//                }
                int sid=-1;
                try {
                    sid = (int) (jTable1.getValueAt(jTable1.getSelectedRow(), 0));
                } catch (NullPointerException npe) {
                    System.out.println("no rows found");
                    jDetails.setText("");
                    return;
                }catch(ArrayIndexOutOfBoundsException aiobe){
                    System.out.println("array index bound error");
                    return;
                }
                CipherKeyPair ckp = DatabaseClient.getInstance().getEncryptedRecordPair(sid);
//                System.out.println("aes key:" + ckp.getKey());
//                System.out.println("cipher_text:" + ckp.getCiphertext());

                Cpabe cpabe = new Cpabe();
                try {
                    System.out.println("private file:" + KeyConfig.getInstance().getUserReadSecretKeyPath());

                    byte[] decKey = cpabe.dec(KeyConfig.getInstance().getPatientReadPublicKeyPath(), KeyConfig.getInstance().getPatientReadSecretKeyPath(), ckp.getKeyBinary());
                    byte[] plainMsgBytes = AESCoder.decrypt(decKey, ckp.getCiphertextBinary());
                    jDetails.setText(new String(plainMsgBytes));

                } catch (IllegalAccessException ex) {
                    jDetails.setText("cannot decrypt, attributes in key do not satisfy policy");
                }catch(NegativeArraySizeException fnfe){
                    jDetails.setText("cannot read, you don't have read access");
                } catch(java.io.FileNotFoundException fnfe){
                    jDetails.setText("cannot read, you don't have read access");
                } catch (Exception ex) {
                    Logger.getLogger(UserHomePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
//        jTable1.setModel(new DefaultTableModel(data, colNames));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPatientName = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        btnAddUser = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jDetails = new javax.swing.JTextArea();
        btnNewRecord = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jAccessPolicy = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jDataRecord = new javax.swing.JTextArea();

        jPatientName.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jPatientName.setText("Welcome");

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnAddUser.setText("Add User");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setText("My Health Records");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel3.setText("Details");

        jDetails.setColumns(20);
        jDetails.setRows(5);
        jScrollPane2.setViewportView(jDetails);

        btnNewRecord.setText("Add New Record");
        btnNewRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRecordActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setText("Add new records");

        jLabel5.setText("Access Policy");

        jLabel6.setText("Data Record");

        jDataRecord.setColumns(20);
        jDataRecord.setRows(5);
        jScrollPane3.setViewportView(jDataRecord);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jAccessPolicy, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnNewRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPatientName)
                    .addComponent(btnLogout)
                    .addComponent(btnAddUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAccessPolicy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNewRecord)
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        parent.nextPanel(Main.USER_ADDD);
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void btnNewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRecordActionPerformed
        int pid = DatabaseClient.getInstance().getPid(Session.getInstance().getPatientName());
        int authorId = DatabaseClient.getInstance().getPatientUserId(Session.getInstance().getPatientName());

        String policy = jAccessPolicy.getText();
        int length = policy.split(" ").length;
//        if(length>1){
//            policy+=" "+length+"of"+length;
//        }
        policy+= " pid:"+pid+" 1of2";
        String record = jDataRecord.getText();

        if (policy.isEmpty() || record.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are mandatory. Please fill again, and proceed.", "Failure", JOptionPane.ERROR_MESSAGE);
            return;
        }

        WriterH h = new WriterH();
        h.sendSection(record, pid, authorId, policy);

        //clean up
        jAccessPolicy.setText("");
        jDataRecord.setText("");
        
        this.update();
    }//GEN-LAST:event_btnNewRecordActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        parent.nextPanel(Main.FIRST_SCREEN);
    }//GEN-LAST:event_btnLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNewRecord;
    private javax.swing.JTextField jAccessPolicy;
    private javax.swing.JTextArea jDataRecord;
    private javax.swing.JTextArea jDetails;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jPatientName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}