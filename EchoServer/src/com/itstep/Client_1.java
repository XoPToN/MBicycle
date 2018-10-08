package com.itstep;

import java.net.*;

import java.io.*;
import java.util.Scanner;

class ClientThread_1 extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientThread_1(InetAddress addr) {
        try {
            socket = new Socket(addr, Server.PORT);
        } catch (IOException e) {
            System.err.println("Socket failed");
        }
        try {
            in = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                    socket.getOutputStream())), true);
            start();
        } catch (IOException e) {
            try {
                socket.close();
            } catch (IOException e2) {
                System.err.println("Socket not closed");
            }
        }
    }

    public void run() {
        try {
            System.out.println("Enter your data : ");
            Scanner inputString = new Scanner(System.in);
            out.println("Client 1 enter = " + inputString.nextLine());
            String str = in.readLine();
            System.out.println(str);
            out.println("END");
        } catch (IOException e) {
            System.err.println("IO Exception - " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Socket not closed");
            }
        }
    }
}

public class Client_1 {
    public static void main(String[] args) throws IOException,
            InterruptedException {
        InetAddress address = InetAddress.getByName(null);
        while (true) {
            new ClientThread_1(address);
            Thread.currentThread().sleep(100);
        }
    }
}
