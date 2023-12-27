/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.cbt.project.csc.pkg301;

import java.awt.Image;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Base64;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Samsung
 */
public class Login extends javax.swing.JFrame {

    String username;
    String password;
    String matno;
    String email;
    String status;
    String type;
    String firstName;

    /**
     * Creates new form login
     */
    public Login() {
        initComponents();
        init();
//           try{
//            Class.forName("com.mysql.cj.jdbc.Driver");                               //db name       //username //password
//            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cbt_quiz", "root", "stanislaus1@");
//            Statement st = (Statement) con.createStatement();
//            ResultSet rs = st.executeQuery("select *from students_info where username=? and password=?");//automatically selects the last value amongst all values
//            while(rs.next()){
//            username = rs.getString(1);
//            password = rs.getString(2);
//            
//            System.out.println(username);
//            System.out.println(password);
//            }
//        }catch(Exception e){
//            
//        }
    }

    public void init() {
        setImage();
    }

    public void setImage() {

        ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/Logo_of_Pan-Atlantic_University.png"));

        Image img1 = icon1.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);

        jLabel1.setIcon(new ImageIcon(img1));
//        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldAdminUsername = new javax.swing.JTextField();
        jPasswordFieldAdminPassword = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLogin = new javax.swing.JButton();
        jBack = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(776, 600));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 90));

        jTextFieldAdminUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(jTextFieldAdminUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 359, -1));

        jPasswordFieldAdminPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(jPasswordFieldAdminPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 359, -1));

        jCheckBox1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jCheckBox1.setText("Show Password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));

        jLogin.setBackground(new java.awt.Color(0, 0, 0));
        jLogin.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLogin.setForeground(new java.awt.Color(255, 255, 255));
        jLogin.setText("Login");
        jLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginActionPerformed(evt);
            }
        });
        getContentPane().add(jLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, -1, -1));

        jBack.setBackground(new java.awt.Color(0, 0, 0));
        jBack.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jBack.setForeground(new java.awt.Color(255, 255, 255));
        jBack.setText("Back");
        jBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackActionPerformed(evt);
            }
        });
        getContentPane().add(jBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, -1, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/20-years.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 600));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setText("Username");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 32, 10, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Login");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 580, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        this.dispose();
        new index().setVisible(true);
    }//GEN-LAST:event_jBackActionPerformed

    //function that hashes
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

    //admin username and password are admin
    private void jLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginActionPerformed

        //the part that checks whether what is in the database is what was inputed
        String uname = jTextFieldAdminUsername.getText();

        //hashes the password inputed because that is what is being compared
        String password = hashPassword(jPasswordFieldAdminPassword.getText());

        //prints out the actual password
        System.out.println(jPasswordFieldAdminPassword.getText());
        System.out.println(password); //hashed

        try {
            ResultSet rs;
            Class.forName("com.mysql.cj.jdbc.Driver");                                        // db name //username //password
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cbt_quiz", "root", "stanislaus1@");
            PreparedStatement pst = con.prepareStatement("select * from students_info where email=? and password=?");

            //this does the comparison i guess
            pst.setString(1, uname);
            pst.setString(2, password);
            rs = pst.executeQuery();

            //if password and username match what is id db
            if (rs.next()) {
                // Retrieve additional information from the selected student
                matno = rs.getString("matno");
                email = rs.getString("email");
                status = rs.getString("status");
                type = rs.getString("type");
                firstName = rs.getString("firstname");

                System.out.println("Matno: " + matno);
                System.out.println("Email: " + email);
                System.out.println("Status: " + status);
                System.out.println("Type: " + type);
                System.out.println("First: " + firstName);
                
                //magic goes down here, for chcking whether user is admin or student
                //if type from the username and password inputed is admin
                if (type.equals("Lecturer")) {
                    this.dispose();
                    new registration(firstName).setVisible(true);
                } else {
                    if (status.equals("done") && type.equals("Student")) {
                        Object[] options = {"View Script", "Close"};
                        int choice = JOptionPane.showOptionDialog(
                                null,
                                "You have attempted this test before. What would you like to do?",
                                "Test Attempted", //title of the dialog stuff
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                options,
                                options[0]);

                        // Handle the user's choice
                        switch (choice) {
                            case 0:
                                // User clicked "View Script"
                                // Add code to redirect to the results frame
                                this.dispose();
                                new result(matno, email).setVisible(true);
                                break;
                            case 1:
                                // User clicked "Close"
                                // Add code to handle closing the application or frame
                                this.dispose();
                                new index().setVisible(true);
                                break;
                            default:
                                // Handle other cases if needed
                                break;
                        }

                    } else {
                        this.dispose();
                        new instructions(matno, email).setVisible(true);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username and password do not match");
            }

        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }

    }//GEN-LAST:event_jLoginActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            jPasswordFieldAdminPassword.setEchoChar((char) 0);
        } else {
            jPasswordFieldAdminPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBack;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldAdminPassword;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldAdminUsername;
    // End of variables declaration//GEN-END:variables
}
