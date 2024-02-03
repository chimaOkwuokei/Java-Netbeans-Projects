package pos.system;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import javax.swing.table.DefaultTableModel;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.TimerTask;

public class Admin extends javax.swing.JFrame {

    public String filename = null;
    public static byte photo[] = null;
    String name;
    String staff_id;
    String email;

    String staff_name;
    String dob;
    String department;
    String type;

    private static String backupTime = "00:00";
    private static Timer timer;

    public Admin(String name, String email, String staff_id) {
        initComponents();
        this.staff_id = staff_id;
        this.email = email;
        this.name = name;

        jLabel21.setText(name);
        jLabel22.setText(email);
        jLabel23.setText(staff_id);

        getUsersRecords();
        checkBirthday();
        getBackupTime();
    }

    private void getBackupTime() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");                               //db name       //username //password
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system", "root", "stanislaus1@");
            PreparedStatement ps = con.prepareStatement("select * from backup");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                backupTime = (rs.getString(1));
            }
            //gets the backup time and sets it to the latest time set in the db
            System.out.println(backupTime);

            //the timer is triggered
            if (isBackupTimeSet() && timer == null) {
                timer = new Timer(true);
                timer.scheduleAtFixedRate(new BackupTask(), calculateInitialDelay(), 24 * 60 * 60 * 1000);
            }

        } catch (Exception e) {

        }
    }

    private static boolean isBackupTimeSet() {
        return !backupTime.equals("00:00");
    }

    private static long calculateInitialDelay() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String currentDate = dateFormat.format(new java.util.Date());

        String nextBackupDateTime = currentDate.split(" ")[0] + " " + backupTime;

        if (calculateTimeDifference(nextBackupDateTime) <= 0) {
            nextBackupDateTime = addDayToDateTime(nextBackupDateTime);
        }

        long timeUntilNextBackup = calculateTimeDifference(nextBackupDateTime);
        return Math.max(0, timeUntilNextBackup);
    }

    private static String addDayToDateTime(String dateTime) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            java.util.Date currentDate = dateFormat.parse(dateTime);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            return dateFormat.format(calendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return dateTime;
        }
    }

    private static long calculateTimeDifference(String targetDateTime) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            java.util.Date targetDate = dateFormat.parse(targetDateTime);
            java.util.Date currentDate = new java.util.Date();
            return targetDate.getTime() - currentDate.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private class BackupTask extends TimerTask {

        @Override
        public void run() {
            // Perform the database backup operation here
            try {
                backupDatabase();
                JOptionPane.showMessageDialog(null, "Database backup completed at " + new java.util.Date());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void backupDatabase() throws Exception {
            // Your database backup code here
            // e.g., execute mysqldump command
            String dumpCommand = "mysqldump -u" + "root" + " -p" + "stanislaus1@"
                    + " -B pos_system -r C:\\Users\\Samsung\\Desktop\\sqldump\\sqldump.sql"; //curse you!
            Process process = Runtime.getRuntime().exec(dumpCommand);
            process.waitFor();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jFileChooser1 = new javax.swing.JFileChooser();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPhoneNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jEmail = new javax.swing.JTextField();
        jAddUser = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jDept = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jType = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jBrowse = new javax.swing.JButton();
        jWebcam = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPassword = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jID = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jBrowseUpdate = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton6 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jWebcamUpdate = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jSetBackup = new javax.swing.JButton();
        jSpinnerHour = new javax.swing.JSpinner();
        jSpinnerMin = new javax.swing.JSpinner();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jDate = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setText("Staff Name");

        jLabel2.setText("Phone Number");

        jLabel3.setText("Email");

        jLabel4.setText("Gender");

        jAddUser.setText("Add User");
        jAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddUserActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Male");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Female");

        jLabel5.setText("Department");

        jDept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Department", "Sales", "Inventory/Stock", "IT", "" }));

        jLabel6.setText("Type of User");

        jType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type", "Manager", "Employee", "", "" }));

        jLabel7.setText("Date Of Birth");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBrowse.setText("Browse");
        jBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowseActionPerformed(evt);
            }
        });

        jWebcam.setText("Webcam");
        jWebcam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jWebcamActionPerformed(evt);
            }
        });

        jLabel9.setText("Password");

        jButton1.setText("Generate Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Check Password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Staff ID ");

        jID.setPreferredSize(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(70, 70, 70))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(61, 61, 61)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jRadioButton1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton2))
                                .addComponent(jPhoneNumber)
                                .addComponent(jEmail)
                                .addComponent(jDept, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jAddUser)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel9))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addGap(18, 18, 18)
                                    .addComponent(jCheckBox1))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))))
                        .addComponent(jButton2)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel10))
                            .addGap(40, 40, 40)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel6))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(jBrowse)
                        .addGap(102, 102, 102)
                        .addComponent(jWebcam))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jDept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jCheckBox1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jAddUser)
                            .addComponent(jButton2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jWebcam)
                            .addComponent(jBrowse))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Staff Registration", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Staff Id");

        jLabel12.setText("Staff Name");

        jLabel13.setText("Phone number ");

        jLabel14.setText("Email");

        jLabel15.setText("Gender");

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Male");

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Female");

        jLabel16.setText("Department");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Department", "Sales", "Inventory/Stock", "IT", "" }));

        jLabel17.setText("Type of user");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type", "Manager", "Employee", "", "" }));

        jLabel18.setText("Date Of Birth");

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel19.setText("Password");

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBrowseUpdate.setText("Browse");
        jBrowseUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowseUpdateActionPerformed(evt);
            }
        });

        jButton5.setText("Update Records");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Check Password");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jButton6.setText("Generate Password");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jWebcamUpdate.setText("Webcam");
        jWebcamUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jWebcamUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel12)
                    .addComponent(jLabel19))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(314, 314, 314))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jRadioButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jRadioButton4))
                                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(55, 55, 55)
                                .addComponent(jBrowseUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jWebcamUpdate)
                                .addGap(69, 69, 69))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox2)))
                                .addGap(109, 109, 109)
                                .addComponent(jButton5)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(76, 76, 76))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(162, 162, 162))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBrowseUpdate)
                        .addComponent(jWebcamUpdate)))
                .addGap(6, 15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2)
                    .addComponent(jButton6)
                    .addComponent(jButton5))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Update Records", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Generate Reports", jPanel3);

        jLabel24.setText("Select the time for backup");

        jSetBackup.setText("Set");
        jSetBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSetBackupActionPerformed(evt);
            }
        });

        jLabel25.setText("Hours");

        jLabel26.setText("Minutes");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel24)
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSetBackup)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinnerHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinnerMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(342, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jSpinnerHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addGap(72, 72, 72)
                .addComponent(jSetBackup)
                .addContainerGap(300, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Schedule Database Backups", jPanel4);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Department", "DOB"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Staff Records", jPanel5);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 112, -1, -1));

        jLabel21.setText("jLabel21");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 46, -1, -1));

        jLabel22.setText("jLabel22");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 46, -1, -1));

        jLabel23.setText("jLabel23");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 46, -1, -1));

        jButton7.setText("Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(732, 43, -1, -1));

        jDate.setText("jLabel24");
        getContentPane().add(jDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 46, -1, -1));
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void checkBirthday() {
        //check birthday
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");                               //db name       //username //password
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system", "root", "stanislaus1@");
            PreparedStatement ps = con.prepareStatement("select * from users");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                staff_name = rs.getString(1); //name
//                jTextField4.setText(rs.getString(2));
//                jTextField5.setText(rs.getString(7));

                department = rs.getString(4);
                type = rs.getString(5);
                dob = rs.getString(6);

                LocalDate currentDate = LocalDate.now();

                //converts it to mm-dd
                String currentDayMonth = currentDate.format(DateTimeFormatter.ofPattern("MM-dd"));

                //gets users birth date
                // Extract day and month from the user's date
                String userDayMonth = new SimpleDateFormat("MM-dd").format(new SimpleDateFormat("yyyy-MM-dd").parse(dob));

                if (currentDayMonth.equals(userDayMonth)) {
                    // Show a birthday message
                    JOptionPane.showMessageDialog(rootPane, "Happy Birthday, " + staff_name + "!");
                    System.out.println(staff_name);
                    System.out.println(department);
                }
            }

        } catch (Exception e) {

        }
    }

    private void getUsersRecords() {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();

            // Clear existing rows in the table
            tableModel.setRowCount(0);

            String selectQuery = "SELECT * FROM users";

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system", "root", "stanislaus1@");
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Object[] row = new Object[3];

                row[0] = resultSet.getObject("name");
                row[1] = resultSet.getObject("department");
                row[2] = resultSet.getObject("date");

                // Add more columns as needed
                tableModel.addRow(row);
            }

            // Check for birthday and display message
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }
//public void checkBirthday() {
//        // Generate a random password (you can customize this according to your requirements)
//        SecureRandom random = new SecureRandom();
//        byte[] passwordBytes = new byte[4];
//        random.nextBytes(passwordBytes);
//        return Base64.getEncoder().encodeToString(passwordBytes);
//    }
//generate random password

    private static String generateRandomPassword() {
        // Generate a random password (you can customize this according to your requirements)
        SecureRandom random = new SecureRandom();
        byte[] passwordBytes = new byte[4];
        random.nextBytes(passwordBytes);
        return Base64.getEncoder().encodeToString(passwordBytes);
    }

    //hash password
    private static String hashPassword(String password) {
        // Hash the password using SHA-256
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.dispose();
        new Login().setVisible(true);
        backupTime = "00:00";
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jWebcamUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jWebcamUpdateActionPerformed
        new webcamUpdate().setVisible(true);
    }//GEN-LAST:event_jWebcamUpdateActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jPasswordField1.setText(generateRandomPassword());
        System.out.println(jPasswordField1.getText());
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if (jCheckBox2.isSelected()) {
            jPasswordField1.setEchoChar((char) 0);
        } else {
            jPasswordField1.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            String staff_id = jTextField2.getText();
            String name = jTextField3.getText();

            String gender = null;
            if (jRadioButton3.isSelected()) {
                gender = "Male";
            } else if (jRadioButton4.isSelected()) {
                gender = "Female";
            }

            String number = jTextField4.getText();

            String department = jComboBox1.getSelectedItem().toString();
            String type = jComboBox2.getSelectedItem().toString();

            String email = jTextField5.getText();
            String password = hashPassword(jPasswordField1.getText()); //you're hashing it because the hashed value is what is being stored in the db

            SimpleDateFormat dat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dat.format(jDateChooser2.getDate());

            Class.forName("com.mysql.cj.jdbc.Driver");                               //db name       //username //password
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system", "root", "stanislaus1@");
            PreparedStatement ps = con.prepareStatement("update users set name=?, number=?, gender=?,department=?, type=?,date=?, email=?,  password=?, photo=? where staff_id=?");

            ps.setString(10, staff_id);
            ps.setString(1, name);
            ps.setString(2, number);
            ps.setString(3, gender);
            ps.setString(4, department);
            ps.setString(5, type);
            ps.setString(6, date);
            ps.setString(7, email);
            ps.setString(8, password);
            ps.setBytes(9, photo);
            //            ps.setString(9, marks);
            //            ps.setString(10, status);
            //            ps.setString(11, questions);
            //            ps.setString(12, answer);
            //            ps.setString(13, studentAnswer);
            //            ps.setString(9, type);

            int rs = ps.executeUpdate();

            //sending email part
            String subject = "Updated username and password for " + name + " for the new CBT system";        // TODO add your handling code here:
            String receiver = email;
            String body = "Hi " + name + "! \nFind within this email, your updated username and password for the cbt system.\n"
            + "Username: " + email + "\n"
            + "Password: " + jPasswordField1.getText() + "\n"
            + "Have a good day!";
            String senderEmail = "chima4484@gmail.com";
            String senderPassword = "bwchyufylzguztic";
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587"); //

            Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmail, senderPassword);
                    }
                });

                try {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(senderEmail));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
                    message.setSubject(subject);
                    message.setText(body);
                    Transport.send(message);
                    JOptionPane.showMessageDialog(rootPane, "Email Sent");

                } catch (MessagingException e) {
                    JOptionPane.showMessageDialog(rootPane, e);
                }

                JOptionPane.showMessageDialog(null, name + "'s record has been updated");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jBrowseUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowseUpdateActionPerformed
        try {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image", "jpeg");

            jFileChooser1.setAcceptAllFileFilterUsed(false);
            jFileChooser1.addChoosableFileFilter(filter);
            jFileChooser1.showOpenDialog(null);

            File f = jFileChooser1.getSelectedFile();
            filename = f.getAbsolutePath();
            String path = f.getAbsolutePath();
            jTextField6.setText(path);

            Image im = Toolkit.getDefaultToolkit().createImage(path);
            im = im.getScaledInstance(jLabel20.getWidth(), jLabel20.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ic = new ImageIcon(im);
            jLabel20.setIcon(ic);

            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] Byte = new byte[1024];

            for (int i = 0; (i = fis.read(Byte)) != -1;) {
                baos.write(Byte, 0, i);
            }
            photo = baos.toByteArray();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jBrowseUpdateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            String staff_id = jTextField2.getText();
            String getID = null;

            Class.forName("com.mysql.cj.jdbc.Driver");                               //db name       //username //password
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system", "root", "stanislaus1@");
            PreparedStatement ps = con.prepareStatement("select * from users where staff_id = ?");

            ps.setString(1, staff_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                getID = rs.getString(10);
                jTextField3.setText(rs.getString(1));
                jTextField4.setText(rs.getString(2));
                jTextField5.setText(rs.getString(7));
                String gender = rs.getString(3);
                if (gender.equalsIgnoreCase("Male")) {
                    jRadioButton3.setSelected(true);
                } else {
                    jRadioButton4.setSelected(true);
                }
                jComboBox1.setSelectedItem(rs.getString(4));
                jComboBox2.setSelectedItem(rs.getString(5));
                jDateChooser2.setDate(rs.getDate(6));

                photo = rs.getBytes(9);
                ImageIcon ic = new ImageIcon(photo);
                Image im = ic.getImage();
                Image scaled = im.getScaledInstance(jLabel20.getWidth(), jLabel20.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIc = new ImageIcon(scaled);
                jLabel20.setIcon(scaledIc);
            }

            if (staff_id.equalsIgnoreCase(getID)) {
                JOptionPane.showMessageDialog(rootPane, "Record found");

            } else {
                JOptionPane.showMessageDialog(rootPane, "Record not found for " + staff_id);

            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jName.setText("");

        buttonGroup1.clearSelection();

        jPhoneNumber.setText("");

        jDept.setSelectedItem(0);
        jType.setSelectedItem(0);

        jEmail.setText("");
        jPassword.setText(""); //you're hashing it because the hashed value is what is being stored in the db

        // SimpleDateFormat dat = new SimpleDateFormat("yyyy-MM-dd");
        // jDateChooser1.setDate();
        jLabel8.setIcon(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            jPassword.setEchoChar((char) 0);
        } else {
            jPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jPassword.setText(generateRandomPassword());
        System.out.println(jPassword.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jWebcamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jWebcamActionPerformed
        new webcam().setVisible(true);
    }//GEN-LAST:event_jWebcamActionPerformed

    private void jBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowseActionPerformed
        try {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image", "jpeg");

            jFileChooser1.setAcceptAllFileFilterUsed(false);
            jFileChooser1.addChoosableFileFilter(filter);
            jFileChooser1.showOpenDialog(null);

            File f = jFileChooser1.getSelectedFile();
            filename = f.getAbsolutePath();
            String path = f.getAbsolutePath();
            jTextField1.setText(path);

            Image im = Toolkit.getDefaultToolkit().createImage(path);
            im = im.getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ic = new ImageIcon(im);
            jLabel8.setIcon(ic);

            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] Byte = new byte[1024];

            for (int i = 0; (i = fis.read(Byte)) != -1;) {
                baos.write(Byte, 0, i);
            }
            photo = baos.toByteArray();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jBrowseActionPerformed

    private void jAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddUserActionPerformed

        try {
            String staff_id = jID.getText();
            String name = jName.getText();

            String gender = null;
            if (jRadioButton1.isSelected()) {
                gender = "Male";
            } else if (jRadioButton2.isSelected()) {
                gender = "Female";
            }

            String number = jPhoneNumber.getText();

            String department = jDept.getSelectedItem().toString();
            String type = jType.getSelectedItem().toString();

            String email = jEmail.getText();
            String password = hashPassword(jPassword.getText()); //you're hashing it because the hashed value is what is being stored in the db

            SimpleDateFormat dat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dat.format(jDateChooser1.getDate());

            System.out.println(password);//hashed

            Class.forName("com.mysql.cj.jdbc.Driver");                               //db name       //username //password
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system", "root", "stanislaus1@");
            PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?,?,?,?,?,?,?,?)");

            ps.setString(10, staff_id);
            ps.setString(1, name);
            ps.setString(2, number);
            ps.setString(3, gender);
            ps.setString(4, department);
            ps.setString(5, type);
            ps.setString(6, date);
            ps.setString(7, email);
            ps.setString(8, password);
            ps.setBytes(9, photo);

            int rs = ps.executeUpdate();

            //sending email part
            String subject = "Welcome to the " + department + " department!\n\n";        // TODO add your handling code here:
            String receiver = email;
            String body = "Hi " + name + "! Find within this email, your username and password for the POS System.\n"
            + "Username: " + email + "\n"
            + "Password: " + jPassword.getText() + "\n"
            + "Have a good day!";
            String senderEmail = "chima4484@gmail.com";
            String senderPassword = "bwchyufylzguztic";
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmail, senderPassword);
                    }
                });

                try {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(senderEmail));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
                    message.setSubject(subject);
                    message.setText(body);
                    Transport.send(message);
                    JOptionPane.showMessageDialog(rootPane, "Email Sent");

                } catch (MessagingException e) {
                    JOptionPane.showMessageDialog(rootPane, e);
                }

                JOptionPane.showMessageDialog(rootPane, name + " has been inserted and email has been sent");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
    }//GEN-LAST:event_jAddUserActionPerformed

    private void jSetBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSetBackupActionPerformed
        //        int hour = Integer.parseInt(jSpinnerHour.getValue().toString());
        //        int minute = Integer.parseInt(jSpinnerMin.getValue().toString());
        //
        //        String formattedHour = String.format("%02d", hour);
        //        String formattedMinute = String.format("%02d", minute);
        //
        //        backupTime = formattedHour + ":" + formattedMinute;
        //        System.out.println(backupTime);
        //
        //        // Schedule the backup task if the time is set and timer is not already running
        //        if (isBackupTimeSet() && timer == null) {
            //            timer = new Timer(true);
            //            timer.scheduleAtFixedRate(new BackupTask(), calculateInitialDelay(), 24 * 60 * 60 * 1000);
            //        }
    }//GEN-LAST:event_jSetBackupActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin("", "", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jAddUser;
    private javax.swing.JButton jBrowse;
    private javax.swing.JButton jBrowseUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jDate;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JComboBox<String> jDept;
    private javax.swing.JTextField jEmail;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JTextField jID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jPhoneNumber;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jSetBackup;
    private javax.swing.JSpinner jSpinnerHour;
    private javax.swing.JSpinner jSpinnerMin;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    public static javax.swing.JTextField jTextField6;
    private javax.swing.JComboBox<String> jType;
    private javax.swing.JButton jWebcam;
    private javax.swing.JButton jWebcamUpdate;
    // End of variables declaration//GEN-END:variables
}
