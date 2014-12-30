/*
 * Main.java
 *
 * Created on September 28, 2007, 2:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jtable;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author evansrb1
 */
public class Main extends JFrame {
    
    private final JTable table;
    
    /** Creates a new instance of Main */
    public Main() {
        super("JTree w/ custom Model");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table = new JTable(new FoodModel());
        add(new JScrollPane(table));
        table.setRowHeight(30);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.pack();
        main.setVisible(true);
    }
    
}
