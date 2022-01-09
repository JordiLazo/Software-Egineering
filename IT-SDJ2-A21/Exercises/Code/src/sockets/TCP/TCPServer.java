package sockets.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        final int PORT = 6789;
        System.out.println("Starting server...");
        //crate a server socket at port 6789....Listening for clients
        ServerSocket listenSocket = new ServerSocket(PORT);

        while(true){
            System.out.println("Waiting for clients...");
            Socket socket = listenSocket.accept();
            //crate input/output stream attached to the socket
            //InoutStream, InputStreamReader, BufferedReader
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outWriter = new PrintWriter(socket.getOutputStream(),true);
            //BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream());
            String request = in.readLine();
            System.out.println("Client> " + request);
            String reply = request.toUpperCase();
            System.out.println("Server> " + reply);
            //send line to client
            outWriter.println(reply);
            // loop back and wait for another client connection

        }
    }
}
