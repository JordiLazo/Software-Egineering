package sockets.ToUpperCaseMVVMSockets.socketuppercaseversion.client.model;

import sockets.ToUpperCaseMVVMSockets.socketuppercaseversion.shared.transferobjects.LogEntry;
import sockets.ToUpperCaseMVVMSockets.socketuppercaseversion.shared.util.Subject;

import java.util.List;

public interface TextConverter extends Subject {

    String toUppercase(String text);
    List<LogEntry> getLogs();

}


