package Question_3_RMI_and_Proxy.rmi.server.model;

import Question_3_RMI_and_Proxy.rmi.shared.transferobjects.LogEntry;
import Question_3_RMI_and_Proxy.rmi.shared.util.Subject;

import java.util.List;

public interface TextManager extends Subject {

    String toUppercase(String str);
    List<LogEntry> getLog();
}
