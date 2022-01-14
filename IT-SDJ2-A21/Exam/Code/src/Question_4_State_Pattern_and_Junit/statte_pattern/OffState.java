package Question_4_State_Pattern_and_Junit.statte_pattern;

public class OffState implements RadiatorState {
    private static final int POWER = 0;

    @Override
    public void turnUp(Radiator radiator) {
        radiator.setPowerState(new Power1State());
    }

    @Override
    public void turnDown(Radiator radiator) {
        return;
    }

    @Override
    public int getPower() {
        return POWER;
    }
}
