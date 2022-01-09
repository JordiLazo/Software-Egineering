package sockets.multithreaded;

import sockets.multithreaded.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPMultiThreadedServer {

    public static void main(String[] args) throws IOException {
        final int PORT = 6789;
        System.out.println("Starting the Server...");
        //create the Listening socket a port
        ServerSocket listenSocket = new ServerSocket(PORT);
        System.out.println("Waiting for a client...");

        while(true){
            //wait and listening socket for contact by client
            Socket socket = listenSocket.accept();
            ClientHandler c = new ClientHandler(socket);
            Thread t = new Thread(c);
            t.start();
        }
    }
}
