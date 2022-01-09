package observer_pattern;

public class SubscriberOne implements Observer{
    @Override
    public void updateMessage(Message m) {
        System.out.println("Subscriber one [notification]: "+m.getMessage());
    }
}
