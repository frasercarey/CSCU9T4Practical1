package com.stir.cscu9t4practical1;

import java.util.Calendar;

/**
 *
 * @author Fraser Carey
 */
public class Entry {
    
    protected String name;
    private Calendar dateAndTime;
    protected float distance;
    
    public Entry(String n, int d, int m, int y, int h, int min, int s, float dist) {
        name = n;
        Calendar inst = Calendar.getInstance();
        inst.set(y, m-1, d, h, min, s);
        dateAndTime = inst;
        distance = dist;
    }

    public String getName() {
        return name;
    }

    public int getDay() {
        return dateAndTime.get(Calendar.DATE);
    }
    
    public int getMonth() {
        return dateAndTime.get(Calendar.MONTH) + 1;
    } 
   
    public int getYear() {
        return dateAndTime.get(Calendar.YEAR);
    }

    public int getHour() {
        return dateAndTime.get(Calendar.HOUR);
    }

    public int getMin() {
        return dateAndTime.get(Calendar.MINUTE);
    }

    public int getSec() {
        return dateAndTime.get(Calendar.SECOND);
    }

    public float getDistance() {
        return distance;
    }

    public String getEntry() {
        return getName()+" completed a distance of " + getDistance() + " km in "
             + getHour() + ":" + getMin() + ":" + getSec() + " on "
             + getDay()+ "/" +getMonth() + "/" + getYear() + "\n";
    }
}