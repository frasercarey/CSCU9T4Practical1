package com.stir.cscu9t4practical1;

/**
 *
 * @author Fraser Carey
 */
public class Cycle extends Entry {
    
    private String terrain;
    private String tempo;
    
    public Cycle(String n, int d, int m, int y, int h, int min, int s, float dist, String ter, String tempo) {
        super(n, d, m, y, h, min, s, dist);
        terrain = ter;
        this.tempo = tempo;
    }

    public String getTerrain() {
        return terrain;    
    }
    
    public String getTempo() {
        return tempo;    
    }
    
    @Override
    public String getEntry() {
        return getName() + " cycled " + getDistance() + "km, on a "
             + getTerrain() + " terrain and tempo of " + getTempo() + " in "
             + getHour() + ":" + getMin()+ ":" + getSec() + " on "
             + getDay() + "/" + getMonth() + "/" + getYear() + "\n"; 
    }   
}