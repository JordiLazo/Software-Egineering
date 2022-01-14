package Question_1_Sockets_and_Strategy_Pattern.sockets.client.core;

import Question_1_Sockets_and_Strategy_Pattern.sockets.client.model.TextConverter;
import Question_1_Sockets_and_Strategy_Pattern.sockets.client.model.TextConverterManager;

public class ModelFactory {

    private TextConverter textConverter;
    private final ClientFactory cf;

    public ModelFactory(ClientFactory cf) {
        this.cf = cf;
    }

    public TextConverter getTextConverter() {
        if(textConverter == null)
            textConverter = new TextConverterManager(cf.getClient());
        return textConverter;
    }
}


