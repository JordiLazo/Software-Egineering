package client.network;

import shared.transferobjects.Message;
import shared.transferobjects.Request;
import shared.transferobjects.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class SocketClient implements Client{

    private PropertyChangeSupport support;


    public SocketClient() {
        this.support = new PropertyChangeSupport(this);
    }

    public void listenToServer(ObjectOutputStream sendToServer, ObjectInputStream receiveFromServer, User user){
        try {
            sendToServer.writeObject(new Request("Listener", user));
            while(true){
                Request request = (Request) receiveFromServer.readObject();
                if(request.getUserRequest().equals("NewMessage")){
                    support.firePropertyChange("NewMessage",null,request.getObjectArgument());
                } else if(request.getUserRequest().equals("UserSignUp")){
                    support.firePropertyChange("UserSignUp",null,request.getObjectArgument());
                } else if(request.getUserRequest().equals("UserRemoved")){
                    support.firePropertyChange("UserRemoved",null, request.getObjectArgument());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Request request(Object request, String type) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost",1234);
        ObjectOutputStream sendToServer = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream receiveFromServer = new ObjectInputStream(socket.getInputStream());
        sendToServer.writeObject(new Request(type,request));
        return (Request) receiveFromServer.readObject();
    }

    @Override
    public void startClient(User user){
        try {
            Socket socket = new Socket("localhost",1234);
            ObjectOutputStream sendToServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream receiveFromServer = new ObjectInputStream(socket.getInputStream());
            Thread t = new Thread(()-> listenToServer(sendToServer,receiveFromServer,user));
            t.setDaemon(true);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkLogInUser(User user) {
        try {
            Request response = request(user,"CheckLogIn");
            boolean temp = (boolean) response.getObjectArgument();
            if(temp){
                startClient(user);
            }
            return temp;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkUsername(String username) {
        try {
            Request request = request(username,"CheckConnectionUser");
            return (boolean) request.getObjectArgument();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName,listener);
    }

    @Override
    public List<Message> getAllMessages() {
        try {
            Request response = request(null,"AllMessages");
            return (List<Message>) response.getObjectArgument();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> getAllUsernames() {
        try {
            Request response = request(null,"AllUsers");
            return (List<String>) response.getObjectArgument();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void sendMessageToChat(Message message) {
        try {
            Request request = request(message,"NewMessage");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean signUpUser(User user) {
        try{
            Request response = request(user,"NewUser");
            return (boolean) response.getObjectArgument();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
