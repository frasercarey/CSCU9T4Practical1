package com.stir.cscu9t4practical1;

/**
 *
 * @author Fraser Carey
 */
public class Run extends Entry {
    
    public Run(String n, int d, int m, int y, int h, int min, int s, float dist) {
        super(n, d, m, y, h, min, s, dist);
    }
    
    @Override
    public String getEntry() {
        return getName()+" ran a distance of " + getDistance() + " km in "
             +getHour() + ":" + getMin() + ":" + getSec() + " on "
             +getDay() + "/" + getMonth() + "/" + getYear() + "\n";
    }
}