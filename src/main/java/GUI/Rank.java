/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import static GUI.Login.client;
import Model.Grade;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jukut
 */
public class Rank extends javax.swing.JFrame {

    private DefaultTableModel model;
    private DefaultTableModel model1;
    private ArrayList<Grade> list = new ArrayList<>();
    private ArrayList<Grade> list1 = new ArrayList<>();

    /**
     * Creates new form Rank
     */
    public Rank() throws Exception {
        initComponents();
        this.setLocationRelativeTo(null);
        String msg = "Rank";
        byte[] encryptedMsg = client.cc.symmetricEncryption(msg);
        client.push(encryptedMsg);
        // Read length of incoming message
        int length = client.in.readInt();
        byte[] encryptedInput = new byte[0];
        if (length > 0) {
            encryptedInput = new byte[length];
            // Read the message
            client.in.readFully(encryptedInput, 0, encryptedInput.length);
        }
        String decrytpedInput = client.cc.symmetricDecryption(encryptedInput);
        System.out.println(decrytpedInput);
        String[] part = decrytpedInput.split(";");
        int temp = (part.length - 1) / 10;
        int count = 1;
        for (int i = 0; i < temp; i++) {
            Grade gr = new Grade();
            gr.setUserId(Integer.parseInt(part[count++]));
            gr.setGrade(Integer.parseInt(part[count++]));
            gr.setWinMatch(Integer.parseInt(part[count++]));
            gr.setLoseMatch(Integer.parseInt(part[count++]));
            gr.setDrawMatch(Integer.parseInt(part[count++]));
            gr.setCurrentWinStreak(Integer.parseInt(part[count++]));
            gr.setCurrentLoseStreak(Integer.parseInt(part[count++]));
            gr.setMaxWinStreak(Integer.parseInt(part[count++]));
            gr.setMaxLoseStreak(Integer.parseInt(part[count++]));
            gr.setWinRate(Float.valueOf(part[count++]));
            list.add(gr);
        }
        model = (DefaultTableModel) tblrankponint.getModel();
        model1 = (DefaultTableModel) tblrankrate.getModel();
        showTable();
        list1 = list;
        Collections.sort(list1);
        showTable1();
    }

    public void showTable() {
        model.setRowCount(0);
        int i = 0;
        for (Grade gr : list) {
            model.addRow(new Object[]{
                i += 1, gr.getUserId(), gr.getGrade()
            });
        }
    }

    public void showTable1() {

        model1.setRowCount(0);
        int i = 0;
        for (Grade gr : list1) {
            model1.addRow(new Object[]{
                i += 1, gr.getUserId(), gr.getWinMatch() + gr.getLoseMatch() + gr.getDrawMatch(), gr.getWinMatch(), gr.getMaxWinStreak(), gr.getWinRate()
            });
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblrankponint = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblrankrate = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        Rank = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblrankponint.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "#", "User Name", "Grade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblrankponint);

        jTabbedPane1.addTab("Point", jScrollPane1);

        tblrankrate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "#", "User Name", "Match", "Win Match", "Max Win Streak", "Win Rate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblrankrate);

        jTabbedPane1.addTab("Win Rate", jScrollPane3);

        Rank.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Rank.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Rank.setIcon(new javax.swing.ImageIcon(getClass().getResource("/championship.png"))); // NOI18N
        Rank.setText("Rank");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Rank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Rank, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Rank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Rank().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Rank.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Rank;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblrankponint;
    private javax.swing.JTable tblrankrate;
    // End of variables declaration//GEN-END:variables
}
