/*
 * TestInternalFrame.java
 *
 * Created on September 26, 2007, 2:17 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package internalframes2;

// Imports
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TestInternalFrame
    extends 	JInternalFrame
{
    // Instance attributes used in this example
    private	JPanel			topPanel;
    private	JScrollPane		scrollPane1;
    
    
    // Constructor of main frame
    public TestInternalFrame()
    {
	// Configure the internal frame embellishments
	setClosable( true );
	setMaximizable( true );
	setIconifiable( true );
	setResizable( true );
	
	// Set the frame characteristics
	setTitle( "Internal Frame" );
	setSize( 300, 200 );
	setBackground( Color.gray );
	
	// Create a panel to hold all other components
	topPanel = new JPanel();
	topPanel.setLayout( new BorderLayout() );
	getContentPane().add( topPanel );
	
	// Populate the panel with something the user
	// can play with
	CreateTopPane( topPanel );
    }
    
    // Create a scrollable pane containing a source file
    private void CreateTopPane( JPanel topPanel )
    {
	// Create a text area
	JTextArea area = new JTextArea();
	
        area.append("This is a test");
	// Create the scrolling pane for the text area
	scrollPane1 = new JScrollPane();
	scrollPane1.getViewport().add( area );
	topPanel.add( scrollPane1, BorderLayout.CENTER );
    }
}

