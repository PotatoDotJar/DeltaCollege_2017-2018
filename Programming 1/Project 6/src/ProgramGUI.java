import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;



/**
 * @author Richard Nader
 * Program GUI class handles the summary GUI view of the submitted health form.
 * Class extends JFrame.
 */
public class ProgramGUI extends JFrame {
	public static final long serialVersionUID = 1L;
	
	// Settings
	public static final float version = 1.03f;

	// Variables
	HealthLog healthData;
	GroupLayout gl_panel;

	private JPanel contentPane;
	JPanel panel;

	// Labels
	JLabel lblSummary;
	JLabel lblBodyMassIndex;
	JLabel lblCaloriesBurnned;
	JLabel lblMaxTargetHeart;
	JLabel lblMinimumTargetHeart;
	JLabel lblBmiClassification;
	JLabel lblMinimumDailyEnergy;

	// Data Fields
	JLabel dataBMI;
	JLabel dataBMIClass;
	JLabel dataCaloriesBurnned;
	JLabel dataMaxTargetHeartRate;
	JLabel dataMinTargetHeartRate;
	JLabel dataMinDailyEnergy;

	// Buttons
	JButton btnBack;

	public ProgramGUI(HealthLog data) {
		// Setup window
		setTitle("Health Calculator Summary - GUI Version " + version);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// Init labels
		lblSummary = new JLabel("Summary");
		lblSummary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSummary.setFont(new Font("Segoe UI", Font.BOLD, 18));
		contentPane.add(lblSummary, BorderLayout.NORTH);

		// Init window panel
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel, BorderLayout.CENTER);

		// Init more labels
		lblBodyMassIndex = new JLabel("Body Mass Index:");
		lblBodyMassIndex.setFont(new Font("Segoe UI", Font.BOLD, 13));

		lblCaloriesBurnned = new JLabel("Calories Burnned:");
		lblCaloriesBurnned.setFont(new Font("Segoe UI", Font.BOLD, 13));

		lblMaxTargetHeart = new JLabel("Maximum Target Heart Rate:");
		lblMaxTargetHeart.setFont(new Font("Segoe UI", Font.BOLD, 13));

		lblMinimumTargetHeart = new JLabel("Minimum Target Heart Rate:");
		lblMinimumTargetHeart.setFont(new Font("Segoe UI", Font.BOLD, 13));

		lblBmiClassification = new JLabel("BMI Classification:");
		lblBmiClassification.setFont(new Font("Segoe UI", Font.BOLD, 13));

		lblMinimumDailyEnergy = new JLabel("Minimum Daily Energy Requirements:");
		lblMinimumDailyEnergy.setFont(new Font("Segoe UI", Font.BOLD, 13));

		// Init back Button
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 12));
		// Handle button press event
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new InputGUI(data).setVisible(true);
				setVisible(false);

			}
		});

		// Init data labels
		dataBMI = new JLabel("NULL");
		dataBMI.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		dataBMI.setText(Double.toString(data.calculateBMI()));

		dataBMIClass = new JLabel("NULL");
		dataBMIClass.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		dataBMIClass.setText(data.calculateBMIClassification().toString());

		dataCaloriesBurnned = new JLabel("NULL");
		dataCaloriesBurnned.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		dataCaloriesBurnned.setText(data.calculateCaloriesBurned() + " calories");

		dataMaxTargetHeartRate = new JLabel("NULL");
		dataMaxTargetHeartRate.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		dataMaxTargetHeartRate.setText(Integer.toString(data.maxTargetHeartRate()) + " BPM");

		dataMinTargetHeartRate = new JLabel("NULL");
		dataMinTargetHeartRate.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		dataMinTargetHeartRate.setText(Integer.toString(data.minTargetHeartRate()) + " BPM");

		dataMinDailyEnergy = new JLabel("NULL");
		dataMinDailyEnergy.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		dataMinDailyEnergy.setText(Double.toString(data.calculateBaseCalorieNeedsToMaintainWeight()) + " calories");

		// Build the complex group layout
		buildLayout();
		
		// Set finished form visible
		panel.setLayout(gl_panel);
	}
	
	// Build GroupLayout manager for the form
	public void buildLayout() {
		gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblBodyMassIndex)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(dataBMI, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblCaloriesBurnned)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(dataCaloriesBurnned, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblMaxTargetHeart)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(dataMaxTargetHeartRate, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblMinimumTargetHeart)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(dataMinTargetHeartRate, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblBmiClassification)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(dataBMIClass, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblMinimumDailyEnergy)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(dataMinDailyEnergy, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
								.addComponent(btnBack))
						.addContainerGap())
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBodyMassIndex)
								.addComponent(dataBMI))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBmiClassification, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(dataBMIClass, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCaloriesBurnned, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(dataCaloriesBurnned, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMaxTargetHeart, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(dataMaxTargetHeartRate, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMinimumTargetHeart, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(dataMinTargetHeartRate, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblMinimumDailyEnergy, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
										.addComponent(btnBack))
								.addComponent(dataMinDailyEnergy, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
				);
		gl_panel.setAutoCreateGaps(true);
		gl_panel.setAutoCreateContainerGaps(true);
	}

}
