package Question_1_Sockets_and_Strategy_Pattern.sockets.client.views.log;

import Question_1_Sockets_and_Strategy_Pattern.sockets.client.model.TextConverter;
import Question_1_Sockets_and_Strategy_Pattern.sockets.shared.transferobjects.LogEntry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
