package Question_1_Sockets_and_Strategy_Pattern.sockets.server;

import Question_1_Sockets_and_Strategy_Pattern.sockets.server.model.TextManagerImpl;
import Question_1_Sockets_and_Strategy_Pattern.sockets.server.network.SocketServer;

public class RunServer {
    public static void main(String[] args) {
        SocketServer ss = new SocketServer(new TextManagerImpl());
        ss.startServerSocket();
    }
}
