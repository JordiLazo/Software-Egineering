package model.radiator;

public class Power3State implements RadiatorState {

    private static final int POWER = 3;
    private Thread t1;

    public Power3State(RadiatorManager radiatorManager) {
        t1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            radiatorManager.setPowerState(new Power2State());
        });
        t1.setDaemon(true);
        t1.start();
    }

    @Override
    public void turnUp(RadiatorManager radiatorManager) {
        return;
    }

    @Override
    public void turnDown(RadiatorManager radiatorManager) {
        t1.interrupt();
    }

    @Override
    public int getPower() {
        return POWER;
    }
}
