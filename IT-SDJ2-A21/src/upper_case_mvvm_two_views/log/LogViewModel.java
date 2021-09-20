package upper_case_mvvm_two_views.log;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import upper_case_mvvm_two_views.model.TextConverter;

public class LogViewModel {

    TextConverter model;
    ObservableList<String> logs;

    public LogViewModel(TextConverter model) {
        this.model = model;
        logs = FXCollections.observableArrayList();
    }

    public ObservableList<String> getLogs(){
        return logs;
    }

}
