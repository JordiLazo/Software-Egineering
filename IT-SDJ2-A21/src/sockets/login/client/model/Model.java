package sockets.login.client.model;

import java.io.IOException;

public interface Model {
    void login(String userName, String password) throws IllegalStateException, IllegalArgumentException, IOException;
}
