import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Richard Nader Class for controlling the drawing panel.
 */
public class DrawingPanel extends JPanel implements MouseMotionListener, ActionListener {
	private static final long serialVersionUID = 1L;

	// Array for pixels.
	private Pixel[][] pixel;
	// Selected string and color.
	private Color chosenColor = Color.BLACK;
	private String selectedColorStr = "Black";

	// Drawing window size.
	private final int WIDTH = 800;
	private final int HEIGHT = 600;

	// Color button array.
	private JButton[] colorButtons;
	private JButton clearScreen;

	// Main constructor.
	public DrawingPanel(JButton[] colorButtons, JButton clearButton) {
		this.colorButtons = colorButtons;
		this.clearScreen = clearButton;

		// Action listener for clear button.
		clearScreen.addActionListener(this);

		// Make the pixel array
		makePixelArray();

		// Other settings
		setBackground(Color.WHITE);
		setSize(new Dimension(WIDTH, HEIGHT));

		// Set action listener for buttons
		for (JButton button : colorButtons) {
			button.addActionListener(this);
		}

		// Mouse listener for drawing
		addMouseMotionListener(this);
	}

	/**
	 * Make the drawing pixel array.
	 */
	private void makePixelArray() {
		pixel = new Pixel[WIDTH][HEIGHT];
	}

	/**
	 * Sets pixel color at specified x and y.
	 * @param x X location to set
	 * @param y Y Location to set
	 * @param color Color to set pixel to.
	 */
	private void setPixel(int x, int y, Color color) {
		// If inside drawing box.
		if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
			// Speed up drawing and conserve memory by keeping unchanged pixels null
			if (pixel[x][y] == null) {
				pixel[x][y] = new Pixel(x, y, color);
			} else if (pixel[x][y] != null) {
				pixel[x][y].setPixelColor(color);
			}

			// Re-draw
			repaint();
		}
	}

	/**
	 * Render method
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Render array of pixels if not null (Speed up processing time)
		for (int x = 0; x < pixel.length; x += 1) {
			for (int y = 0; y < pixel[x].length; y += 1) {
				if (pixel[x][y] != null)
					pixel[x][y].renderPixel(g);
			}
		}

		// To tell what color is selected.
		g.setColor(Color.BLACK);
		g.drawString("SELECTED COLOR: " + selectedColorStr, 10, 10);

	}

	/**
	 * Draw when mouse button is held down and moving.
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		setPixel(e.getX(), e.getY(), chosenColor);
	}

	// Not used
	@Override
	public void mouseMoved(MouseEvent e) {
	}

	/**
	 * Action Listener for buttons
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Run th
		for (int i = 0; i < colorButtons.length; i++) {
			// Check if color is selected and set it as the chosen color.
			if (e.getSource() == colorButtons[i]) {
				chosenColor = MainWindow.colors[i];
				selectedColorStr = MainWindow.colorNames[i];
				repaint();
				break;
			}
		}

		// Clear screen button
		if (e.getSource() == clearScreen) {
			pixel = new Pixel[WIDTH][HEIGHT];
			repaint();
		}

	}

}
