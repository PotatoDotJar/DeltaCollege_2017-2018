
// Delta College - CST 283 - Klingler 
// This program processes payroll by instantiating an object of the
// Payroll class.

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ProcessPayroll extends JFrame {
	private JTextArea outputTextArea;
	JScrollPane scrollPane;
	private static Payroll thePayRoll;
	private String outputReport;

	// Invoke payroll actions within text area object.
	public ProcessPayroll() {
		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		// Process payroll via object
		thePayRoll = new Payroll();
		thePayRoll.preparePayroll();
		thePayRoll.sortByNetPay();
		outputReport = thePayRoll.toString();

		// Send output to text area
		outputTextArea = new JTextArea(outputReport, 40, 20);
		outputTextArea.setEditable(false);
		outputTextArea.setFont(new Font("monospaced", Font.PLAIN, 16));
		container.add(outputTextArea);
	}

	public static void main(String args[]) {
		ProcessPayroll application = new ProcessPayroll();

		// Set attributes of application
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(800, 400);
		application.setVisible(true);
		application.setTitle("Payroll");
	}

}