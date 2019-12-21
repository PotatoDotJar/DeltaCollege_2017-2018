import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Richard Nader
 *
 */
public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	// Button array
	public static String[] colorNames = { "White", "Black", "Dark Grey", "Grey", "Light Grey", "Red", "Orange", "Cyan",
			"Magenta", "Pink", "Blue", "Yellow", "Green" };
	public static Color[] colors = { Color.WHITE, Color.BLACK, Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.RED,
			Color.ORANGE, Color.CYAN, Color.MAGENTA, Color.PINK, Color.BLUE, Color.YELLOW, Color.GREEN };
	private JButton[] colorSelectors = new JButton[colorNames.length];

	// Panels
	private JPanel buttonPanel;
	private DrawingPanel drawingPanel;

	// Buttons
	private JButton clear;

	/**
	 * Main constructor for the MainWindow JFrame.
	 */
	public MainWindow() {
		// Make the color button array.
		// Must be loaded first.
		makeButtonArray();

		// Add clear button
		clear = new JButton("Clear Screen");
		buttonPanel.add(clear);

		// Drawing panel
		drawingPanel = new DrawingPanel(colorSelectors, clear);

		// Add panels.
		add(buttonPanel, BorderLayout.WEST);
		add(drawingPanel, BorderLayout.CENTER);

		// Main window settings
		setSize(new Dimension(getSize().width + drawingPanel.getSize().width, 600));
		setResizable(false);
		setTitle("RJ Paint - Version: Better");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // Center window
		setVisible(true);
	}

	/**
	 * Method for building array of JButtons for the color selections.
	 * 
	 * @return void.
	 */
	private void makeButtonArray() {

		// Add button to panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(colorSelectors.length + 1, 1));
		buttonPanel.setSize(new Dimension(70, 600));

		for (int i = 0; i < colorNames.length; i++) {
			colorSelectors[i] = new JButton(colorNames[i]);
			colorSelectors[i].setBackground(colors[i]);
			buttonPanel.add(colorSelectors[i]);

			// Making text on dark backgrounds white.
			if (colors[i] == Color.BLACK) {
				colorSelectors[i].setForeground(Color.WHITE);
			} else if (colors[i] == Color.DARK_GRAY) {
				colorSelectors[i].setForeground(Color.WHITE);
			} else if (colors[i] == Color.BLUE) {
				colorSelectors[i].setForeground(Color.WHITE);
			}
		}
	}

}
