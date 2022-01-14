package client.core;

import client.views.chat.ChatViewModel;
import client.views.login.LogInViewModel;
import client.views.signup.SignUpViewModel;

public class ViewModelFactory {
    private final ModelFactory modelFactory;
    private LogInViewModel loginViewModel;
    private ChatViewModel chatViewModel;
    private SignUpViewModel signUpViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LogInViewModel getLoginViewModel(){
        if(loginViewModel == null){
            loginViewModel = new LogInViewModel(modelFactory);
        }
        return loginViewModel;
    }

    public ChatViewModel getChatViewModel(){
        if(chatViewModel == null){
            chatViewModel = new ChatViewModel(modelFactory);
        }
        return chatViewModel;
    }
    public SignUpViewModel getSignUpViewModel(){
        if(signUpViewModel == null){
            signUpViewModel = new SignUpViewModel(modelFactory);
        }
        return signUpViewModel;
    }
}
