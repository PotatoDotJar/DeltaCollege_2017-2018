import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class Test extends JFrame {
	private static final long serialVersionUID = 1802199483736051124L;

	public Test() {
		setSize(500, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new FlowLayout());

		JRadioButton option1 = new JRadioButton("Option 1", true);
		JRadioButton option2 = new JRadioButton("Option 2");
		JRadioButton option3 = new JRadioButton("Option 3");
		
		ButtonGroup group = new ButtonGroup();
		group.add(option1);
		group.add(option2);
		group.add(option3);
		
		add(option1);
		add(option2);
		add(option3);
		
	}
	
	
	public static void main(String[] args) {new Test();}

}
