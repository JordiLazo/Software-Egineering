package temperature_clock.external;

public class TestClass {
    public static void main(String[] args) {
        RunnableClock c1 = new RunnableClock();
        Thread t1 = new Thread(c1);
        t1.start();

    }
}
