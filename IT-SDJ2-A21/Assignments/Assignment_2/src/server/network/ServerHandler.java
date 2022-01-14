package server.network;

import server.model.ServerChat;
import server.model.ServerLogIn;
import shared.transferobjects.Message;
import shared.transferobjects.Request;
import shared.transferobjects.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ServerHandler implements Runnable {
    private Socket socket;
    private ObjectInputStream receiveFromClient;
    private ObjectOutputStream sendToClient;
    private ServerChat serverChat;
    private ServerLogIn serverLogIn;
    private ConectionPool conectionPool;
    private User user;

    public ServerHandler(Socket socket, ServerLogIn serverLogIn, ServerChat serverChat, ConectionPool conectionPool){
        this.socket = socket;
        this.serverChat = serverChat;
        this.conectionPool = conectionPool;
        this.serverLogIn = serverLogIn;
        try {
            this.receiveFromClient = new ObjectInputStream(socket.getInputStream());
            this.sendToClient = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToClient(Message message){
        try {
            sendToClient.writeObject(new Request("NewMessage",message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUser(User user){
        this.user = user;
    }

    public String getUsername(){
        if(user == null){
            return "";
        }else {
            return user.getUsername();
        }
    }

    public void sendRemovedUserToClient(String username){
        try {
            sendToClient.writeObject(new Request("UserRemoved",username));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void sendUsersToClient(String username){
        try {
            sendToClient.writeObject(new Request("UserSignUp",username));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try{
            while(true) {
                Request request = (Request) receiveFromClient.readObject();
                if ("CheckConnectionUser".equals(request.getUserRequest())) {
                    String temp = (String) request.getObjectArgument();
                    if(serverLogIn.checkUsername(temp)){
                        sendToClient.writeObject(new Request("CheckConnectionUser",true));
                    }else{
                        sendToClient.writeObject(new Request("CheckConnectionUser", false));
                    }
                } else if("Listener".equals(request.getUserRequest())){
                    this.user = (User) request.getObjectArgument();
                } else if("AllMessages".equals(request.getUserRequest())){
                    List<Message> message = serverChat.getAllMessages();
                    sendToClient.writeObject(new Request("AllMessages",message));
                } else if("NewMessage".equals(request.getUserRequest())){
                    serverChat.addMessage((Message) request.getObjectArgument());
                    conectionPool.broadcastMessage((Message) request.getObjectArgument());
                } else if ("NewUser".equals(request.getUserRequest())) {
                    boolean temp = serverLogIn.addUser((User) request.getObjectArgument());
                    sendToClient.writeObject(new Request("NewUser", temp));
                } else if("CheckLogIn".equals(request.getUserRequest())){
                    User user = (User) request.getObjectArgument();
                    boolean temp = serverLogIn.checkLogInUser(user);
                    sendToClient.writeObject(new Request("CheckLogIn",temp));
                    if(temp){
                        setUser(user);
                        conectionPool.broadcastUsername(user.getUsername());
                    }
                } else if("AllUsers".equals(request.getUserRequest())){
                    sendToClient.writeObject(new Request("AllUsers",serverLogIn.getAllUsers()));
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            conectionPool.broadcastUserDisconnected(user.getUsername());
            conectionPool.removeUser(this);
            e.printStackTrace();
        }
    }
}
