import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class InputGUI extends JFrame {
	private static final long serialVersionUID = 1L;

	// Used for storing healthData from previous submit
	HealthLog healthData;

	// Content pane object
	Container contentPane;

	// Labels
	JLabel lblAge;
	JLabel lblWeight;
	JLabel lblHeight;
	JLabel lblGender;
	JLabel lblActivity;
	JLabel lblSpeed;
	JLabel lblDuration;

	// Spinners
	JSpinner spnrAge;
	JSpinner spnrWeight;
	JSpinner spnrHeight;
	JSpinner spnrSpeed;
	JSpinner spnrDuration;

	// Gender Select
	ButtonGroup genderGroup;
	JRadioButton radioBtnMale;
	JRadioButton radioBtnFemale;

	// Activity Select
	ButtonGroup activityGroup;
	JRadioButton radioBtnRunning;
	JRadioButton radioBtnWalking;

	// Buttons
	JButton btnSubmit;


	public InputGUI() {

		//healthData = new HealthLog(age, weight, height, gen, typeOfActivity, 
		//		speed, workoutTimeMinutes);

		// Set up window
		setTitle("Health Calculator Data - GUI Version " + ProgramGUI.version);
		setSize(new Dimension(ProgramGUI.WIDTH, ProgramGUI.HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = this.getContentPane();
		setBounds(100, 100, 450, 294);

		// Labels Initialization
		lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Segoe UI", Font.BOLD, 12));

		lblWeight = new JLabel("Weight (lbs):");
		lblWeight.setFont(new Font("Segoe UI", Font.BOLD, 12));

		lblHeight = new JLabel("Height (in):");
		lblHeight.setFont(new Font("Segoe UI", Font.BOLD, 12));

		lblGender = new JLabel("Gender: ");
		lblGender.setFont(new Font("Segoe UI", Font.BOLD, 12));

		lblActivity = new JLabel("Activity:");
		lblActivity.setFont(new Font("Segoe UI", Font.BOLD, 12));

		lblSpeed = new JLabel("Walking/Running Speed (mph):");
		lblSpeed.setFont(new Font("Segoe UI", Font.BOLD, 12));

		lblDuration = new JLabel("Exercise Duration (min):");
		lblDuration.setFont(new Font("Segoe UI", Font.BOLD, 12));

		// Buttons Initialization
		btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnSubmit.addActionListener(new InputGUIEventHandler(btnSubmit, this));

		// Spinners Initialization
		spnrAge = new JSpinner();
		spnrAge.setModel(new SpinnerNumberModel(17, 1, 112, 1));
		spnrAge.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		spnrAge.setValue(17);

		spnrWeight = new JSpinner();
		spnrWeight.setModel(new SpinnerNumberModel(20, 20, 400, 1));
		spnrWeight.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		spnrWeight.setValue(120);

		spnrHeight = new JSpinner();
		spnrHeight.setModel(new SpinnerNumberModel(24, 24, 96, 1));
		spnrHeight.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		spnrHeight.setValue(56);

		spnrSpeed = new JSpinner();
		spnrSpeed.setModel(new SpinnerNumberModel(1, 1, 35, 1));
		spnrSpeed.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		spnrSpeed.setValue(2);

		spnrDuration = new JSpinner();
		spnrDuration.setModel(new SpinnerNumberModel(1, 1, 360, 1));
		spnrDuration.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		spnrDuration.setValue(30);

		// Radio Buttons Initialization
		genderGroup = new ButtonGroup();
		radioBtnMale = new JRadioButton("Male");
		radioBtnMale.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		radioBtnMale.setSelected(true);

		radioBtnFemale = new JRadioButton("Female");
		radioBtnFemale.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		genderGroup.add(radioBtnMale);
		genderGroup.add(radioBtnFemale);

		activityGroup = new ButtonGroup();
		radioBtnRunning = new JRadioButton("Running");
		radioBtnRunning.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		radioBtnRunning.setSelected(true);

		radioBtnWalking = new JRadioButton("Walking");
		radioBtnWalking.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		activityGroup.add(radioBtnRunning);
		activityGroup.add(radioBtnWalking);	

		buildLayout();
		
		// Set form visible
		setVisible(true);

	}
	
	// Construct form using existing data object
	public InputGUI(HealthLog data) {
		
		// Store to global variable
		healthData = data;
		
		// Set up window
		setTitle("Health Calculator Data - GUI Version " + ProgramGUI.version);
		setSize(new Dimension(ProgramGUI.WIDTH, ProgramGUI.HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = this.getContentPane();
		setBounds(100, 100, 450, 294);

		// Labels Initialization
		lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Segoe UI", Font.BOLD, 12));

		lblWeight = new JLabel("Weight (lbs):");
		lblWeight.setFont(new Font("Segoe UI", Font.BOLD, 12));

		lblHeight = new JLabel("Height (in):");
		lblHeight.setFont(new Font("Segoe UI", Font.BOLD, 12));

		lblGender = new JLabel("Gender: ");
		lblGender.setFont(new Font("Segoe UI", Font.BOLD, 12));

		lblActivity = new JLabel("Activity:");
		lblActivity.setFont(new Font("Segoe UI", Font.BOLD, 12));

		lblSpeed = new JLabel("Walking/Running Speed (mph):");
		lblSpeed.setFont(new Font("Segoe UI", Font.BOLD, 12));

		lblDuration = new JLabel("Exercise Duration (min):");
		lblDuration.setFont(new Font("Segoe UI", Font.BOLD, 12));

		// Buttons Initialization
		btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnSubmit.addActionListener(new InputGUIEventHandler(btnSubmit, this));

		// Spinners Initialization
		spnrAge = new JSpinner();
		spnrAge.setModel(new SpinnerNumberModel(17, 1, 112, 1));
		spnrAge.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		spnrAge.setValue(data.getAge());

		spnrWeight = new JSpinner();
		spnrWeight.setModel(new SpinnerNumberModel(20, 20, 400, 1));
		spnrWeight.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		spnrWeight.setValue(data.getWeight());

		spnrHeight = new JSpinner();
		spnrHeight.setModel(new SpinnerNumberModel(24, 24, 96, 1));
		spnrHeight.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		spnrHeight.setValue(data.getHeight());

		spnrSpeed = new JSpinner();
		spnrSpeed.setModel(new SpinnerNumberModel(1, 1, 35, 1));
		spnrSpeed.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		spnrSpeed.setValue(data.getSpeed());

		spnrDuration = new JSpinner();
		spnrDuration.setModel(new SpinnerNumberModel(1, 1, 360, 1));
		spnrDuration.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		spnrDuration.setValue(data.getWorkoutTimeMinutes());

		// Radio Buttons Initialization
		genderGroup = new ButtonGroup();
		radioBtnMale = new JRadioButton("Male");
		radioBtnMale.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		radioBtnMale.setSelected(data.getGender() == HealthLog.gender.MALE ? true : false);

		radioBtnFemale = new JRadioButton("Female");
		radioBtnFemale.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		radioBtnFemale.setSelected(data.getGender() == HealthLog.gender.FEMALE ? true : false);
		genderGroup.add(radioBtnMale);
		genderGroup.add(radioBtnFemale);

		activityGroup = new ButtonGroup();
		radioBtnRunning = new JRadioButton("Running");
		radioBtnRunning.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		radioBtnRunning.setSelected(data.getTypeOfActivity() == HealthLog.activityType.RUNNING ? true : false);

		radioBtnWalking = new JRadioButton("Walking");
		radioBtnWalking.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		radioBtnWalking.setSelected(data.getTypeOfActivity() == HealthLog.activityType.WALKING ? true : false);
		activityGroup.add(radioBtnRunning);
		activityGroup.add(radioBtnWalking);	

		// Build the complex group layout
		buildLayout();

		// Set finished form visible
		setVisible(true);

	}

	// Action Listener class for buttons
	private class InputGUIEventHandler implements ActionListener {

		// Create new Buttons and a storage object for the JFrame
		JButton button;
		JFrame prev;

		public InputGUIEventHandler(JButton button, JFrame prev) {
			this.button = button;
			this.prev = prev;
		}

		// Runs when button is clicked
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == button) {
				// When button pressed...
				//System.out.println("Clicked...");

				try {
					// Commit fields that are being edited
					spnrAge.commitEdit();
					spnrDuration.commitEdit();
					spnrHeight.commitEdit();
					spnrSpeed.commitEdit();
					spnrWeight.commitEdit();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				// Get inputed values and make a new HealthLog object then pass it to a new programGUI.
				int age = (int) spnrAge.getValue();
				int duration = (int) spnrDuration.getValue();
				int height = (int) spnrHeight.getValue();
				int speed = (int) spnrSpeed.getValue();
				int weight = (int) spnrWeight.getValue();

				HealthLog.gender gen = radioBtnFemale.isSelected() ? HealthLog.gender.FEMALE : HealthLog.gender.MALE;
				HealthLog.activityType activity = radioBtnRunning.isSelected() ? HealthLog.activityType.RUNNING : HealthLog.activityType.WALKING;


				healthData = new HealthLog(age, weight, height, gen, activity, speed, duration);
				prev.setVisible(false);
				new ProgramGUI(healthData).setVisible(true);
				
			}

		}

	}

	// Build GroupLayout manager for the form
	public void buildLayout() {
		GroupLayout layout = new GroupLayout(contentPane);
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
												.addGroup(layout.createSequentialGroup()
														.addComponent(lblAge)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(spnrAge, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
												.addGroup(layout.createSequentialGroup()
														.addComponent(lblHeight)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(spnrHeight, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
												.addComponent(lblSpeed, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(layout.createSequentialGroup()
														.addComponent(lblWeight)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(spnrWeight, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
												.addGroup(layout.createSequentialGroup()
														.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
																.addComponent(lblActivity, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(lblGender, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(layout.createParallelGroup(Alignment.LEADING)
																.addGroup(layout.createSequentialGroup()
																		.addComponent(radioBtnMale)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(radioBtnFemale))
																.addGroup(layout.createSequentialGroup()
																		.addComponent(radioBtnRunning)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(radioBtnWalking, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(spnrSpeed, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnSubmit)
								.addGroup(layout.createSequentialGroup()
										.addComponent(lblDuration)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(spnrDuration, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(181, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAge)
								.addComponent(spnrAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblWeight, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(spnrWeight, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHeight, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(spnrHeight, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(radioBtnMale)
								.addComponent(radioBtnFemale))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblActivity, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(radioBtnRunning, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(radioBtnWalking, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSpeed, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(spnrSpeed, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDuration, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(spnrDuration, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
						.addComponent(btnSubmit)
						.addContainerGap())
				);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		contentPane.setLayout(layout);

	}



}


