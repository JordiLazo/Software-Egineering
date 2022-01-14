package Question_3_RMI_and_Proxy.rmi.client.views.uppercase;

import Question_3_RMI_and_Proxy.rmi.client.model.TextConverter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UppercaseViewModel {
    private StringProperty request, reply, error;
    private TextConverter textConverter;

    public UppercaseViewModel(TextConverter textConverter) {
        this.textConverter = textConverter;
        request = new SimpleStringProperty();
        reply = new SimpleStringProperty();
        error = new SimpleStringProperty();
    }

    void convert() {
        String input = request.get();
        if(input != null && !"".equals(input)) {
            String result = textConverter.toUppercase(input);
            reply.set(result);
        } else {
            error.set("Input cannot be empty");
        }
    }

    StringProperty requestProperty() {
        return request;
    }

    StringProperty replyProperty() {
        return reply;
    }

    StringProperty errorProperty() {
        return error;
    }
}
