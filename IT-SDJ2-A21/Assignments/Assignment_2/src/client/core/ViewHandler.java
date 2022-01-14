package client.core;

import client.views.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {
    private final ViewModelFactory viewModelFactory;
    private Stage stage;
    private Scene logInScene;
    private Scene chatScene;
    private Scene signUpScene;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
    }

    public void start(){
        this.stage = new Stage();
        openToLogIn();
    }

    public void openToLogIn(){
        if(logInScene == null){
            try {
                Parent root = loadFXML("../views/login/LogInView.fxml");
                stage.setTitle("LogIn");
                logInScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(logInScene);
        stage.show();
    }
    public void openToChat(){
        if(chatScene == null) {
            try {
                Parent root = loadFXML("../views/chat/ChatView.fxml");
                stage.setTitle("Chat");
                chatScene = new Scene(root);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        stage.setScene(chatScene);
        stage.show();
    }

    public void openToSignUp(){
        if(signUpScene == null) {
            try {
                Parent root = loadFXML("../views/signup/SignUpView.fxml");
                stage.setTitle("SignUp");
                signUpScene = new Scene(root);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        stage.setScene(signUpScene);
        stage.show();
    }

    private Parent loadFXML(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();
        ViewController viewController = loader.getController();
        viewController.init(this,viewModelFactory);
        return root;
    }
}
