/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webdevhw4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dwanderson
 */
public class WebDevHW4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final List<Destroyer> destroyers = new ArrayList<>();
        destroyers.add(new Destroyer());
        destroyers.add(new Destroyer("This Destroys", "Destroyer", 100, 10, 3));
        
        final List<Submarine> submarines = new ArrayList<>();
        submarines.add(new Submarine("A sub", "Sub", -100, -10, -10));
        System.out.println("There should be some error-handling above...\n");
        submarines.add(new Submarine());
        submarines.get(1).setNumberTorpedos("Foo");
        System.out.println("There should be some error-handling above...\n");
        
        final List<Ship> ships = new ArrayList<>();
        ships.addAll(destroyers);
        ships.addAll(submarines);
        
        final List<P3> p3s = new ArrayList<>();
        p3s.add(new P3());
        p3s.add(new P3("Another P3", "plane", 50, 300, 40000, 6));
        p3s.add(new P3("One more P3", "P3", -50, -200, -1000, -3));
        System.out.println("There should be some error-handling above...\n");
        
        final List<Aircraft> aircrafts = new ArrayList<>();
        aircrafts.addAll(p3s);
        
        System.out.println("Let's print info on all our ships:");
        for (int i=0; i < ships.size(); i++) {
            System.out.println(ships.get(i));
        }
        
        System.out.println("\nLet's print info on all our aircraft(s)");
        for (int i=0; i < aircrafts.size(); i++) {
            System.out.println(aircrafts.get(i));
        }
    }
}
