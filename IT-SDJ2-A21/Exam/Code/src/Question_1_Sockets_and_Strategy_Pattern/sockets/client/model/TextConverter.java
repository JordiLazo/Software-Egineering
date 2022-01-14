package Question_1_Sockets_and_Strategy_Pattern.sockets.client.model;

import Question_1_Sockets_and_Strategy_Pattern.sockets.shared.transferobjects.LogEntry;
import Question_1_Sockets_and_Strategy_Pattern.sockets.shared.util.Subject;

import java.util.List;

public interface TextConverter extends Subject {

    String toUppercase(String text);
    List<LogEntry> getLogs();

}


