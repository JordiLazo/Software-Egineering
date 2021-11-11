package observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class MessagePublisher implements Subject{

    private final List<Observer> listOfObservers = new ArrayList<>();

    @Override
    public void attachSubscriber(Observer o) {
        listOfObservers.add(o);
    }

    @Override
    public void detachSubscriber(Observer o) {
        listOfObservers.remove(o);
    }

    @Override
    public void notifyUpdate(Message message) {
        for(Observer allSubscribers: listOfObservers){
            allSubscribers.updateMessage(message);
        }
    }
}
