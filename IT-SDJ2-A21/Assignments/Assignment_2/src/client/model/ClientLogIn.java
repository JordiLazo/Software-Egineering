package client.model;

import shared.transferobjects.User;
import shared.utils.Subject;

public interface ClientLogIn extends Subject {
    boolean logInUser(User user);
    boolean signUpNewUser(String username, String password);
    boolean checkUsername(String username);
    User getUser();
}
