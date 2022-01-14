package client.model;

import shared.transferobjects.Message;
import shared.utils.Subject;

import java.util.List;

public interface ClientChat extends Subject {
    List<Message> getChatMessages();
    List<String> getUsersOnline();
    void sendMessageToChat(Message message);
}
