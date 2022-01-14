package Question_1_Sockets_and_Strategy_Pattern.sockets.client.views;

import Question_1_Sockets_and_Strategy_Pattern.sockets.client.core.ViewHandler;
import Question_1_Sockets_and_Strategy_Pattern.sockets.client.core.ViewModelFactory;

public interface ViewController {

    void init(ViewHandler vh, ViewModelFactory vmf);

}
