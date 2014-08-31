package app;

import java.text.ParseException;

public class Clock {
    private Time currentTime, startTime;
    
    public Clock() {
        startTime = new Time();
        init();
    }
    
    private void init() {
        currentTime = new Time();
    }
    
    public String getCurrentTime() {
        init();
        return currentTime.getTime(true);
    }
    
    public String getPastTime() {
        return Time.difTimes(currentTime, startTime);
    }
    
    public String getDate(){
        return currentTime.getDate(false);
    }
    
    public void setStartTime(String start) {
        try {
            Time tmp = new Time(start);
            startTime = tmp;
        } catch (ParseException ex) {
        }
    }
    
    public void addTimeZone(int num) {
        startTime.addHours(num);
        currentTime.addHours(num);
    }
    
    public String toString() {
        return startTime.toString();
    }
    
}