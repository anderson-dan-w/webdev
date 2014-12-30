/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webdevhw4;

/**
 *
 * @author dwanderson
 */
public class P3 extends Aircraft {
    static private int numP3s = 0;
    private int numberEngines;

    public P3() {
        super();
        this.numberEngines = 2;
        this.setName("P3_" + numP3s);
        this.setType("P3");
        numP3s++;
    }
    
    public P3(String name, String type, int length, int speed, int altitude,
            int numberEngines) {
        super(name, type, length, speed, altitude);
        if (numberEngines >= 0) {
            this.numberEngines = numberEngines;
        } else {
            System.out.println("A negative engine count has no meaning; " +
                    "setting current value for engine count to 2.");
            this.numberEngines = 2;
        }
        numP3s++;
    }
    
    /**
     * Customizes the string-representation
     * @return 
     */
    @Override
    public String toString() {
        String string = super.toString() + " Furthermore, we are burnin' on " +
                this.numberEngines + " engines.";
        return string;
    }
    
    /**
     * Returns the number of engines
     * @return the numberEngines
     */
    public int getNumberEngines() {
        return numberEngines;
    }

    /**
     * Sets the number of engines
     * @param numberEngines the numberEngines to set
     */
    public void setNumberEngines(int numberEngines) {
        if (numberEngines >= 0) {
            this.numberEngines = numberEngines;
        } else {
            System.out.println("A negative engine count has no meaning; " +
                    "leaving current value for engine count, " + 
                    this.numberEngines + " intact.");
        }
    }
}
