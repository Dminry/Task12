package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;



public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 8888;
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(HOST,PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
            String response = in.readLine();
            System.out.println(response);
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            out.println(name);
            response = in.readLine();
            System.out.println("Соединение установлено" +
                    " ");
            System.out.println(response);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
