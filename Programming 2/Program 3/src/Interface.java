import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 * @author Richard Nader
 * Main interface class
 */
public class Interface extends JFrame {

	// Panels
	private JPanel contentPane;
	private JPanel panelCountySelect;
	private JPanel panelData;
	private JPanel panelMap;
	private JScrollPane scrollPane;

	// Components
	private JList listCounties;

	// Data handling
	private DataManager dataManager;

	// Labels
	private JLabel lblName;
	private JLabel lblSeat;
	private JLabel lblFieldName;
	private JLabel lblFieldSeat;
	private JLabel lblFieldYear;
	private JLabel lblYear;
	private JLabel lblFieldNmOrig;
	private JLabel lblNmOrig;
	private JLabel lblFieldArea;
	private JLabel lblFieldPopul;
	private JLabel lblArea;
	private JLabel lblFieldFipsCode;
	private JLabel lblPopul;
	private JLabel lblFipsCode;

	// Menu
	private JMenuBar menuBar;
	private JMenu mnOption;
	private JMenuItem menuOptionSearch;
	private JMenu mnView;
	private JMenuItem mntmSortListAsc;
	private JMenuItem mntmSortListDesc;

	// Action Handler
	ListAction listAction;

	public Interface(DataManager dataManager) {
		this.dataManager = dataManager;

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1240, 862);

		// Menu bar
		MenuAction menuAction = new MenuAction();
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnOption = new JMenu("Option");
		menuBar.add(mnOption);

		menuOptionSearch = new JMenuItem("Search");
		menuOptionSearch.addActionListener(menuAction);
		mnOption.add(menuOptionSearch);

		mnView = new JMenu("View");
		menuBar.add(mnView);

		mntmSortListAsc = new JMenuItem("Sort List Ascending");
		mntmSortListAsc.addActionListener(menuAction);
		mnView.add(mntmSortListAsc);

		mntmSortListDesc = new JMenuItem("Sort List Descending");
		mntmSortListDesc.addActionListener(menuAction);
		mnView.add(mntmSortListDesc);

