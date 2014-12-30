/*
 * Main.java
 *
 * Created on September 26, 2007, 2:35 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package internalframes2;

// Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

// simple example which shows how to manage internal frame icons.  a better
// solution would be to customize a JDesktopPane and put the functionality
// there (see homework 1)

class Main extends JFrame
    implements	ActionListener, ComponentListener
 {
     // Instance attributes used in this example
     private JMenuItem		menuFileNew;
     private JMenuItem		jOptionFileNew;
     private JMenuItem		paletteNew;
     private	JDesktopPane	desktopPane;
     private Dimension size = new Dimension(0, 0);
     Rectangle rect = new Rectangle(0, 0, 0, 0);
     double x = 0;
     double y = 0;
     
     // Constructor of main frame
     public Main() {
	// Set the frame characteristics
	setTitle( "Internal Frame Manging Icons" );
	setSize( 600, 400 );
	setBackground( Color.gray );
	
	// Create an application menu
	JMenu menuFile = new JMenu( "File" );
	menuFile.setMnemonic( 'F' );
	menuFileNew = CreateMenuItem( menuFile, "New Internal",
				      'N', "Create a new internal frame" );
	jOptionFileNew = CreateMenuItem( menuFile, "New JOption",
				      'N', "Create a new internal frame" );
	paletteNew = CreateMenuItem( menuFile, "New Palette",
				      'N', "Create a new internal frame" );
	JMenuBar menuBar = new JMenuBar();
	menuBar.add( menuFile );
	setJMenuBar( menuBar );
	
	// Create a desktop pane to support the internal
	// frame interface.
	desktopPane = new JDesktopPane();
	add( desktopPane, BorderLayout.CENTER );
	addComponentListener(this);
    }

     public void componentResized(ComponentEvent e) {
	 size = desktopPane.getSize(size);
	 x = 0;
	 y = size.getHeight();
	 int count = desktopPane.getComponentCount();
	 Component next;
	 for(int i = 0; i < count; i++) {
	     next = desktopPane.getComponent(i);
	     if(next instanceof JInternalFrame.JDesktopIcon)  {
		 rect = next.getBounds(rect);
		 if (x + rect.getWidth() > size.getWidth()) {
		     y = y - rect.getHeight();
		     x = 0;
		 }
		 next.setLocation((int)x, (int)(y - rect.getHeight()));
		 x += rect.getWidth();
	     }
	 }
     }
     public void componentMoved(ComponentEvent e) {}
     public void componentShown(ComponentEvent e) {}
     public void componentHidden(ComponentEvent e) {}
     
     public void actionPerformed( ActionEvent event )    {
	//  		System.out.println( event );

	Object source = event.getSource();
	if (source == menuFileNew) {
	    // Create a new internal frame and add it to the desktop panel
	    TestInternalFrame internalFrame = new TestInternalFrame();
	    desktopPane.add( internalFrame, JLayeredPane.PALETTE_LAYER );
	    internalFrame.setVisible(true);
	} else if (source == jOptionFileNew) {
	    System.out.println("this = " + this);
	    JOptionPane.showInternalConfirmDialog(desktopPane,
		  "please choose one",
		  "information",
		  JOptionPane.YES_NO_CANCEL_OPTION,
		  JOptionPane.INFORMATION_MESSAGE);
	    System.out.println("hello");
	    
	} else if (source == paletteNew) {
	    // Create a new internal frame and add it to the desktop panel
	    TestInternalFrame internalFrame = new TestInternalFrame();
	    internalFrame.putClientProperty("JInternalFrame.isPalette",
					    Boolean.TRUE);
	    internalFrame.setBounds(200, 200, 200, 200);
	    desktopPane.add( internalFrame, JLayeredPane.PALETTE_LAYER );
	    internalFrame.setVisible(true);
	}

    }
     
     
     public JMenuItem CreateMenuItem( JMenu menu, String sText,
				      int acceleratorKey, String sToolTip )
    {
	// Create the item
	JMenuItem menuItem = new JMenuItem();
	
	// Add the item test
	menuItem.setText( sText );
	
	// Add the accelerator key
	if( acceleratorKey > 0 )
	    menuItem.setMnemonic( acceleratorKey );
	
	// Add the optional tool tip text
	if( sToolTip != null )
	    menuItem.setToolTipText( sToolTip );
	
	// Add an action handler to this menu item
	menuItem.addActionListener( this );
	
	menu.add( menuItem );
	
	return menuItem;
    }
     
     
     // Main entry point for this example
     public static void main( String args[] )
    {
	// Create an instance of the test application
	final Main mainFrame	= new Main();
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Runnable showFrame = new Runnable() {
		public void run() {
		    mainFrame.setVisible(true);
		}
	    };
	SwingUtilities.invokeLater(showFrame);
    }
}
