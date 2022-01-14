package client.model;

import client.network.Client;
import shared.transferobjects.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ClientLogInManager implements ClientLogIn {
    private Client client;
    private User user;
    private PropertyChangeSupport support;

    public ClientLogInManager(Client client) {
        this.client = client;
        client.startClient(user);
        this.support = new PropertyChangeSupport(this);
        client.addListener("UserSignUp",this::userSignUp);
        client.addListener("UserRemoved",this::userRemoved);
    }

    private void userRemoved(PropertyChangeEvent propertyChangeEvent) {
        support.firePropertyChange("UserRemoved",null,propertyChangeEvent.getNewValue());
    }

    private void userSignUp(PropertyChangeEvent propertyChangeEvent) {
        support.firePropertyChange("UserSignUp",null,propertyChangeEvent.getNewValue());
    }

    @Override
    public boolean logInUser(User user) {
        boolean temp = client.checkLogInUser(user);
        if(temp){
            this.user = user;
        }
        return temp;
    }

    @Override
    public boolean signUpNewUser(String username, String password) {
        User temp = new User(username,password);
        return client.signUpUser(temp);
    }

    @Override
    public boolean checkUsername(String username) {
        return client.checkUsername(username);
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }
}
