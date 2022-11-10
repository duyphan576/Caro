/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static Controller.Client.cc;
import Crypto.ClientCryptography;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duyph
 */
class Receive implements Runnable {

    private Socket socket;
    private DataInputStream is;

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
                String data = decrypt();
                System.out.println("Received: " + data);
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
}

public class Client {

    public static Socket socket;
    public static int port = 1234;
    public static String host = "localhost";
    public static DataInputStream in;
    public static DataOutputStream out;
    public static BufferedReader stdIn;
    public static boolean closed = false;
    public static ClientCryptography cc;

    public Client() {
        try {
            socket = new Socket(host, port);
            System.out.println("Client connected");
            out = new DataOutputStream(new DataOutputStream(socket.getOutputStream()));
            in = new DataInputStream(new DataInputStream(socket.getInputStream()));
            cc = new ClientCryptography();
            int length = in.readInt();
            byte[] encryptedInput = new byte[0];
            if (length > 0) {
                encryptedInput = new byte[length];
                // read the message
                in.readFully(encryptedInput, 0, encryptedInput.length);
            }
            cc.setServersPublicKey(encryptedInput);
            cc.generateSymmetricKeys();
            byte[] encryptedMsg = cc.createInitialMsg("Hello World!");
            out.writeInt(encryptedMsg.length);
            out.write(encryptedMsg);
            out.flush();
//            Receive recv = new Receive(socket, in);
//            ExecutorService excutor = Executors.newCachedThreadPool();
//            excutor.execute(recv);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void push(byte[] encryptedMsg) {
        try {
            out.writeInt(encryptedMsg.length);
            out.write(encryptedMsg);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static byte[] encrypt(String msg) throws Exception {
        return cc.symmetricEncryption(msg);
    }

}
