package Question_1_Sockets_and_Strategy_Pattern.sockets.client;

import Question_1_Sockets_and_Strategy_Pattern.sockets.client.core.ClientFactory;
import Question_1_Sockets_and_Strategy_Pattern.sockets.client.core.ModelFactory;
import Question_1_Sockets_and_Strategy_Pattern.sockets.client.core.ViewHandler;
import Question_1_Sockets_and_Strategy_Pattern.sockets.client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class UppercaseApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory cf = new ClientFactory();
        ModelFactory mf = new ModelFactory(cf);
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();
    }
}
