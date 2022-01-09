package sockets.login.client.mediator;

import com.google.gson.Gson;
import sockets.login.client.model.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UserClient implements Model, Runnable {
    private User user;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Gson gson;
    private String host;
    private int port;

    public UserClient(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
        this.gson=new Gson();
        this.socket = new Socket(host,port);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(),true);
    }

    public void disconnect() throws IOException {
        socket.close();
    }

    @Override
    public void login(String userName, String password) throws IllegalStateException, IllegalArgumentException, IOException {
        user = new User(userName,password);
        String json = gson.toJson(user);
        out.println(json);
        String request = in.readLine();
        if(!request.startsWith("Success")){
            throw new IllegalStateException("Error");
        }
        System.out.println(in.readLine());
    }

    @Override
    public void run() {

    }
}
