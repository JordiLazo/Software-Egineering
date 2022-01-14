package Question_3_RMI_and_Proxy.rmi.client.views;

import Question_3_RMI_and_Proxy.rmi.client.core.ViewHandler;
import Question_3_RMI_and_Proxy.rmi.client.core.ViewModelFactory;

public interface ViewController {

    void init(ViewHandler vh, ViewModelFactory vmf);

}
