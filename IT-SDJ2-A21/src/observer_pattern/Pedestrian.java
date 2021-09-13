package observer_pattern;

public class Pedestrian implements Users {
    private int id;

    public Pedestrian(int id) {
        this.id = id;
    }

    @Override
    public void lightChanged(String light) {

        if("GREEN".equals(light)) {
            System.out.println("Pedestrian " + id + " stops");
        } else if("RED".equals(light)) {
            System.out.println("Pedestrian " + id + " walks");
        }
    }


}
