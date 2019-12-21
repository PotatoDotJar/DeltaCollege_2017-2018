import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;

/**
 * @author Richard Nader
 * JFrame class for populating the window and handle the event handling.
 */
public class SettingsGUI extends JFrame {
	private static final long serialVersionUID = 1L;

	// Window Panels
	private JPanel contentPane;
	private JPanel communicationPanel;
	private JPanel usernamePanel;
	private JPanel settingsPanel;
	private JSplitPane windowPanel;
	private JPanel titlePanel;
	private JTextPane textPanel;
	public JPanel gameDifficultyPanel;
	public JPanel gameSpeedPanel;
	public JPanel gamepieceColorPanel;

	// Components
	private JButton btnSave;
	private JLabel lblSettingsWindow;
	private JTextField usernameField;
	public JCheckBox chckbxEmail;
	public JCheckBox chckbxTextMessages;
	public ButtonGroup communicationButtonGroup;
	public JRadioButton rdbtnBeginner;
	public JRadioButton rdbtnExperienced;
	public JRadioButton rdbtnAdvanced;
	public JRadioButton rdbtnExpert;
	public ButtonGroup difficultyButtonGroup;
	public JSlider sliderGameSpeed;
	public JLabel labelSliderValue;
	public JComboBox gamePieceColorList;

	String[] gamePieceColors = {"RED", "GREEN", "BLUE", "YELLOW", "PURPLE"};

	Settings gameSettings;

	public SettingsGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Window Title Panel
		titlePanel = new JPanel();
		contentPane.add(titlePanel, BorderLayout.NORTH);

		// Window Title Label
		lblSettingsWindow = new JLabel("Settings Window");
		lblSettingsWindow.setFont(new Font("Tahoma", Font.BOLD, 18));
		titlePanel.add(lblSettingsWindow);

		// Main window panel (Split Panel)
		windowPanel = new JSplitPane();
		contentPane.add(windowPanel, BorderLayout.CENTER);

		// Output Text Panel
		textPanel = new JTextPane();
		textPanel.setEditable(false);
		windowPanel.setRightComponent(textPanel);

		// Panel with setting fields
		settingsPanel = new JPanel();
		windowPanel.setLeftComponent(settingsPanel);
		settingsPanel.setLayout(new GridLayout(5, 1, 0, 0));

