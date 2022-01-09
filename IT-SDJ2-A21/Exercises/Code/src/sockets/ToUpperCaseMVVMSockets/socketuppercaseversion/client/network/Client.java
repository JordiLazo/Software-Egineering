package sockets.ToUpperCaseMVVMSockets.socketuppercaseversion.client.network;

import sockets.ToUpperCaseMVVMSockets.localuppercaseversion.util.Subject;
import sockets.ToUpperCaseMVVMSockets.socketuppercaseversion.shared.transferobjects.LogEntry;

import java.util.List;

public interface Client extends Subject {
    String toUppercase(String str);
    List<LogEntry> getLog();
    void startClient();
}
