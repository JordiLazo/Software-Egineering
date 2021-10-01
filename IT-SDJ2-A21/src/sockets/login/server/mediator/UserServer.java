package sockets.login.server.mediator;

import sockets.login.server.model.Model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UserServer implements Runnable{
    private final int PORT = 1099;
    private boolean running;
    private ServerSocket welcomeSocket;
    private Model model;

    public UserServer(Model model) throws IOException {
        this.model = model;
        this.welcomeSocket = new ServerSocket(PORT);
        this.running = false;
    }

    public void close() throws IOException {
        welcomeSocket.close();
    }

    @Override
    public void run() {
        System.out.println("Starting the Server...");
        //create the Listening socket a port
        System.out.println("Waiting for a client...");
        running = true;
        while(running){
            try {
                Socket socket = welcomeSocket.accept();
                UserClientHandler c = new UserClientHandler(socket,model);
                Thread t1 = new Thread(c);
                t1.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
