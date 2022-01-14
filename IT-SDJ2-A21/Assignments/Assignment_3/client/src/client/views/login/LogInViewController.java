package client.views.login;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LogInViewController implements ViewController {
    @FXML
    public TextField requestUsername;
    public TextField requestPassword;
    public Label logInLabel;

    private ViewHandler viewHandler;
    private LogInViewModel loginViewModel;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory){
        this.viewHandler = viewHandler;
        this.loginViewModel = viewModelFactory.getLoginViewModel();
        this.requestPassword.textProperty().bindBidirectional(loginViewModel.getRequestPassword());
        this.requestUsername.textProperty().bindBidirectional(loginViewModel.getRequestUsername());
        this.logInLabel.textProperty().bind(loginViewModel.getLogInLabel());
    }

    public void onSignUpButton(ActionEvent actionEvent) {
        viewHandler.openToSignUp();
    }

    public void onLogInButton(ActionEvent actionEvent) {
       if(loginViewModel.checkLogIn(requestUsername.getText(),requestPassword.getText())){
           viewHandler.openToChat();
           requestUsername.clear();
           requestPassword.clear();
       }
        requestUsername.clear();
        requestPassword.clear();
    }
}
