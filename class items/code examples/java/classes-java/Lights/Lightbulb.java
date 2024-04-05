package classes.Lights;

import java.text.DecimalFormat;

/**
 * General class for a lightbulb
 */
public class Lightbulb {

    private double lifetime = 10;
    public final static double LIFE_PER_USE = 0.3;


    /**
     * Constructor that requires  the power draw and how long the light should last
     * @param lifetime how long the lightbulb should last
     */
    public Lightbulb(double lifetime){
        //'this' is THIS instance
        this.lifetime = lifetime;
    }

    /**
     * Adds the total power consumption to the lightbulb for the given time period and
     * decreases the lifetime by one.
     * @param time how long the light is on
     */
    public void turnOn(double time){

        if(isAlive()) {
            lifetime -= time * LIFE_PER_USE;

            if(!isAlive()) {
                lifetime = 0;
            }
        }
    }

    /**
     * returns true if the light can still turn on
     * @return if their is life left is the bulb, this returns true
     */
    public boolean isAlive(){
        return lifetime>0;
    }

    /**
     * Returns the status of the light
     * @return the status of the light
     */
    public String toString(){
        DecimalFormat format = new DecimalFormat("#.##");
        return "The lightbulb has " + format.format(lifetime)  + " life left.";
    }
}
