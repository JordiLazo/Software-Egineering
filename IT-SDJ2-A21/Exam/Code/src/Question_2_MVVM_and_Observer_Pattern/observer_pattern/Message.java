package Question_2_MVVM_and_Observer_Pattern.observer_pattern;

public class Message {

    private final String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
