package Question_3_RMI_and_Proxy.rmi.client.model;

import Question_3_RMI_and_Proxy.rmi.shared.transferobjects.LogEntry;
import Question_3_RMI_and_Proxy.rmi.shared.util.Subject;

import java.util.List;

public interface TextConverter extends Subject {

    String toUppercase(String text);
    List<LogEntry> getLogs();

}


