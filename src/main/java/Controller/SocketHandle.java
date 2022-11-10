/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Crypto.ClientCryptography;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duyph
 */
public class SocketHandle {

    public static Socket socket;
    public static int port = 1234;
    public static String host = "localhost";
    public static DataInputStream in;
    public static DataOutputStream out;
    public static BufferedReader stdIn;
    public static boolean closed = false;
    public static ClientCryptography cc;

    public static void start() {
        try {
            socket = new Socket(host, port);
            in = new DataInputStream(new DataInputStream(socket.getInputStream()));
            out = new DataOutputStream(new DataOutputStream(socket.getOutputStream()));
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            cc = new ClientCryptography();
            // Read from server: byte[] publicKey
            // Read length of incoming message
            int length = in.readInt();
            byte[] key = new byte[0];
            if (length > 0) {
                key = new byte[length];
                // Read the message
                in.readFully(key, 0, key.length);
            }
            // Set public key and generate symmetric keys
            cc.setServersPublicKey(key);
            cc.generateSymmetricKeys();
            byte[] encryptedMsg = cc.createInitialMsg("Hello World!");
            out.writeInt(encryptedMsg.length);
            out.write(encryptedMsg);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(SocketHandle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SocketHandle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void process() throws IOException, Exception {

        while (true) {
            // Client nhận dữ liệu từ keyboard và gửi vào stream -> server
            System.out.println("Write something");
            byte[] msg = cc.createInitialMsg("hello");
            push(msg);
            // Client nhận phản hồi từ server
            // Read length of incoming message
            int length = in.readInt();
            byte[] encryptedInput = new byte[0];
            if (length > 0) {
                encryptedInput = new byte[length];
                // Read the message
                in.readFully(encryptedInput, 0, encryptedInput.length);
            }
            // Read from server: byte[] encryptedInput;
            String decrytpedInput = cc.symmetricDecryption(encryptedInput);
            System.out.println("Client received: " + decrytpedInput);
        }
    }

    public static void close() {
        try {
            socket.close();
            in.close();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketHandle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void push(byte[] encryptedMsg) {
        try {
            out.writeInt(encryptedMsg.length);
            out.write(encryptedMsg);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(SocketHandle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            start();
            process();
            close();
        } catch (Exception ex) {
            Logger.getLogger(SocketHandle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (socket != null) {
                socket.close();
                System.out.println("Client socket closed");
            }
        }
    }
}
