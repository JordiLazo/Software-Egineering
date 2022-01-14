package Question_1_Sockets_and_Strategy_Pattern.sockets.server.model;

import Question_1_Sockets_and_Strategy_Pattern.sockets.shared.transferobjects.LogEntry;
import Question_1_Sockets_and_Strategy_Pattern.sockets.shared.util.Subject;

import java.util.List;

public interface TextManager extends Subject {
    String toUppercase(String str);
    List<LogEntry> getlog();
}
