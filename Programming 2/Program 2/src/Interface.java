import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
/**
 * @author Richard Nader Main runnable class for project.
 * Main interface class.
 */
public class Interface extends JFrame {
	private static final long serialVersionUID = 1L;

	// Panels
	private JPanel mainWindowPane;
	private JPanel paneTitle;
	private JPanel paneCenter;
	private JPanel panelButtons;

	// Input Fields
	private JTextField fieldYearsToInvest;
	private JTextField fieldAmountPerMonth;
	private JTextField fieldAnnualInterest;
	private JTextField fieldYearsPostRetirement;

	// Labels
	private JLabel lblTitle;
	private JLabel lblYearsToInvest;
	private JLabel lblAmountPerMonth;
	private JLabel lblAnualInterestRate;
	private JLabel lblNumberOfYearsToReceive;

	// Buttons
	private JButton btnCalculate;
	private JButton btnClearFields;

	private Annuity annuity;

	// Main constructor
	public Interface() {

		annuity = new Annuity();

		// Window settings
		setTitle("Annuity Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 404);
		mainWindowPane = new JPanel();
		setResizable(false);
		mainWindowPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(mainWindowPane);
		mainWindowPane.setLayout(new BorderLayout(0, 0));

		// Title panel
		paneTitle = new JPanel();
		mainWindowPane.add(paneTitle, BorderLayout.NORTH);

		// Title label
		lblTitle = new JLabel("Annuity Calculator");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 29));
		paneTitle.add(lblTitle);

		// Center panel init
		paneCenter = new JPanel();
		mainWindowPane.add(paneCenter, BorderLayout.CENTER);
		paneCenter.setLayout(null);

		Font lblFont = new Font("Tahoma", Font.PLAIN, 17);

		// Field for years to invest.
		fieldYearsToInvest = new JTextField();
		fieldYearsToInvest.setBounds(268, 17, 145, 34);
		fieldYearsToInvest.setFont(lblFont);
		paneCenter.add(fieldYearsToInvest);
		fieldYearsToInvest.setColumns(66);

		lblYearsToInvest = new JLabel("Number of years to invest:");
		lblYearsToInvest.setBounds(10, 23, 233, 20);
		lblYearsToInvest.setHorizontalAlignment(SwingConstants.LEFT);
		lblYearsToInvest.setFont(lblFont);
		paneCenter.add(lblYearsToInvest);

		// Field for amount to invest per month.
		lblAmountPerMonth = new JLabel("Amount able to invest monthly:");
		lblAmountPerMonth.setBounds(10, 59, 233, 20);
		lblAmountPerMonth.setFont(lblFont);
		paneCenter.add(lblAmountPerMonth);

		fieldAmountPerMonth = new JTextField();
		fieldAmountPerMonth.setColumns(66);
		fieldAmountPerMonth.setBounds(268, 53, 145, 34);
		fieldAmountPerMonth.setFont(lblFont);
		paneCenter.add(fieldAmountPerMonth);

		// Field for annual interest rate.
		lblAnualInterestRate = new JLabel("Annual Interest Rate:");
		lblAnualInterestRate.setBounds(10, 95, 233, 20);
		lblAnualInterestRate.setFont(lblFont);
		paneCenter.add(lblAnualInterestRate);

		fieldAnnualInterest = new JTextField();
		fieldAnnualInterest.setColumns(66);
		fieldAnnualInterest.setBounds(268, 89, 145, 34);
		fieldAnnualInterest.setFont(lblFont);
		paneCenter.add(fieldAnnualInterest);

		// Field for number of years after retirement.
		lblNumberOfYearsToReceive = new JLabel("Number of years to receive funds:");
		lblNumberOfYearsToReceive.setBounds(10, 131, 251, 20);
		lblNumberOfYearsToReceive.setFont(lblFont);
		paneCenter.add(lblNumberOfYearsToReceive);

		fieldYearsPostRetirement = new JTextField();
		fieldYearsPostRetirement.setColumns(66);
		fieldYearsPostRetirement.setBounds(268, 125, 145, 34);
		fieldYearsPostRetirement.setFont(lblFont);
		paneCenter.add(fieldYearsPostRetirement);

		// Button panel
		panelButtons = new JPanel();
		mainWindowPane.add(panelButtons, BorderLayout.SOUTH);

		// Button init
		ButtonListener buttonListener = new ButtonListener();
		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(buttonListener);
		btnCalculate.setFont(lblFont);
		panelButtons.add(btnCalculate);

		btnClearFields = new JButton("Clear Fields");
		btnClearFields.addActionListener(buttonListener);
		btnClearFields.setFont(lblFont);
		panelButtons.add(btnClearFields);
		setVisible(true);
	}

	private OutputWindow outputWindow;

	private void calculate() {
		int yearsToInvest;
		if (!fieldYearsToInvest.getText().isEmpty()) {
			try {
				yearsToInvest = Integer.parseInt(fieldYearsToInvest.getText());
				if (yearsToInvest <= 0)
					throw new NumberFormatException();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "[Error] Invalid years to invest!");
				fieldYearsToInvest.setText("");
				return;
			}
			annuity.setInvestmentYears(yearsToInvest);

		} else {
			JOptionPane.showMessageDialog(this, "[Error] Years to invest is empty!");
			return;
		}
		double amountInvestPerMonth;
		if (!fieldAmountPerMonth.getText().isEmpty()) {
			try {
				amountInvestPerMonth = Double.parseDouble(fieldAmountPerMonth.getText());
				if (amountInvestPerMonth <= 0)
					throw new NumberFormatException();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "[Error] Invalid amount to invest per month!");
				fieldAmountPerMonth.setText("");
				return;
			}
			annuity.setInvestmentAmount(amountInvestPerMonth);

		} else {
			JOptionPane.showMessageDialog(this, "[Error] Amount able to invest per month is empty!");
			return;
		}
		double annualInterest;
		if (!fieldAnnualInterest.getText().isEmpty()) {
			try {
				annualInterest = (Double.parseDouble(fieldAnnualInterest.getText())) / 100;
				if (annualInterest < 0 || annualInterest > 100)
					throw new NumberFormatException();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "[Error] Invalid annual intrest rate!");
				fieldAnnualInterest.setText("");
				return;
			}
			annuity.setInterestRate(annualInterest);

		} else {
			JOptionPane.showMessageDialog(this, "[Error] Annual interest is empty!");
			return;
		}
		int yearsAfterRetirement;
		if (!fieldYearsPostRetirement.getText().isEmpty()) {
			try {
				yearsAfterRetirement = Integer.parseInt(fieldYearsPostRetirement.getText());
				if (yearsAfterRetirement <= 0)
					throw new NumberFormatException();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "[Error] Invalid years to recive funds!");
				fieldYearsPostRetirement.setText("");
				return;
			}
			annuity.setPaymentYears(yearsAfterRetirement);

		} else {
			JOptionPane.showMessageDialog(this, "[Error] Number of years to recive funds is empty!");
			return;
		}

		outputWindow = new OutputWindow(annuity);
	}

	// Class for listening for button input.
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Button click for calculating.
			if (e.getSource() == btnCalculate) {
				calculate();
			}

			// Button click for clearing fields.
			else if (e.getSource() == btnClearFields) {
				fieldAmountPerMonth.setText("");
				fieldAnnualInterest.setText("");
				fieldYearsPostRetirement.setText("");
				fieldYearsToInvest.setText("");
				if (outputWindow != null)
					outputWindow.setVisible(false);
				outputWindow = null;
			}

		}
	}
}
