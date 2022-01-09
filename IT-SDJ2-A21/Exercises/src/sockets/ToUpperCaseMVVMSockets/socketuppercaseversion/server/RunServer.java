package sockets.ToUpperCaseMVVMSockets.socketuppercaseversion.server;

import sockets.ToUpperCaseMVVMSockets.socketuppercaseversion.server.model.TextManagerImpl;
import sockets.ToUpperCaseMVVMSockets.socketuppercaseversion.server.network.SocketServer;

public class RunServer {
    public static void main(String[] args) {
        SocketServer ss = new SocketServer(new TextManagerImpl());
        ss.startServerSocket();
    }
}
