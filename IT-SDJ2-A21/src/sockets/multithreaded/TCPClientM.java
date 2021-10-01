package sockets.multithreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientM {

    public static void main(String[] args) throws IOException {
        final int PORT = 6789;
        //final String HOST = "localhost";
        InetAddress HOST = InetAddress.getLocalHost();

        //create a client socket and connect to the server
        Socket clientSocket = new Socket(HOST.getHostName(),6789);

        Scanner input = new Scanner(System.in);

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        System.out.println("Write a line for the server: ");

        String request = input.nextLine();

        System.out.println("Client > "+ request);

        //send line to server
        out.println(request);

        String reply = in.readLine();

        System.out.println("Server > " + reply);
        clientSocket.close();
    }
}
