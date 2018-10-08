package com.itstep;

import java.io.*;
import java.net.*;

class ServeOneJabber extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServeOneJabber(Socket s) throws IOException {
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket
                .getOutputStream())), true);
        start();
    }

    public void run() {
        try {
            while (true) {
                String str = in.readLine();
                if (str.equals("END"))
                    break;
                System.out.println("Echoing: " + str);
                out.println(str);
            }
        } catch (IOException e) {
            System.err.println("IO Exception - "+e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Socket not closed");
            }
        }
    }
}

public class Server {
    static final int PORT = 8020;

    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Server started");
        try {
            while (true) {
                Socket socket = s.accept();
                try {
                    new ServeOneJabber(socket);
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            s.close();
        }
    }
}
