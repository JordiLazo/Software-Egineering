package client.views.signup;

import client.core.ModelFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SignUpViewModel {
    private StringProperty requestUsername;
    private StringProperty requestPassword;
    private StringProperty signUpLabel;
    private ModelFactory modelFactory;

    public SignUpViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        this.requestUsername = new SimpleStringProperty();
        this.requestPassword = new SimpleStringProperty();
        this.signUpLabel = new SimpleStringProperty();
    }

    public boolean checkSignUp(String username, String password){
        if(username.equals("")){
            signUpLabel.set("Username or password is empty");
        }else if(!modelFactory.getClientLogIn().checkUsername(username)){
            signUpLabel.set("Username is not available");
            return false;
        }else{
            if(modelFactory.getClientLogIn().signUpNewUser(username,password)){
                signUpLabel.set("Account created successfully");
                return true;
            }
        }
        return false;
    }

    public StringProperty getRequestUsername() {
        return requestUsername;
    }

    public StringProperty getRequestPassword(){
        return requestPassword;
    }

    public StringProperty getSignUpLabel(){
        return signUpLabel;
    }

}
