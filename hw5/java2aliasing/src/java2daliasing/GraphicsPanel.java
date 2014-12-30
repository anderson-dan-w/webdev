/*
 * GraphicsPanel.java
 *
 * Created on September 23, 2007, 3:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package java2daliasing;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 *
 * @author evansrb1
 */
public class GraphicsPanel extends JPanel {
    // the font which we will use
    Ellipse2D circle1 = new Ellipse2D.Double(10, 10, 100, 100);
    Ellipse2D circle2 = new Ellipse2D.Double(120, 10, 100, 100);

    /** Creates a new instance of GraphicsPanel */
    public GraphicsPanel() {
        // call superclass constructor, use null as a layout manager 
        // (we don't need it for this example)'
        super(null);
        // set the preferred size of the JPanel, so pack() in JFrame will work!
        setPreferredSize(new Dimension(500, 300));
    }

    // this is the actuall method you should override to have painting occur
    // in the JPanel
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        super.paintComponent(g);
        g2d.draw(circle1);
        // turn anti-aliasing on
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.draw(circle2);
        // turn anti-aliasing off        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,        
                RenderingHints.VALUE_ANTIALIAS_OFF);                
        g2d.drawString("aliased", 40, 65);
        g2d.drawString("anti-aliased", 140, 65);
    }
}
