package sockets.ToUpperCaseMVVMSockets.localuppercaseversion.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class TextConverterManager implements TextConverter {

    private List<LogEntry> logs = new ArrayList<>();
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public String toUppercase(String text) {
        String result = text.toUpperCase();
        LogEntry log = new LogEntry(text, result);
        logs.add(log);
        support.firePropertyChange("LogAdded", null, log);
        return result;
    }

    @Override
    public List<LogEntry> getLogs() {
        return logs;
    }


    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}


