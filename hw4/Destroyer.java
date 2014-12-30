/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webdevhw4;

/**
 *
 * @author dwanderson
 */
public class Destroyer extends Ship {
    
    static private int numDestroyers = 0;
    private int numberMissiles;
    

    /**
     * Default constructor for a Destroyer
     */
    public Destroyer() {
        super();
        this.setName("Destroyer" + numDestroyers);
        this.setType("Destroyer");
        this.numberMissiles = 2;
        numDestroyers++;
    }
    
    /**
     * Customized constructor
     * @param name
     * @param type
     * @param length
     * @param speed
     * @param numberMissiles 
     */
    public Destroyer(String name, String type, int length, int speed,
                    int numberMissiles) {
        super(name, type, length, speed);
        if (numberMissiles >= 0) {
            this.numberMissiles = numberMissiles;
        } else {
            System.out.println("A negative missile count has no meaning; " +
                    "setting current value for missile count to 2.");
            this.numberMissiles = 2;
        }
        numDestroyers++;
    }
    
    /**
     * Customizes the string-representation
     * @return 
     */
    @Override
    public String toString() {
        String string = super.toString() + " Furthermore, we are burnin' on " +
                this.numberMissiles + " missiles.";
        return string;
    }
    
    
    /**
     * Returns the number of missiles
     * @return the numberMissiles
     */
    public int getNumberMissiles() {
        return numberMissiles;
    }

    /**
     * Sets the number of missiles, from the provided int
     * @param numberMissiles the numberMissiles to set
     */
    public void setNumberMissiles(int numberMissiles) {
        if (numberMissiles >= 0) {
            this.numberMissiles = numberMissiles;
        } else {
            System.out.println("A negative missile count has no meaning; " +
                    "leaving current value for missile count, " + 
                    this.numberMissiles + " intact.");
        }
    }
    
    /**
     * Sets number of missiles, from provided String, which ought to pass a
     * call to Integer.parseInt, with a failure defaulting to numberMissiles
     * being set to 2.
     * @param numberMissiles 
     */
    public void setNumberMissiles(String numberMissiles) {
        int defaultNumberMissiles = 2;
        try {
            int numberMissilesInt = Integer.parseInt(numberMissiles);
            setNumberMissiles(numberMissilesInt);
        } catch (NumberFormatException e) {
            System.out.println("Unable to parse String into an int; setting " +
                    "default value of numberMissiles to " +
                    defaultNumberMissiles);
        }
    }
}
