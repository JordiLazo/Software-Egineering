package server.model;

import shared.transferobjects.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ServerChatManager implements ServerChat {
    private PropertyChangeSupport support;
    private List<Message> listOfMessages;

    public ServerChatManager() {
        this.support = new PropertyChangeSupport(this);
        this.listOfMessages = new ArrayList<>();
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
        return listOfMessages;
    }

    @Override
    public void addMessage(Message message) {
        listOfMessages.add(message);
    }
}
