package client.network;

import shared.transferobjects.Message;
import shared.transferobjects.User;
import shared.utils.Subject;

import java.util.List;

public interface Client extends Subject {
    List<Message> getAllMessages();
    List<String> getAllUsernames();
    void sendMessageToChat(Message message);
    boolean signUpUser(User user);
    void startClient(User user);
    boolean checkLogInUser(User user);
    boolean checkUsername(String username);
}
