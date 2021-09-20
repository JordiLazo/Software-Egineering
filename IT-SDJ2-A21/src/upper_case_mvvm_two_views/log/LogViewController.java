package upper_case_mvvm_two_views.log;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import observer_pattern.temperature.view.ViewHandler;

public class LogViewController {

    @FXML
    public ListView<String> logList;

    @FXML
    public void onBackButton(){

    }

    public void init(ViewHandler viewHandler, LogViewModel viewModel){
        return;
    }
}
