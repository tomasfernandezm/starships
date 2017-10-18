package edu.austral.util;

public class Timer {

    private double interval;
    private double currentTime;

    public Timer(double interval) {
        this.interval = interval;
        currentTime = System.currentTimeMillis();
    }

    public void restart(){
        currentTime = System.currentTimeMillis();
    }

    public boolean canOperate(){
        return (System.currentTimeMillis() - currentTime) >= interval;
    }

    public void changeInterval(double interval){
        this.interval = interval;
        restart();
    }
}
