package client.views.chat;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import shared.transferobjects.Message;

public class ChatViewController implements ViewController {
    @FXML
    public ListView<Message> messagesList;
    public TextField messageFromUser;
    public ListView<String> usersList;

    private ViewHandler viewHandler;
    private ChatViewModel chatViewModel;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        chatViewModel = viewModelFactory.getChatViewModel();
        chatViewModel.loadMessages();
        messagesList.setItems(chatViewModel.getListOfMessages());
        usersList.setItems(chatViewModel.getUsersList());
    }

    @FXML
    public void onSendMessageButton() {
        chatViewModel.sendMessage(messageFromUser.getText());
        messageFromUser.clear();
    }

    @FXML
    public void onBackButton(ActionEvent actionEvent) {
        viewHandler.openToLogIn();
    }
}
