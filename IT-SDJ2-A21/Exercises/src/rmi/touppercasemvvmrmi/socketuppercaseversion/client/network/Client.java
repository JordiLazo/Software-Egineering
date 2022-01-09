package rmi.touppercasemvvmrmi.socketuppercaseversion.client.network;

import rmi.touppercasemvvmrmi.socketuppercaseversion.shared.transferobjects.LogEntry;
import rmi.touppercasemvvmrmi.socketuppercaseversion.shared.util.Subject;

import java.util.List;

public interface Client extends Subject {
    String toUppercase(String str);
    List<LogEntry> getLog();
    void startClient();
}
