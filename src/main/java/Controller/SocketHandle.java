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

    private static Socket socket;
    private static int port = 1234;
    private static String host = "localhost";
    private static DataInputStream in;
    private static DataOutputStream out;
    private static BufferedReader stdIn;
    private static ClientCryptography cc;

    public static void start() throws IOException, Exception {
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
    }

    public static void process() throws IOException, Exception {
        while (true) {
            // Client nhận dữ liệu từ keyboard và gửi vào stream -> server
            System.out.print("Client input: ");
            String line = stdIn.readLine();

            byte[] encryptedMsg = cc.createInitialMsg(line);
            // Write to server: byte[] encryptedMsg
            out.writeInt(encryptedMsg.length);
            out.write(encryptedMsg);
            out.flush();

            if (line.equals("bye")) {
                break;
            }
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

    public static void main(String[] args) throws IOException {
        try {
            start();
            process();
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
