package model.radiator;

public class OffState implements RadiatorState {

    private static final int POWER = 0;

    @Override
    public void turnUp(RadiatorManager radiatorManager) {
        radiatorManager.setPowerState(new Power1State());
    }

    @Override
    public void turnDown(RadiatorManager radiatorManager) {
        return;
    }

    @Override
    public int getPower() {
        return POWER;
    }
}
