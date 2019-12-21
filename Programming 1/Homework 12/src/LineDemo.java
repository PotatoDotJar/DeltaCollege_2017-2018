import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JApplet;

public class LineDemo extends JApplet {
	private static final long serialVersionUID = 1L;


	public void init() {
		getContentPane().setBackground(Color.WHITE);
		setSize(500, 500);
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		
		int[] pointsX = {10, 10, 50, 50};
		int[] pointsY = {10, 25, 25, 10};
		
		g.drawPolygon(pointsX, pointsY, 4);
		
	}

}
