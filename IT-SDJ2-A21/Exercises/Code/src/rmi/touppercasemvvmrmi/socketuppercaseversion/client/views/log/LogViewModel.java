package rmi.touppercasemvvmrmi.socketuppercaseversion.client.views.log;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import rmi.touppercasemvvmrmi.socketuppercaseversion.client.model.TextConverter;
import rmi.touppercasemvvmrmi.socketuppercaseversion.shared.transferobjects.LogEntry;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class LogViewModel {

    private ObservableList<LogEntry> logs;

    private TextConverter textConverter;

    public LogViewModel(TextConverter textConverter) {
        this.textConverter = textConverter;
        textConverter.addListener("NewLogEntry", this::onNewLogEntry);
    }

    private void onNewLogEntry(PropertyChangeEvent propertyChangeEvent) {
        logs.add((LogEntry) propertyChangeEvent.getNewValue());
    }

    void loadLogs() {
        List<LogEntry> logList = textConverter.getLogs();
        logs = FXCollections.observableArrayList(logList);
    }

    ObservableList<LogEntry> getLogs() {
        return logs;
    }
}
