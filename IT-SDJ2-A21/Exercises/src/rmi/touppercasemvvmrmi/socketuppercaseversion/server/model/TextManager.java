package rmi.touppercasemvvmrmi.socketuppercaseversion.server.model;

import rmi.touppercasemvvmrmi.socketuppercaseversion.shared.transferobjects.LogEntry;
import rmi.touppercasemvvmrmi.socketuppercaseversion.shared.util.Subject;

import java.util.List;

public interface TextManager extends Subject {
    String toUppercase(String str);
    List<LogEntry> getlog();
}
