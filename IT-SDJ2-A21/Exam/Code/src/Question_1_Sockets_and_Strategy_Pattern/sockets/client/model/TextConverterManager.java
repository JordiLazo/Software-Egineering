package Question_1_Sockets_and_Strategy_Pattern.sockets.client.model;

import Question_1_Sockets_and_Strategy_Pattern.sockets.client.network.Client;
import Question_1_Sockets_and_Strategy_Pattern.sockets.shared.transferobjects.LogEntry;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class TextConverterManager implements TextConverter {

    private Client client;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public TextConverterManager(Client client) {
        this.client = client;
        client.startClient();
        client.addListener("NewLogEntry",this::onNewLogEntry);
    }

    private void onNewLogEntry(PropertyChangeEvent propertyChangeEvent) {
        support.firePropertyChange(propertyChangeEvent);
    }

    @Override
    public String toUppercase(String text) {
        return client.toUppercase(text);
    }

    @Override
    public List<LogEntry> getLogs() {
        return client.getLog();
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


