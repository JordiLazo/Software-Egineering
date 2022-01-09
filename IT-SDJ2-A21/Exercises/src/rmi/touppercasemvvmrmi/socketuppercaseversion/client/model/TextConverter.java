package rmi.touppercasemvvmrmi.socketuppercaseversion.client.model;

import rmi.touppercasemvvmrmi.socketuppercaseversion.shared.transferobjects.LogEntry;
import rmi.touppercasemvvmrmi.socketuppercaseversion.shared.util.Subject;

import java.util.List;

public interface TextConverter extends Subject {

    String toUppercase(String text);
    List<LogEntry> getLogs();

}


