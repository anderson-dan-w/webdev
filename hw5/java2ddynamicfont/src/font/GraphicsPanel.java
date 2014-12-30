/*
 * GraphicsPanel.java
 *
 * Created on September 23, 2007, 3:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package font;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.net.*;

/**
 *
 * @author evansrb1
 */
public class GraphicsPanel extends JPanel {
    // the font which we will use
    File file = null;
    Font font = null;
    
    /** Creates a new instance of GraphicsPanel */
    public GraphicsPanel() {
        // call superclass constructor, use null as a layout manager 
        // (we don't need it for this example)'
        super(null);
        // set the preferred size of the JPanel, so pack() in JFrame will work!
        setPreferredSize(new Dimension(500, 300));
        try {
            file = new File(getClass().getResource("A_Damn_Mess.ttf").toURI());
            FileInputStream fis = new FileInputStream(file);
            font = Font.createFont(Font.TRUETYPE_FONT, fis);
            font = font.deriveFont(Font.PLAIN, 24);
        } catch (FileNotFoundException ioe) {            
            System.err.println("Couldn't find A_Damn_Mess.ttf "+ ioe.getMessage());                                    
        } catch (IOException ioe) {
            System.err.println("Couldn't open A_Damn_Mess.ttf "+ ioe.getMessage());                        
        } catch (FontFormatException ffe) {
            System.err.println("Couldn't process A_Damn_Mess.ttf");
        } catch (URISyntaxException urise) {
            System.err.println("Couldn't convert URL to URI");            
        } finally {
            if (font == null) {
                font = new Font("Sans Serif", Font.BOLD, 24);
            }
        }
    }

    // this is the actuall method you should override to have painting occur
    // in the JPanel
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        super.paintComponent(g);
        String text = "what a mess";
        // set the font
        g2d.setFont(font);
        g2d.drawString(text, 10, 30);
    }
}
