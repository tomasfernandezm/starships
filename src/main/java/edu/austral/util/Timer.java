package edu.austral.util;

public class Timer {

    private double interval;
    private double currentTime;

    public Timer(double interval) {
        this.interval = interval;
    }

    public void start(){
        currentTime = System.currentTimeMillis();
    }

    public boolean canOperate(){
        return (System.currentTimeMillis() - currentTime) >= interval;
    }
}
