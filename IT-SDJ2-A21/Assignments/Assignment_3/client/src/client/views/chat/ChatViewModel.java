package client.views.chat;

import client.core.ModelFactory;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.Message;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class ChatViewModel {
    private ObservableList<Message> listOfMessages;
    private ObservableList<String> listOfUsers;
    private ModelFactory modelFactory;

    public ChatViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        modelFactory.getClientChat().addListener("NewMessage",this::newMessage);
        modelFactory.getClientLogIn().addListener("UserSignUp",this::userSignUp);
        modelFactory.getClientLogIn().addListener("UserRemoved",this::userRemoved);
        //loadMessages();
        loadUsers();
    }

    private void userRemoved(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(()->{
            listOfUsers.remove((String) propertyChangeEvent.getNewValue());
        });
    }

    private void userSignUp(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(()->{
            listOfUsers.add((String) propertyChangeEvent.getNewValue());
        });
    }

    private void newMessage(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(()-> {
            listOfMessages.add((Message) propertyChangeEvent.getNewValue());
        });

    }

    public void loadMessages(){
        List<Message> messageList = modelFactory.getClientChat().getChatMessages();
        listOfMessages = FXCollections.observableArrayList(messageList);
    }

    public void loadUsers(){
        List<String> onlineUsers = modelFactory.getClientChat().getUsersOnline();
        listOfUsers = FXCollections.observableArrayList(onlineUsers);
    }

    public void sendMessage(String userText){
        Message message = new Message(modelFactory.getClientLogIn().getUser().getUsername(),userText);
        modelFactory.getClientChat().sendMessageToChat(message);
    }

    public ObservableList<Message> getListOfMessages(){
        return listOfMessages;
    }

    public ObservableList<String> getUsersList(){
        return listOfUsers;
    }
}
