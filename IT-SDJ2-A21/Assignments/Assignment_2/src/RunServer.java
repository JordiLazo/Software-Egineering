import server.model.ServerChatManager;
import server.model.ServerLogInManager;
import server.network.SocketServer;

import java.io.IOException;

public class RunServer {
    public static void main(String[] args) throws IOException {
        SocketServer socketServer = new SocketServer(new ServerLogInManager(),new ServerChatManager());
        socketServer.startSocketServer();
    }
}
