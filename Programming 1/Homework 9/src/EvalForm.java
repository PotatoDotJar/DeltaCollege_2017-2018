// Delta College - CST 183 
// This class includes a generic form with a large variety of interface
// components.  It acts as the "front-end" interface for a hypothetical 
// application to allow the user to input and retrieve information.

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class EvalForm extends JFrame 
{

	int maxRatings = 10;
	
    // All GUI components for class
    private JPanel topPanel, secondPanel, thirdPanel, bottomButtonPanel;
    private JMenu fileMenu, formatMenu;
    private JMenuItem aboutItem, quitItem;
    private JMenuBar mainMenuBar;
    private JLabel nameLabel, countyFromLabel, courseNameLabel;
    private JTextField nameField;
    private JLabel radioLabelQuestion;
    private JPanel questionPanel, questionRadioPanel;
    private JRadioButton radioButtonsQ1[];
    private ButtonGroup theButtonGroup;
    private JPanel checkboxPanel;
    private JComboBox countyChoiceList;
    private JCheckBox fullTimeCheck, majorCheck;
    private JTextArea largeTextArea;
    private JList courseList;
    private JButton sendButton;
    private JButton resetButton;
    Container container;
    EvalData theData;   // Object for "back end" data colletion

    // Set up GUI
    public EvalForm() 
    {
        theData = new EvalData();     // Object to manage data

        container = getContentPane();
        container.setLayout(new GridLayout(4, 1));

        // Set up File menu and its menu items
        fileMenu = new JMenu("File");
        JMenuItem aboutItem = new JMenuItem("About...");
        fileMenu.add(aboutItem);
        aboutItem.addActionListener(new AboutMenuChoiceHandler());
        JMenuItem quitItem = new JMenuItem("Quit");
        fileMenu.add(quitItem);
        quitItem.addActionListener(new QuitMenuChoiceHandler());

        // Create Format menu, its submenus and menu items
        //    formatMenu = new JMenu("Format");
        // Create menu bar and attach it to MenuTest window
        JMenuBar mainMenuBar = new JMenuBar();
        this.setJMenuBar(mainMenuBar);
        mainMenuBar.add(fileMenu);

        // Set up top panel with name, county fields and check boxes
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        nameLabel = new JLabel("Name");
        nameField = new JTextField(10);
        topPanel.add(nameLabel);
        topPanel.add(nameField);

        countyFromLabel = new JLabel("Home County");
        String countyHomeChoices[] = {"", "Bay", "Huron", "Midland", "Saginaw", "Tuscola"};
        countyChoiceList = new JComboBox(countyHomeChoices);
        topPanel.add(countyFromLabel);
        topPanel.add(countyChoiceList);

        checkboxPanel = new JPanel();
        checkboxPanel.setLayout(new GridLayout(2, 1));
        fullTimeCheck = new JCheckBox("Full-time Student");
        majorCheck = new JCheckBox("CST Major");
        checkboxPanel.add(fullTimeCheck);
        checkboxPanel.add(majorCheck);
        topPanel.add(checkboxPanel);

        container.add(topPanel);

        // et up 2nd panel down with course list and radio button group
        secondPanel = new JPanel();
        secondPanel.setLayout(new FlowLayout());

        JLabel courseNameLabel = new JLabel("Course ");
        secondPanel.add(courseNameLabel);
        String courseListStrings[] = {"CST 173", "CST 183", "CST 184", "CST 186", "CST 283"};
        courseList = new JList(courseListStrings);
        courseList.setVisibleRowCount(4);
        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        secondPanel.add(new JScrollPane(courseList));

        questionPanel = new JPanel();
        questionPanel.setLayout(new GridLayout(2, 1));

        // Create radio button objects for survey questions
        radioLabelQuestion = new JLabel("Rate the course 1.." + maxRatings);
        questionPanel.add(radioLabelQuestion);

        questionRadioPanel = new JPanel();
        radioButtonsQ1 = new JRadioButton[maxRatings];
        theButtonGroup = new ButtonGroup();

        for (int i = 0; i < maxRatings; i++) 
        {
            radioButtonsQ1[i] = new JRadioButton(Integer.toString(i + 1));
            questionRadioPanel.add(radioButtonsQ1[i]);
            theButtonGroup.add(radioButtonsQ1[i]);
        }
        questionPanel.add(questionRadioPanel);

        secondPanel.add(questionPanel);
        container.add(secondPanel);

        // Set up 3rd panel with text area
        thirdPanel = new JPanel();

        String initialText = "Enter stuff here.";
        largeTextArea = new JTextArea(initialText, 8, 50);
        thirdPanel.add(new JScrollPane(largeTextArea));

        container.add(thirdPanel);

        // Set up bottom panel containing only button
        bottomButtonPanel = new JPanel();

        sendButton = new JButton("Send");
        bottomButtonPanel.add(sendButton);
        sendButton.addActionListener(new SendButtonEventHandler());
        container.add(bottomButtonPanel);
        
        resetButton = new JButton("Reset");
        bottomButtonPanel.add(resetButton);
        resetButton.addActionListener(new ResetButtonEventHandler());

    } // end constructor

    public static void main(String args[]) 
    {
        EvalForm application = new EvalForm();

        // Set application window attributes      
        application.setSize(650, 360);
        application.setVisible(true);
        application.setTitle("Course Evaluation");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // ---------------------------------------------------------------------
    // Handle button click.  Perform some error checking to be sure 
    // required fields are complete.  The following conditions must be met:
    // * Non-blank name field          * County choice not first blank value
    // * A radio button was selected   * A course was selected
    private class SendButtonEventHandler implements ActionListener 
    {
        // Test that all required components have data.  If any one missing
        // logic triggers an error dialog.  Otherwise, data are "set" to object.

        public void actionPerformed(ActionEvent event) 
        {
            if (nameField.getText() != ""
                    && countyChoiceList.getSelectedIndex() != 0
                    && theButtonGroup.getSelection() != null
                    && courseList.getSelectedIndex() > 0) {
                theData.setName(nameField.getText());
                theData.setCounty(countyChoiceList.getSelectedItem().toString());
                theData.setCourse((String) courseList.getSelectedValue());
                for (int i = 0; i < maxRatings; i++) 
                {
                    if (radioButtonsQ1[i].isSelected()) 
                    {
                        theData.setCourseRating(i + 1);
                    }
                }
                theData.setCStmajorCheck(majorCheck.isSelected());
                theData.setFullTimeCheck(fullTimeCheck.isSelected());
                theData.setComments(largeTextArea.getText());

                JOptionPane.showMessageDialog(null, theData.toString());
            } else 
            {
                JOptionPane.showMessageDialog(null,
                        "Some data files are incomplete",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // ---------------------------------------------------------------------
    // Handle reset button click.  Resets all fields to default.
    private class ResetButtonEventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Clear radio buttons
			theButtonGroup.clearSelection();
			
			// Clear text fields 
			nameField.setText("");
			largeTextArea.setText("Enter stuff here.");
			
			// Clear check boxes
			fullTimeCheck.setSelected(false);
			majorCheck.setSelected(false);
			
			// Clear course selection
			courseList.clearSelection();
			
			// Reset country
			countyChoiceList.setSelectedIndex(0);
		}
    	
    }

    // ---------------------------------------------------------------------
    // Handle selection of File Menu - About
    private class AboutMenuChoiceHandler implements ActionListener 
    {

        public void actionPerformed(ActionEvent event) 
        {
            JOptionPane.showMessageDialog(EvalForm.this,
                    "This is a course evaluation application.",
                    "About", JOptionPane.PLAIN_MESSAGE);
        }
    }
    // ---------------------------------------------------------------------
    // Handle selection of File Menu - Quit

    private class QuitMenuChoiceHandler implements ActionListener 
    {

        public void actionPerformed(ActionEvent event) 
        {
            System.exit(0);
        }
    }
}