/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webdevhw4;

/**
 *
 * @author dwanderson
 */
public interface Contact {
    
    /**
     * Returns the length
     * @return 
     */
    int getLength();
    
    /**
     * Sets the length
     * @param length int value for length
     */
    void setLength(int length);
    
    /**
     * Returns the speed
     * @return 
     */
    int getSpeed();
    
    /**
     * Sets the speed, when given as an int
     * @param speed int value for speed
     */
    void setSpeed(int speed);
    
    /**
     * Sets the speed, when given as a String
     * @param speed String value for speed, must succeed Integer.parseInt
     */
    void setSpeed(String speed);
    
    /**
     * Returns the name
     * @return 
     */
    String getName();
    
    /**
     * Sets the name to the provided String
     * @param name String value for name
     */
    void setName(String name);
    
    /**
     * Returns the type, as a String
     * @return 
     */
    String getType();
    
    /**
     * Sets the type to the provided String
     * @param type String value for type
     */
    void setType(String type);
}
