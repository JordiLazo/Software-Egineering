package sockets.ToUpperCaseMVVMSockets.socketuppercaseversion.server.model;

import sockets.ToUpperCaseMVVMSockets.localuppercaseversion.util.Subject;
import sockets.ToUpperCaseMVVMSockets.socketuppercaseversion.shared.transferobjects.LogEntry;

import java.util.List;

public interface TextManager extends Subject {
    String toUppercase(String str);
    List<LogEntry> getlog();
}
