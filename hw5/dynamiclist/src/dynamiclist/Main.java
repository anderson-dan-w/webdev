/*
 * Main.java
 *
 * Created on September 28, 2007, 1:38 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package dynamiclist;

	
// Imports
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class Main    extends 	JFrame
    implements	ActionListener, ListSelectionListener {

    // Instance attributes used in this example
    private	JList		listbox;
    private	DefaultListModel listData;
    private	JButton		addButton;
    private	JButton		removeButton;
    private	JTextField	dataField;
    private	JScrollPane scrollPane;
    
    // Constructor of main frame
    public Main()  {
	// Set the frame characteristics
	setTitle( "Modifying a JList" );
	setSize( 300, 100 );
	setBackground( Color.gray );
	
	// Create the data model for this example
	listData = new DefaultListModel();
	
	// Create a new listbox control
	listbox = new JList( listData );
	listbox.addListSelectionListener( this );
	
	// Add the listbox to a scrolling pane
	scrollPane = new JScrollPane();
	scrollPane.getViewport().add( listbox );
	add( scrollPane, BorderLayout.CENTER );
	createDataEntryPanel();
    }

    // Create the bottom panel which holds the Add, Delete, and
    // TextField
    private void createDataEntryPanel()    {
	// Create a panel to hold all other components
	JPanel dataPanel = new JPanel();
	dataPanel.setLayout( new BorderLayout() );
	add( dataPanel, BorderLayout.SOUTH );
	
	// Create some function buttons
	addButton = new JButton( "Add" );
	dataPanel.add( addButton, BorderLayout.WEST );
	addButton.addActionListener( this );
	
	removeButton = new JButton( "Remove" );
	dataPanel.add( removeButton, BorderLayout.EAST );
	removeButton.addActionListener( this );
	
	// Create a text field for data entry and display
	dataField = new JTextField();
	dataField.addActionListener(this);
	dataPanel.add( dataField, BorderLayout.CENTER );
    }
    
    // Handler for list selection changes
    public void valueChanged( ListSelectionEvent event )    {
	// See if this is a listbox selection and the
	// event stream has settled
	if( event.getSource() == listbox
	    && !event.getValueIsAdjusting() ) {
	    // Get the current selection `and place it in the
	    // edit field
	    String stringValue = (String)listbox.getSelectedValue();
	    if( stringValue != null )
		dataField.setText( stringValue );
	}
    }
    
    // Handler for button presses
    public void actionPerformed( ActionEvent event )    {
	if( event.getSource() == addButton ||
	    event.getSource() == dataField) {
	    // Get the text field value
	    String stringValue = dataField.getText();
	    dataField.setText( "" );
	    
	    // Add this item to the list and refresh
	    if( stringValue != null ) {
		listData.addElement( stringValue );
	    }
	} 
	
	if( event.getSource() == removeButton ) {
	    // Get the current selection
	    int selection = listbox.getSelectedIndex();
	    if( selection >= 0 ) {
		// Add this item to the list and refresh
		listData.removeElementAt( selection );
// 		listbox.revalidate();
// 		listbox.repaint();
		
		// As a nice touch, select the next item
		if( selection >= listData.size() )
		    selection = listData.size() - 1;
		listbox.setSelectedIndex( selection );
	    }
	}
    }
    
    // Main entry point for this example
    public static void main( String args[] )    {
	// Create an instance of the test application
	final Main mainFrame	= new Main();
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Runnable showFrame = new Runnable() {
		public void run() {
		    mainFrame.pack();
		    mainFrame.setVisible(true);
		}
	};
	SwingUtilities.invokeLater(showFrame);
    }
}

