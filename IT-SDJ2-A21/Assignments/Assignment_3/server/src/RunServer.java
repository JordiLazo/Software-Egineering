import server.model.ServerChatManager;
import server.model.ServerLogInManager;
import server.network.RMIServerManager;

import java.io.IOException;
import java.rmi.AlreadyBoundException;

public class RunServer {
    public static void main(String[] args) throws IOException, AlreadyBoundException {
        RMIServerManager socketServer = new RMIServerManager(new ServerChatManager(), new ServerLogInManager());
        socketServer.startServer();
        System.out.println("Server is running...");
    }
}
