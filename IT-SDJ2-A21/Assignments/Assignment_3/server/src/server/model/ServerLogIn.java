package server.model;

import shared.transferobjects.User;

import java.util.List;

public interface ServerLogIn {
    boolean addUser(User user);
    boolean checkUsername(String username);
    boolean checkLogInUser(User user);
    void removeUser(User user);
    List<String> getAllUsers();
}
