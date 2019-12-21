
// Delta College - CST 283 - Klingler  
// This application reads and repeats a sequence of words.

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class WordCheck extends JFrame {
	// Class wide component declarations
	private JTextField wordEntry;
	private JLabel wordLabel;
	private JButton addButton;
	private JButton listButton;
	private JButton clearButton;

	private StringStack wordStack;

	// set up GUI
	public WordCheck() {
		// Ready frame container
		Container frameContainer = getContentPane();
		frameContainer.setLayout(new FlowLayout());

		// Initialize GUI objects
		wordLabel = new JLabel("Enter a Word");
		wordEntry = new JTextField(15);
		frameContainer.add(wordLabel);
		frameContainer.add(wordEntry);
		addButton = new JButton("Add Word");
		frameContainer.add(addButton);
		listButton = new JButton("List Words");
		frameContainer.add(listButton);
		clearButton = new JButton("Clear Words");
		frameContainer.add(clearButton);

		// Register event handler for buttons
		ButtonHandler handler = new ButtonHandler();
		addButton.addActionListener(handler);
		listButton.addActionListener(handler);
		clearButton.addActionListener(handler);

		// Set application window attributes
		setTitle("Word Processor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 200);
		setVisible(true);

		// Initialize word output list to blank
		wordStack = new StringStack(100);
	}

	// Private inner class for event handling
	private class ButtonHandler implements ActionListener {
		// Process button click
		public void actionPerformed(ActionEvent event) {
			// Add Button - get text and add to data
			if (event.getSource() == addButton) {
				String newWord = wordEntry.getText();
				wordStack.push(newWord);
				wordEntry.setText("");
			}

			// List Button - display all words added so far
			if (event.getSource() == listButton) {
				String out = "";

				while (!wordStack.isEmpty()) {
					out += wordStack.pop() + "\n";
				}

				JOptionPane.showMessageDialog(null, out);
			}

			// Clear Button - clear word string
			if (event.getSource() == clearButton) {
				wordStack.clear();
			}
		}
	}

	// Main method - to launch application
	public static void main(String args[]) {
		WordCheck application = new WordCheck();
	}

}