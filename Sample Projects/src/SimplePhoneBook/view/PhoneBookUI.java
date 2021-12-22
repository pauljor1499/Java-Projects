/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimplePhoneBook.view;

import SimplePhoneBook.controller.PhonebookController;//tawagon nimo imong class sa phonebookcontroller
import SimplePhoneBook.model.Person;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import SimplePhoneBook.model.Person;//class sa person
import SimplePhoneBook.util.PhonebookUtil;

/**
 *
 * @author OOP-Jor
 */
public class PhoneBookUI extends javax.swing.JFrame {
    private Object PhoneBookUtil;

    /**
     * Creates new form PhoneBookUI
     */
    public PhoneBookUI() {
        initComponents();
        
        this.setResizable(false);//Resize
        setLocationRelativeTo(this);//Maadto sa tunga
    }
    
PhonebookController controller = new PhonebookController(); //global variable
//Person p = new Person();//global variable
Person selectedPerson = new Person ();
Person updatePerson = new Person ();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        diagAddContact = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        cmbPhoneNumber = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        cmbAge = new javax.swing.JComboBox();
        cmbGender = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        PopupMenu = new javax.swing.JPopupMenu();
        mnEditContact = new javax.swing.JMenuItem();
        mnDeleteContact = new javax.swing.JMenuItem();
        diagEditContact = new javax.swing.JDialog();
        jLabel9 = new javax.swing.JLabel();
        txtEditName = new javax.swing.JTextField();
        txtEditPhoneNumber = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbEditGender = new javax.swing.JComboBox();
        cmbEditAge = new javax.swing.JComboBox();
        btnUpdate = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnAddNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContacts = new javax.swing.JTable();
        lbSelected = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnLoadData = new javax.swing.JMenuItem();
        mnSaveData = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        diagAddContact.setModal(true);

        jLabel5.setText("Name :");

        cmbPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPhoneNumberActionPerformed(evt);
            }
        });

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        cmbAge.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        cmbAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAgeActionPerformed(evt);
            }
        });

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Male", "Female", " " }));

        jLabel6.setText("Age :");

        jLabel7.setText("Gender :");

        jLabel8.setText("Phone Number :");

        btnSave.setText("Save to Phonebook");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout diagAddContactLayout = new javax.swing.GroupLayout(diagAddContact.getContentPane());
        diagAddContact.getContentPane().setLayout(diagAddContactLayout);
        diagAddContactLayout.setHorizontalGroup(
            diagAddContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diagAddContactLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(diagAddContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(diagAddContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(diagAddContactLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(diagAddContactLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(65, 65, 65)
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(cmbAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(diagAddContactLayout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbPhoneNumber)))
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        diagAddContactLayout.setVerticalGroup(
            diagAddContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diagAddContactLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(diagAddContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(diagAddContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmbAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(diagAddContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(diagAddContactLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel8))
                    .addGroup(diagAddContactLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cmbPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addContainerGap())
        );

        mnEditContact.setText("Edit");
        mnEditContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnEditContactActionPerformed(evt);
            }
        });
        PopupMenu.add(mnEditContact);

        mnDeleteContact.setText("Delete");
        mnDeleteContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDeleteContactActionPerformed(evt);
            }
        });
        PopupMenu.add(mnDeleteContact);

        jLabel9.setText("Age :");

        txtEditName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditNameActionPerformed(evt);
            }
        });

        txtEditPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditPhoneNumberActionPerformed(evt);
            }
        });

        jLabel10.setText("Name :");

        cmbEditGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Male", "Female", " " }));

        cmbEditAge.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        cmbEditAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEditAgeActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel11.setText("Gender :");

        jLabel12.setText("Phone Number :");

        javax.swing.GroupLayout diagEditContactLayout = new javax.swing.GroupLayout(diagEditContact.getContentPane());
        diagEditContact.getContentPane().setLayout(diagEditContactLayout);
        diagEditContactLayout.setHorizontalGroup(
            diagEditContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diagEditContactLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(diagEditContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(diagEditContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(diagEditContactLayout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(18, 18, 18)
                            .addComponent(txtEditName, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(diagEditContactLayout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbEditGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(65, 65, 65)
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addComponent(cmbEditAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(diagEditContactLayout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtEditPhoneNumber)))
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        diagEditContactLayout.setVerticalGroup(
            diagEditContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diagEditContactLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(diagEditContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtEditName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(diagEditContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cmbEditGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cmbEditAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(diagEditContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(diagEditContactLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel12))
                    .addGroup(diagEditContactLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtEditPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnAddNew.setText("Add New Contact");
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });

        tblContacts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Gender", "Age", "Phone Number"
            }
        ));
        tblContacts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblContactsMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblContacts);

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel1.setText("Search Name:");

        jMenu1.setText("File");

        mnLoadData.setText("Load Data");
        mnLoadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnLoadDataActionPerformed(evt);
            }
        });
        jMenu1.add(mnLoadData);

        mnSaveData.setText("Save Data");
        mnSaveData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSaveDataActionPerformed(evt);
            }
        });
        jMenu1.add(mnSaveData);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(205, 205, 205)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddNew)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAgeActionPerformed

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        // TODO add your handling code here:
        //diagAddContact.pack();
        diagAddContact.pack();//para dili mahide
        diagAddContact.setLocationRelativeTo(this);
        diagAddContact.setVisible(true);
    }//GEN-LAST:event_btnAddNewActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        Person p = new Person(); // pwede ra sad wala kay naa namay global
        
        p.setName(txtName.getText());
        p.setGender(cmbGender.getSelectedItem().toString());//properties sa imong gender //items(Male or Female)
        p.setAge(Integer.parseInt(cmbAge.getSelectedItem().toString()));
        p.setPhonenumber(cmbPhoneNumber.getText());

        controller.addContact(p);
        diagAddContact.dispose();
        JOptionPane.showMessageDialog(null,"Successfully saved.");
        refreshTable();
        
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cmbPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPhoneNumberActionPerformed

    private void tblContactsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContactsMouseReleased
        // TODO add your handling code here:
        
        int row = tblContacts.rowAtPoint(evt.getPoint());
        if (row >= 0 && row <tblContacts.getRowCount()) {
            tblContacts.setRowSelectionInterval(row, row);
        }else{
            tblContacts.clearSelection();
        }
        int rowindex = tblContacts.getSelectedRow();
        if (rowindex < 0 ) {
            return;
        }
        
        selectedPerson = controller.getPersonlist().get(rowindex); //user editing
        lbSelected.setText("Selected: "+ selectedPerson.getName());
        
        if (evt.isPopupTrigger()) {
            PopupMenu.show(evt.getComponent(),evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblContactsMouseReleased

    private void mnEditContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEditContactActionPerformed
        // TODO add your handling code here:
        Person p = new Person();
        
        if (selectedPerson != null) {
            txtEditName.setText(selectedPerson.getName());
            cmbEditAge.setSelectedItem(selectedPerson.getAge());
            cmbEditGender.setSelectedItem(selectedPerson.getGender());
            txtEditPhoneNumber.setText(selectedPerson.getPhonenumber());
            
            diagEditContact.pack();
            diagEditContact.setLocationRelativeTo(this);
            diagEditContact.setVisible(true);
        }
    }//GEN-LAST:event_mnEditContactActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String view = "";
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Person p = controller.search(txtSearch.getText());
            if (p != null) {
                view = view + "Name: "+ p.getName() + " ("+p.getGender() + ") \n";
                view = view + "Gender: "+p.getGender()+"\n";
                view = view + "Phone Number: "+p.getPhonenumber() + "\n";
                
                JOptionPane.showMessageDialog(this, view, "Information: ", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Not found!!!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtEditNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditNameActionPerformed

    private void txtEditPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditPhoneNumberActionPerformed

    private void cmbEditAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEditAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEditAgeActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        updatePerson.setName(txtEditName.getText());
        updatePerson.setAge(Integer.parseInt(cmbEditAge.getSelectedItem().toString()));
        updatePerson.setGender(cmbEditGender.getSelectedItem().toString());
        updatePerson.setPhonenumber(txtEditPhoneNumber.getText());
        
        controller.upadteContact(selectedPerson, updatePerson);
        diagEditContact.dispose();
        refreshTable();

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void mnDeleteContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDeleteContactActionPerformed
        // TODO add your handling code here:
        if (selectedPerson != null) {
            int ans = JOptionPane.showConfirmDialog(this, "The selected record will be removed: " + selectedPerson.getName()
                    + "(" + selectedPerson.getPhonenumber()+ ")", "Confirm", JOptionPane.YES_NO_OPTION);
            
            if (ans == JOptionPane.YES_OPTION) {
                controller.removeContact(selectedPerson);
                refreshTable();
            }
        }
        
    }//GEN-LAST:event_mnDeleteContactActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void mnLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnLoadDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnLoadDataActionPerformed

    private void mnSaveDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSaveDataActionPerformed
        // TODO add your handling code here:
        if (controller.getPersonlist().isEmpty()) {
            JOptionPane.showMessageDialog(this, "The Phonebook is empty!","Erorr",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String csvFile = "contacts.csv";
        try{
            FileWriter writer = new FileWriter (csvFile);
            PhonebookUtil.saveContacts(writer, controller.getPersonlist());
            writer.flush();
            writer.close();
            JOptionPane.showMessageDialog(this, "Successfully saved to file.","File save", JOptionPane.INFORMATION_MESSAGE);
        }catch(IOException ex){
            Logger.getLogger(PhoneBookUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_mnSaveDataActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        PhonebookUtil pbUtil = new PhonebookUtil();
        
        int confirm = JOptionPane.showConfirmDialog(this, "Would like to save the contacts to file?","Exit", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_NO_OPTION) {
            if (controller.getPersonlist().isEmpty()) {
                JOptionPane.showMessageDialog(this, "The Phonebook is empty!","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String csvFile = "conacts.csv";
            try{
                FileWriter writer = new FileWriter (csvFile);
                pbUtil.saveContacts(writer, controller.getPersonlist());
                writer.flush();
                writer.close();
                JOptionPane.showMessageDialog(this, "Successfully saved to file.","File save", JOptionPane.INFORMATION_MESSAGE);
                this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                System.exit(0);
            }catch(IOException ex){
                Logger.getLogger(PhoneBookUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (confirm == JOptionPane.NO_OPTION) {
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            System.exit(0);
        }else if (confirm == JOptionPane.CANCEL_OPTION) {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
        
        
    }//GEN-LAST:event_formWindowClosing

    public void refreshTable(){
        DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(
            new Object [][] {
    },
    new String [] {
        "Name", "Gender", "Age", "Phone Number"
    }
) {
    boolean[] canEdit = new boolean [] {
        false, false, false, false
    };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
      };
        
        for(Person p: controller.getPersonlist()){
            ArrayList al = new ArrayList();
            al.add(p.getName());
            al.add(p.getGender());
            al.add(p.getAge());
            al.add(p.getPhonenumber());
            
            tableModel.addRow(al.toArray());
        }
        
        tblContacts.setModel(tableModel);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PhoneBookUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhoneBookUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhoneBookUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhoneBookUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhoneBookUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu PopupMenu;
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cmbAge;
    private javax.swing.JComboBox cmbEditAge;
    private javax.swing.JComboBox cmbEditGender;
    private javax.swing.JComboBox cmbGender;
    private javax.swing.JTextField cmbPhoneNumber;
    private javax.swing.JDialog diagAddContact;
    private javax.swing.JDialog diagEditContact;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbSelected;
    private javax.swing.JMenuItem mnDeleteContact;
    private javax.swing.JMenuItem mnEditContact;
    private javax.swing.JMenuItem mnLoadData;
    private javax.swing.JMenuItem mnSaveData;
    private javax.swing.JTable tblContacts;
    private javax.swing.JTextField txtEditName;
    private javax.swing.JTextField txtEditPhoneNumber;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}