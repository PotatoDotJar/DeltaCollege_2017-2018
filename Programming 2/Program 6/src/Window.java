import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * Main class for the output window
 * 
 * @author Richard Nader
 */
public class Window extends JFrame {
	private static final long serialVersionUID = 1L;

	// Main content
	private JPanel contentPane;

	// Button
	private JButton btnLoad;

	// Text Output
	private JTextArea textOutput;

	// Data manager
	private DataManager dataManager;


	// Main constructor
	public Window() {

		dataManager = new DataManager();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		btnLoad = new JButton("Reload Data File");
		btnLoad.addActionListener(new ActionButton());
		contentPane.add(btnLoad, BorderLayout.SOUTH);

		textOutput = new JTextArea();
		textOutput.setEditable(false);
		textOutput.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textOutput.setText(buildOutputString());
		contentPane.add(textOutput, BorderLayout.CENTER);
		setVisible(true);
	}

	// Build the output string
	private String buildOutputString() {
		String out = "";
		for (Player player : dataManager.getQualifiedPlayerList()) {
			out += player.toString() + "\n";
		}
		return out;
	}

	// Action Listener for the load button
	private class ActionButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnLoad) {
				textOutput.setText("");
				dataManager = new DataManager();
				textOutput.setText(buildOutputString());
			}
			
		}
	}

}
