import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * JFrame for managing the database
 * 
 * Delta College - CST 283
 * 
 * @author Richard Nader
 *
 */
public class MainWindow extends JFrame {

	// Main content panel
	private JPanel contentPane;

	// Binary search tree for storing and searching data
	private BinarySearchTree<Traveler> binarySearchTree;
	private JButton btnEditTravelers;
	private JButton btnSeekHighRisk;
	private JButton btnQuit;

	// Main constructor
	public MainWindow(BinarySearchTree<Traveler> binarySearchTree) {

		this.binarySearchTree = binarySearchTree; // Initialize the binary search tree

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null); // Open in middle of screen
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setTitle("Flight Database Admin");

		// Init new ButtonHandler
		ButtonHandler buttonHandler = new ButtonHandler(this);

		btnEditTravelers = new JButton("Edit Travelers");
		btnEditTravelers.addActionListener(buttonHandler);
		contentPane.add(btnEditTravelers);

		btnSeekHighRisk = new JButton("Seek High Risk Travelers");
		btnSeekHighRisk.addActionListener(buttonHandler);
		contentPane.add(btnSeekHighRisk);

		btnQuit = new JButton("Quit");
		btnQuit.addActionListener(buttonHandler);
		contentPane.add(btnQuit);
		setVisible(true);
	}

	// Event handler for the buttons
	private class ButtonHandler implements ActionListener {

		// Prev window
		private JFrame prevWindow;

		public ButtonHandler(JFrame prevJFrame) {
			this.prevWindow = prevJFrame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnEditTravelers) {
				UserTableWindow userWindow = new UserTableWindow(prevWindow, binarySearchTree);

			} else if (e.getSource() == btnSeekHighRisk) {
				SeekHighRiskWindow seekHighRiskWindow = new SeekHighRiskWindow(prevWindow, binarySearchTree);

			} else if (e.getSource() == btnQuit) {
				prevWindow.dispose();
				System.exit(0);
			}
		}
	}

}
