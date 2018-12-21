package watch;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

public class Watch {
    private final Timer timer;
    private LocalDateTime now;
    private final List<Observer> observers = new ArrayList<>();
    
    public Watch() {
        timer = new Timer();
        timer.schedule(timerTask(), 0, 1000);
    }

    private TimerTask timerTask() {
        return new TimerTask() {
            @Override
            public void run() {
                now = LocalDateTime.now();
                updateObservers();
            }

        };
    }
    
    private void updateObservers() {
        for (Observer observer : observers) 
            observer.update(null, null);
    }

    public double getSeconds() {
        return Math.PI/2 - (s() / 60.0) * 2 * Math.PI;
    }

    public double getMinutes() {
        return Math.PI/2 - ((s() + m() * 60.0) / (60.0 * 60)) * 2 * Math.PI;
    }

    public double getHours() {
        return Math.PI/2 - ((s() + m() * 60.0 + h() * 60.0 * 60) / (60.0 * 60 * 12)) * 2 * Math.PI;
    }

    public void add(Observer observer) {
        observers.add(observer);
    }

    private double normalize(double v) {
        return v % (2 * Math.PI);
    }

    private int s() {
        return now.getSecond();
    }

    private int m() {
        return now.getMinute();
    }

    private int h() {
        return now.getHour();
    }
}
