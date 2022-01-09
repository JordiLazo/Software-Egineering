package observer_pattern;

public class RunApp {
    public static void main(String[] args) {
        MessagePublisher messagePublisher = new MessagePublisher();
        SubscriberOne s1 = new SubscriberOne();
        SubscriberTwo s2 = new SubscriberTwo();
        SubscriberThree s3 = new SubscriberThree();

        messagePublisher.attachSubscriber(s1);
        messagePublisher.attachSubscriber(s2);

        messagePublisher.notifyUpdate(new Message("Users 1 and 2 have subscribe, now they are Subscribers "));

        messagePublisher.detachSubscriber(s2);
        messagePublisher.attachSubscriber(s3);

        messagePublisher.notifyUpdate(new Message("Subscriber 2 has been deleted and User 3 have subscribe"));
    }
}
