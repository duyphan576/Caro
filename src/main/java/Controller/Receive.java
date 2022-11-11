/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static Controller.Client.cc;
import static Controller.Client.login;
import GUI.HomePage;
import GUI.Rank;
import Model.Grade;
import Model.User;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.TextArea;

/**
 *
 * @author duyph
 */
class Receive implements Runnable {
    private String msghomepage="";
    private Socket socket;
    private DataInputStream is;
    public static String data;
    public String mesdata="";
    private HomePage h;
    private ArrayList<Grade> listrank = new ArrayList<>();
    public Receive(Socket s, DataInputStream r) {
        try {
            this.socket = s;
            this.is = r;

        } catch (Exception ex) {
            Logger.getLogger(Receive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        try {
            while (true) {
                data = decrypt();
                String[] parts = data.split(";");
                if (parts[0].equals("Login")) {
                    System.out.println("Client received: " + data);
                    User us = setUser(parts);
                    Grade gr = setGrade(parts);
                    h = new HomePage(us, gr);
                    login.setVisible(false);
                    h.setVisible(true);
                }else if(parts[0].equals("Rank")){
                    System.out.println("Client received: " + data);
                    ArrayList<Grade> l = setRank(parts);
                    Rank r = new Rank(l);
                    r.setVisible(true);
                }else if (parts[0].equals("Chathomepage")){
                    mesdata+="\n"+parts[1]; 
                    h.areachatbox(mesdata);
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
    private ArrayList setRank(String[] part){
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
            listrank.add(gr);
        }
        return listrank;
    }
}
