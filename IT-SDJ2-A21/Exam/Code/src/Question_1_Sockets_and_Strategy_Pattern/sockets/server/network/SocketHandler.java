package Question_1_Sockets_and_Strategy_Pattern.sockets.server.network;

import Question_1_Sockets_and_Strategy_Pattern.sockets.server.model.TextManager;
import Question_1_Sockets_and_Strategy_Pattern.sockets.shared.transferobjects.LogEntry;
import Question_1_Sockets_and_Strategy_Pattern.sockets.shared.transferobjects.Request;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class SocketHandler implements Runnable{
    private Socket socket;
    private TextManager textManager;
    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;

    public SocketHandler(Socket socket, TextManager textManager) {
        this.socket = socket;
        this.textManager = textManager;

        try {
            outToClient = new ObjectOutputStream(socket.getOutputStream());
            inFromClient = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Request request = (Request) inFromClient.readObject();
            if("Listener".equals(request.getType())){
                textManager.addListener("NewLogEntry", this::onNewLogENtry);
            }else if("Uppercase".equals(request.getType())){
                String result = textManager.toUppercase((String) request.getArg());
                outToClient.writeObject(new Request("Uppercase",result));
            }else if("FetchLog".equals(request.getType())){
                List<LogEntry> log = textManager.getlog();
                outToClient.writeObject(new Request("FetchLog",log));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void onNewLogENtry(PropertyChangeEvent propertyChangeEvent) {
        try {
            outToClient.writeObject(new Request(propertyChangeEvent.getPropertyName(),propertyChangeEvent.getNewValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
