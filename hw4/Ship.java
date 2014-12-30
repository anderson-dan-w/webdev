/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webdevhw4;

/**
 *
 * @author dwanderson
 */
public abstract class Ship implements Contact {
    static private int numShips = 0;
    
    private int length;
    private int speed;
    private String name;
    private String type;

    /**
     * Default constructor for Ship
     */
    public Ship() {
        this.name = "Ship" + numShips;
        this.type = "Ship";
        this.length = 0;
        this.speed = 0;
        numShips++;
        
    }
    
    /**
     * Customized constructor
     * @param name
     * @param type
     * @param length
     * @param speed 
     */
    public Ship(String name, String type, int length, int speed) {
        this.name = name;
        this.type = type;
        if (length >= 0) {
            this.length = length;
        } else {
            System.out.println("A negative length has no meaning; setting " +
                    "current value for length to 0.");
            this.length = 0;
        }
        if (speed >= 0) {
            this.speed = speed;
        } else {
            System.out.println("A negative speed has no meaning; setting " +
                    "current value for speed to 0.");
            this.speed = 0;
        }
        numShips++;
    }
    
    /**
     * Customizes the string representation
     * @return 
     */
    @Override
    public String toString() {
        String string = "What we've got here is a " + this.type + " by th'" +
                "name of " + this.name + ", which is " + this.length +
                " units long " + "and cruising at a speed of " + this.speed +
                " mph.";
        
        return string;
    }
    /**
     * @return the length
     */
    @Override
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    @Override
    public void setLength(int length) {
        if (length >= 0) {
            this.length = length;
        } else {
            System.out.println("A negative length has no meaning; leaving " +
                    "current value for length, " + this.length + " intact.");
        }
    }
    
    /**
     * @return the speed
     */
    @Override
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    @Override
    public void setSpeed(int speed) {
        if (speed >= 0) {
            this.speed = speed;
        } else {
            System.out.println("A negative speed has no meaning; leaving " +
                    "current value for speed, " + this.speed + " intact.");
        }
    }

    /**
     * 
     * @param speed 
     */
    @Override
    public void setSpeed(String speed) {
        try {
            int speed_int;
            speed_int = Integer.parseInt(speed);
            setSpeed(speed_int);
        } catch (NumberFormatException e) {
            System.out.println("Need to provide a number that passes a call " +
                    "to Integer.parseInt to set the speed.");
        }
    }
    
    /**
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    @Override
    public void setType(String type) {
        this.type = type;
    }
    
}
