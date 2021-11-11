package observer_pattern;


public interface Subject {
    void attachSubscriber (Observer o);
    void detachSubscriber (Observer o);
    void notifyUpdate (Message message);
}
