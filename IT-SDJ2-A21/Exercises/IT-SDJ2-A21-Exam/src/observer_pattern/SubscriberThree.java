package observer_pattern;

public class SubscriberThree implements Observer{
    @Override
    public void updateMessage(Message m) {
        System.out.println("Subscriber three [notification]: "+m.getMessage());
    }
}
