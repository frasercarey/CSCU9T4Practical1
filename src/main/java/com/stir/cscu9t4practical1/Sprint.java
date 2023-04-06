package com.stir.cscu9t4practical1;

/**
 *
 * @author Fraser Carey
 */
public class Sprint extends Entry {
    
    private int noOfSprints;
    private int recoveryTime;
    private float totalDistance;
    
    public Sprint(String n, int d, int m, int y, int h, int min, int s, float dist, int sprints, int recovery) {
        super(n, d, m, y, h, min, s, dist);
        noOfSprints = sprints;
        recoveryTime = recovery;
        totalDistance = sprints * dist;
    }

    public int getNoOfSprints() {
        return noOfSprints;
    }

    public int getRecoveryTime() {
        return recoveryTime;
    }

    public float getTotalDistance() {
        return totalDistance;
    }
 
    @Override
    public String getEntry() {
        return getName() + " ran " + getNoOfSprints() + "x"
             + getDistance() + "km (" + getTotalDistance() + "km total), "
                + "with a recovery time of " + getRecoveryTime() + "mins in "
             + getHour() + ":" + getMin() + ":" + getSec() + " on "
             + getDay()+ "/" + getMonth() + "/" + getYear()+ "\n"; 
    }   
}