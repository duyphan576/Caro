/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import static Controller.Main.client;
import static Controller.Receive.findRoom;
import static Controller.Receive.homePage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author duyph
 */
public class FindRoom extends javax.swing.JFrame {

    /**
     * Creates new form FindRoom
     */
    private Timer timer;
    private boolean isFinded;

    public FindRoom() {
        initComponents();
        pcb.setValue(70);
        isFinded = false;
        startFind();
        sendFindRequest();
    }

    public void stopAllThread() {
        timer.stop();
    }

    public void startFind() {
        timer = new Timer(1000, new ActionListener() {
            int count = 20;

            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                if (count >= 0) {
                    if (count >= 10) {
                        lblTime.setText("00:" + count);
                    } else {
                        lblTime.setText("00:0" + count);
                    }
                    pcb.setValue(Math.round((float) count / 20 * 100));
                } else {
                    ((Timer) (e.getSource())).stop();
                    try {
                        String msg = "Cancel;";
                        byte[] encryptedMsg = client.cc.symmetricEncryption(msg);
                        client.push(encryptedMsg);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                    }
                    int res = JOptionPane.showConfirmDialog(rootPane, "Tìm kiếm thất bại, bạn muốn thử lại lần nữa chứ?");
                    if (res == JOptionPane.YES_OPTION) {
                        startFind();
                        sendFindRequest();
                    } else {
                        //Có thể hỏi chơi với máy không
                        findRoom.setVisible(false);
                        homePage.setVisible(true);
                    }
                }
            }
        });
        timer.setInitialDelay(0);
        timer.start();
    }

    public void sendFindRequest() {
        try {
            String msg = "playNow;";
            byte[] encryptedMsg = client.cc.symmetricEncryption(msg);
            client.push(encryptedMsg);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

    public void showFindedRoom() {
        isFinded = true;
        timer.stop();
        lblText.setText("Found another player, joining the room");
        lblTime.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLoading = new javax.swing.JLabel();
        lblText = new javax.swing.JLabel();
        pcb = new javax.swing.JProgressBar();
        lblTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLoading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loading.gif"))); // NOI18N

        lblText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText.setText("Finding orther player");

        lblTime.setText("00:20");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pcb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addComponent(lblLoading, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTime)
                .addGap(211, 211, 211))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(lblTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pcb, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLoading)
                .addGap(18, 18, 18)
                .addComponent(lblText)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLoading;
    private javax.swing.JLabel lblText;
    private javax.swing.JLabel lblTime;
    private javax.swing.JProgressBar pcb;
    // End of variables declaration//GEN-END:variables
}
