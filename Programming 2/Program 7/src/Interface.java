import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Main interface
 * 
 * @author Richard Nader
 */
public class Interface extends JFrame {

	// Panels
	private JPanel contentPane;
	private JPanel panelImageSettings;
	private JPanel panelSettings;
	private JPanel panelBtn;
	private JPanel panelRotationSettings;
	private JPanel panelCustomRotate;
	private JPanel panelFile;

	// Radio Buttons
	private ButtonGroup rdbtnGroup;
	private JRadioButton rdbtnSharpen;
	private JRadioButton rdbtnBlur;
	private JRadioButton rdbtnNone;

	// Buttons
	private JButton btnCommit;
	private JButton btnUndo;

	// Check Boxes
	private JCheckBox chckbxFlipHorizontally;
	private JCheckBox chckbxFlipVertically;
	private JCheckBox chckbxCustomRotation;

	// Slider
	private JSlider sliderRotation;

	// File select dropdown
	private JComboBox listFileSelect;
	private String[] fileList = { "", "myPicture.png", "dogsAndCats.png", "theGreatDoggo.png", "tomHortoms.png",
			"Tom_The_King_Of_The_Hortoms.png" };

	// Undo Stack
	StateStack undoStack;

	private boolean enableUndoSave = true;

	public Interface() {
		// Window settings
		setTitle("Fotoshop Editor - Version 0.0.3A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Undo stack
		undoStack = new StateStack(1000);

		// Action Listener
		IEvent eventHandle = new IEvent();

		// Init Button Panel
		panelBtn = new JPanel();
		contentPane.add(panelBtn, BorderLayout.SOUTH);

		// Init buttons
		btnUndo = new JButton("Undo");
		btnUndo.addActionListener(eventHandle);
		panelBtn.add(btnUndo);
		btnCommit = new JButton("Commit");
		btnCommit.addActionListener(eventHandle);
		panelBtn.add(btnCommit);

		// Init settings panel
		panelSettings = new JPanel();
		contentPane.add(panelSettings, BorderLayout.WEST);
		panelSettings.setLayout(new GridLayout(4, 1, 0, 0));

		// Image settings panel
		panelImageSettings = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelImageSettings.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelImageSettings.setBorder(
				new TitledBorder(null, "Image Settings", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSettings.add(panelImageSettings);

		// Radio buttons

		rdbtnGroup = new ButtonGroup();
		rdbtnSharpen = new JRadioButton("Sharpen");
		rdbtnSharpen.setSelected(true);
		rdbtnGroup.add(rdbtnSharpen);
		rdbtnSharpen.addActionListener(eventHandle);
		panelImageSettings.add(rdbtnSharpen);

		rdbtnBlur = new JRadioButton("Blur");
		rdbtnBlur.addActionListener(eventHandle);
		rdbtnGroup.add(rdbtnBlur);
		panelImageSettings.add(rdbtnBlur);

		rdbtnNone = new JRadioButton("None");
		rdbtnNone.addActionListener(eventHandle);
		rdbtnGroup.add(rdbtnNone);
		panelImageSettings.add(rdbtnNone);

		// Rotation settings panel
		panelRotationSettings = new JPanel();
		panelRotationSettings.setBorder(
				new TitledBorder(null, "Rotation Settings", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSettings.add(panelRotationSettings);

		// Check boxes
		chckbxFlipVertically = new JCheckBox("Flip Vertically");
		chckbxFlipVertically.addActionListener(eventHandle);
		panelRotationSettings.add(chckbxFlipVertically);
		chckbxFlipHorizontally = new JCheckBox("Flip Horizontally");
		chckbxFlipHorizontally.addActionListener(eventHandle);
		panelRotationSettings.add(chckbxFlipHorizontally);

		// Custom rotate settings
		panelCustomRotate = new JPanel();
		panelCustomRotate.setBorder(
				new TitledBorder(null, "Custom Rotation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSettings.add(panelCustomRotate);

		// Custom rotate setting
		chckbxCustomRotation = new JCheckBox("Custom Rotation");
		chckbxCustomRotation.addActionListener(eventHandle);
		chckbxCustomRotation.setHorizontalAlignment(SwingConstants.LEFT);
		panelCustomRotate.add(chckbxCustomRotation);

		// Custom rotate slider
		sliderRotation = new JSlider();
		sliderRotation.setValue(0);
		sliderRotation.setMinimum(0);
		sliderRotation.setMaximum(360);
		sliderRotation.addChangeListener(new IEventChange());
		panelCustomRotate.add(sliderRotation);

		// File select panel
		panelFile = new JPanel();
		panelFile.setBorder(new TitledBorder(null, "Select a File to apply to", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		panelSettings.add(panelFile);

		// File select list
		listFileSelect = new JComboBox(fileList);
		listFileSelect.addActionListener(eventHandle);
		panelFile.add(listFileSelect);
		setVisible(true);

		saveStateToStack();
	}

	// Method to return obj of the current state of the application
	public State getAppState() {
		State state = new State(fileList);

		boolean[] radBtnState = { rdbtnSharpen.isSelected(), rdbtnBlur.isSelected(), rdbtnNone.isSelected() };
		state.setrBtn(radBtnState);

		boolean[] chkBoxState = { chckbxFlipVertically.isSelected(), chckbxFlipHorizontally.isSelected(),
				chckbxCustomRotation.isSelected() };
		state.setChkBox(chkBoxState);

		state.setSliderValue(sliderRotation.getValue());

		state.setListSelectionIndex(listFileSelect.getSelectedIndex());

		return state;
	}

	// Method to set a state to the current application.
	public void setAppState(State state) {
		enableUndoSave = false;
		// Set radio buttons
		rdbtnSharpen.setSelected(state.getrBtn()[0]);
		rdbtnBlur.setSelected(state.getrBtn()[1]);
		rdbtnNone.setSelected(state.getrBtn()[2]);

		// Set check boxes
		chckbxFlipVertically.setSelected(state.getChkBox()[0]);
		chckbxFlipHorizontally.setSelected(state.getChkBox()[1]);
		chckbxCustomRotation.setSelected(state.getChkBox()[2]);

		// Set slider
		sliderRotation.setValue(state.getSliderValue());

		// Set list selection
		listFileSelect.setSelectedIndex(state.getListSelectionIndex());
		enableUndoSave = true;
	}

	// Method to push state data to stack.
	public void saveStateToStack() {
		if (enableUndoSave) {
			System.out.println("Saving undo changes. | " + undoStack.getSize());
			undoStack.push(getAppState());
		}
	}

	// Change in state for check boxes and radio buttons
	private class IEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnUndo || e.getSource() == btnCommit) {

				if (e.getSource() == btnUndo && !undoStack.isEmpty()) {

					setAppState(undoStack.pop());
				} else if (e.getSource() == btnCommit) {
					JOptionPane.showMessageDialog(null, getAppState().toString());
				}

			} else {

				if (e.getSource() == chckbxCustomRotation && chckbxCustomRotation.isSelected()) {
					chckbxFlipHorizontally.setSelected(false);
					chckbxFlipVertically.setSelected(false);
				} else if ((e.getSource() == chckbxFlipHorizontally || e.getSource() == chckbxFlipVertically)
						&& chckbxCustomRotation.isSelected()) {
					chckbxCustomRotation.setSelected(false);
				}

				saveStateToStack();

			}
		}
	}

	int sliderChagesBeforeSave, sliderChangesBeforeSave = 50;

	// Change in state for slider
	private class IEventChange implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {

			if (e.getSource() == sliderRotation) {

				sliderChagesBeforeSave++;
				if (sliderChagesBeforeSave >= sliderChangesBeforeSave) {
					saveStateToStack();
					sliderChagesBeforeSave = 0;
				}
			}

		}
	}

}
