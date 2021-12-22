//ORIGINAL FILE
//MAO PA NI MURUN
package Main;

//LOCAL VARIABLES
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author admin
 */
public class Kiosk extends javax.swing.JFrame {

    /**
     * Creates new form Kiosk
     */
    public Kiosk() {
        initComponents();

        subject_table.setSelectionBackground(Color.red);

        default_photo();
        dash_pay.setEnabled(false);
        jTabbedPane2.setEnabled(false);
        combo_box.setFocusable(true);
        dash_amount.setEnabled(false);

    }

    Connection con;
    PreparedStatement pst, pst2, pst3, pst4;
    ResultSet rs, rs2, rs3;

    public void viewStudent() {

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://E:\\Enrollment_System.accdb");
            pst = con.prepareStatement("select * from Student where std_number='" + dash_ID.getText() + "'");
            rs = pst.executeQuery();

            if (rs.next()) {

                dash_first_name.setText(rs.getString("std_first_name"));
                dash_middle_name.setText(rs.getString("std_middle_name"));
                dash_last_name.setText(rs.getString("std_last_name"));
                dash_course_year.setText(rs.getString("std_course") + " " + rs.getString("std_year_level"));

                ImageIcon icon = new ImageIcon(rs.getString("std_photo"));
                Image image = icon.getImage().getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(image);

                dash_image.setIcon(icon);

                jTabbedPane2.setEnabled(true);
                viewTeacher();
                viewSubjects();
                viewGrades();
                viewSem();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid student number.", "Invalid", JOptionPane.ERROR_MESSAGE);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Kiosk.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void viewTuition() {

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://E:\\Enrollment_System.accdb");

            pst = con.prepareStatement("select * from Tuitions where std_number='" + dash_ID.getText() + "'");
            rs = pst.executeQuery();

            while (rs.next()) { //while loop akoang gigamit kay duha man ka student nga ID ang parehas PAREHAS.

                if (rs.getString("tuition_semester").equalsIgnoreCase(selectedValue)) {

                    subtotal_Fee.setText("P" + rs.getString("tuition_fee"));
                    totalAmount += rs.getInt("tuition_fee");

                    lab_Fee.setText("P" + rs.getString("lab_fee"));
                    totalAmount += rs.getInt("lab_fee");

                    other_Fee.setText("P" + rs.getString("other_fee"));
                    totalAmount += rs.getInt("other_fee");

                    misc_Fee.setText("P" + rs.getString("misc_fee"));
                    totalAmount += rs.getInt("misc_fee");

                    dash_amount.setEnabled(true);
                    total_amount.setText("P" + totalAmount + "");
                    dash_balance.setText(totalAmount + "");

                    break; //importante kaayo ang role sa break diri

                }

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Kiosk.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void viewSubjects() {

        DefaultTableModel model = (DefaultTableModel) subject_table.getModel();
        model.setRowCount(0);

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://E:\\Enrollment_System.accdb");

            pst = con.prepareStatement("select * from Enroll where std_number='" + dash_ID.getText() + "'");
            rs = pst.executeQuery();

            while (rs.next()) {

                //Enroll table
                pst2 = con.prepareStatement("select * from Class where faculty_ID ='" + rs.getString("faculty_ID") + "'");
                rs2 = pst2.executeQuery();

                if (rs2.next()) {

                    //Class table
                    schedList.add(rs2.getString("class_day") + "          " + rs2.getString("class_time"));

                    pst3 = con.prepareStatement("select * from Subjects where subject_ID ='" + rs2.getString("subject_ID") + "'");
                    rs3 = pst3.executeQuery();

                    if (rs3.next()) {

                        //Subject table
                        subs.add(rs3.getString("subject_ID"));
                        subs.add(rs3.getString("subject_title"));

                        model.addRow(subs.toArray());
                        subs.clear(); //inig human ug add sa table kay walaon ang data sa arraylist
                    }

                }
            }
            subject_table.setModel(model);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Kiosk.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void default_photo() {

        ImageIcon icon = new ImageIcon("C:\\Users\\admin\\Desktop\\SamplePhotos\\logo.png");
        Image image = icon.getImage().getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        dash_image.setIcon(icon);

    }

    public void viewSem() {

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://E:\\Enrollment_System.accdb");

            pst = con.prepareStatement("select * from Tuitions where std_number='" + dash_ID.getText() + "'");
            rs = pst.executeQuery(); //RS1

            while (rs.next()) { //DAKPON ANG ID NUMBER

                pst2 = con.prepareStatement("select * from Tuitions where std_number='" + dash_ID.getText() + "'");
                rs2 = pst2.executeQuery(); //RS2

                if (rs2.next()) {//DAKPON ANG SEMESTER TYPE GIKAN SA ID NUMBER

                    combo_box.addItem(rs.getString("tuition_semester"));

                }

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Kiosk.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void viewSub_Details() {

        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://E:\\Enrollment_System.accdb");
            pst = con.prepareStatement("select * from Subjects where subject_ID ='" + subject_ID + "'");
            rs = pst.executeQuery();

            if (rs.next()) {

                detail_class.setText(rs.getString("subject_class"));
                detail_code.setText(rs.getString("subject_code"));
                detail_title.setText(rs.getString("subject_title"));
                detail_units.setText(rs.getString("subject_units") + " units");

                grade_title.setText(rs.getString("subject_title"));

            }

        } catch (Exception e) {

        }
    }

    public void viewTeacher() {

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://E:\\Enrollment_System.accdb");

            pst = con.prepareStatement("select * from Enroll where std_number='" + dash_ID.getText() + "'");
            rs = pst.executeQuery();

            while (rs.next()) {

                pst2 = con.prepareStatement("select * from Class where faculty_ID ='" + rs.getString("faculty_ID") + "'");
                rs2 = pst2.executeQuery();

                if (rs2.next()) {

                    //System.out.println(rs2.getString("subject_ID"));
                    pst3 = con.prepareStatement("select * from Teachers where teacher_number ='" + rs2.getString("teacher_number") + "'");
                    rs3 = pst3.executeQuery();

                    if (rs3.next()) {

                        //System.out.println(rs3.getString("subject_title"));
                        teacherList.add((rs3.getString("teacher_first_name")) + " " + (rs3.getString("teacher_middle_name")) + " " + (rs3.getString("teacher_last_name")));
                    }

                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Kiosk.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void viewGrades() {

        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://E:\\Enrollment_System.accdb");
            pst = con.prepareStatement("select * from Subjects where subject_ID ='" + subject_ID + "'");
            rs = pst.executeQuery();

            if (rs.next()) {

                grade_title.setText(rs.getString("subject_title"));

            }

        } catch (Exception e) {

        }

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://E:\\Enrollment_System.accdb");

            pst = con.prepareStatement("select * from Grades where std_number='" + dash_ID.getText() + "'");
            rs = pst.executeQuery();

            while (rs.next()) {

                gradesList1.add(rs.getString("midterm_grade"));
                gradesList2.add(rs.getString("final_grade"));

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Kiosk.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void uploadPhoto() {

        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://E:\\Enrollment_System.accdb");
            pst = con.prepareStatement("select * from Student where std_number='" + dash_ID.getText() + "'");
            rs = pst.executeQuery();

            if (rs.next()) {

                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                File f = chooser.getSelectedFile();
                String filename = f.getAbsolutePath();

                try {

                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    con = DriverManager.getConnection("jdbc:ucanaccess://E:\\Enrollment_System.accdb");
                    pst = con.prepareStatement("update Student set std_photo=? where std_number=? ");
                    pst.setString(1, filename);
                    pst.setString(2, dash_ID.getText());
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Photo changed.");

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(Kiosk.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, ex);
                }

                ImageIcon icon = new ImageIcon(filename);
                Image image = icon.getImage().getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(image);

                dash_image.setIcon(icon);
            } else {

                JOptionPane.showMessageDialog(null, "Please enter student number.", "Invalid", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {

        }
    }

    public void payAmount() {

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://E:\\Enrollment_System.accdb");

            pst = con.prepareStatement("select * from Student where std_number='" + dash_ID.getText() + "'");
            rs = pst.executeQuery();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Kiosk.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        view_details = new javax.swing.JMenuItem();
        view_grades = new javax.swing.JMenuItem();
        frame_details = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        detail_units = new javax.swing.JLabel();
        detail_title = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        detail_class = new javax.swing.JLabel();
        detail_schedule = new javax.swing.JLabel();
        detail_code = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        detail_teacher = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        frame_grades = new javax.swing.JFrame();
        jPanel5 = new javax.swing.JPanel();
        grade_remarks = new javax.swing.JLabel();
        grade_title = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        grade_midterm = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        grade_teacher = new javax.swing.JLabel();
        grade_final = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        dash_ID = new javax.swing.JFormattedTextField();
        dash_search = new javax.swing.JButton();
        dash_image = new javax.swing.JLabel();
        dash_first_name = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        dash_course_year = new javax.swing.JLabel();
        dash_middle_name = new javax.swing.JLabel();
        dash_last_name = new javax.swing.JLabel();
        upload_photo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel12 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        SubjectFrame = new javax.swing.JScrollPane();
        subject_table = new javax.swing.JTable();
        TuitionFrame = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        combo_box = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        subtotal_Fee = new javax.swing.JLabel();
        lab_Fee = new javax.swing.JLabel();
        other_Fee = new javax.swing.JLabel();
        misc_Fee = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        total_amount = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        dash_pay = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        dash_amount = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        dash_balance = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();

        view_details.setBackground(new java.awt.Color(255, 255, 255));
        view_details.setText("View Details");
        view_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_detailsActionPerformed(evt);
            }
        });
        jPopupMenu1.add(view_details);

        view_grades.setText("View Grades");
        view_grades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_gradesActionPerformed(evt);
            }
        });
        jPopupMenu1.add(view_grades);

        frame_details.setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        detail_units.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        detail_units.setText("--");

        detail_title.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        detail_title.setText("--");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Subject class :");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setText("Code :");

        detail_class.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        detail_class.setText("--");

        detail_schedule.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        detail_schedule.setText("--");

        detail_code.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        detail_code.setText("--");

        jLabel24.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel24.setText("Schedule :");

        jLabel25.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel25.setText("Teacher :");

        detail_teacher.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(detail_title, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(detail_units, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel24))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(detail_code)
                            .addComponent(detail_schedule)
                            .addComponent(detail_class)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addGap(37, 37, 37)
                            .addComponent(detail_teacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detail_units)
                    .addComponent(detail_title))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(detail_class))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(detail_code))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(detail_schedule))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(detail_teacher))
                .addGap(16, 16, 16))
        );

        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Back");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout frame_detailsLayout = new javax.swing.GroupLayout(frame_details.getContentPane());
        frame_details.getContentPane().setLayout(frame_detailsLayout);
        frame_detailsLayout.setHorizontalGroup(
            frame_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(frame_detailsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frame_detailsLayout.setVerticalGroup(
            frame_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frame_detailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        frame_grades.setUndecorated(true);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        grade_remarks.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        grade_remarks.setForeground(new java.awt.Color(0, 204, 0));
        grade_remarks.setText("--");

        grade_title.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        grade_title.setText("--");

        jLabel29.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel29.setText("Midterm Grade :");

        jLabel30.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel30.setText("Final Grade :");

        grade_midterm.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        grade_midterm.setText("--");

        jLabel32.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel32.setText("Instructor :");

        grade_teacher.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        grade_teacher.setText("--");

        grade_final.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        grade_final.setText("--");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(grade_title, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(grade_remarks, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(grade_midterm)
                            .addComponent(grade_final)))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel32)
                            .addGap(18, 18, 18)
                            .addComponent(grade_teacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grade_remarks)
                    .addComponent(grade_title))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(grade_midterm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(grade_final))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(grade_teacher))
                .addGap(16, 16, 16))
        );

        jLabel37.setForeground(new java.awt.Color(255, 51, 51));
        jLabel37.setText("Back");
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout frame_gradesLayout = new javax.swing.GroupLayout(frame_grades.getContentPane());
        frame_grades.getContentPane().setLayout(frame_gradesLayout);
        frame_gradesLayout.setHorizontalGroup(
            frame_gradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(frame_gradesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel37)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frame_gradesLayout.setVerticalGroup(
            frame_gradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frame_gradesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(153, 153, 153))); // NOI18N

        try {
            dash_ID.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dash_ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dash_IDKeyPressed(evt);
            }
        });

        dash_search.setText("Search");
        dash_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dash_searchActionPerformed(evt);
            }
        });

        dash_image.setBackground(new java.awt.Color(204, 204, 204));
        dash_image.setText("         No image");
        dash_image.setMaximumSize(new java.awt.Dimension(68, 14));
        dash_image.setMinimumSize(new java.awt.Dimension(68, 14));

        dash_first_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dash_first_name.setText("----");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Student number");

        logout.setText("LOG-OUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        dash_course_year.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dash_course_year.setForeground(new java.awt.Color(102, 102, 102));
        dash_course_year.setText("----");

        dash_middle_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dash_middle_name.setText("----");

        dash_last_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dash_last_name.setText("----");

        upload_photo.setText("Upload Photo");
        upload_photo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upload_photoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(dash_image, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addComponent(dash_last_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dash_middle_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dash_course_year, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dash_first_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(dash_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dash_search))
                    .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(upload_photo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(187, 187, 187))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dash_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dash_search))
                .addGap(18, 18, 18)
                .addComponent(dash_image, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(upload_photo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dash_first_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dash_middle_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dash_last_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dash_course_year)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel40.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel40.setText("student kiosk");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(281, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addGap(211, 211, 211))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        subject_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Code"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        subject_table.getTableHeader().setReorderingAllowed(false);
        subject_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subject_tablesubjectTableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                subject_tablesubjectTableMouseReleased(evt);
            }
        });
        SubjectFrame.setViewportView(subject_table);

        jTabbedPane2.addTab("Subjects", SubjectFrame);

        TuitionFrame.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        combo_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_boxcomboBoxActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Tuition Fees");

        jLabel12.setText("Subtotal Tuition Fees");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Laboratory Fees");

        jLabel15.setText("Subtotal Laboratory Fees");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Other Fees");

        jLabel21.setText("Subtotal Other Fees");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Miscellaneous Fees");

        jLabel27.setText("Subtotal Miscellaneous Fee");

        subtotal_Fee.setText("--");

        lab_Fee.setText("--");

        other_Fee.setText("--");

        misc_Fee.setText("--");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 51, 51));
        jLabel23.setText("Total Amount");

        total_amount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        total_amount.setForeground(new java.awt.Color(255, 51, 51));
        total_amount.setText("--");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel22)
                            .addComponent(jLabel14)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel15)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel21))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel27)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(subtotal_Fee, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(lab_Fee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(other_Fee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(misc_Fee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(total_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(subtotal_Fee)
                        .addGap(27, 27, 27)
                        .addComponent(lab_Fee)
                        .addGap(27, 27, 27)
                        .addComponent(other_Fee)
                        .addGap(27, 27, 27)
                        .addComponent(misc_Fee))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(total_amount))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combo_box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel10.setText("Account Balance");

        dash_pay.setText("PAY");
        dash_pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dash_payActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel17.setText("Amount to pay");

        dash_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dash_amountKeyReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("P");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("P");

        dash_balance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(dash_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(dash_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(dash_pay, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dash_pay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dash_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(dash_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20)))))
                .addContainerGap())
        );

        javax.swing.GroupLayout TuitionFrameLayout = new javax.swing.GroupLayout(TuitionFrame);
        TuitionFrame.setLayout(TuitionFrameLayout);
        TuitionFrameLayout.setHorizontalGroup(
            TuitionFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TuitionFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TuitionFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TuitionFrameLayout.setVerticalGroup(
            TuitionFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TuitionFrameLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Tuition", TuitionFrame);

        jLabel34.setText("PaulJor-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 605, Short.MAX_VALUE)
                        .addComponent(jLabel34)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel34)
                .addGap(129, 129, 129))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    String selectedValue = "--";
    String subject_ID;

    int totalAmount = 0;

    ArrayList schedList = new ArrayList();
    ArrayList teacherList = new ArrayList();
    ArrayList subs = new ArrayList();//subject's list
    ArrayList gradesList1 = new ArrayList();//midterm grade
    ArrayList gradesList2 = new ArrayList();//final grade

    private void dash_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dash_searchActionPerformed

        viewStudent();

    }//GEN-LAST:event_dash_searchActionPerformed

    private void subject_tablesubjectTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subject_tablesubjectTableMouseClicked

        DefaultTableModel model = (DefaultTableModel) subject_table.getModel(); //if jtable clicked, the value will go to jlabel.
        int selectedIndex = subject_table.getSelectedRow();

        subject_ID = model.getValueAt(selectedIndex, 0).toString();

        for (int i = 0; i < schedList.size(); i++) {

            if (selectedIndex == i) {
                detail_schedule.setText((String) schedList.get(i));
                detail_teacher.setText((String) teacherList.get(i));

                grade_midterm.setText((String) gradesList1.get(i));
                grade_final.setText((String) gradesList2.get(i));
                grade_teacher.setText((String) teacherList.get(i));

                double midterm = Double.parseDouble((String) gradesList1.get(i));
                double finals = Double.parseDouble((String) gradesList2.get(i));
                double average = (midterm + finals) / 2;

                if (average > 3) {
                    grade_remarks.setForeground(Color.RED);
                    grade_remarks.setText("Failed");
                } else if (average < 1) {
                    grade_remarks.setForeground(Color.BLACK);
                    grade_remarks.setText("Invalid");
                } else {
                    grade_remarks.setForeground(Color.GREEN);
                    grade_remarks.setText("Passed");
                }
            }
        }

    }//GEN-LAST:event_subject_tablesubjectTableMouseClicked

    private void subject_tablesubjectTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subject_tablesubjectTableMouseReleased

        try {

            if (evt.isPopupTrigger()) {
                jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_subject_tablesubjectTableMouseReleased

    private void combo_boxcomboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_boxcomboBoxActionPerformed

        totalAmount = 0;//reset ang totalAmount

        selectedValue = combo_box.getSelectedItem().toString();

        viewTuition();//sudlan ang totalAmount

    }//GEN-LAST:event_combo_boxcomboBoxActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed

        int diagResult = JOptionPane.showConfirmDialog(null, "Do you want to log-out?", "Warning", JOptionPane.YES_NO_OPTION);
        if (diagResult == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {

        }

    }//GEN-LAST:event_logoutActionPerformed

    private void view_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_detailsActionPerformed

        frame_details.setVisible(true);
        frame_details.pack(); //pack ang unahon kaysa sa location para matunga
        frame_details.setLocationRelativeTo(this);

        viewSub_Details();
    }//GEN-LAST:event_view_detailsActionPerformed

    private void view_gradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_gradesActionPerformed

        frame_grades.setVisible(true);
        frame_grades.pack();
        frame_grades.setLocationRelativeTo(this);

        viewGrades();

    }//GEN-LAST:event_view_gradesActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked

        frame_details.setVisible(false);

    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked

        frame_grades.setVisible(false);

    }//GEN-LAST:event_jLabel37MouseClicked

    private void dash_IDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dash_IDKeyPressed

        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

                viewStudent();

            }
        } catch (Exception e) {

        }

    }//GEN-LAST:event_dash_IDKeyPressed

    private void upload_photoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upload_photoActionPerformed

        uploadPhoto();

    }//GEN-LAST:event_upload_photoActionPerformed

    private void dash_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dash_amountKeyReleased

        try {

            try {
                if (Integer.parseInt(dash_amount.getText()) < totalAmount) {//Minimum of 1k

                    dash_pay.setEnabled(false);

                }
            } catch (Exception e) {
                String trim = dash_amount.getText().substring(0, dash_amount.getText().length() - 1); //Will not accept if not integer
                dash_amount.setText(trim);
            }

            if (Integer.parseInt(dash_amount.getText()) >= totalAmount) {

                dash_pay.setEnabled(true);

            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_dash_amountKeyReleased

    private void dash_payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dash_payActionPerformed

    }//GEN-LAST:event_dash_payActionPerformed

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
            java.util.logging.Logger.getLogger(Kiosk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kiosk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kiosk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kiosk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kiosk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane SubjectFrame;
    private javax.swing.JPanel TuitionFrame;
    private javax.swing.JComboBox<String> combo_box;
    private javax.swing.JFormattedTextField dash_ID;
    private javax.swing.JTextField dash_amount;
    private javax.swing.JLabel dash_balance;
    private javax.swing.JLabel dash_course_year;
    private javax.swing.JLabel dash_first_name;
    private javax.swing.JLabel dash_image;
    private javax.swing.JLabel dash_last_name;
    private javax.swing.JLabel dash_middle_name;
    private javax.swing.JButton dash_pay;
    private javax.swing.JButton dash_search;
    private javax.swing.JLabel detail_class;
    private javax.swing.JLabel detail_code;
    private javax.swing.JLabel detail_schedule;
    private javax.swing.JLabel detail_teacher;
    private javax.swing.JLabel detail_title;
    private javax.swing.JLabel detail_units;
    private javax.swing.JFrame frame_details;
    private javax.swing.JFrame frame_grades;
    private javax.swing.JLabel grade_final;
    private javax.swing.JLabel grade_midterm;
    private javax.swing.JLabel grade_remarks;
    private javax.swing.JLabel grade_teacher;
    private javax.swing.JLabel grade_title;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lab_Fee;
    private javax.swing.JButton logout;
    private javax.swing.JLabel misc_Fee;
    private javax.swing.JLabel other_Fee;
    private javax.swing.JTable subject_table;
    private javax.swing.JLabel subtotal_Fee;
    private javax.swing.JLabel total_amount;
    private javax.swing.JButton upload_photo;
    private javax.swing.JMenuItem view_details;
    private javax.swing.JMenuItem view_grades;
    // End of variables declaration//GEN-END:variables
}
