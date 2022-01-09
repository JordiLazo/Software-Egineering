package sockets.ToUpperCaseMVVMSockets.localuppercaseversion.views.log;

import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sockets.ToUpperCaseMVVMSockets.localuppercaseversion.core.ViewHandler;
import sockets.ToUpperCaseMVVMSockets.localuppercaseversion.core.ViewModelFactory;
import sockets.ToUpperCaseMVVMSockets.localuppercaseversion.model.LogEntry;
import sockets.ToUpperCaseMVVMSockets.localuppercaseversion.views.ViewController;

public class LogViewController implements ViewController {

    // I can make these field public. Or make them private, and mark them with @FXML.
    // The result is the same. Private is probably preferable,
    // because if something doesn't _need_ to be public, it shouldn't be

    @FXML
    private TableView<LogEntry> tableView;
    public TableColumn<String, LogEntry> inputColumn;
    public TableColumn<String, LogEntry> outputColumn;

    private LogViewModel vm;
    private ViewHandler vh;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        vm = vmf.getLogViewModel();
        vm.loadLogs();
        tableView.setItems(vm.getLogs());
        inputColumn.setCellValueFactory(new PropertyValueFactory<>("input"));
        outputColumn.setCellValueFactory(new PropertyValueFactory<>("output"));
    }

    public void onBackButton() {
        vh.openToUppercase();
    }
}
