package client.views.login;

import client.core.ModelFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferobjects.User;

public class LogInViewModel {
    private StringProperty requestUsername;
    private StringProperty requestPassword;
    private StringProperty logInLabel;
    private ModelFactory modelFactory;

    public LogInViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        this.requestPassword= new SimpleStringProperty();
        this.requestUsername=new SimpleStringProperty();
        this.logInLabel = new SimpleStringProperty();
    }

    public boolean checkLogIn(String username, String password){
        User user = new User(username,password);
        if(!modelFactory.getClientLogIn().logInUser(user)){
            logInLabel.set("Please, create an account. SIGN UP!");
            return false;
        }
        return true;
    }
    public StringProperty getRequestUsername(){return requestUsername;}
    public StringProperty getRequestPassword(){
        return requestPassword;
    }
    public StringProperty getLogInLabel(){return logInLabel;}
}
