import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * JFrame for making and exporting reports for Travelers
 * 
 * Delta College - CST 283
 * 
 * @author Richard Nader
 *
 */
public class ReportWindow extends JFrame {

	// Main content
	private JPanel contentPane;

	// Binary search tree database
	private BinarySearchTree<Traveler> binarySearchTree;

	// Traveler to export
	private Traveler traveler;
	private JPanel panelBottom;
	private JButton btnExportToFile;
	private JTextField fldFileName;
	private JPanel panelCenter;
	private JTextArea textOutput;
	private JLabel lblFileName;
	private JCheckBox chckbxAppendToExisting;

	public ReportWindow(BinarySearchTree<Traveler> binarySearchTree, Traveler traveler) {
		this.binarySearchTree = binarySearchTree;
		this.traveler = traveler;

		// Window settings
		setTitle("Export data for " + traveler.getFirstName() + " " + traveler.getLastName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // Location to middle of screen
		setBounds(100, 100, 650, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));

		textOutput = new JTextArea();
		textOutput.setText(getTemplateText(traveler));
		panelCenter.add(textOutput, BorderLayout.CENTER);

		// Buttons panel
		panelBottom = new JPanel();
		contentPane.add(panelBottom, BorderLayout.SOUTH);

		lblFileName = new JLabel("File Name: ");
		panelBottom.add(lblFileName);

		fldFileName = new JTextField();
		fldFileName.setToolTipText("Name of the file. Will be \"Export_#.txt\" if blank.");
		panelBottom.add(fldFileName);
		fldFileName.setColumns(15);

		// Form buttons
		IButtonHandler buttonHandler = new IButtonHandler(this); // ActionListener

		// Export button
		btnExportToFile = new JButton("Export to file");
		btnExportToFile.addActionListener(buttonHandler);
		panelBottom.add(btnExportToFile);

		// Append Checkbox
		chckbxAppendToExisting = new JCheckBox("Append");
		chckbxAppendToExisting.setSelected(true);
		chckbxAppendToExisting.setToolTipText(
				"If the file exists it will append it to the existing file. If un-checked it will overwrite existing files.");
		panelBottom.add(chckbxAppendToExisting);

		// Close button
		btnClose = new JButton("Close");
		btnClose.addActionListener(buttonHandler);
		panelBottom.add(btnClose);

		setVisible(true); // Show window
	}

	// Method to generate a template to export from the traveler
	private String getTemplateText(Traveler traveler) {
		String string = "";

		string += "Name: " + traveler.getFirstName() + " " + traveler.getLastName() + "\n";
		string += "Address: " + traveler.getAddress() + " " + traveler.getCity() + ", " + traveler.getState() + " "
				+ traveler.getZipCode() + "\n";
		string += "Phone Number: " + traveler.getPhone() + "\n";
		string += getRiskString(traveler.getRiskLevel()) + "\n\n";

		return string;
	}

	// Method to build a string based on risk level
	private String getRiskString(int risk) {
		switch (risk) {
		case 1:
			return "User is classified as a risk level of 1 | LOW RISK";
		case 2:
			return "User is classified as a risk level of 2 | MEDIUM-LOW RISK";
		case 3:
			return "User is classified as a risk level of 3 | MEDIUM-HIGH RISK";
		case 4:
			return "User is classified as a risk level of 4 | ****HIGH RISK****";
		default:
			return "User's risk is out of bounds!";
		}
	}

	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	private JButton btnClose;
	private boolean saveToFile(boolean append) {
		String fileName = fldFileName.getText().isEmpty() ? "Export.txt" : fldFileName.getText();

		if (!fileName.endsWith(".txt")) {
			fileName += ".txt";
		}

		try {
			fileWriter = new FileWriter(fileName, append);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(textOutput.getText());

			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error writing to file " + fileName, "Error writing to file",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		JOptionPane.showMessageDialog(null, "Traveler data exported to " + fileName + " successfully!",
				"Export Complete!", JOptionPane.PLAIN_MESSAGE);
		return true;
	}

	// Class to handle button events
	private class IButtonHandler implements ActionListener {

		private JFrame frame; // The window

		public IButtonHandler(JFrame window) {
			this.frame = window;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			// Export file
			if (e.getSource() == btnExportToFile) {
				saveToFile(chckbxAppendToExisting.isSelected());
				frame.dispose();

				// Close window
			} else if (e.getSource() == btnClose) {
				frame.dispose();
			}

		}
	}

}
