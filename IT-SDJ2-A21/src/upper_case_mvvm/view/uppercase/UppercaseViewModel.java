package upper_case_mvvm.view.uppercase;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UppercaseViewModel {
    private StringProperty request;
    private StringProperty reply;
    private StringProperty error;

    public UppercaseViewModel() {
        request = new SimpleStringProperty();
        reply = new SimpleStringProperty();
        error = new SimpleStringProperty();
    }

    public void convert(){
        System.out.println(request.toString());
        if (request.getValue() == null){
            System.out.println("New message");
            error.setValue("Please insert a new value");
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
