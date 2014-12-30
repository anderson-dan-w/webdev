/*
 * Main.java
 *
 * Created on September 23, 2007, 3:20 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package awtgraphics_1;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
        

/**
 *
 * @author evansrb1
 */
public class Main extends JFrame {
    
    // the GraphicsPanel is the object where the drawing is going on,
    // the JFrame will just contain this panel
    private final JPanel panel = new GraphicsPanel();
    
    /** Creates a new instance of Main */
    public Main() {
        super("GradientPaint Examples");
        // add the panel to the center of the JFrame
        getContentPane().add(panel, BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Main();
    }
    
}
