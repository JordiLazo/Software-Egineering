package observer_pattern;

public class main {
    public static void main(String[] args) throws InterruptedException {

        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(3);

        Taxi t1 = new Taxi(4);
        Taxi t2 = new Taxi(5);

        Pedestrian p1 = new Pedestrian(6);
        Pedestrian p2 = new Pedestrian(7);

        TrafficLight sem = new TrafficLight();

        sem.addUsers(car1);
        sem.addUsers(car2);
        sem.addUsers(car3);
        sem.addUsers(t1);
        sem.addUsers(t2);
        sem.addUsers(p1);
        sem.addUsers(p2);

        sem.start();
    }
}
