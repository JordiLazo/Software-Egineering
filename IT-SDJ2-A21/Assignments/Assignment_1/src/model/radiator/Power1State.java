package model.radiator;

public class Power1State implements RadiatorState {

    private static final int POWER = 1;

    @Override
    public void turnUp(RadiatorManager radiatorManager) {
        radiatorManager.setPowerState(new Power2State());
    }

    @Override
    public void turnDown(RadiatorManager radiatorManager) {
        radiatorManager.setPowerState(new OffState());
    }

    @Override
    public int getPower() {
        return POWER;
    }
}
