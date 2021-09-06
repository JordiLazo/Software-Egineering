package temperature_clock.external;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RunnableClock implements Runnable{

    public void showTime(String timeString){
        System.out.println(timeString);

    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis(); //fetch starting time
        while((System.currentTimeMillis() - startTime) < 1000){
            LocalTime time = LocalTime.now();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String timeString = time.format(timeFormatter);
            showTime(timeString);

        }

    }

}
