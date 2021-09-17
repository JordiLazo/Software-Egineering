package upper_case_mvvm.view.uppercase;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import upper_case_mvvm.model.TextConverter;

public class UppercaseViewModel {
    private StringProperty request;
    private StringProperty reply;
    private StringProperty error;
    private TextConverter textConverter;

    public UppercaseViewModel(TextConverter textConverter) {
        request = new SimpleStringProperty();
        reply = new SimpleStringProperty();
        error = new SimpleStringProperty();
        this.textConverter = textConverter;
    }

    public void convert(){
        String input = request.get();
        if (input != null && !"".equals(input)){
            String result = textConverter.toUppercase(input);
            reply.setValue(result);
        }else {
            error.set("Please insert words");
        }
    }

    public StringProperty errorProperty() {
        return error;
    }

    public StringProperty requestProperty(){
        return request;
    }

    public StringProperty replyProperty(){
        return reply;
    }

}
