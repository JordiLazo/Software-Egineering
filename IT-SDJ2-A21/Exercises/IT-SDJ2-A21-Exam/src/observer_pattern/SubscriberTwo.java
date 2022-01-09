package observer_pattern;

public class SubscriberTwo implements Observer{
    @Override
    public void updateMessage(Message m) {
        System.out.println("Subscriber two [notification]: "+m.getMessage());
    }
}
