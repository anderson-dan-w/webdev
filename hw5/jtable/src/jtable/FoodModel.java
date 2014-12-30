/*
 * FoodModel.java
 *
 * Created on September 29, 2007, 9:11 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jtable;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author evansrb1
 */
public class FoodModel extends AbstractTableModel{
    private ArrayList<Food> foods = new ArrayList<Food>();
    private String[] headers = {"Name", "Cost", "Description", "Type"};
    /** Creates a new instance of FoodModel */

    public FoodModel() {
        initData();
    }
    
    public int getRowCount() {
        return foods.size();
    }

    public int getColumnCount() {
        return 4;
    }
    
    public Class getColumnClass(int column) {
        if (column == 3) {
            return ImageIcon.class;
        } else {
            return String.class;
        }
    }
    
    public String getColumnName(int columnIndex) {
        return headers[columnIndex];
    }
    
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return foods.get(row).getName();
            case 1:
                return foods.get(row).getCost();
            case 2:
                return foods.get(row).getDescription();
            case 3:
                return foods.get(row).getIcon();
            default:
                System.err.println("Ooops");
                return null;
        }
    }
    
    private void initData() {
        foods.add(new Food("Coca Cola", "1.00", "12 oz Can of Coke", new ImageIcon(getClass().getResource("soda.gif"))));
        foods.add(new Food("Sprite", "1.00", "12 oz Can of Sprint", new ImageIcon(getClass().getResource("soda.gif"))));        
        foods.add(new Food("Blueberry Muffin", "1.50", "Blueberry Muffin", new ImageIcon(getClass().getResource("muffin.gif"))));                
        foods.add(new Food("Banana Muffin", "1.50", "Banana Muffin", new ImageIcon(getClass().getResource("muffin.gif"))));                        
        foods.add(new Food("Bran Muffin", "1.50", "Lowfat Bran Muffin", new ImageIcon(getClass().getResource("muffin.gif"))));                                
        foods.add(new Food("Apple", "0.50", "Red Delicious", new ImageIcon(getClass().getResource("fruit.gif"))));                                
        foods.add(new Food("IBC Root Beer", "1.20", "16 oz bottle", new ImageIcon(getClass().getResource("bottlesoda.gif"))));                                        
        foods.add(new Food("Cheese Pizza", "5.20", "12 inch pizza", new ImageIcon(getClass().getResource("pizza.gif"))));                                                
        foods.add(new Food("Veggie Pizza", "5.20", "Onions and Peppers, 12 inch pizza", new ImageIcon(getClass().getResource("pizza.gif"))));                                                        
        foods.add(new Food("Submarine Sandwich", "2.50", "Roast Beef", new ImageIcon(getClass().getResource("sandwich.gif"))));                                                        
                
    }
}
