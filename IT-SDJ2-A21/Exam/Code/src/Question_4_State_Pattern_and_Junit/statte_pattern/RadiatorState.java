package Question_4_State_Pattern_and_Junit.statte_pattern;

public interface RadiatorState {
    void turnUp (Radiator radiator);
    void turnDown (Radiator radiator);
    int getPower();
}
