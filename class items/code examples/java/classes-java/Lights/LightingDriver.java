package classes.Lights;

import java.util.ArrayList;


public class LightingDriver {
    public static void main(String[] args) {
        //classes.Lights??? Why the dot?
        // need the full folder chain for the package


        //related topic on details for importing
        //Typically import out to the file. E.g.
        //import classes.SubClass;
        //SubClass c = new SubClass();

        //with no import, need chain from "highest" available package
        //that no package right now.
        classes.SubClass c = new classes.SubClass();

        ArrayList<Lightbulb> lights = new ArrayList<>();

        //make lights
        for(int i = 0; i < 3; i ++){
            lights.add(new Lightbulb(3));
        }
        lights.add(new ColorLight("red"));
        lights.add(new ColorLight("blue"));

        //simulate turning lights on and off
        boolean allAlive = true;
        int count = 0;
        while(allAlive){
            count++;
            for(Lightbulb light : lights){
                light.turnOn(Math.random()*10);
                allAlive = allAlive && light.isAlive();
                System.out.println(light);
            }
        }
        System.out.println("Lights lasted: " + count + " times");
    }
}
