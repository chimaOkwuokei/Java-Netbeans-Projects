package main.cbt.project.csc.pkg301;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
import javax.swing.Timer;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Samsung
 */
public class test extends javax.swing.JFrame {

    //list decalration for questions,optons and answer
    List<String> questions = new ArrayList<>();

    List<String> optionA = new ArrayList<>();

    List<String> optionB = new ArrayList<>();

    List<String> optionC = new ArrayList<>();

    List<String> optionD = new ArrayList<>();

    List<String> answer = new ArrayList<>();

    List<String> studentAnswer = new ArrayList<>(); //this should be filled up with empty strings

    String yourOption = "";

    int i = 0;
    int score = 0;
    int m = 1; //for question number
    String matno;
    String email;
    int duration;
    int numberOfQuestions;

    //System.out.println(questions);
//        System.out.println(optionA);
//        System.out.println(optionB);
//        System.out.println(optionC);
//        System.out.println(optionD);
//        System.out.println(answer);
//        System.out.println(questions.size());
//        System.out.println(studentAnswer);  code for tester
    /**
     * Creates new form test
     */
    Timer time;

    public test(String matno, String email) {
        initComponents();
        init();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the current time
                java.util.Date currentTime = new java.util.Date();

                // Create a SimpleDateFormat object to format the time
                SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd-MM-yyyy  HH:mm:ss"); // Customize the format as needed

                // Format the time as a String and set it to the JLabel
                jDate.setText(sdf.format(currentTime));
            }
        });
        timer.start();

        jViewresult.setEnabled(false);
        //question count
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");                               //db name       //username //password
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cbt_quiz", "root", "stanislaus1@");
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery("select *from questionamount ");//automatically selects the last value amongst all values
            while (rs.next()) {
                //jLabel2.setText(rs.getString(1));
                numberOfQuestions = Integer.parseInt(rs.getString(1));
            }
        } catch (Exception e) {

        }

        //timer 
        //for duration
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");                               //db name       //username //password
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cbt_quiz", "root", "stanislaus1@");
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery("select *from duration ");//automatically selects the last value amongst all values
            while (rs.next()) {
                //jLabel2.setText(rs.getString(1));
                duration = Integer.parseInt(rs.getString(1));
            }
        } catch (Exception e) {

        }
//        timer

        setLocationRelativeTo(this);

        time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int hours = duration / 3600;
                int minutes = (duration % 3600) / 60;
                int seconds = duration % 60;

                jHours.setText(String.valueOf(hours) + ":");
                jMin.setText(String.valueOf(minutes) + ":");
                jsec.setText(String.valueOf(seconds));

                if (duration == 0) {
                    time.stop();

                    //do what submit is meant to do
                    if (jRadioButton1.isSelected()) {
                        yourOption = jRadioButton1.getText(); //text of jradiobutton would be stored in yourOption, 
                        //then would be stored in the array Useranswer
                        studentAnswer.set(i, yourOption);
                    } else if (jRadioButton2.isSelected()) {
                        yourOption = jRadioButton2.getText();
                        studentAnswer.set(i, yourOption);
                    } else if (jRadioButton3.isSelected()) {
                        yourOption = jRadioButton3.getText();
                        studentAnswer.set(i, yourOption);
                    } else if (jRadioButton4.isSelected()) {
                        yourOption = jRadioButton4.getText();
                        studentAnswer.set(i, yourOption);
                    }

                    if (studentAnswer.get(i) == jRadioButton1.getText()) {
                        jRadioButton1.setSelected(true);
                    } else if (studentAnswer.get(i) == jRadioButton2.getText()) {
                        jRadioButton2.setSelected(true);
                    } else if (studentAnswer.get(i) == jRadioButton3.getText()) {
                        jRadioButton3.setSelected(true);
                    } else if (studentAnswer.get(i) == jRadioButton4.getText()) {
                        jRadioButton4.setSelected(true);
                    }

                    updateDatabase(); //for the students mark

                    String ans; //actual answer
                    String sanswer; //student answer
                    int k;
                    for (k = 0; k < questions.size(); k++) {
                        ans = answer.get(k);
                        sanswer = studentAnswer.get(k);

                        //use .equals() when comparing strings
                        if (sanswer.equals(ans)) {
                            score = score + 5;
                        } else {
                            score = score + 0;
                        }

                    }// TODO add your handling code here:
                    System.out.println(score);

                    updateDatabaseScore();
                    testStatus();
                    //sending email part
                    String subject = "Your bad score for the quiz!\n";        // TODO add your handling code here:
                    String receiver = email;
                    String body = "Hi! Find within this email, your score for the quiz .\n"
                            + "Score " + score + "/25 \n"
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

                    jNext.setEnabled(false);
                    jPrevious.setEnabled(false);
                    jSubmit.setEnabled(false);
                    jViewresult.setEnabled(true);
                    //
                    testResult(); 
                    JOptionPane.showMessageDialog(null, "Timer finished!");

                }

                --duration;
            }
        });
        time.start();

        this.matno = matno;
        this.email = email;

        // Now you can use matno and email as needed in this JFrame
        System.out.println("Matno: " + matno);
        System.out.println("Email: " + email);

        jEmail.setText("USERNAME: " + email);
        jMatno.setText("MATNO: " + matno);
