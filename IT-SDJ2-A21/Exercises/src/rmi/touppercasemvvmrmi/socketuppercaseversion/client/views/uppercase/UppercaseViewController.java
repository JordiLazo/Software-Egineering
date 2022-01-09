package rmi.touppercasemvvmrmi.socketuppercaseversion.client.views.uppercase;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rmi.touppercasemvvmrmi.socketuppercaseversion.client.core.ViewHandler;
import rmi.touppercasemvvmrmi.socketuppercaseversion.client.core.ViewModelFactory;
import rmi.touppercasemvvmrmi.socketuppercaseversion.client.views.ViewController;

public class UppercaseViewController implements ViewController {
    @FXML
    private Label errorLabel;
    @FXML
    private TextField requestField;
    @FXML
    private TextField replyField;

    private UppercaseViewModel viewModel;
    private ViewHandler vh;

    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.viewModel = vmf.getUppercaseViewModel();
        replyField.setDisable(true);
        errorLabel.textProperty().bind(viewModel.errorProperty());
        requestField.textProperty().bindBidirectional(viewModel.requestProperty());
        replyField.textProperty().bind(viewModel.replyProperty());
    }

    @FXML
    private void onSubmitButton() {
        viewModel.convert();
    }

    // I can make this method public, or do like above, make it private and mark it @FXML.
    // The result is the same
    public void onLogButton() {
        vh.openLog();
    }
}

