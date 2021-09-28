package sockets.login_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        final int PORT = 5678;
        System.out.println("Server ONLINE");
        ServerSocket serverSocket = new ServerSocket(PORT);

        while(true){
            Socket socket = serverSocket.accept();
            BufferedReader inReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outWriter = new PrintWriter(socket.getOutputStream(),true);

            String replyConnect = inReader.readLine();
            if(replyConnect.equals("connect")){
                outWriter.println("Connection accepted");
                outWriter.println("Username accepted");
                outWriter.println("Password accepted");
                System.out.println("Waiting for new users");
            }else{
                outWriter.println("Incorrect input...disconnecting");
                System.out.println("A user introduces an incorrect input. Closing server...");
                serverSocket.close();
            }
        }
    }
}