//        List<String> questions = new ArrayList<>();

        //part that gets the questions and all and stores in an array
        try {

//            int numberOfQuestions = 3;
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cbt_quiz", "root", "stanislaus1@");

            // Create a statement with a query to select a given amount of questions randomly
            String query = "SELECT question, optionA, optionB, optionC, optionD, answer FROM questions ORDER BY RAND() LIMIT ?";

            // Adjust the number in setInt(1, numberOfQuestions) to the desired number of questions
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, numberOfQuestions); //"numberofquestions" executes the LIMIT stuff. basically limits/regulates the amount of questions

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Process the results and store them in the array
            while (resultSet.next()) {
                String value = resultSet.getString("question");
                String value1 = resultSet.getString("optionA");
                String value2 = resultSet.getString("optionB");
                String value3 = resultSet.getString("optionC");
                String value4 = resultSet.getString("optionD");
                String value5 = resultSet.getString("answer");

                questions.add(value);
                optionA.add(value1);
                optionB.add(value2);
                optionC.add(value3);
                optionD.add(value4);
                answer.add(value5);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //sets first set of questions
        jQNo.setText("" + m);
        jTextArea1.setText(questions.get(i));
        jRadioButton1.setText(optionA.get(i));
        jRadioButton2.setText(optionB.get(i));
        jRadioButton3.setText(optionC.get(i));
        jRadioButton4.setText(optionD.get(i));

        //dependent on whatever the question size is
        //the iterator here which was i before was conflicting with the initial i, so it was changed to j
        for (int j = 0; j < questions.size(); j++) {
            studentAnswer.add("n/a"); // Add an empty string for each question
        }
        // Now 'dataArray' contains the values retrieved from the database
        // You can loop through it or perform other operations as needed
//        for (String value : questions) {
//            System.out.println(value);
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jNext = new javax.swing.JButton();
        jPrevious = new javax.swing.JButton();
        jSubmit = new javax.swing.JButton();
        jQNo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jEmail = new javax.swing.JLabel();
        jMatno = new javax.swing.JLabel();
        jHours = new javax.swing.JLabel();
        jsec = new javax.swing.JLabel();
        jMin = new javax.swing.JLabel();
        jViewresult = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jDate = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(776, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(776, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 569, 202));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton1.setText("Option A");
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton2.setText("Option B");
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, -1, -1));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton3.setText("Option C");
        getContentPane().add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, -1, -1));

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton4.setText("Option D");
        getContentPane().add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, -1, -1));

        jNext.setBackground(new java.awt.Color(0, 0, 0));
        jNext.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jNext.setForeground(new java.awt.Color(255, 255, 255));
        jNext.setText("Next");
        jNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNextActionPerformed(evt);
            }
        });
        getContentPane().add(jNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 500, -1, -1));

        jPrevious.setBackground(new java.awt.Color(0, 0, 0));
        jPrevious.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPrevious.setForeground(new java.awt.Color(255, 255, 255));
        jPrevious.setText("Previous");
        jPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPreviousActionPerformed(evt);
            }
        });
        getContentPane().add(jPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        jSubmit.setBackground(new java.awt.Color(0, 0, 0));
        jSubmit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jSubmit.setForeground(new java.awt.Color(255, 255, 255));
        jSubmit.setText("Submit");
        jSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(jSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, -1, -1));

        jQNo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jQNo.setText("0");
        getContentPane().add(jQNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 10, -1, -1));

        jEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jEmail.setText("jLabel1");
        getContentPane().add(jEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        jMatno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMatno.setText("jLabel3");
        getContentPane().add(jMatno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jHours.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jHours.setText("jLabel1");
        getContentPane().add(jHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        jsec.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jsec.setText("jLabel3");
        getContentPane().add(jsec, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        jMin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMin.setText("jLabel4");
        getContentPane().add(jMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        jViewresult.setBackground(new java.awt.Color(0, 0, 0));
        jViewresult.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jViewresult.setForeground(new java.awt.Color(255, 255, 255));
        jViewresult.setText("View Script");
        jViewresult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jViewresultActionPerformed(evt);
            }
        });
        getContentPane().add(jViewresult, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 90));

        jDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(jDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 250, 20));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//part that sends the users test info to db
    private void testResult() {
        String Query = "UPDATE students_info SET questions = ?, answer = ?, studentAnswer = ? WHERE matno = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cbt_quiz", "root", "stanislaus1@");
                PreparedStatement preparedStatement = connection.prepareStatement(Query)) {

            // Convert arrays to strings
// Insert into the database 
            String questionsString = String.join(", ", questions);
            String answerString = String.join(", ", answer);
            String userAnswerString = String.join(", ", studentAnswer);

            preparedStatement.setString(4, matno);
            preparedStatement.setString(1, questionsString);
            preparedStatement.setString(2, answerString);
            preparedStatement.setString(3, userAnswerString);

            preparedStatement.executeUpdate();

            // Optionally commit the changes (depending on your transaction requirements)
            //connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
//    private void retrieveTestResult() {
//        String selectQuery = "SELECT questions, answer, studentAnswer FROM students_info WHERE matno = ?";
//
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cbt_quiz", "root", "stanislaus1@");
//                PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
//
//            preparedStatement.setString(1, matno);
//
//            // Execute the query and process the results
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                // Retrieve and process the data from the result set
//                String questionsString = resultSet.getString("questions");
//                String answerString = resultSet.getString("answer");
//                String userAnswerString = resultSet.getString("studentAnswer");
//
//                // Split the strings based on commas
//                String[] questionsArray = questionsString.split(", ");
//                String[] answerArray = answerString.split(", ");
//                String[] userAnswerArray = userAnswerString.split(", ");
//
//                // Display questions and answers in a column-like format
//                for (int n = 0; n < questionsArray.length; n++) {
//                    System.out.println("Question: " + questionsArray[n]);
//                    System.out.println("Answer: " + answerArray[n]);
//                    System.out.println("User Answer: " + userAnswerArray[n]);
//                    System.out.println(); // Add a blank line between each set of questions and answers
//                }
//            }
//
//            // Close resources
//            resultSet.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//  method to update the database with student answers

    private void updateDatabase() {
        String updateQuery = "UPDATE questions SET studentAnswer = ? WHERE questionNo = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cbt_quiz", "root", "stanislaus1@");
                PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            // Loop through each question
            for (int l = 0; l < questions.size(); l++) {
                String studentAnswerValue = studentAnswer.get(l);

                // Set the parameters for the update statement
                preparedStatement.setString(1, studentAnswerValue);
                preparedStatement.setString(2, String.valueOf(l + 1)); // Assuming question_id is an integer and starts from 1, adjust accordingly

                // Execute the update statement
                preparedStatement.executeUpdate();
            }

            // Optionally commit the changes (depending on your transaction requirements)
            //connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateDatabaseScore() {
        String updateQuery = "UPDATE students_info SET marks = ? WHERE matno = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cbt_quiz", "root", "stanislaus1@");
                PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            String studentMarks = String.valueOf(score);

            // Set the parameters for the update statement
            preparedStatement.setString(1, studentMarks);

            //update where matno equals matno
            preparedStatement.setString(2, matno);

            // Execute the update statement
            preparedStatement.executeUpdate();

            // Optionally commit the changes (depending on your transaction requirements)
            //connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void testStatus() {
        String updateQuery = "UPDATE students_info SET status = ? WHERE matno = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cbt_quiz", "root", "stanislaus1@");
                PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            String status = "done";

            // Set the parameters for the update statement
            preparedStatement.setString(1, status);

            //update where matno equals matno
            preparedStatement.setString(2, matno); // Assuming question_id is an integer and starts from 1, adjust accordingly

            // Execute the update statement
            preparedStatement.executeUpdate();

            // Optionally commit the changes (depending on your transaction requirements)
            //connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void jNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNextActionPerformed
        if (i == (questions.size() - 1)) {
            JOptionPane.showMessageDialog(null, "This is the last question");
        } else {
            if (jRadioButton1.isSelected()) {
                yourOption = jRadioButton1.getText();
                studentAnswer.set(i, yourOption);
            } else if (jRadioButton2.isSelected()) {
                yourOption = jRadioButton2.getText();
                studentAnswer.set(i, yourOption);
            } else if (jRadioButton3.isSelected()) {
                yourOption = jRadioButton3.getText();
                studentAnswer.set(i, yourOption);
            } else if (jRadioButton4.isSelected()) {
                yourOption = jRadioButton4.getText();
                studentAnswer.set(i, yourOption);
            }

            //changes question
            i = i + 1;
            m = m + 1;

            jQNo.setText("" + m);
            jTextArea1.setText(questions.get(i));
            jRadioButton1.setText(optionA.get(i));
            jRadioButton2.setText(optionB.get(i));
            jRadioButton3.setText(optionC.get(i));
            jRadioButton4.setText(optionD.get(i));
            buttonGroup1.clearSelection();

            if (studentAnswer.get(i) == jRadioButton1.getText()) {
                jRadioButton1.setSelected(true);
            } else if (studentAnswer.get(i) == jRadioButton2.getText()) {
                jRadioButton2.setSelected(true);
            } else if (studentAnswer.get(i) == jRadioButton3.getText()) {
                jRadioButton3.setSelected(true);
            } else if (studentAnswer.get(i) == jRadioButton4.getText()) {
                jRadioButton4.setSelected(true);
            }

        }

    }//GEN-LAST:event_jNextActionPerformed

    private void jPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPreviousActionPerformed
        if (i == 0) {
            JOptionPane.showMessageDialog(null, "This is the first question");

            if (jRadioButton1.isSelected()) {
                yourOption = jRadioButton1.getText();
                studentAnswer.set(i, yourOption);
            } else if (jRadioButton2.isSelected()) {
                yourOption = jRadioButton2.getText();
                studentAnswer.set(i, yourOption);
            } else if (jRadioButton3.isSelected()) {
                yourOption = jRadioButton3.getText();
                studentAnswer.set(i, yourOption);
            } else if (jRadioButton4.isSelected()) {
                yourOption = jRadioButton4.getText();
                studentAnswer.set(i, yourOption);
            }

        } else {
            if (jRadioButton1.isSelected()) {
                yourOption = jRadioButton1.getText();
                studentAnswer.set(i, yourOption);
            } else if (jRadioButton2.isSelected()) {
                yourOption = jRadioButton2.getText();
                studentAnswer.set(i, yourOption);
            } else if (jRadioButton3.isSelected()) {
                yourOption = jRadioButton3.getText();
                studentAnswer.set(i, yourOption);
            } else if (jRadioButton4.isSelected()) {
                yourOption = jRadioButton4.getText();
                studentAnswer.set(i, yourOption);
            }
            i = i - 1;
            m = m - 1;

            jQNo.setText("" + m);
            jTextArea1.setText(questions.get(i));
            jRadioButton1.setText(optionA.get(i));
            jRadioButton2.setText(optionB.get(i));
            jRadioButton3.setText(optionC.get(i));
            jRadioButton4.setText(optionD.get(i));
            buttonGroup1.clearSelection();

            if (studentAnswer.get(i) == jRadioButton1.getText()) {
                jRadioButton1.setSelected(true);
            } else if (studentAnswer.get(i) == jRadioButton2.getText()) {
                jRadioButton2.setSelected(true);
            } else if (studentAnswer.get(i) == jRadioButton3.getText()) {
                jRadioButton3.setSelected(true);
            } else if (studentAnswer.get(i) == jRadioButton4.getText()) {
                jRadioButton4.setSelected(true);
            }
            // TODO add your handling code here:
        }
    }//GEN-LAST:event_jPreviousActionPerformed

    private void jSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSubmitActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to submit?", "Select", JOptionPane.YES_NO_OPTION);

        if (a == 0) {
            time.stop();

            if (jRadioButton1.isSelected()) {
                yourOption = jRadioButton1.getText(); //text of jradiobutton would be stored in yourOption, 
                //then would be stored in the array Useranswer
                studentAnswer.set(i, yourOption);
            } else if (jRadioButton2.isSelected()) {
                yourOption = jRadioButton2.getText();
                studentAnswer.set(i, yourOption);
            } else if (jRadioButton3.isSelected()) {
                yourOption = jRadioButton3.getText();
                studentAnswer.set(i, yourOption);
            } else if (jRadioButton4.isSelected()) {
                yourOption = jRadioButton4.getText();
                studentAnswer.set(i, yourOption);
            }

            if (studentAnswer.get(i) == jRadioButton1.getText()) {
                jRadioButton1.setSelected(true);
            } else if (studentAnswer.get(i) == jRadioButton2.getText()) {
                jRadioButton2.setSelected(true);
            } else if (studentAnswer.get(i) == jRadioButton3.getText()) {
                jRadioButton3.setSelected(true);
            } else if (studentAnswer.get(i) == jRadioButton4.getText()) {
                jRadioButton4.setSelected(true);
            }

            updateDatabase();

            String ans; //actual answer
            String sanswer; //student answer
            int k;
            for (k = 0; k < questions.size(); k++) {
                ans = answer.get(k);
                sanswer = studentAnswer.get(k);

                //use .equals() when comparing strings
                if (sanswer.equals(ans)) {
                    score = score + 5;
                } else {
                    score = score + 0;
                }

            }// TODO add your handling code here:
            System.out.println(score);

            int totalScore = 5 * numberOfQuestions;
            updateDatabaseScore();
            testStatus(); //sets status to done

            //sending email part
            String subject = "Your score for the quiz!\n";        // TODO add your handling code here:
            String receiver = email;
            String body = "Hi! Find within this email, your score for the quiz .\n"
                    + "Score " + score + "/" + totalScore + "\n"
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

            testResult(); //sets the questions, answers and useranswer for the given user

            jNext.setEnabled(false);
            jPrevious.setEnabled(false);
            jSubmit.setEnabled(false);
            jViewresult.setEnabled(true);
        }


    }//GEN-LAST:event_jSubmitActionPerformed

    private void jViewresultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jViewresultActionPerformed

        this.dispose();
        new result(matno, email).setVisible(true);
    }//GEN-LAST:event_jViewresultActionPerformed

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
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new test("", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jDate;
    private javax.swing.JLabel jEmail;
    private javax.swing.JLabel jHours;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jMatno;
    private javax.swing.JLabel jMin;
    private javax.swing.JButton jNext;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jPrevious;
    private javax.swing.JLabel jQNo;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jSubmit;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jViewresult;
    private javax.swing.JLabel jsec;
    // End of variables declaration//GEN-END:variables
}
