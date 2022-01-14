package Question_3_RMI_and_Proxy.rmi.client.core;


import Question_3_RMI_and_Proxy.rmi.client.model.TextConverter;
import Question_3_RMI_and_Proxy.rmi.client.model.TextConverterManager;

public class ModelFactory {

    private final ClientFactory cf;
    private TextConverter textConverter;

    public ModelFactory(ClientFactory cf) {
        this.cf = cf;
    }

    public TextConverter getTextConverter() {
        if(textConverter == null)
            textConverter = new TextConverterManager(cf.getClient());
        return textConverter;
    }
}


