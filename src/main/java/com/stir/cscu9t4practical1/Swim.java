package com.stir.cscu9t4practical1;

/**
 *
 * @author Fraser Carey
 */
public class Swim extends Entry {
    
    private String where;
    
    public Swim(String n, int d, int m, int y, int h, int min, int s, float dist, String where) {
        super(n, d, m, y, h, min, s, dist);
        this.where = where;
    }
    
    public String getWhere() {
        if (where.equalsIgnoreCase("pool"))
            return "in a pool";
        else if (where.equalsIgnoreCase("outdoors"))
            return "outdoors";
        else
            return "unknown";
    }
    
    @Override
    public String getEntry() {
        return getName() + " swam " + getDistance() + " km " + getWhere() + " in "
             + getHour() + ":" + getMin() + ":" + getSec() + " on " + getDay() + "/" 
             + getMonth() + "/" + getYear() + "\n";
    }
}