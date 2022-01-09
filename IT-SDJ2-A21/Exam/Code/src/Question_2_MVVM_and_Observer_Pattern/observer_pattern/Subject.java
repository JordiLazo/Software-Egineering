package Question_2_MVVM_and_Observer_Pattern.observer_pattern;


public interface Subject {
    void attachSubscriber (Observer o);
    void detachSubscriber (Observer o);
    void notifyUpdate (Message message);
}
