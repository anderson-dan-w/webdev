/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webdevhw4;

/**
 *
 * @author dwanderson
 */
public class Submarine extends Ship {
    static private int numSubmarines = 0;
    private int numberTorpedos; 

    /**
     * Default constructor for a Destroyer
     */
    public Submarine() {
        super();
        this.setName("Submarine" + numSubmarines);
        this.setType("Submarine");
        this.numberTorpedos = 2;
        numSubmarines++;
    }
    
    /**
     * Customized constructor
     * @param name
     * @param type
     * @param length
     * @param speed
     * @param numberTorpedos 
     */
    public Submarine(String name, String type, int length, int speed,
                    int numberTorpedos) {
        super(name, type, length, speed);
        if (numberTorpedos >= 0) {
            this.numberTorpedos = numberTorpedos;
        } else {
            System.out.println("A negative torpedo count has no meaning; " +
                    "setting torpedo count to 2.");
            this.numberTorpedos = 2;
        }
        numSubmarines++;
    }
    
    /**
     * Customizes the string-representation
     * @return 
     */
    @Override
    public String toString() {
        String string = super.toString() + " Furthermore, we are burnin' on " +
                this.numberTorpedos + " torpedos.";
        return string;
    }
    
    /**
     * Returns the number of torpedos
     * @return the numberTorpedos
     */
    public int getNumberTorpedos() {
        return numberTorpedos;
    }

    /**
     * Sets the number of torpedos to the given int
     * @param numberTorpedos the numberTorpedos to set
     */
    public void setNumberTorpedos(int numberTorpedos) {
        if (numberTorpedos >= 0) {
            this.numberTorpedos = numberTorpedos;
        } else {
            System.out.println("A negative torpedo count has no meaning; " +
                    "leaving current value for torpedo count, " + 
                    this.numberTorpedos + " intact.");
        }
    }
    
    public void setNumberTorpedos(String numberTorpedos) {
        int defaultNumberTorpedos = 2;
        try {
            int numberTorpedosInt = Integer.parseInt(numberTorpedos);
            setNumberTorpedos(numberTorpedosInt);
        } catch (NumberFormatException e) {
            System.out.println("Unable to parse String into an int; setting " +
                    "default value of numberTorpedos to " +
                    defaultNumberTorpedos);
        }
    }
}
