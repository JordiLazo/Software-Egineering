package sockets.login.server.mediator;

import com.google.gson.Gson;
import sockets.login.server.model.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UserClientHandler implements Runnable{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private boolean running;
    private Gson gson;
    private String clienttlp;
    private Model model;

    public UserClientHandler(Socket socket, Model model) throws IOException {
        this.socket = socket;
        this.model = model;
        this.gson = new Gson();
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream());
        this.running = false;
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            try {
                String request = in.readLine();
                UserPackage userPackage = gson.fromJson(request, UserPackage.class);
                model.addUser(userPackage.getUser(), userPackage.getPassword());
                out.println("Success: you are now logged in");

            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
                System.out.println("Error adding user");
            }
        }
    }
}
