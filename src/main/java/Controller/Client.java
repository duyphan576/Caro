/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Crypto.ClientCryptography;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author duyph
 */
public class Client {

    private Socket socket;
    private static int port = 1234;
    private static String host;
    public static ClientCryptography cc;
    private DataInputStream in;
    public static DataOutputStream out;

    public Client() {
        try {
            String api = "https://api-generator.retool.com/VoJlkt/data/1";
            Document doc = Jsoup.connect(api).ignoreContentType(true).ignoreHttpErrors(true).header("Content-Type", "application/json")
                    .method(Connection.Method.GET).execute().parse();
            JSONObject jsonObject = new JSONObject(doc.text());
            host = jsonObject.get("ip").toString();
            socket = new Socket(host, port);
            System.out.println("Client connected");
            in = new DataInputStream(new DataInputStream(socket.getInputStream()));
            out = new DataOutputStream(new DataOutputStream(socket.getOutputStream()));
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

            Receive recv = new Receive(socket, in);
            ExecutorService excutor = Executors.newCachedThreadPool();
            excutor.execute(recv);
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

}
