/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pau_cafeteria_mgt_system;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class dashboard extends javax.swing.JFrame {

    private double total = 0.0;
    private int x = 0;
    private double tax = 0.0;
   

    public dashboard() {
        initComponents();
        init();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the current time
                Date currentTime = new Date();

                // Create a SimpleDateFormat object to format the time
                SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd-MM-yyyy  HH:mm:ss"); // Customize the format as needed

                // Format the time as a String and set it to the JLabel
                jLabel5.setText(sdf.format(currentTime));
            }
        });
        timer.start();
        jReciept.setEnabled(false);

    }

    public void init() {
        setImage();
    }

    public void setImage() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/jollof.jpg"));
        ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/7up.jpg"));
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/coke.jpg"));
        ImageIcon icon3 = new ImageIcon(getClass().getResource("/images/chickennoodles.jpg"));
        ImageIcon icon4 = new ImageIcon(getClass().getResource("/images/fruitscake.jpg"));
        ImageIcon icon5 = new ImageIcon(getClass().getResource("/images/chickenburger.jpg"));
        ImageIcon icon6 = new ImageIcon(getClass().getResource("/images/background.jpg"));
        ImageIcon icon7 = new ImageIcon(getClass().getResource("/images/Logo_of_Pan-Atlantic_University.png"));

        Image img = icon.getImage().getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), Image.SCALE_SMOOTH);
        Image img1 = icon1.getImage().getScaledInstance(jLabel27.getWidth(), jLabel27.getHeight(), Image.SCALE_SMOOTH);
        Image img2 = icon2.getImage().getScaledInstance(jLabel35.getWidth(), jLabel35.getHeight(), Image.SCALE_SMOOTH);
        Image img3 = icon3.getImage().getScaledInstance(jnoodles.getWidth(), jnoodles.getHeight(), Image.SCALE_SMOOTH);
        Image img4 = icon4.getImage().getScaledInstance(jLabel43.getWidth(), jLabel43.getHeight(), Image.SCALE_SMOOTH);
        Image img5 = icon5.getImage().getScaledInstance(jLabel19.getWidth(), jLabel19.getHeight(), Image.SCALE_SMOOTH);
        Image img6 = icon6.getImage().getScaledInstance(jLabel54.getWidth(), jLabel54.getHeight(), Image.SCALE_SMOOTH);
        Image img7 = icon7.getImage().getScaledInstance(jLabel55.getWidth(), jLabel55.getHeight(), Image.SCALE_SMOOTH);

        jLabel3.setIcon(new ImageIcon(img));
        jLabel27.setIcon(new ImageIcon(img1));
        jLabel35.setIcon(new ImageIcon(img2));
        jnoodles.setIcon(new ImageIcon(img3));
        jLabel43.setIcon(new ImageIcon(img4));
        jLabel19.setIcon(new ImageIcon(img5));
        jLabel54.setIcon(new ImageIcon(img6));
        jLabel55.setIcon(new ImageIcon(img7));
    }

    public boolean qtyIsZero(int qty) {
        if ((qty) == 0) {
            JOptionPane.showMessageDialog(null, "Please Increase item quantity");
            return false;
        }
        return true;
    }

    public void reset() {
        jReciept.setEnabled(false);
        jSpinnerJollof.setValue(0);
        jSpinnerChickenNoodles.setValue(0);
        jSpinnerChickenBurger.setValue(0);
        jSpinner7up.setValue(0);
        jSpinnerCoke.setValue(0);
        jSpinnerFruitCakes.setValue(0);
        jTax.setText("0.0");
        jSub.setText("0.0");
        jTotal1.setText("0.0");
        jTextArea1.setText(" ");
        jCheckBoxJollof.setSelected(false);
        jCheckBoxChickenNoodles.setSelected(false);
        jCheckBoxChickenBurger.setSelected(false);
        jCheckBox7up.setSelected(false);
        jCheckBoxCoke.setSelected(false);
        jCheckBoxFruitCakes.setSelected(false);
        x = 0;
        total = 0;
        tax = 0;
        jTotal.setEnabled(true);
        jCheckBoxJollof.setEnabled(true);
        jCheckBoxChickenNoodles.setEnabled(true);
        jCheckBoxChickenBurger.setEnabled(true);
        jCheckBox7up.setEnabled(true);
        jCheckBoxCoke.setEnabled(true);
        jCheckBoxFruitCakes.setEnabled(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jjollof = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSpinnerJollof = new javax.swing.JSpinner();
        jCheckBoxJollof = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jnoodles = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jChickenNoodles = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSpinnerChickenNoodles = new javax.swing.JSpinner();
        jCheckBoxChickenNoodles = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jChickenBurger = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jSpinnerChickenBurger = new javax.swing.JSpinner();
        jCheckBoxChickenBurger = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        j7up = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jSpinner7up = new javax.swing.JSpinner();
        jCheckBox7up = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jCoke = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jSpinnerCoke = new javax.swing.JSpinner();
        jCheckBoxCoke = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jFruitCakes = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jSpinnerFruitCakes = new javax.swing.JSpinner();
        jCheckBoxFruitCakes = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        jTotal = new javax.swing.JButton();
        jReciept = new javax.swing.JButton();
        jReset = new javax.swing.JButton();
        jExit = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTax = new javax.swing.JTextField();
        jSub = new javax.swing.JTextField();
        jTotal1 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cedarville Cursive", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PAU CAFETERIA");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 6));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel4.setText("Name :");

        jLabel6.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel6.setText("Price  : ");

        jjollof.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jjollof.setText("Jellof Rice");

        jLabel10.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel10.setText(" ₦600");

        jLabel11.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel7.setText("Quantity :");

        jLabel8.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel8.setText("Purchase :");

        jSpinnerJollof.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBoxJollof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxJollofActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(38, 38, 38)
                .addComponent(jjollof))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jSpinnerJollof)
                    .addComponent(jCheckBoxJollof, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jjollof))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7)
                    .addComponent(jSpinnerJollof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jCheckBoxJollof))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MENU");

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 6));
        jPanel5.setPreferredSize(new java.awt.Dimension(188, 240));

        jnoodles.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel12.setText("Name :");

        jLabel13.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel13.setText("Price  : ");

        jChickenNoodles.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jChickenNoodles.setText("Chicken Noodles");

        jLabel15.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel15.setText(" ₦600");

        jLabel16.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel17.setText("Quantity :");

        jLabel18.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel18.setText("Purchase :");

        jSpinnerChickenNoodles.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBoxChickenNoodles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxChickenNoodlesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jnoodles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(38, 38, 38)
                .addComponent(jChickenNoodles))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jSpinnerChickenNoodles)
                    .addComponent(jCheckBoxChickenNoodles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jnoodles, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jChickenNoodles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jSpinnerChickenNoodles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jCheckBoxChickenNoodles)))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 6));
        jPanel6.setPreferredSize(new java.awt.Dimension(188, 240));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel20.setText("Name :");

        jLabel21.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel21.setText("Price  : ");

        jChickenBurger.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jChickenBurger.setText("Chicken Burger");

        jLabel23.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel23.setText("1800");

        jLabel24.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel25.setText("Quantity :");

        jLabel26.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel26.setText("Purchase :");

        jSpinnerChickenBurger.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBoxChickenBurger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxChickenBurgerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel20)
                .addGap(38, 38, 38)
                .addComponent(jChickenBurger))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jSpinnerChickenBurger)
                    .addComponent(jCheckBoxChickenBurger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jChickenBurger))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jSpinnerChickenBurger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jCheckBoxChickenBurger))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 6));
        jPanel7.setPreferredSize(new java.awt.Dimension(188, 240));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));

        jLabel28.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel28.setText("Name :");

        jLabel29.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel29.setText("Price  : ");

        j7up.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        j7up.setText("7Up");

        jLabel31.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel31.setText("250");

        jLabel32.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel33.setText("Quantity :");

        jLabel34.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel34.setText("Purchase :");

        jSpinner7up.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBox7up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7upActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel28)
                .addGap(38, 38, 38)
                .addComponent(j7up))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34))
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jSpinner7up)
                    .addComponent(jCheckBox7up, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(j7up))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jSpinner7up, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jCheckBox7up))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 6));
        jPanel8.setPreferredSize(new java.awt.Dimension(188, 240));

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));

        jLabel36.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel36.setText("Name :");

        jLabel37.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel37.setText("Price  : ");

        jCoke.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jCoke.setText("Coke");

        jLabel39.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel39.setText("150");

        jLabel40.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N

        jLabel41.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel41.setText("Quantity :");

        jLabel42.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel42.setText("Purchase :");

        jSpinnerCoke.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBoxCoke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCokeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel36)
                .addGap(38, 38, 38)
                .addComponent(jCoke))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42))
                .addGap(22, 22, 22)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jSpinnerCoke)
                    .addComponent(jCheckBoxCoke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jCoke))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(jSpinnerCoke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jCheckBoxCoke))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 6));
        jPanel9.setPreferredSize(new java.awt.Dimension(188, 240));

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));

        jLabel44.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel44.setText("Name :");

        jLabel45.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel45.setText("Price  : ");

        jFruitCakes.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jFruitCakes.setText("Fruits Cake");

        jLabel47.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel47.setText("500");

        jLabel48.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N

        jLabel49.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel49.setText("Quantity :");

        jLabel50.setFont(new java.awt.Font("Cedarville Cursive", 1, 12)); // NOI18N
        jLabel50.setText("Purchase :");

        jSpinnerFruitCakes.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBoxFruitCakes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxFruitCakesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel44)
                .addGap(38, 38, 38)
                .addComponent(jFruitCakes))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50))
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jSpinnerFruitCakes)
                    .addComponent(jCheckBoxFruitCakes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jFruitCakes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel49)
                    .addComponent(jSpinnerFruitCakes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jCheckBoxFruitCakes)))
        );

        jTotal.setBackground(new java.awt.Color(0, 204, 0));
        jTotal.setText("TOTAL");
        jTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTotalActionPerformed(evt);
            }
        });

        jReciept.setBackground(new java.awt.Color(255, 153, 0));
        jReciept.setText("RECIEPT");
        jReciept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRecieptActionPerformed(evt);
            }
        });

        jReset.setBackground(new java.awt.Color(255, 255, 255));
        jReset.setText("RESET");
        jReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jResetActionPerformed(evt);
            }
        });

        jExit.setBackground(new java.awt.Color(255, 0, 0));
        jExit.setText("EXIT");
        jExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTotal)
                .addGap(151, 151, 151)
                .addComponent(jReciept)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jReset)
                .addGap(145, 145, 145)
                .addComponent(jExit)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTotal)
                    .addComponent(jReciept)
                    .addComponent(jReset)
                    .addComponent(jExit))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTax.setEditable(false);
        jTax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTax.setText("0.0");
        jTax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTaxActionPerformed(evt);
            }
        });

        jSub.setEditable(false);
        jSub.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jSub.setText("0.0");
        jSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSubActionPerformed(evt);
            }
        });

        jTotal1.setEditable(false);
        jTotal1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTotal1.setText("0.0");
        jTotal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTotal1ActionPerformed(evt);
            }
        });

        jLabel51.setText("Tax");

        jLabel52.setText("Sub Total");

        jLabel53.setText("Total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTax, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSub, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addGap(0, 54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
        public void paucafe() {
        int purchaseId = 15020 + (int)(Math.random()*80900);
        jTextArea1.setText("*********************PAU CAFETERIA*************************\n"
                + "Date & Time: " + jLabel5.getText() + "\n"
                 +"Purchase ID: \t\t\t" + purchaseId+"\n"
                + "********************************************************************\n"
               
                +"\n"       
                + "Item Name:\t\t\t" + "Price(₦) \n");
        
        }

    private void jCheckBoxFruitCakesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxFruitCakesActionPerformed
        int qty = Integer.parseInt(jSpinnerFruitCakes.getValue().toString());
        if (qtyIsZero(qty) && jCheckBoxFruitCakes.isSelected()) {
            x++;
            if (x == 1) {
                paucafe();
            }
            double price = qty * 500.0;
            total += price;
            tax1(total);

            jTextArea1.setText(jTextArea1.getText() + x + " " + jFruitCakes.getText() + "\t\t\t" + price + "\n");
            dudate();
        } else {
            jCheckBoxFruitCakes.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBoxFruitCakesActionPerformed

    private void jCheckBoxCokeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCokeActionPerformed
        int qty = Integer.parseInt(jSpinnerCoke.getValue().toString());
        if (qtyIsZero(qty) && jCheckBoxCoke.isSelected()) {
            x++;
            if (x == 1) {
                paucafe();
            }
            double price = qty * 150.0;
            total += price;
            tax1(total);

            jTextArea1.setText(jTextArea1.getText() + x + " " + jCoke.getText() + "\t\t\t" + price + "\n");
            dudate();
        } else {
            jCheckBoxCoke.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBoxCokeActionPerformed

    private void jCheckBox7upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7upActionPerformed
        int qty = Integer.parseInt(jSpinner7up.getValue().toString());
        if (qtyIsZero(qty) && jCheckBox7up.isSelected()) {
            x++;
            if (x == 1) {
                paucafe();
            }
            double price = qty * 250.0;
            total += price;
            tax1(total);

            jTextArea1.setText(jTextArea1.getText() + x + " " + j7up.getText() + "\t\t\t" + price + "\n");
            dudate();
        } else {
            jCheckBox7up.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox7upActionPerformed

    private void jCheckBoxChickenBurgerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxChickenBurgerActionPerformed
        int qty = Integer.parseInt(jSpinnerChickenBurger.getValue().toString());
        if (qtyIsZero(qty) && jCheckBoxChickenBurger.isSelected()) {
            x++;
            if (x == 1) {
                paucafe();
            }
            double price = qty * 1800.0;
            total += price;
            tax1(total);

            jTextArea1.setText(jTextArea1.getText() + x + " " + jChickenBurger.getText() + "\t\t" + price + "\n");
            dudate();
        } else {
            jCheckBoxChickenBurger.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBoxChickenBurgerActionPerformed

    private void jCheckBoxChickenNoodlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxChickenNoodlesActionPerformed
        int qty = Integer.parseInt(jSpinnerChickenNoodles.getValue().toString());
        if (qtyIsZero(qty) && jCheckBoxChickenNoodles.isSelected()) {
            x++;
            if (x == 1) {
                paucafe();
            }
            double price = qty * 600.0;
            total += price;
            tax1(total);

            jTextArea1.setText(jTextArea1.getText() + x + " " + jChickenNoodles.getText() + "\t\t" + price + "\n");
            dudate();

        } else {
            jCheckBoxChickenNoodles.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBoxChickenNoodlesActionPerformed

    private void jCheckBoxJollofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxJollofActionPerformed
        int qty = Integer.parseInt(jSpinnerJollof.getValue().toString());
        if (qtyIsZero(qty) && jCheckBoxJollof.isSelected()) {
            x++;
            if (x == 1) {
                paucafe();
            }
            double price = qty * 600.0;
            total += price;
            tax1(total);

            jTextArea1.setText(jTextArea1.getText() + x + " " + jjollof.getText() + "\t\t\t" + price + "\n");
            dudate();
        } else {
            jCheckBoxJollof.setSelected(false);
        }

    }//GEN-LAST:event_jCheckBoxJollofActionPerformed


    private void jTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTotalActionPerformed

        if (total == 0.0) {
            JOptionPane.showMessageDialog(null, "Nothing has been purchased yet");
        } else {
            tax1(total);

            jTextArea1.setText(jTextArea1.getText()
                    + "\n********************************************************************\n"
                    + "Tax: \t\t\t " + tax + "\n"
                    + "Sub Total: \t\t\t" + total + "\n"
                    + "Total: \t\t\t" + String.format("%.2f", (total + tax)) + "\n\n"
                    + "*******************************Enjoy!*************************************"
            );
            dudate();

            jTotal.setEnabled(false);
            jReciept.setEnabled(true);
            jCheckBoxJollof.setEnabled(false);
            jCheckBoxChickenNoodles.setEnabled(false);
            jCheckBoxChickenBurger.setEnabled(false);
            jCheckBox7up.setEnabled(false);
            jCheckBoxCoke.setEnabled(false);
            jCheckBoxFruitCakes.setEnabled(false);
        }
    }//GEN-LAST:event_jTotalActionPerformed
    public void dudate() {
        jTax.setText(String.format("%.2f", (tax)));
        jSub.setText(String.format("%.2f", (total)));
        jTotal1.setText(String.format("%.2f", (total + tax)));
    }

    public void tax1(double t) {
        if (t >= 10.0 && t <= 20.0) {
            tax = 500;

        } else if (t > 2000.0 && t <= 4000.0) {
            tax = 1000;
        } else if (t > 4000.0 && t <= 6000.0) {
            tax = 2000;
        } else if (t > 6000.0 && t <= 8000.0) {
            tax = 2050;
        } else if (t > 8000.0 && t <= 10000.0) {
            tax = 3000;
        } else if (t > 10000.0 && t <= 15000.0) {
            tax = 3050;
        } else if (t > 15000.0 && t <= 20000.0) {
            tax = 3060.0;
        } else if (t > 20000.0) {
            tax = 3080.0;
        }

    }
    private void jExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jExitActionPerformed

    private void jSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSubActionPerformed

    private void jTaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTaxActionPerformed

    private void jTotal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTotal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTotal1ActionPerformed

    private void jResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jResetActionPerformed
        reset();
    }//GEN-LAST:event_jResetActionPerformed

//    int xx, xy;
    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
//        int x = evt.getXOnScreen();
//        int y = evt.getYOnScreen();
//        this.setLocation(x=xx,y=xy);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

    }//GEN-LAST:event_formMousePressed

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
//        xx = evt.getX();
//        xy = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jRecieptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRecieptActionPerformed
        if (total != 0 ) {

            try {
                jTextArea1.print();
            } catch (PrinterException ex) {
                Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
           JOptionPane.showMessageDialog(null, "Nothing has been bought yet;you want to waste my ink?");
        }
    }//GEN-LAST:event_jRecieptActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        for(double i=0.0; i<=1.0;i+=0.1){
//            String s = i+"";
//            float f = Float.valueOf(s);
//            this.setOpacity(f);
//            try {
//                Thread.sleep(40);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel j7up;
    private javax.swing.JCheckBox jCheckBox7up;
    private javax.swing.JCheckBox jCheckBoxChickenBurger;
    private javax.swing.JCheckBox jCheckBoxChickenNoodles;
    private javax.swing.JCheckBox jCheckBoxCoke;
    private javax.swing.JCheckBox jCheckBoxFruitCakes;
    private javax.swing.JCheckBox jCheckBoxJollof;
    private javax.swing.JLabel jChickenBurger;
    private javax.swing.JLabel jChickenNoodles;
    private javax.swing.JLabel jCoke;
    private javax.swing.JButton jExit;
    private javax.swing.JLabel jFruitCakes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JButton jReciept;
    private javax.swing.JButton jReset;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner7up;
    private javax.swing.JSpinner jSpinnerChickenBurger;
    private javax.swing.JSpinner jSpinnerChickenNoodles;
    private javax.swing.JSpinner jSpinnerCoke;
    private javax.swing.JSpinner jSpinnerFruitCakes;
    private javax.swing.JSpinner jSpinnerJollof;
    private javax.swing.JTextField jSub;
    private javax.swing.JTextField jTax;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jTotal;
    private javax.swing.JTextField jTotal1;
    private javax.swing.JLabel jjollof;
    private javax.swing.JLabel jnoodles;
    // End of variables declaration//GEN-END:variables
}
