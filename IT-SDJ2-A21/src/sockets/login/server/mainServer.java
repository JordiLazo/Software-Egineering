package sockets.login.server;

import sockets.login.server.mediator.UserServer;
import sockets.login.server.model.Model;
import sockets.login.server.model.ModelManager;

import java.io.IOException;

public class mainServer {
    public static void main(String[] args) throws IOException {
        Model model = new ModelManager();
        UserServer userServer = new UserServer(model);
        Thread t1 = new Thread(userServer);
        t1.start();
    }
}
