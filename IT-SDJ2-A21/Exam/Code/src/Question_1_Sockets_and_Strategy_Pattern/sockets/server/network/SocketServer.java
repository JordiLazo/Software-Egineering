package Question_1_Sockets_and_Strategy_Pattern.sockets.server.network;

import Question_1_Sockets_and_Strategy_Pattern.sockets.server.model.TextManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private TextManager textManager;

    public SocketServer(TextManager textManager) {
        this.textManager = textManager;
    }

    public void startServerSocket(){
        try {
            ServerSocket welcomesocket = new ServerSocket(2910);
            while(true){
                Socket socket = welcomesocket.accept();
                new Thread(new SocketHandler(socket,textManager)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
