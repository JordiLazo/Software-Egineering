package server.model;

import shared.transferobjects.Message;
import shared.utils.Subject;

import java.util.List;

public interface ServerChat extends Subject {
    List<Message> getAllMessages();
    void addMessage(Message message);
}
