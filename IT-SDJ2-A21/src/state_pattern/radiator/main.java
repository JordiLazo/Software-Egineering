package state_pattern.radiator;

public class main {
    public static void main(String[] args) throws InterruptedException {
        Radiator r = new Radiator();
        r.setPowerState(new Power3State(r));
        System.out.println("Radiator level : " + r.getPower());
        System.out.println("Waiting...");
        Thread.sleep(11000);

        System.out.println(r.getPower());
    }
}
