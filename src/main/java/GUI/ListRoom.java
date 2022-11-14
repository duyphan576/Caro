/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import static Controller.Main.client;
import static Controller.Receive.joinRoom;
import static Controller.Receive.listRoom;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jukut
 */
public class ListRoom extends javax.swing.JFrame {

    /**
     * Creates new form ListRoom
     */
    private Vector<String> Room;
    private Vector<String> Password;
    private Thread thread;
    private boolean isPlayThread;
    private boolean isFiltered;
    DefaultTableModel defaultTableModel;

    public ListRoom() {
        initComponents();
        defaultTableModel = (DefaultTableModel) tblRoom.getModel();
        isPlayThread = true;
        isFiltered = false;
        thread = new Thread() {
            @Override
            public void run() {
                while (listRoom.isDisplayable() && isPlayThread && !isFiltered) {
                    try {
                        String msg = "viewListRoom;";
                        byte[] encryptedMsg = client.cc.symmetricEncryption(msg);
                        client.push(encryptedMsg);
                        Thread.sleep(500);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                    }
                }
            }
        };
        thread.start();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Object[][] rows = { }; String[] columns = {"Room",""}; DefaultTableModel model = new DefaultTableModel(rows, columns){     @Override     public Class<?> getColumnClass(int column){         switch(column){             case 0: return String.class;             case 1: return ImageIcon.class;             default: return Object.class;         }     } };
        tblRoom = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("List Room");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backnho.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                .addContainerGap())
        );

        tblRoom.setModel(model);
        tblRoom.getTableHeader().setReorderingAllowed(false);
        tblRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRoomMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRoom);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRoomMouseClicked
        // TODO add your handling code here:
        if (tblRoom.getSelectedRow() == -1) {
        } else {
            try {
                isPlayThread = false;
                int index = tblRoom.getSelectedRow();
                int room = Integer.parseInt(Room.get(index).split(" ")[1]);
                String password = Password.get(index);
                String msg = "joinRoom;";
                if (password.equals(" ")) {
                    byte[] encryptedMsg = client.cc.symmetricEncryption(msg);
                    client.push(encryptedMsg);
                    listRoom.setVisible(false);
                } else {
                    listRoom.setVisible(false);
                    joinRoom = new JoinRoom();
                    joinRoom.setVisible(true);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
    }//GEN-LAST:event_tblRoomMouseClicked

    public void updateRoomList(Vector<String> room, Vector<String> password) {
        this.Room = room;
        this.Password = password;
        defaultTableModel.setRowCount(0);
        ImageIcon imageIcon;
        for (int i = 0; i < Room.size(); i++) {
            if (Password.get(i).equals(" ")) {
                imageIcon = new ImageIcon(getClass().getResource("/swords-1-mini.png"));
            } else {
                imageIcon = new ImageIcon(getClass().getResource("/swords-1-lock-mini.png"));
            }
            defaultTableModel.addRow(new Object[]{
                Room.get(i),
                ""
            });
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRoom;
    // End of variables declaration//GEN-END:variables
}
