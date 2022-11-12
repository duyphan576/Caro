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
import java.util.ArrayList;
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
    public static ArrayList<Grade> listRank = new ArrayList<>();
    public static ArrayList<User> listUser = new ArrayList<>();

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

    @Override
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
                } else if (parts[0].equals("rankSuccess")) {
                    listRank = setRank(parts);
                    rank = new Rank();
                    rank.setVisible(true);
                } else if (parts[0].equals("registerSuccess")) {
                    login = new Login();
                    register.setVisible(false);
                    login.setVisible(true);
                } else if (parts[0].equals("createRoomSuccess")) {
                    createRoom.setVisible(false);
                    waitingRoom = new WaitingRoom();
                    waitingRoom.setVisible(true);
                } else if (parts[0].equals("userStatusSuccess")) {
                    listUser = setUserStatus(parts);
                    homePage.setUserStatus(listUser);
                } else if (parts[0].equals("broadcastSuccess")) {
                    if (homePage.isShowing()) {
                        homePage.addMessage(parts[1]);
                    }
                } else if (parts[0].equals("Exit")) {
                    break;
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
        User user = new User();
        user.setUserId(Integer.parseInt(parts[1]));
        user.setUserName(parts[2]);
        user.setPassword(parts[3]);
        user.setNickname(parts[4]);
        user.setSex(Integer.parseInt(parts[5]));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(parts[6]);
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
        user.setBirthday(sql);
        return user;
    }

    private Grade setGrade(String[] parts) {
        Grade grade = new Grade();
        grade.setUserId(Integer.parseInt(parts[7]));
        grade.setGrade(Integer.parseInt(parts[8]));
        grade.setWinMatch(Integer.parseInt(parts[9]));
        grade.setLoseMatch(Integer.parseInt(parts[10]));
        grade.setDrawMatch(Integer.parseInt(parts[11]));
        grade.setCurrentWinStreak(Integer.parseInt(parts[12]));
        grade.setMaxWinStreak(Integer.parseInt(parts[13]));
        grade.setCurrentLoseStreak(Integer.parseInt(parts[14]));
        grade.setMaxLoseStreak(Integer.parseInt(parts[15]));
        grade.setWinRate(Float.parseFloat(parts[16]));
        return grade;
    }

    private ArrayList setRank(String[] part) {
        int length = (part.length - 1) / 10;
        int count = 1;
        ArrayList<Grade> l = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Grade grade = new Grade();
            grade.setUserId(Integer.parseInt(part[count++]));
            grade.setGrade(Integer.parseInt(part[count++]));
            grade.setWinMatch(Integer.parseInt(part[count++]));
            grade.setLoseMatch(Integer.parseInt(part[count++]));
            grade.setDrawMatch(Integer.parseInt(part[count++]));
            grade.setCurrentWinStreak(Integer.parseInt(part[count++]));
            grade.setCurrentLoseStreak(Integer.parseInt(part[count++]));
            grade.setMaxWinStreak(Integer.parseInt(part[count++]));
            grade.setMaxLoseStreak(Integer.parseInt(part[count++]));
            grade.setWinRate(Float.valueOf(part[count++]));
            l.add(grade);
        }
        return l;
    }

    private ArrayList setUserStatus(String[] part) {
        int temp = Integer.parseInt(part[1].trim());
        int count = 2;
        ArrayList<User> l = new ArrayList<>();
        for (int i = 0; i < temp; i++) {
            User user = new User();
            user.setNickname(part[count++]);
            user.setStatus(Integer.parseInt(part[count++]));
            l.add(user);
        }
        return l;
    }
}
