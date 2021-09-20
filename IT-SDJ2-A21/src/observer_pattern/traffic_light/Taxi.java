package observer_pattern.traffic_light;

public class Taxi implements Users {
    private int id;

    public Taxi(int id) {
        this.id = id;
    }

    @Override
    public void lightChanged(String light) {

        if("GREEN".equals(light)) {
            System.out.println("Taxi " + id + " drives super fast");
        } else if("RED".equals(light)) {
            System.out.println("Taxi " + id + " stops with screething tires");
        }
    }
}
