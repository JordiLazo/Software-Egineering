package threads.temperature_clock.external;

import threads.temperature_clock.view.TemperatureViewController;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RunnableClock implements Runnable{
    public TemperatureViewController test;

    public RunnableClock(TemperatureViewController test) {
        this.test = test;
    }

    @Override
    public void run() {
        while (true){
            LocalTime time = LocalTime.now();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String timeString = time.format(timeFormatter);
            System.out.println(timeString);
            test.showTime(timeString);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }

}
