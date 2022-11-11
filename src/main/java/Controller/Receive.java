/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static Controller.Client.cc;
import GUI.CreateRoom;
import GUI.Game;
import GUI.HomePage;
import GUI.JoinRoom;
import GUI.ListRoom;
import GUI.WaitingRoom;
import GUI.Login;
import GUI.Rank;
import GUI.Register;
import Model.Grade;
import Model.User;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duyph
 */

public class Receive implements Runnable {

    private Socket socket;
    private DataInputStream is;
    private String data;
    public static Login login;
    public static CreateRoom createRoom;
    public static Game game;
    public static HomePage homePage;
    public static JoinRoom joinRoom;
    public static ListRoom lítRoom;
    public static WaitingRoom waitingRoom;
    public static Rank rank;
    public static Register register;
    public static User us;
    public static Grade gr;
    
    public Receive(Socket s, DataInputStream r) {
        try {
            this.socket = s;
            this.is = r;
            login = new Login();
            login.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Receive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        try {
            while (true) {
                data = decrypt();
                String[] parts = data.split(";");
                if (parts[0].equals("loginSuccess")) {
                    us = setUser(parts);
                    gr = setGrade(parts);
                    homePage = new HomePage();
                    login.setVisible(false);
                    homePage.setVisible(true);
                } else if (parts[0].equals("registerSuccess")){
                    login = new Login();
                    register.setVisible(false);
                    login.setVisible(true);
                } else if (parts[0].equals("createRoomSuccess")){
                    createRoom.setVisible(false);
                    waitingRoom = new WaitingRoom();
                    waitingRoom.setVisible(true);
                }              
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(Receive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String decrypt() throws IOException, Exception {
        int length = is.readInt();
        byte[] encryptedInput = new byte[0];
        if (length > 0) {
            encryptedInput = new byte[length];
            // read the message
            is.readFully(encryptedInput, 0, encryptedInput.length);
        }
        return cc.symmetricDecryption(encryptedInput);
    }

    private User setUser(String[] parts) throws ParseException {
        User us = new User();
        us.setUserId(Integer.parseInt(parts[1]));
        us.setUserName(parts[2]);
        us.setPassword(parts[3]);
        us.setNickname(parts[4]);
        us.setSex(Integer.parseInt(parts[5]));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(parts[6]);
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
        System.out.println(sql);
        us.setBirthday(sql);
        return us;
    }

    private Grade setGrade(String[] parts) {
        Grade gr = new Grade();
        gr.setUserId(Integer.parseInt(parts[7]));
        gr.setGrade(Integer.parseInt(parts[8]));
        gr.setWinMatch(Integer.parseInt(parts[9]));
        gr.setLoseMatch(Integer.parseInt(parts[10]));
        gr.setDrawMatch(Integer.parseInt(parts[11]));
        gr.setCurrentWinStreak(Integer.parseInt(parts[12]));
        gr.setMaxWinStreak(Integer.parseInt(parts[13]));
        gr.setCurrentLoseStreak(Integer.parseInt(parts[14]));
        gr.setMaxLoseStreak(Integer.parseInt(parts[15]));
        gr.setWinRate(Float.parseFloat(parts[16]));
        return gr;
    }
}
