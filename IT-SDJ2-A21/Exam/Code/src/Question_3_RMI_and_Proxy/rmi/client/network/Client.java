package Question_3_RMI_and_Proxy.rmi.client.network;

import Question_3_RMI_and_Proxy.rmi.shared.transferobjects.LogEntry;
import Question_3_RMI_and_Proxy.rmi.shared.util.Subject;

import java.util.List;

public interface Client extends Subject {

    String toUppercase(String str);
    List<LogEntry> getLog();

    void startClient();

    void unRegisterClient();
}
