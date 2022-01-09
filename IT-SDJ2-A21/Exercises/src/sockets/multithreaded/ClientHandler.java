package sockets.multithreaded;

import com.google.gson.Gson;
import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private BufferedReader in;// in from the server
    private PrintWriter out;//out to the client
    Socket socket;

    public ClientHandler(Socket socket) throws IOException {
        //create input stream attached to the socket
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        this.socket = socket;
    }

    @Override
    public void run() {
        //read from client
        try {
            Gson gson = new Gson();
            String request = in.readLine();
            System.out.println("Client [" +socket.getPort()+"] > "+ request);
            String reply = request.toUpperCase();
            System.out.println("Server > " + reply);
            //send the line to the client
            out.println(reply);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
