package Question_3_RMI_and_Proxy.rmi.client;

import Question_3_RMI_and_Proxy.rmi.client.core.ClientFactory;
import Question_3_RMI_and_Proxy.rmi.client.core.ModelFactory;
import Question_3_RMI_and_Proxy.rmi.client.core.ViewHandler;
import Question_3_RMI_and_Proxy.rmi.client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class UppercaseApp extends Application {
    private ClientFactory cf;

    @Override
    public void start(Stage stage) throws Exception {
        cf = new ClientFactory();
        ModelFactory mf = new ModelFactory(cf);
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Stop");
        cf.getClient().unRegisterClient();
    }
}
