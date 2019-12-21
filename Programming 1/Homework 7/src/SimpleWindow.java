import javax.swing.JFrame;

public class SimpleWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	public SimpleWindow() {
		final int WIDTH = 350;
		final int HEIGHT = 250;
		
		setTitle("Hello, JFrame!");
		
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
}
