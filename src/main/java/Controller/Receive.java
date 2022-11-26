/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static Controller.Client.cc;
import GUI.ChangeInfo;
import GUI.ChangePassword;
import GUI.CreateRoom;
import GUI.FindRoom;
import GUI.Game;
import GUI.HomePage;
import GUI.JoinRoom;
import GUI.ListRoom;
import GUI.WaitingRoom;
import GUI.Login;
import GUI.Rank;
import GUI.Register;
import GUI.Setting;
import Model.Grade;
import Model.User;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    public static ListRoom listRoom;
    public static WaitingRoom waitingRoom;
    public static Rank rank;
    public static Register register;
    public static FindRoom findRoom;
    public static Setting setting;
    public static ChangeInfo changeInfo;
    public static ChangePassword changePassword;
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
                System.out.println(data);
                String[] parts = data.split(";");
                if (parts[0].equals("Login")) {
                    us = setUser(0, parts);
                    gr = setGrade(parts);
                    homePage = new HomePage();
                    login.dispose();
                    homePage.setVisible(true);
                } else if (parts[0].equals("Rank")) {
                    listRank = setRank(parts);
                    rank = new Rank();
                    rank.setVisible(true);
                } else if (parts[0].equals("Register")) {
                    login = new Login();
                    register.dispose();
                    login.setVisible(true);
                } else if (parts[0].equals("CreateRoom")) {
                    if (parts.length == 2) {
                        waitingRoom = new WaitingRoom();
                        waitingRoom.setVisible(true);
                        waitingRoom.setRoomName(parts[1]);
                    } else {
                        createRoom.dispose();
                        waitingRoom = new WaitingRoom();
                        waitingRoom.setVisible(true);
                        waitingRoom.setRoomName(parts[1]);
                        waitingRoom.setRoomPassword(parts[2]);
                    }
                } else if (parts[0].equals("UserStatus")) {
                    if (homePage != null) {
                        listUser = setUserStatus(parts);
                        homePage.setUserStatus(listUser);
                    }
                } else if (parts[0].equals("Broadcast")) {
                    if (homePage.isShowing()) {
                        homePage.addMessage(parts[1]);
                    }
                } else if (parts[0].equals("ViewListRoom")) {
                    Vector<String> rooms = new Vector<>();
                    Vector<String> passwords = new Vector<>();
                    for (int i = 1; i < parts.length; i = i + 2) {
                        rooms.add("Room " + parts[i]);
                        passwords.add(parts[i + 1]);
                    }
                    listRoom.updateRoomList(rooms, passwords);
                } else if (parts[0].equals("GoToRoom")) {

                    int roomID = Integer.parseInt(parts[1]);
                    String competitorIP = parts[2];
                    int isStart = Integer.parseInt(parts[3]);
                    User competitor = setUser(3, parts);
                    if (findRoom != null) {
                        findRoom.showFindedRoom();
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ex) {
                            JOptionPane.showMessageDialog(findRoom, "Error while sleep thread");
                        }
                    } else if (!(waitingRoom == null)) {
                        waitingRoom.showFindedCompetitor();
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ex) {
                            JOptionPane.showMessageDialog(waitingRoom, "Error while sleep thread");
                        }
                    }
                    System.out.println(data);
                    closeAllViews();
                    game = new Game(competitor, roomID, isStart, competitorIP);
                    game.setVisible(true);
                    game.newGame();
                } else if (parts[0].equals("Caro")) {
                    game.addCompetitorMove(parts[1], parts[2], true);
                } else if (parts[0].equals("Lose")) {
                    game.addCompetitorMove(parts[1], parts[2], false);
                } else if (parts[0].equals("DrawRequest")) {
                    game.showDrawRequest();
                } else if (parts[0].equals("DrawConfirm")) {
                    closeAllViews();
                    homePage = new HomePage();
                    homePage.setVisible(true);
                } else if (parts[0].equals("DrawRefuse")) {
                    game.displayDrawRefuse();
                } else if (parts[0].equals("SurrenderRequest")) {
                    closeAllViews();
                    homePage = new HomePage();
                    homePage.setVisible(true);
                } else if (parts[0].equals("WinRequest")) {
                    if (parts[1].equals("1")) {
                        game.showWinRequest();
                    }
                } else if (parts[0].equals("ChangePassword")) {
                    changePassword.showMessage(parts[1]);
                } else if (parts[0].equals("ChangeInfo")) {
                    changeInfo.showMessage(parts[1]);
                } else if (parts[0].equals("AgainConfirm1")) {
                    game.showWinRequest1();
                } else if (parts[0].equals("AgainRefuse")) {
                    closeAllViews();
                    homePage = new HomePage();
                    homePage.setVisible(true);
                } else if (parts[0].equals("AgainConfirm")) {
                    game.setVisible(true);
                    game.newGame();
                } else if (parts[0].equals("Chat")) {
                    game.addMessage(parts[1]);
                } else if (parts[0].equals("SurrenderConfirm")) {
                    closeAllViews();
                    homePage = new HomePage();
                    homePage.setVisible(true);
                } else if (parts[0].equals("GetInfo")) {
                    us = setUser(0, parts);
                    gr = setGrade(parts);
                    homePage.setInfo();
                } else if (parts[0].equals("Error")) {
                    showMessage(parts[1]);
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

    private User setUser(int start, String[] parts) throws ParseException {
        User user = new User();
        user.setUserId(Integer.parseInt(parts[start + 1]));
        user.setUserName(parts[start + 2]);
        user.setPassword(parts[start + 3]);
        user.setNickname(parts[start + 4]);
        user.setSex(Integer.parseInt(parts[start + 5]));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(parts[start + 6]);
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

    public static void closeAllViews() {
        if (login != null) {
            login.dispose();
        }
        if (register != null) {
            register.dispose();
        }
        if (homePage != null) {
            homePage.dispose();
        }
        if (listRoom != null) {
            listRoom.dispose();
        }
        if (rank != null) {
            rank.dispose();
        }
        if (findRoom != null) {
            findRoom.stopAllThread();
            findRoom.dispose();
        }
        if (waitingRoom != null) {
            waitingRoom.dispose();
        }
        if (game != null) {
            game.stopAllThread();
            game.dispose();
        }
        if (createRoom != null) {
            createRoom.dispose();
        }
        if (joinRoom != null) {
            joinRoom.dispose();
        }
        if (rank != null) {
            rank.dispose();
        }
    }

    public void showMessage(String message) {
        if (login != null) {
            JOptionPane.showMessageDialog(login, message);
        }
        if (register != null) {
            JOptionPane.showMessageDialog(register, message);
        }
        if (homePage != null) {
            JOptionPane.showMessageDialog(homePage, message);
        }
        if (listRoom != null) {
            JOptionPane.showMessageDialog(listRoom, message);
        }
        if (rank != null) {
            JOptionPane.showMessageDialog(rank, message);
        }
        if (findRoom != null) {
            JOptionPane.showMessageDialog(findRoom, message);
        }
        if (waitingRoom != null) {
            JOptionPane.showMessageDialog(waitingRoom, message);
        }
        if (game != null) {
            JOptionPane.showMessageDialog(game, message);
        }
        if (createRoom != null) {
            JOptionPane.showMessageDialog(createRoom, message);
        }
        if (joinRoom != null) {
            JOptionPane.showMessageDialog(joinRoom, message);
        }
        if (rank != null) {
            JOptionPane.showMessageDialog(rank, message);
        }
    }
}
