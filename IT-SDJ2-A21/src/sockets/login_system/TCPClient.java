package sockets.login_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        final int PORT = 5678;
        final String HOST = "localhost";

        Scanner inputUser = new Scanner(System.in);
        Socket clientSocket = new Socket(HOST,PORT);
        BufferedReader inReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter outWriter = new PrintWriter(clientSocket.getOutputStream(), true);
        System.out.println("Connect to the server:");

        String requestConnect = inputUser.nextLine();
        inReader.readLine();
        String replyConnect = inReader.readLine();
        System.out.println(replyConnect);
    }
}