		// Main container
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Build county list panel
		panelCountySelect = new JPanel();
		panelCountySelect
				.setBorder(new TitledBorder(null, "County Select", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCountySelect.setBounds(15, 0, 286, 775);
		contentPane.add(panelCountySelect);
		panelCountySelect.setLayout(new BorderLayout(0, 0));

		listAction = new ListAction();

		listCounties = new JList(dataManager.getCountySortedByNameAsc());
		listCounties.setVisibleRowCount(46);
		listCounties.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCounties.setSelectedIndex(0);
		listCounties.addListSelectionListener(listAction);
		listCounties.setFont(new Font("Tahoma", Font.PLAIN, 18));

		scrollPane = new JScrollPane();
		scrollPane.setViewportView(listCounties);
		panelCountySelect.add(scrollPane);

		// Build data column
		panelData = new JPanel();
		panelData.setBorder(new TitledBorder(null, "County Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelData.setBounds(301, 0, 918, 775);
		contentPane.add(panelData);
		panelData.setLayout(null);

		lblFieldName = new JLabel("Name:");
		lblFieldName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFieldName.setBounds(15, 47, 80, 45);
		panelData.add(lblFieldName);

		lblName = new JLabel("NULL");
		lblName.setBounds(148, 47, 730, 45);
		panelData.add(lblName);

		lblFieldSeat = new JLabel("Seat:");
		lblFieldSeat.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFieldSeat.setBounds(15, 108, 80, 45);
		panelData.add(lblFieldSeat);

		lblSeat = new JLabel("NULL");
		lblSeat.setBounds(148, 108, 730, 45);
		panelData.add(lblSeat);

		lblFieldYear = new JLabel("Year Founded:");
		lblFieldYear.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFieldYear.setBounds(15, 169, 118, 45);
		panelData.add(lblFieldYear);

		lblYear = new JLabel("NULL");
		lblYear.setBounds(148, 169, 730, 45);
		panelData.add(lblYear);

		lblFieldNmOrig = new JLabel("Name Origin:");
		lblFieldNmOrig.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFieldNmOrig.setBounds(15, 230, 113, 45);
		panelData.add(lblFieldNmOrig);

		lblNmOrig = new JLabel("NULL");
		lblNmOrig.setBounds(148, 230, 730, 45);
		panelData.add(lblNmOrig);

		lblFieldArea = new JLabel("Area #:");
		lblFieldArea.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFieldArea.setBounds(15, 291, 80, 45);
		panelData.add(lblFieldArea);

		lblArea = new JLabel("NULL");
		lblArea.setBounds(148, 291, 730, 45);
		panelData.add(lblArea);

		lblFieldPopul = new JLabel("Population:");
		lblFieldPopul.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFieldPopul.setBounds(15, 352, 94, 45);
		panelData.add(lblFieldPopul);

		lblPopul = new JLabel("NULL");
		lblPopul.setBounds(148, 352, 730, 45);
		panelData.add(lblPopul);

		lblFieldFipsCode = new JLabel("FIPS Code:");
		lblFieldFipsCode.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFieldFipsCode.setBounds(15, 413, 94, 45);
		panelData.add(lblFieldFipsCode);

		lblFipsCode = new JLabel("NULL");
		lblFipsCode.setBounds(148, 413, 730, 45);
		panelData.add(lblFipsCode);

		panelMap = new JPanel();
		panelMap.setBorder(new TitledBorder(null, "Map", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMap.setBounds(15, 458, 200, 234);
		panelData.add(panelMap);
		setVisible(true);
		// Setup data column
		setDataTable((County) listCounties.getSelectedValue());

	}

	// Load data into right column.
	private JLabel imageLbl;

	private void setDataTable(County county) {
		lblName.setText(county.getName());
		lblSeat.setText(county.getSeat());
		lblYear.setText(String.valueOf(county.getYearCreated()));
		lblNmOrig.setText(county.getNameOrigin());
		lblArea.setText(String.valueOf(county.getArea()));
		lblPopul.setText(String.valueOf(county.getPopulation()));
		lblFipsCode.setText(String.valueOf(county.getFipscode()));

		panelMap.removeAll();

		try {
			BufferedImage image = ImageIO.read(new File(county.getMapFileURI()));
			imageLbl = new JLabel(new ImageIcon(image));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Error loading image file <" + county.getMapFileURI() + ">!\n" + e.getMessage());
		}
		panelMap.add(imageLbl);

	}

	// Listen for list selection changes
	private class ListAction implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			try {
				setDataTable((County) listCounties.getSelectedValue());
			} catch (NullPointerException f) {
				listCounties.setSelectedIndex(0);
			}
		}
	}

	// Listen for menu actions
	private class MenuAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Sort ascending
			if (e.getSource() == mntmSortListAsc) {

				listCounties.setListData(dataManager.getCountySortedByNameAsc());
				listCounties.setSelectedIndex(0);
				setDataTable((County) listCounties.getSelectedValue());
				// Sort descending
			} else if (e.getSource() == mntmSortListDesc) {

				listCounties.setListData(dataManager.getCountySortedByNameDec());
				listCounties.setSelectedIndex(0);
				setDataTable((County) listCounties.getSelectedValue());

				// Search
			} else if (e.getSource() == menuOptionSearch) {
				String querry = JOptionPane.showInputDialog("County name or FIPS number:");

				if (querry.isEmpty()) {
					JOptionPane.showMessageDialog(null, "You must enter a County name or FIPS number.");

					// Search by FIPS
				} else if (isNumber(querry)) {
					boolean found = false;
					int FIPS = Integer.parseInt(querry);
					for (int i = 0; i < listCounties.getModel().getSize(); i++) {
						County county = (County) listCounties.getModel().getElementAt(i);
						if (county.getFipscode() == FIPS) {
							listCounties.setSelectedIndex(i);
							setDataTable((County) listCounties.getSelectedValue());
							found = true;
							break;
						}
					}
					if (!found)
						JOptionPane.showMessageDialog(null, "County with FIPS number " + FIPS + " not found!");

					// Search by name
				} else {
					boolean found = false;
					String name = querry;
					for (int i = 0; i < listCounties.getModel().getSize(); i++) {
						County county = (County) listCounties.getModel().getElementAt(i);
						if (county.getName().equalsIgnoreCase(name)) {
							listCounties.setSelectedIndex(i);
							setDataTable((County) listCounties.getSelectedValue());
							found = true;
							break;
						}
					}
					if (!found)
						JOptionPane.showMessageDialog(null, "County with name \"" + name + "\" not found!");
				}
			}

		}

	}

	// Method for testing if a string is a number
	private Boolean isNumber(String str) {
		try {
			int test = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
