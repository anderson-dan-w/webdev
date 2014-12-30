/*
 * GraphicsPanel.java
 *
 * Created on September 23, 2007, 3:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package awtgraphics_1;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.net.*;
import java.awt.geom.*;

/**
 *
 * @author evansrb1
 */
public class GraphicsPanel extends JPanel {
    // the font which we will use
    Font font = new Font("Sans Serif", Font.BOLD, 24);
    // holder for the url of the image
    URL url = null;
    // holder for the image itself
    BufferedImage bi = null;
    GradientPaint gp = new GradientPaint(30, 30, Color.BLUE, 80, 20, Color.WHITE, true);
    Ellipse2D.Double c1 = new Ellipse2D.Double(10, 10, 60, 60);
    Ellipse2D.Double c2 = new Ellipse2D.Double(10, 80, 60, 60);
    Ellipse2D.Double c3 = new Ellipse2D.Double(40, 40, 60, 60);
    Ellipse2D.Double c4 = new Ellipse2D.Double(160, 140, 60, 60);
    Ellipse2D.Double c5 = new Ellipse2D.Double(40, 25, 120, 120);
    Ellipse2D.Double c6 = new Ellipse2D.Double(180, 40, 120, 120);
    
    /** Creates a new instance of GraphicsPanel */
    public GraphicsPanel() {
        // call superclass constructor, use null as a layout manager 
        // (we don't need it for this example)'
        super(null);
        // set the preferred size of the JPanel, so pack() in JFrame will work!
        setPreferredSize(new Dimension(500, 300));
        // get the image url 
        url = getClass().getResource("duke.gif");
        // load the image
        try {
            bi = ImageIO.read(url);
        } catch (IOException ioe) {
            System.err.println("Couldn't open duke.gif " + ioe.getMessage());
        }
    }

    // this is the actuall method you should override to have painting occur
    // in the JPanel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        // set the font
        g2d.setPaint(gp);
        // paint the inside of the rectangle
        g2d.fill(c1);
        g2d.fill(c2);
        g2d.fill(c3);
        g2d.fill(c4);
        g2d.fill(c5);
        g2d.fill(c6);        
    }
}
