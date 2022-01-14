package client.views.signup;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SignUpViewController implements ViewController {
    @FXML
    public TextField requestUsername;
    public TextField requestPassword;
    public Text signUpLabel;

    private SignUpViewModel signUpViewModel;
    private ViewHandler viewHandler;

    public void onBackButton(ActionEvent actionEvent) {
        viewHandler.openToLogIn();
    }

    public void onCreateAccount(ActionEvent actionEvent) {
        signUpViewModel.checkSignUp(requestUsername.getText(), requestPassword.getText());
        requestPassword.clear();
        requestUsername.clear();
    }

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        this.signUpViewModel = viewModelFactory.getSignUpViewModel();
        this.requestUsername.textProperty().bindBidirectional(signUpViewModel.getRequestUsername());
        this.requestPassword.textProperty().bindBidirectional(signUpViewModel.getRequestPassword());
        this.signUpLabel.textProperty().bind(signUpViewModel.getSignUpLabel());
    }
}
