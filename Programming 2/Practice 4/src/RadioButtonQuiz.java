
// Delta College - CST 283 - Klingler  
// This appication demonstrates radio buttons by implementing
// an interface for a simple survey or quiz.

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonQuiz extends JFrame {
	private JRadioButton options[][];
	private JButton submitButton;
	private ButtonGroup questions[];
	private JLabel questionLabels[];
	private int questionChoice[];
	private JPanel titlePanel, optionsPanel, buttonPanel;
	private JLabel title;

	private final int NUMBER_QUESTIONS = 6;
	private final int NUMBER_OPTIONS = 6;

	// Construct GUI
	public RadioButtonQuiz() {
		// Get content pane and set its layout. Design opitions for grid with each
		// row containing a question label and the question options. Overall,
		// BorderLayout will be used to manage zones of GUI.
		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		// Design questions as a grid.
		optionsPanel = new JPanel();
		optionsPanel.setLayout(new GridLayout(NUMBER_QUESTIONS, NUMBER_OPTIONS + 1));

		// Instantiate questions and question option objects
		options = new JRadioButton[NUMBER_QUESTIONS][NUMBER_OPTIONS];
		questions = new ButtonGroup[NUMBER_QUESTIONS];
		questionLabels = new JLabel[NUMBER_QUESTIONS];
		questionChoice = new int[NUMBER_QUESTIONS];

		// Ready button handler - this handler will manage all buttons
		RadioButtonHandler optionHandler = new RadioButtonHandler();

		// Initiate loop to build grid of questions and associated question options
		// Allow all radio buttons to initialize to default unchecked state. The
		// questionChoice[] array initialized to -1 to mark unchose. Otherwise,
		// questionChoice[] stores the indes of the question chosen.
		for (int i = 0; i < NUMBER_QUESTIONS; i++) {
			questions[i] = new ButtonGroup();
			questionLabels[i] = new JLabel("Question " + (i + 1));
			optionsPanel.add(questionLabels[i]);
			questionChoice[i] = -1;
			for (int j = 0; j < NUMBER_QUESTIONS; j++) {
				options[i][j] = new JRadioButton(Integer.toString(j));
				optionsPanel.add(options[i][j]);
				questions[i].add(options[i][j]);
				options[i][j].addItemListener(optionHandler);
			}

		}

		// Design title for top
		titlePanel = new JPanel();
		title = new JLabel("Employee Survey");
		title.setFont(new Font("Monospaced", Font.BOLD, 24));
		title.setForeground(Color.CYAN);
		titlePanel.add(title);

		// Design button panel for bottom
		buttonPanel = new JPanel();
		submitButton = new JButton("Submit");
		SubmitButtonHandler buttonHandler = new SubmitButtonHandler();
		submitButton.addActionListener(buttonHandler);
		buttonPanel.add(submitButton);

		// Add panels to overall GUI
		container.add(titlePanel, BorderLayout.NORTH);
		container.add(optionsPanel, BorderLayout.CENTER);
		container.add(buttonPanel, BorderLayout.SOUTH);

	} // end RadioButtonTest GUI constructor

	// Private inner class for ItemListener event handling
	private class RadioButtonHandler implements ItemListener {
		// Respond to radio button events
		public void itemStateChanged(ItemEvent event) {
			for (int i = 0; i < NUMBER_QUESTIONS; i++) {
				questions[i] = new ButtonGroup();
				for (int j = 0; j < NUMBER_QUESTIONS; j++) {
					if (options[i][j].isSelected())
						questionChoice[i] = j;
				}
			}
		}
	}

	// Private inner class for ItemListener event handling
	private class SubmitButtonHandler implements ActionListener {
		// Respond to button click - calculate and display number of times zero is
		// chosen
		// and all questions are responded to at time of click.
		public void actionPerformed(ActionEvent event) {
			int sum = 0;
			boolean allAnswered = true; // Assume all radio buttons clicked

			for (int i = 0; i < NUMBER_QUESTIONS; i++) {
				if (questionChoice[i] == 0)
					sum++;
				else if (questionChoice[i] > NUMBER_OPTIONS || questionChoice[i] < 0) {
					allAnswered = false;
				}
			}

			// If all radio buttons have been answered, determine number of zeros
			if (allAnswered) {
				int numZero = sum;

				JOptionPane.showMessageDialog(null, "Number of times zero is chosen: " + numZero);
			} else
				JOptionPane.showMessageDialog(null, "Please answer all questions");
		}
	}

	// Main application method
	public static void main(String args[]) {
		RadioButtonQuiz application = new RadioButtonQuiz();

		// Set GUI Window attributes
		application.setSize(500, 300);
		application.setVisible(true);
		application.setTitle("Survey");
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
