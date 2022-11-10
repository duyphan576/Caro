/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Controller.SocketHandle;
import Model.Grade;
import Model.User;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jukut
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     *
     * @param us
     */
    private User user;
    private Grade grade;
    private DefaultTableModel model;
    private int iduser;
    public HomePage(User us, Grade gr) throws Exception {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            this.user = us;
            iduser=us.getUserId();
            this.grade = gr;
            initComponents();
            setInfo();
            setFriendOnl();
        } catch (UnsupportedLookAndFeelException ex) {
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

        JPanel1 = new javax.swing.JPanel();
        JPanel2 = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblGrade = new javax.swing.JLabel();
        Profile = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblSex = new javax.swing.JLabel();
        lblBirthday = new javax.swing.JLabel();
        lblProfile = new javax.swing.JLabel();
        lblMatch = new javax.swing.JLabel();
        lblWinMatch = new javax.swing.JLabel();
        lblWinRate = new javax.swing.JLabel();
        lblLoseMatch = new javax.swing.JLabel();
        lblMaxWinStreak = new javax.swing.JLabel();
        lblMaxLoseStreak = new javax.swing.JLabel();
        lblCurrentWinStreak = new javax.swing.JLabel();
        lblCurrentLoseStreak = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JPanel3 = new javax.swing.JPanel();
        lblGameName = new javax.swing.JLabel();
        btnPlayNow = new javax.swing.JButton();
        btnNewRoom = new javax.swing.JButton();
        btnListRoom = new javax.swing.JButton();
        btnRank = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        JPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaChatBox = new javax.swing.JTextArea();
        txtMessage = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblOnlineUser = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOnlineUser = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        JPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        JPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblID.setText("ID:");

        lblUserName.setText("User Name:");

        lblGrade.setText("Grade :");

        Profile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblName.setText("Name:");

        lblSex.setText("Sex:");

        lblBirthday.setText("Birthday:");

        lblProfile.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblProfile.setForeground(new java.awt.Color(0, 204, 255));
        lblProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/resume.png"))); // NOI18N

        lblMatch.setText("Match:");

        lblWinMatch.setText("Win Match :");

        lblWinRate.setText("Win Rate:");

        lblLoseMatch.setText("Lose Match:");

        lblMaxWinStreak.setText("Max Win Streak:");

        lblMaxLoseStreak.setText("Max Lose Streak:");

        lblCurrentWinStreak.setText("Current Win Streak:");

        lblCurrentLoseStreak.setText("Current Lose Streak:");

        javax.swing.GroupLayout ProfileLayout = new javax.swing.GroupLayout(Profile);
        Profile.setLayout(ProfileLayout);
        ProfileLayout.setHorizontalGroup(
            ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfileLayout.createSequentialGroup()
                        .addComponent(lblMatch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblWinRate, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCurrentWinStreak, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                    .addComponent(lblCurrentLoseStreak, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                    .addComponent(lblMaxLoseStreak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMaxWinStreak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfileLayout.createSequentialGroup()
                        .addComponent(lblWinMatch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLoseMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        ProfileLayout.setVerticalGroup(
            ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSex, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWinRate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLoseMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWinMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMaxWinStreak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMaxLoseStreak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCurrentWinStreak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCurrentLoseStreak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user.png"))); // NOI18N

        javax.swing.GroupLayout JPanel2Layout = new javax.swing.GroupLayout(JPanel2);
        JPanel2.setLayout(JPanel2Layout);
        JPanel2Layout.setHorizontalGroup(
            JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGrade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(Profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JPanel2Layout.setVerticalGroup(
            JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JPanel2Layout.createSequentialGroup()
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lblGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addComponent(Profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        JPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblGameName.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblGameName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGameName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tic-tac-toe.png"))); // NOI18N

        btnPlayNow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/match.png"))); // NOI18N
        btnPlayNow.setText("Play Now");

        btnNewRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button.png"))); // NOI18N
        btnNewRoom.setText("New Room");

        btnListRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/waiting-room.png"))); // NOI18N
        btnListRoom.setText("List Room");

        btnRank.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/medal.png"))); // NOI18N
        btnRank.setText("Rank");

        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/log-out.png"))); // NOI18N
        btnLogOut.setText("Log Out");

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/exit.png"))); // NOI18N
        btnExit.setText("Exit");

        javax.swing.GroupLayout JPanel3Layout = new javax.swing.GroupLayout(JPanel3);
        JPanel3.setLayout(JPanel3Layout);
        JPanel3Layout.setHorizontalGroup(
            JPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPlayNow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNewRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JPanel3Layout.createSequentialGroup()
                        .addComponent(lblGameName, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JPanel3Layout.setVerticalGroup(
            JPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblGameName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnPlayNow)
                .addGap(18, 18, 18)
                .addComponent(btnNewRoom)
                .addGap(18, 18, 18)
                .addComponent(btnListRoom)
                .addGap(18, 18, 18)
                .addComponent(btnRank)
                .addGap(18, 18, 18)
                .addComponent(btnLogOut)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        JPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        areaChatBox.setColumns(20);
        areaChatBox.setRows(5);
        jScrollPane1.setViewportView(areaChatBox);

        btnSend.setBackground(new java.awt.Color(242, 242, 242));
        btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/share.png"))); // NOI18N
        btnSend.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout JPanel4Layout = new javax.swing.GroupLayout(JPanel4);
        JPanel4.setLayout(JPanel4Layout);
        JPanel4Layout.setHorizontalGroup(
            JPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(JPanel4Layout.createSequentialGroup()
                        .addComponent(txtMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSend))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        JPanel4Layout.setVerticalGroup(
            JPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMessage))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblOnlineUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOnlineUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user-list.png"))); // NOI18N

        tblOnlineUser.setAutoCreateRowSorter(true);
        tblOnlineUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblOnlineUser);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOnlineUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblOnlineUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout JPanel1Layout = new javax.swing.GroupLayout(JPanel1);
        JPanel1.setLayout(JPanel1Layout);
        JPanel1Layout.setHorizontalGroup(
            JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202))
        );
        JPanel1Layout.setVerticalGroup(
            JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void setInfo() {
        lblID.setText(lblID.getText() + " " + Integer.toString(user.getUserId()));
        lblUserName.setText(lblUserName.getText() + " " + user.getUserName());
        lblGrade.setText(lblGrade.getText() + " " + Integer.toString(grade.getGrade()));
        lblName.setText(lblName.getText() + " " + user.getNickname());
        switch (user.getSex()) {
            case 0:
                lblSex.setText(lblSex.getText() + " Male");
                break;
            case 1:
                lblSex.setText(lblSex.getText() + " Female");
                break;
            default:
                lblSex.setText(lblSex.getText() + " Unknown");
                break;
        }
        lblBirthday.setText(lblBirthday.getText() + " " + user.getBirthday().toString());
        lblMatch.setText(lblMatch.getText() + " " + Integer.toString((grade.getWinMatch() + grade.getLoseMatch() + grade.getDrawMatch())));
        lblWinRate.setText(lblWinRate.getText() + " " + grade.getWinRate() + "%");
        lblWinMatch.setText(lblWinMatch.getText() + " " + Integer.toString(grade.getWinMatch()));
        lblLoseMatch.setText(lblLoseMatch.getText() + " " + Integer.toString(grade.getLoseMatch()));
        lblCurrentWinStreak.setText(lblCurrentWinStreak.getText() + " " + Integer.toString(grade.getCurrentWinStreak()));
        lblCurrentLoseStreak.setText(lblCurrentLoseStreak.getText() + " " + Integer.toString(grade.getCurrentLoseStreak()));
        lblMaxWinStreak.setText(lblMaxWinStreak.getText() + " " + Integer.toString(grade.getMaxWinStreak()));
        lblMaxLoseStreak.setText(lblMaxLoseStreak.getText() + " " + Integer.toString(grade.getMaxLoseStreak()));

    }
    //thieu loai tru chinh minh trong danh sach friend
    private void setFriendOnl() throws Exception {
        String msg = "FriendOnl";
        byte[] encryptedMsg = SocketHandle.cc.createInitialMsg(msg);
        SocketHandle.push(encryptedMsg);
        // Read length of incoming message
        int length = SocketHandle.in.readInt();
        byte[] encryptedInput = new byte[0];
        if (length > 0) {
            encryptedInput = new byte[length];
            // Read the message
            SocketHandle.in.readFully(encryptedInput, 0, encryptedInput.length);
        }
        String decrytpedInput = SocketHandle.cc.symmetricDecryption(encryptedInput);
        String[] part = decrytpedInput.split(";");
        int temp = Integer.parseInt(part[0].trim());
        int count = 1;
        ArrayList<User> l = new ArrayList();
        for (int i = 0; i < temp; i++) {
            User us = new User();
            us.setNickname(part[count++]);
            us.setStatus(Integer.parseInt(part[count++]));
            l.add(us);
        }
        model = (DefaultTableModel) tblOnlineUser.getModel();
        model.setRowCount(0);
        int i = 0;
        for (User u : l) {
            String te = "";
            if (u.getStatus() == 1) {
                te = "Online";
            } else {
                te = "Ofline";
            }
            if(!(u.getUserId()==iduser)){
                model.addRow(new Object[]{
                u.getNickname(), te
            });
            }
        }
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel1;
    private javax.swing.JPanel JPanel2;
    private javax.swing.JPanel JPanel3;
    private javax.swing.JPanel JPanel4;
    private javax.swing.JPanel Profile;
    private javax.swing.JTextArea areaChatBox;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnListRoom;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnNewRoom;
    private javax.swing.JButton btnPlayNow;
    private javax.swing.JButton btnRank;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBirthday;
    private javax.swing.JLabel lblCurrentLoseStreak;
    private javax.swing.JLabel lblCurrentWinStreak;
    private javax.swing.JLabel lblGameName;
    private javax.swing.JLabel lblGrade;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLoseMatch;
    private javax.swing.JLabel lblMatch;
    private javax.swing.JLabel lblMaxLoseStreak;
    private javax.swing.JLabel lblMaxWinStreak;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOnlineUser;
    private javax.swing.JLabel lblProfile;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblWinMatch;
    private javax.swing.JLabel lblWinRate;
    private javax.swing.JTable tblOnlineUser;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables
}
