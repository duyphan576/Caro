/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import static Controller.Main.client;
import static Controller.Receive.login;
import static Controller.Receive.register;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import Model.User;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jukut
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form SignUp
     */
    private static User user = new User();

    public Register() throws Exception {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            initComponents();
            this.setIconImage(new ImageIcon(this.getClass().getResource("/tic-tac-toe.png")).getImage());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
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
        jPanel1 = new javax.swing.JPanel();
        lblRegisterPage = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        pwPassword = new javax.swing.JPasswordField();
        lblConfirmPassword = new javax.swing.JLabel();
        pwConfirm = new javax.swing.JPasswordField();
        lblFullName = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        lblSex = new javax.swing.JLabel();
        rdMale = new javax.swing.JRadioButton();
        Male = new javax.swing.JLabel();
        rdFemale = new javax.swing.JRadioButton();
        Female = new javax.swing.JLabel();
        rdAnother = new javax.swing.JRadioButton();
        lblBirthday = new javax.swing.JLabel();
        DateChooser = new com.toedter.calendar.JDateChooser();
        btnRegister = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txterro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 700));

        lblRegisterPage.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblRegisterPage.setForeground(new java.awt.Color(0, 0, 153));
        lblRegisterPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegisterPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/register-page.png"))); // NOI18N

        lblUserName.setText("User Name");
        lblUserName.setMaximumSize(new java.awt.Dimension(119, 29));
        lblUserName.setMinimumSize(new java.awt.Dimension(119, 29));
        lblUserName.setPreferredSize(new java.awt.Dimension(119, 29));
        lblUserName.setRequestFocusEnabled(false);

        lblPassword.setText("Password");
        lblPassword.setMaximumSize(new java.awt.Dimension(119, 29));
        lblPassword.setMinimumSize(new java.awt.Dimension(119, 29));
        lblPassword.setPreferredSize(new java.awt.Dimension(119, 29));

        lblConfirmPassword.setText("Confirm Password");
        lblConfirmPassword.setMaximumSize(new java.awt.Dimension(119, 29));
        lblConfirmPassword.setMinimumSize(new java.awt.Dimension(119, 29));
        lblConfirmPassword.setPreferredSize(new java.awt.Dimension(119, 29));

        lblFullName.setText("Full Name");
        lblFullName.setMaximumSize(new java.awt.Dimension(119, 29));
        lblFullName.setMinimumSize(new java.awt.Dimension(119, 29));
        lblFullName.setPreferredSize(new java.awt.Dimension(119, 29));

        lblSex.setText("Sex");
        lblSex.setMaximumSize(new java.awt.Dimension(119, 29));
        lblSex.setMinimumSize(new java.awt.Dimension(119, 29));
        lblSex.setPreferredSize(new java.awt.Dimension(119, 29));

        buttonGroup1.add(rdMale);

        Male.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Male.setIcon(new javax.swing.ImageIcon(getClass().getResource("/male.png"))); // NOI18N
        Male.setMaximumSize(new java.awt.Dimension(25, 25));
        Male.setMinimumSize(new java.awt.Dimension(25, 25));
        Male.setPreferredSize(new java.awt.Dimension(25, 25));

        buttonGroup1.add(rdFemale);
        rdFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdFemaleActionPerformed(evt);
            }
        });

        Female.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Female.setIcon(new javax.swing.ImageIcon(getClass().getResource("/female.png"))); // NOI18N
        Female.setMaximumSize(new java.awt.Dimension(25, 25));
        Female.setMinimumSize(new java.awt.Dimension(25, 25));
        Female.setPreferredSize(new java.awt.Dimension(25, 25));

        buttonGroup1.add(rdAnother);
        rdAnother.setText("Another");

        lblBirthday.setText("Birthday");
        lblBirthday.setMaximumSize(new java.awt.Dimension(119, 29));
        lblBirthday.setMinimumSize(new java.awt.Dimension(119, 29));
        lblBirthday.setPreferredSize(new java.awt.Dimension(119, 29));

        btnRegister.setBackground(new java.awt.Color(242, 242, 242));
        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/register.png"))); // NOI18N
        btnRegister.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(242, 242, 242));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back.png"))); // NOI18N
        btnBack.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblBirthday, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSex, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFullName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblUserName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblConfirmPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblRegisterPage)
                                .addGap(88, 88, 88))
                            .addComponent(DateChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtFullName, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                        .addComponent(txtUserName)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(rdMale)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Male, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(rdFemale)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Female, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(rdAnother))
                        .addComponent(pwPassword)
                        .addComponent(pwConfirm))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegister)
                        .addGap(119, 119, 119)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txterro, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRegisterPage)
                    .addComponent(txterro))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Female, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addComponent(rdMale, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Male, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdFemale, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(rdAnother, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegister))
                .addGap(175, 175, 175))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rdFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdFemaleActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        try {
            String password1 = String.copyValueOf(pwPassword.getPassword());
            String password2 = String.copyValueOf(pwConfirm.getPassword());
            int g = 0;
            if (txtUserName.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Please enter User Name");
                g = 1;
            } else if (password1.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Please enter Password");
                g = 1;
            } else if (!password2.equals(password1)) {
                JOptionPane.showMessageDialog(rootPane, "Please Confirm Password is not equal Password");
                g = 1;
            } else if (password2.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Please enter Confirm Password");
                g = 1;
            } else if ((!rdMale.isSelected() & !rdFemale.isSelected() & !rdAnother.isSelected())) {
                JOptionPane.showMessageDialog(rootPane, "Please selected sex");
                g = 1;
            } else if (txtFullName.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Please enter FullName");
                g = 1;
            } else if (DateChooser.getDate().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Please choose Date");
                g = 1;
            } else {
                g = 0;
            }
            if (g == 0) {

                txterro.setText("");
                int i = 0;
                user.setUserName(txtUserName.getText());
                user.setPassword(password1);
                user.setNickname(txtFullName.getText());
                if (rdMale.isSelected()) {
                    i = 0;
                } else if (rdFemale.isSelected()) {
                    i = 1;
                } else {
                    i = 2;
                }
                user.setSex(i);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String startDateString = dateFormat.format(DateChooser.getDate());
                user.setIsBlocked(0);
                String msg = "Register;" + user.getUserName() + ";" + user.getPassword() + ";" + user.getNickname() + ";" + user.getSex() + ";" + startDateString;
                byte[] encryptedMsg = client.cc.symmetricEncryption(msg);
                client.push(encryptedMsg);
            }
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        try {
            // TODO add your handling code here:
            register.setVisible(false);
            login = new Login();
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JLabel Female;
    private javax.swing.JLabel Male;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRegister;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBirthday;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRegisterPage;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPasswordField pwConfirm;
    private javax.swing.JPasswordField pwPassword;
    private javax.swing.JRadioButton rdAnother;
    private javax.swing.JRadioButton rdFemale;
    private javax.swing.JRadioButton rdMale;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JLabel txterro;
    // End of variables declaration//GEN-END:variables
}
