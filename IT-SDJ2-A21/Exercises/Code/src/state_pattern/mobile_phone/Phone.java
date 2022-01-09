package state_pattern.mobile_phone;

public class Phone implements PhoneState{
    private PhoneState currentState = new SoundState();
    private int currentVolume;

    public Phone() {
    }

    public void receiveMessage(String txt) {
        currentState.onReceiveMessage(txt,this);
    }

    public void receiveCall() {
        currentState.onReceiveCall(this);
    }

    public void volumeButtonUp(){
        currentState.onVolumeButtonUp(this);
    }

    public void volumeButtonDown(){
        currentState.onVolumeButtonDown(this);
    }

    public void goToSilent(){
        currentState = new SilentState();
    }

    public void goToVibrate() {
        currentState = new VibrateState();
    }

    public void goToSound() {
        currentState = new SoundState();
    }

    public void turnVolumeUp(){
        currentVolume++;
    }

    public void turnVolumeDown(){
        currentVolume--;
    }

    public void playRingTone(){
        System.out.println("RING TONE");
    }

    public void vibrate(){
        System.out.println("BRRRRRRRR");
    }

    public void lightUpScreen(){
        System.out.println("BRIGHT");
    }

    public void beepBeep(){
        System.out.println("BEEP-BEEP");
    }

    public int getVolume(){
        return currentVolume;
    }

    public void setCurrentState(PhoneState currentState){
        this.currentState = currentState;
    }


    @Override
    public void onReceiveMessage(String txt, Phone phone) {

    }

    @Override
    public void onReceiveCall(Phone phone) {

    }

    @Override
    public void onVolumeButtonUp(Phone phone) {

    }

    @Override
    public void onVolumeButtonDown(Phone phone) {

    }

}
