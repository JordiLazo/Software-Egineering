package client.model;

import client.network.Client;
import shared.transferobjects.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ClientChatManager implements ClientChat {
    private Client client;
    private PropertyChangeSupport support;

    public ClientChatManager(Client client) {
        this.client = client;
        this.support = new PropertyChangeSupport(this);
        client.addListener("NewMessage",this::messageSentInChat);
        client.addListener("NewUserInChat", this::newUserInChat);
    }

    private void newUserInChat(PropertyChangeEvent propertyChangeEvent) {
        String username = (String) propertyChangeEvent.getNewValue();
        support.firePropertyChange("NewUserInChat",null,username);
    }

    private void messageSentInChat(PropertyChangeEvent propertyChangeEvent) {
        Message message = (Message) propertyChangeEvent.getNewValue();
        support.firePropertyChange("NewMessage",null,message);
    }

    @Override
    public List<Message> getChatMessages() {
        return client.getAllMessages();
    }

    @Override
    public List<String> getUsersOnline() {
        return client.getAllUsernames();
    }

    @Override
    public void sendMessageToChat(Message message) {
        client.sendMessageToChat(message);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName,listener);
    }
}
