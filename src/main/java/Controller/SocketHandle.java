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

    private static Socket socket = null;
    private static int port = 1234;
    private static String host = "localhost";
//    private static DataInputStream in = null;
//    private static DataOutputStream out = null;
//    private static BufferedReader stdIn = null;
//    private static ClientCryptography cc = null;

//    public static void start() throws IOException, Exception {
//        socket = new Socket(host, port);
//        in = new DataInputStream(new DataInputStream(socket.getInputStream()));
//        out = new DataOutputStream(new DataOutputStream(socket.getOutputStream()));
//        stdIn = new BufferedReader(new InputStreamReader(System.in));
//        cc = new ClientCryptography();
//        // read length of incoming message
//        int length = in.readInt();
//        byte[] key = new byte[0];
//        if (length > 0) {
//            key = new byte[length];
//            // read the message
//            in.readFully(key, 0, key.length);
//        }
//
//        cc.setServersPublicKey(key);
//        cc.generateSymmetricKeys();
//    }
//
//    public static void process() throws Exception {
//        while (true) {
//            // Client nhận dữ liệu từ keyboard và gửi vào stream -> server
//            System.out.print("Client input: ");
//            String line = stdIn.readLine();
//
//            byte[] encryptedMsg = cc.createInitialMsg(line);
//            push(encryptedMsg);
//            if (line.equals("bye")) {
//                break;
//            }
//            // Client nhận phản hồi từ server
//            int length = in.readInt();                    // read length of incoming message
//            byte[] msg = new byte[0];
//            if (length > 0) {
//                msg = new byte[length];
//                in.readFully(msg, 0, msg.length); // read the message
//            }
//            //Read from client: byte[] encryptedMsg
//            String decrytpedInput = cc.symmetricDecryption(msg);
//            System.out.println("Client received: " + decrytpedInput);
//        }
//    }

//    public static void push(byte[] msg) throws IOException {
//        out.writeInt(msg.length);
//        out.write(msg);
//        out.flush();
//    }

    public static void main(String[] args) throws IOException {
        try {
            socket = new Socket(host, port);
            DataInputStream in = new DataInputStream(new DataInputStream(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(new DataOutputStream(socket.getOutputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            ClientCryptography cc = new ClientCryptography();
            // read length of incoming message
            int length = in.readInt();
            byte[] key = new byte[0];
            if (length > 0) {
                key = new byte[length];
                // read the message
                in.readFully(key, 0, key.length);
            }

            cc.setServersPublicKey(key);
            cc.generateSymmetricKeys();

            while (true) {
                // Client nhận dữ liệu từ keyboard và gửi vào stream -> server
                System.out.print("Client input: ");
                String line = stdIn.readLine();

                byte[] encryptedMsg = cc.createInitialMsg(line);
                out.writeInt(encryptedMsg.length);
                out.write(encryptedMsg);
                out.flush();
                if (line.equals("bye")) {
                    break;
                }
                // Client nhận phản hồi từ server
                length = in.readInt();                    // read length of incoming message
                byte[] msg = new byte[0];
                if (length > 0) {
                    msg = new byte[length];
                    in.readFully(msg, 0, msg.length); // read the message
                }
                //Read from client: byte[] encryptedMsg
                String decrytpedInput = cc.symmetricDecryption(msg);
                System.out.println("Client received: " + decrytpedInput);
            }
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
