import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class MainGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private DataHandler dataHandler;
	
	private JPanel contentPane;
	public JPanel panelTitle;
	public JPanel panelNumberpad;
	public JPanel panelControl;
	public JLabel lblZipCodeLookup;
	public JButton btnOne;
	public JButton btnTwo;
	public JButton btnThree;
	public JButton btnFour;
	public JButton btnFive;
	public JButton btnSix;
	public JButton btnSeven;
	public JButton btnEight;
	public JButton btnNine;
	public JTextField textZipcode;
	public JButton btnClear;
	public JButton btnSubmit;
	public JPanel panelZipField;
	public JButton btnBack;
	public JButton btnZero;
	public JButton btnMagicPlacer;
	
	public MainGUI(DataHandler dataHandler) {
		setResizable(false);
		
		this.dataHandler = dataHandler;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		// Title Panel
		panelTitle = new JPanel();
		contentPane.add(panelTitle);
		panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		// Title Label
		lblZipCodeLookup = new JLabel("Zip Code Lookup");
		lblZipCodeLookup.setHorizontalAlignment(SwingConstants.CENTER);
		lblZipCodeLookup.setVerticalAlignment(SwingConstants.TOP);
		lblZipCodeLookup.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelTitle.add(lblZipCodeLookup);
		
		// Zipcode Entry Panel
		panelZipField = new JPanel();
		contentPane.add(panelZipField);
		// Zipcode Entry Field
		textZipcode = new JTextField();
		textZipcode.setEditable(false);
		panelZipField.add(textZipcode);
		textZipcode.setFont(new Font("Tahoma", Font.BOLD, 20));
		textZipcode.setHorizontalAlignment(SwingConstants.CENTER);
		textZipcode.setColumns(10);
		
		// Panel for number pad
		panelNumberpad = new JPanel();
		panelNumberpad.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panelNumberpad);
		panelNumberpad.setLayout(new GridLayout(3, 3, 7, 7));
		
		// BUTTONS!
		ButtonPadHandler buttonPadHandler = new ButtonPadHandler();
		
		btnNine = new JButton("9");
		btnNine.addActionListener(buttonPadHandler);
		panelNumberpad.add(btnNine);
		
		btnEight = new JButton("8");
		btnEight.addActionListener(buttonPadHandler);
		panelNumberpad.add(btnEight);
		
		btnSeven = new JButton("7");
		btnSeven.addActionListener(buttonPadHandler);
		panelNumberpad.add(btnSeven);
		
		btnSix = new JButton("6");
		btnSix.addActionListener(buttonPadHandler);
		panelNumberpad.add(btnSix);
		
		btnFive = new JButton("5");
		btnFive.addActionListener(buttonPadHandler);
		panelNumberpad.add(btnFive);
		
		btnFour = new JButton("4");
		btnFour.addActionListener(buttonPadHandler);
		panelNumberpad.add(btnFour);
		
		btnThree = new JButton("3");
		btnThree.addActionListener(buttonPadHandler);
		panelNumberpad.add(btnThree);
		
		btnTwo = new JButton("2");
		btnTwo.addActionListener(buttonPadHandler);
		panelNumberpad.add(btnTwo);
		
		btnOne = new JButton("1");
		btnOne.addActionListener(buttonPadHandler);
		
		btnMagicPlacer = new JButton("New button");
		btnMagicPlacer.setForeground(Color.WHITE);
		btnMagicPlacer.setEnabled(false);
		btnMagicPlacer.setVisible(false);
		panelNumberpad.add(btnMagicPlacer);
		panelNumberpad.add(btnOne);
		
		btnZero = new JButton("0");
		btnZero.addActionListener(buttonPadHandler);
		panelNumberpad.add(btnZero);
		
		// Panel for control buttons
		panelControl = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelControl.getLayout();
		contentPane.add(panelControl);
		ActionButtonHandler actionButtonHandler = new ActionButtonHandler();
		// Button for clearing entry
		btnClear = new JButton("Clear");
		btnClear.setToolTipText("Clear the zipcode entry");
		btnClear.addActionListener(actionButtonHandler);
		panelControl.add(btnClear);
		// Button for entry backspace
		btnBack = new JButton("Back Space");
		btnBack.addActionListener(actionButtonHandler);
		panelControl.add(btnBack);
		// Button to submit form
		btnSubmit = new JButton("Submit");
		btnSubmit.setToolTipText("Search database for entered zipcode.");
		btnSubmit.addActionListener(actionButtonHandler);
		panelControl.add(btnSubmit);
		setVisible(true);
	}
	
	private class ButtonPadHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent a) {
			if(a.getSource() == btnOne) {
				if(textZipcode.getText().length() < 5) {
					String newNum = textZipcode.getText() + "1";
					textZipcode.setText(newNum);
				}
			}
			else if(a.getSource() == btnTwo) {
				if(textZipcode.getText().length() < 5) {
					String newNum = textZipcode.getText() + "2";
					textZipcode.setText(newNum);
				}
			}
			else if(a.getSource() == btnThree) {
				if(textZipcode.getText().length() < 5) {
					String newNum = textZipcode.getText() + "3";
					textZipcode.setText(newNum);
				}
			}
			else if(a.getSource() == btnFour) {
				if(textZipcode.getText().length() < 5) {
					String newNum = textZipcode.getText() + "4";
					textZipcode.setText(newNum);
				}
			}
			else if(a.getSource() == btnFive) {
				if(textZipcode.getText().length() < 5) {
					String newNum = textZipcode.getText() + "5";
					textZipcode.setText(newNum);
				}
			}
			else if(a.getSource() == btnSix) {
				if(textZipcode.getText().length() < 5) {
					String newNum = textZipcode.getText() + "6";
					textZipcode.setText(newNum);
				}
			}
			else if(a.getSource() == btnSeven) {
				if(textZipcode.getText().length() < 5) {
					String newNum = textZipcode.getText() + "7";
					textZipcode.setText(newNum);
				}
			}
			else if(a.getSource() == btnEight) {
				if(textZipcode.getText().length() < 5) {
					String newNum = textZipcode.getText() + "8";
					textZipcode.setText(newNum);
				}
			}
			else if(a.getSource() == btnNine) {
				if(textZipcode.getText().length() < 5) {
					String newNum = textZipcode.getText() + "9";
					textZipcode.setText(newNum);
				}
			}
			else if(a.getSource() == btnZero) {
				if(textZipcode.getText().length() < 5) {
					String newNum = textZipcode.getText() + "0";
					textZipcode.setText(newNum);
				}
			}
		}
	}
	
	private class ActionButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent a) {
			if(a.getSource() == btnClear) {
				textZipcode.setText("");
			}
			else if(a.getSource() == btnBack) {
				if(!textZipcode.getText().isEmpty()) {
					String newNum = textZipcode.getText().substring(0, textZipcode.getText().length() - 1);
					textZipcode.setText(newNum);
				}
			}
			else if(a.getSource() == btnSubmit) {
				if(textZipcode.getText().length() == 5) {
					int zipcode = Integer.parseInt(textZipcode.getText());
					setVisible(false);
					Location searchedLocation = dataHandler.getLocationFromZipcode(zipcode);
					if(searchedLocation == null) {
						JOptionPane.showMessageDialog(null, "Zipcode not found...");
						setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, searchedLocation.toString());
					}
					
					System.out.println(zipcode);
				} else {
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Invalid Zipcode: Zipcode must be 5 digts!");
					setVisible(true);
				}
				
				
				
			}
		}
	}
	
	

}
