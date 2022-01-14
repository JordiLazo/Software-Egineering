package server.network;

import server.model.ServerChat;
import server.model.ServerLogIn;

import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private ServerChat serverChat;
    private ServerLogIn serverLogIn;

    public SocketServer(ServerLogIn serverLogIn, ServerChat serverChat) {
        this.serverChat = serverChat;
        this.serverLogIn = serverLogIn;
    }

    public void startSocketServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            ConectionPool conectionPool = new ConectionPool();
            while (true){
                Socket socket = serverSocket.accept();
                ServerHandler serverHandler = new ServerHandler(socket,serverLogIn,serverChat,conectionPool);
                conectionPool.addConnection(serverHandler);
                Thread thread = new Thread(serverHandler);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
