package sockets.login.client.model;

import sockets.login.client.mediator.UserClient;

import java.io.IOException;

public class ModelManager implements Model{
    private UserClient userClient;

    public ModelManager(UserClient userClient) {
        this.userClient = userClient;
    }


    @Override
    public void login(String userName, String password) throws IllegalStateException, IllegalArgumentException, IOException {

    }
}
