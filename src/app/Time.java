package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {
    private int year, month, day, hour, minute, second, am_pm;
    private static SimpleDateFormat sd;
    
    public static final int YEAR = 0;
    public static final int MONTH = 1;
    public static final int DAY = 2;
    public static final int HOUR = 3;
    public static final int MINUTE = 4;
    public static final int SECOND = 5;
    public static final int AM_PM = 6;
    public static final int WEEKS = 7;
    
    public Time() {
        init();
        setNew(new Date());
    }
    
    public Time(String str) throws ParseException { // 27/02/2012 02:00:00 AM
        init();
         setNew(sd.parse(str));
    }
    
    private void init() {
        sd = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
    }
    
    public void setNew(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        setYear(cal.get(Calendar.YEAR));
        setMonth((cal.get(Calendar.MONTH)) + 1);
        setDay(cal.get(Calendar.DAY_OF_MONTH));
        setHour(cal.get(Calendar.HOUR));
        setMinute(cal.get(Calendar.MINUTE));
        setSecond(cal.get(Calendar.SECOND));
        setAm_pm(cal.get(Calendar.AM_PM));
    }
    
    public static int difDates(Time t1, Time t2, int choice) throws ParseException {
        Date time1 = sd.parse(t1.toString());
        Date time2 = sd.parse(t2.toString());
        
        switch(choice) {
            case SECOND: 
                return Math.abs((int)(time1.getTime() - time2.getTime()) 
                 / (1000));
            case MINUTE: 
                return Math.abs((int)(time1.getTime() - time2.getTime()) 
                 / (1000 * 60));
            case HOUR: 
                return Math.abs((int)(time1.getTime() - time2.getTime()) 
                 / (1000 * 60 * 60));
            case DAY: 
                return Math.abs((int)(time1.getTime() - time2.getTime()) 
                 / (1000 * 60 * 60 * 24))+1;
            case WEEKS:
                return (int)(difDates(t1, t2, 1) / 7);
            default:
                return 0;
        }
    }
    
    public static String difTimes(Time t1, Time t2) {
        try {
            Date time1 = sd.parse(t1.toString());
            Date time2 = sd.parse(t2.toString());
        
            int sec = Math.abs((int)(time1.getTime() - time2.getTime()) 
                     / (1000));

            int newhours = sec / (60 * 60);
            sec -= (newhours * (60 * 60));

            int newmin = sec / 60;
            sec -= (newmin * 60);

            return ((newhours < 10) ? "0"+newhours : newhours) + ":" +
                    ((newmin < 10) ? "0"+newmin : newmin);
        
        }catch(Exception e) {
            System.out.println("ERROR on diffTime at Time.java: "+e.getMessage());
        }
        
        return "00:00";
    }
    
    public String toString() {
        return getDate(true) + " " + getTime(true);
    }
    
    public String getDate(boolean year) {
        String d = (year == true) ? "/"+getYear() : "";
        return ((getDay() < 10) ? "0"+getDay() : getDay())+"/"+
                ((getMonth() < 10) ? "0"+getMonth() : getMonth()) + d;
    }
    
    public String getTime(boolean am_pm) {
        String t = "";
        if(am_pm == true){
            t += (getAm_pm() == 1) ? " PM" : " AM";  
        }
        return (
                (getHour() < 10) ? "0"+getHour() : getHour()) + ":" +
                ((getMinute() < 10) ? "0"+getMinute() : getMinute()) + ":" +
                ((getSecond() < 10) ? "0"+getSecond() : getSecond()) + t;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * @return the hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * @param hour the hour to set
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * @return the minute
     */
    public int getMinute() {
        return minute;
    }

    /**
     * @param minute the minute to set
     */
    public void setMinute(int minute) {
        this.minute = minute;
    }

    /**
     * @return the second
     */
    public int getSecond() {
        return second;
    }

    /**
     * @param second the second to set
     */
    public void setSecond(int second) {
        this.second = second;
    }

    /**
     * @return the am_pm
     */
    public int getAm_pm() {
        return am_pm;
    }

    /**
     * @param am_pm the am_pm to set
     */
    public void setAm_pm(int am_pm) {
        this.am_pm = am_pm;
    }
    
    public void addHours(int num){
        int h = getHour();
        int total = (h + num) - 12;
        if(total >= 0) {
            setHour(total);
            setAm_pm((getAm_pm() == -1) ? 0 : -1);
        }else {
            setHour(h + num);
        }
    }
    
}