		// Username Settings Panel
		usernamePanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) usernamePanel.getLayout();
		flowLayout.setHgap(0);
		flowLayout.setVgap(0);
		usernamePanel.setBorder(new TitledBorder(null, "Username", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		settingsPanel.add(usernamePanel);

		// Username text field
		TextFieldUpdateListener textFieldUpdateListener = new TextFieldUpdateListener();
		usernameField = new JTextField();
		usernameField.setText("<Insert Username here>");
		usernameField.setToolTipText("Insert your username.");
		usernamePanel.add(usernameField);
		usernameField.setColumns(24);
		usernameField.addActionListener(textFieldUpdateListener);

		// Panel for communication settings
		communicationPanel = new JPanel();
		communicationPanel.setToolTipText("Check which method of communication to allow for game development updates from the devs.");
		communicationPanel.setBorder(new TitledBorder(null, "Communication", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		settingsPanel.add(communicationPanel);
		communicationPanel.setLayout(new GridLayout(2, 1, 0, 0));

		// Communication Settings
		communicationButtonGroup = new ButtonGroup();
		CommunicationUpdateListener communicationUpdateListener = new CommunicationUpdateListener();

		chckbxEmail = new JCheckBox("Email");
		chckbxEmail.setSelected(true);
		chckbxEmail.addActionListener(communicationUpdateListener);
		communicationButtonGroup.add(chckbxEmail);
		communicationPanel.add(chckbxEmail);


		chckbxTextMessages = new JCheckBox("Text Messages");
		chckbxTextMessages.addActionListener(communicationUpdateListener);
		communicationPanel.add(chckbxTextMessages);
		communicationButtonGroup.add(chckbxTextMessages);

		// Panel for game difficulty settings
		gameDifficultyPanel = new JPanel();
		gameDifficultyPanel.setToolTipText("Choose your prefered game difficulty.");
		gameDifficultyPanel.setBorder(new TitledBorder(null, "Game Difficulty", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		settingsPanel.add(gameDifficultyPanel);
		gameDifficultyPanel.setLayout(new GridLayout(4, 1, 0, 0));


		// JRadioButtons for game difficulty
		difficultyButtonGroup = new ButtonGroup();
		DifficultyUpdateListener difficultyUpdateListener = new DifficultyUpdateListener();

		rdbtnBeginner = new JRadioButton("Beginner");
		rdbtnBeginner.setSelected(true);
		rdbtnBeginner.addActionListener(difficultyUpdateListener);
		gameDifficultyPanel.add(rdbtnBeginner);
		difficultyButtonGroup.add(rdbtnBeginner);

		rdbtnExperienced = new JRadioButton("Experienced");
		rdbtnExperienced.addActionListener(difficultyUpdateListener);
		gameDifficultyPanel.add(rdbtnExperienced);
		difficultyButtonGroup.add(rdbtnExperienced);

		rdbtnAdvanced = new JRadioButton("Advanced");
		rdbtnAdvanced.addActionListener(difficultyUpdateListener);
		gameDifficultyPanel.add(rdbtnAdvanced);
		difficultyButtonGroup.add(rdbtnAdvanced);

		rdbtnExpert = new JRadioButton("Expert");
		rdbtnExpert.addActionListener(difficultyUpdateListener);
		gameDifficultyPanel.add(rdbtnExpert);
		difficultyButtonGroup.add(rdbtnExpert);

		// Game speed panel
		gameSpeedPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) gameSpeedPanel.getLayout();
		gameSpeedPanel.setBorder(new TitledBorder(null, "Game Speed", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		settingsPanel.add(gameSpeedPanel);


		// Game speed slider
		GameSpeedUpdateListener gameSpeedUpdateListener = new GameSpeedUpdateListener();
		sliderGameSpeed = new JSlider();
		sliderGameSpeed.setToolTipText("Choose your prefered game speed.");
		sliderGameSpeed.setPaintLabels(true);
		sliderGameSpeed.addChangeListener(gameSpeedUpdateListener);
		gameSpeedPanel.add(sliderGameSpeed);

		// Label for game speed value
		labelSliderValue = new JLabel("");
		gameSpeedPanel.add(labelSliderValue);
		labelSliderValue.setText(Integer.toString(sliderGameSpeed.getValue()));

		// Game piece color panel
		gamepieceColorPanel = new JPanel();
		gamepieceColorPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Game Piece Color", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		settingsPanel.add(gamepieceColorPanel);
		// Game piece color list
		GamePieceColorUpdateListener colorUpdateListener = new GamePieceColorUpdateListener();
		gamePieceColorList = new JComboBox(gamePieceColors);
		gamePieceColorList.setEditable(true);
		gamePieceColorList.setSelectedIndex(0);
		gamePieceColorList.addItemListener(colorUpdateListener);
		gamepieceColorPanel.add(gamePieceColorList);

		// Save Settings Button
		SaveButton saveButtonListener = new SaveButton(this);
		btnSave = new JButton("Save");
		btnSave.addActionListener(saveButtonListener);
		contentPane.add(btnSave, BorderLayout.SOUTH);


		// Populate game settings obj
		gameSettings = new Settings(usernameField.getName(), Settings.ContactPrefrence.EMAIL, Settings.Difficulty.BEGINNER, sliderGameSpeed.getValue(), Settings.GamePieceColor.RED);

		// Set window visible
		setVisible(true);
	}

	// Set text in output pane
	public void updateTextOutput() {
		textPanel.setText(gameSettings.toString());
	}

	// Listener for Username field change
	private class TextFieldUpdateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!usernameField.getText().equals("") && usernameField.getText() != null) {
				if(usernameField.getText().contains(" ")) {
					System.err.println("Invalid username");
					JOptionPane.showMessageDialog(null, "Username cannot contain spaces");
					String editedUsername = "";

					// Loop through username and replace spaces with underscores
					for(int i = 0; i < usernameField.getText().length(); i++) {
						char currentChar = usernameField.getText().charAt(i);
						// If current char is a space then replace it with an underscore
						if(currentChar == ' ')
							editedUsername += "_";
						else 
							editedUsername += currentChar;
					}

					usernameField.setText(editedUsername);
					gameSettings.setUsername(editedUsername);
				}
				else {
					gameSettings.setUsername(usernameField.getText());
					System.out.println(usernameField.getText());
				}
			}
			else {
				gameSettings.setUsername("");
				System.err.println("Invalid username");
				JOptionPane.showMessageDialog(null, "Invalid username!");
				usernameField.setText("");
			}
			updateTextOutput();
		}
	}

	// Listener for communication method change
	private class CommunicationUpdateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(chckbxEmail.isSelected()) {
				gameSettings.setContactPrefrence(Settings.ContactPrefrence.EMAIL);
				//System.out.println("EMAIL");
			}
			else if(chckbxTextMessages.isSelected()) {
				gameSettings.setContactPrefrence(Settings.ContactPrefrence.TEXT);
				//System.out.println("TEXT_MESSAGES");
			}
			updateTextOutput();
		}
	}

	// Listener for difficulty change
	private class DifficultyUpdateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (rdbtnBeginner.isSelected()) {
				//System.out.println("BEGINNER");
				gameSettings.setGameDifficulty(Settings.Difficulty.BEGINNER);
			}
			else if (rdbtnExperienced.isSelected()) {
				//System.out.println("EXPERIENCED");
				gameSettings.setGameDifficulty(Settings.Difficulty.EXPERIANCED);
			}
			else if (rdbtnAdvanced.isSelected()) {
				//System.out.println("ADVANCED");
				gameSettings.setGameDifficulty(Settings.Difficulty.ADVANCED);
			}
			else if (rdbtnExpert.isSelected()) {
				//System.out.println("EXPERT");
				gameSettings.setGameDifficulty(Settings.Difficulty.EXPERT);
			}
			updateTextOutput();
		}
	}

	// Listener for game speed slider change
	private class GameSpeedUpdateListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			//System.out.println("Game Speed: " + sliderGameSpeed.getValue());
			labelSliderValue.setText(Integer.toString(sliderGameSpeed.getValue()));
			gameSettings.setGameSpeed(sliderGameSpeed.getValue());
			updateTextOutput();
		}
	}

	// Listener for game piece color change
	private class GamePieceColorUpdateListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			gameSettings.setGamePieceColor(Settings.getColorEnumFromString((String) gamePieceColorList.getSelectedItem()));
			//System.out.println(gamePieceColorList.getSelectedItem());
			updateTextOutput();
		}
	}

	// Listener for save button
	private class SaveButton implements ActionListener {
		JFrame window;
		public SaveButton(JFrame window) {
			this.window = window;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println("Save button");
			window.setVisible(false);
			JOptionPane.showMessageDialog(null, "Settings saved!");
			// Other stuff for settings file save here!
			System.exit(0);
		}
	}

}