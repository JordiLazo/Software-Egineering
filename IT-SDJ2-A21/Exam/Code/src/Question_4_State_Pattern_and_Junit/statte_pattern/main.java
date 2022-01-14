package Question_4_State_Pattern_and_Junit.statte_pattern;

public class main {
    public static void main(String[] args) throws InterruptedException {
        Radiator r = new Radiator();
        r.setPowerState(new Power3State(r));
        System.out.println("Radiator level : " + r.getPower());
        System.out.println("Waiting...");
        Thread.sleep(3000);

        System.out.println(r.getPower());
    }
}
