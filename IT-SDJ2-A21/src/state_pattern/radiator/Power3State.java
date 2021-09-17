package state_pattern.radiator;

public class Power3State implements RadiatorState {
    private static final int POWER = 3;
    private Thread t1;

    public Power3State(Radiator radiator) {
        t1 = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            radiator.setPowerState(new Power2State());
        });
        t1.setDaemon(true);
        t1.start();
    }

    @Override
    public void turnUp(Radiator radiator) {
        return;
    }

    @Override
    public void turnDown(Radiator radiator) {
        t1.interrupt();
    }

    @Override
    public int getPower() {
        return POWER;
    }
}
