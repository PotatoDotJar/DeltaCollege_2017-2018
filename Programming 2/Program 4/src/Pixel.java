import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Richard Nader Data object representation for a pixel.
 *
 */
public class Pixel {

	private int width = 10;
	private int height = 10;
	private int xPos;
	private int yPos;
	private Color pixelColor;

	public Pixel(int xPos, int yPos, Color pixelColor) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.pixelColor = pixelColor;
	}

	public Pixel(int xPos, int yPos, int width, int height, Color pixelColor) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.pixelColor = pixelColor;
	}

	// Method for rendering the pixel to screen.
	public void renderPixel(Graphics g) {
		g.setColor(pixelColor);
		// g.fillRect(xPos, yPos, width, height);
		g.fillOval(xPos - (width / 2), yPos - (height / 2), width, height);
	}

	/**
	 * @return the pixelColor
	 */
	public Color getPixelColor() {
		return pixelColor;
	}

	/**
	 * @param pixelColor
	 *            the pixelColor to set
	 */
	public void setPixelColor(Color pixelColor) {
		this.pixelColor = pixelColor;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the xPos
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * @param xPos
	 *            the xPos to set
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	/**
	 * @return the yPos
	 */
	public int getyPos() {
		return yPos;
	}

	/**
	 * @param yPos
	 *            the yPos to set
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

}
