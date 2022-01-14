package Question_2_MVVM_and_Observer_Pattern.mvvm.view.uppercase;

import Question_2_MVVM_and_Observer_Pattern.mvvm.model.TextConverter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UppercaseViewController {
    @FXML
    private TextField RequestField;
    @FXML
    private TextField ReplyField;
    @FXML
    private Label errorLabel;
    private TextConverter text;
    private UppercaseViewModel viewModel = new UppercaseViewModel(text);

    public void init(UppercaseViewModel uppercaseViewModel){
        this.viewModel = uppercaseViewModel;
        errorLabel.textProperty().bind(viewModel.errorProperty());
        ReplyField.textProperty().bind(viewModel.replyProperty());
        RequestField.textProperty().bindBidirectional(viewModel.requestProperty());
    }

    @FXML
    public void onSubmitButton(ActionEvent actionEvent) {
        System.out.println("Sumbit pressed");
        viewModel.convert();
    }

}
