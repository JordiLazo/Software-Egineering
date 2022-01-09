package sockets.ToUpperCaseMVVMSockets.localuppercaseversion.model;

import sockets.ToUpperCaseMVVMSockets.localuppercaseversion.util.Subject;

import java.util.List;

public interface TextConverter extends Subject {

    String toUppercase(String text);
    List<LogEntry> getLogs();

}


