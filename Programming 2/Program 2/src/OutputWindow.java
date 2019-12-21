import java.awt.BorderLayout;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
/**
 * @author Richard Nader 
 * Output window.
 */
public class OutputWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtAnnuitySummary;

	private Annuity annuity;

	/**
	 * Create the frame.
	 */
	public OutputWindow(Annuity annuity) {

		this.annuity = annuity;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		txtAnnuitySummary = new JTextField();
		txtAnnuitySummary.setEditable(false);
		txtAnnuitySummary.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtAnnuitySummary.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnnuitySummary.setText("Annuity Summary");
		contentPane.add(txtAnnuitySummary, BorderLayout.NORTH);
		txtAnnuitySummary.setColumns(10);

		JTextPane textOutputPane = new JTextPane();
		textOutputPane.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textOutputPane.setEditable(false);
		textOutputPane.setText(createSummary());
		contentPane.add(textOutputPane, BorderLayout.CENTER);
		setVisible(true);
	}

	DecimalFormat format = new DecimalFormat("#######.##");

	private String createSummary() {
		String outputString = "$" + format.format(annuity.getInvestmentAmount()) + "/month for "
				+ annuity.getInvestmentYears() + " years at an annual interest rate of "
				+ (annuity.getInterestRate() * 100) + "%\n" + "Calculated Total Annuity value while working: $"
				+ format.format(annuity.calcInvestTotal()) + "\n" + "Years expected to live off Annuity: "
				+ annuity.getPaymentYears() + " years\n" + "Calculated monthly payout after retirement: $"
				+ format.format(annuity.calcPayout()) + "/month";
		return outputString;
	}

}
