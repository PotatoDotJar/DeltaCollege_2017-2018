

// This application demonstrates a Java Map as it stores CST class names
// using the class code as the key.

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GetCSTCourses extends JFrame {
	Map<String, String> cstData;

	private JComboBox courseNumDropList;
	private JButton doIt;

	private String key;
	private String data;

	private final String DATA_FILENAME = "cstCourses.txt";

	// set up GUI
	public GetCSTCourses() {
		// get content pane and set its layout
		Container container = getContentPane();
		container.setLayout(new FlowLayout());


		// Instantiate file object
		File inputfile = new File(DATA_FILENAME);

		final String delimiter = ","; // Comma separated content

		cstData = new HashMap<String, String>();

		try {
			Scanner inputFileScanner = new Scanner(inputfile);
			while (inputFileScanner.hasNext()) {
				String inputLine = inputFileScanner.nextLine();

				StringTokenizer tokens = new StringTokenizer(inputLine, delimiter);

				key = tokens.nextToken();
				data = tokens.nextToken();

				// Add data for given state to data map
				cstData.put(key, new String(data));
			}
			inputFileScanner.close();

		} catch (IOException e) {
			System.out.println("Problem with file - Shutting down.");
			System.exit(0);
		}

		// Extract key values to store in temporary array - needed for
		// drop-down list data
		String cstListData[] = new String[cstData.size() + 1]; // Size of map

		// Iterate through map, extract key values and assign to array.
		cstListData[0] = ""; // Initial value blank
		int i = 1;
		Set set = cstData.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) iterator.next();
			cstListData[i] = (String) mapEntry.getKey(); // Typecast Object to String
			i++;
		}

		// Set up JComboBox and register its event handler.
		courseNumDropList = new JComboBox(cstListData);
		container.add(courseNumDropList);

		// Set up selection button
		doIt = new JButton("Get Population");
		container.add(doIt);
		doIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (courseNumDropList.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "You must make a selection");
				} else {
					String key = (String) courseNumDropList.getSelectedItem();
					String className = cstData.get(key);

					JOptionPane.showMessageDialog(null,
							"Class name for " + key + " is " + className);

				}
			}
		} // end anonymous inner class
		); // end call to addActionListener

		// Set up application attributes
		setSize(350, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Delta CST Courses");

	}

	public static void main(String args[]) {
		GetCSTCourses application = new GetCSTCourses();
	}
}

