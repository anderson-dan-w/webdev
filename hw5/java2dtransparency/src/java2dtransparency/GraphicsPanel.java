/*
 * GraphicsPanel.java
 *
 * Created on September 23, 2007, 3:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package java2dtransparency;

import java.awt.*;
import java.awt.image.*;
import java.net.*;
import java.io.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.imageio.*;
/**
 *
 * @author evansrb1
 */
public class GraphicsPanel extends JPanel {
    // holder for the url of the image
    URL url = null;
    // holder for the image itself
    BufferedImage bi = null;
    Ellipse2D circle = new Ellipse2D.Double(10, 10, 200, 200);
    
    Font font = new Font("Sans Serif", Font.BOLD, 64);
    String text = "JAVA";
    AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);
    
    /** Creates a new instance of GraphicsPanel */
    public GraphicsPanel() {
        // call superclass constructor, use null as a layout manager 
        // (we don't need it for this example)'
        super(null);
        // set the preferred size of the JPanel, so pack() in JFrame will work!
        setPreferredSize(new Dimension(220, 220));        // get the image url 
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
        Graphics2D g2d = (Graphics2D)g;
        super.paintComponent(g);

        g2d.setPaint(Color.WHITE);
        g2d.fill(circle);
        g2d.setPaint(Color.BLACK);        
        g2d.draw(circle);    
        g2d.drawImage(bi, 42, 35, this);
        // turn anti-aliasing on
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setComposite(alpha);
        g2d.setFont(font);
        g2d.drawString(text, 30, 140);
    }
}
