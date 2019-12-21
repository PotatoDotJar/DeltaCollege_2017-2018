package project;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
/**
 * @author Richard Nader
 * JFrame for the Avg monthly reviews Window.
 */
public class AvgMonthlyProdReviews extends JFrame {
	private static final long serialVersionUID = 1L;

	// Primary panel
	private JPanel contentPane;

	// Labels
	JLabel title;

	// Back button
	JButton btnBack;

	// Reviews
	private JTextArea textData;

	// Getting loaded data
	private ProductBuilder builder;
	private JPanel header;
	private JLabel lblMonth;
	private JPanel dateSelector;
	private JSpinner spnrMonth;
	private JLabel lblYear;
	private JSpinner spnrYear;

	// Window constructor
	public AvgMonthlyProdReviews(JFrame prevView, ProductBuilder builder) {
		this.builder = builder;

		prevView.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.addActionListener(new BackButton(prevView, this));
		contentPane.add(btnBack, BorderLayout.SOUTH);

		textData = new JTextArea();
		textData.setFont(new Font("Tahoma", Font.PLAIN, 14));



		header = new JPanel();
		contentPane.add(header, BorderLayout.NORTH);
		header.setLayout(new BorderLayout(0, 0));

		title = new JLabel("Individual Product Review By Month");
		header.add(title, BorderLayout.NORTH);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.BOLD, 18));

		dateSelector = new JPanel();
		header.add(dateSelector, BorderLayout.SOUTH);
		dateSelector.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblMonth = new JLabel("Month:");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateSelector.add(lblMonth);

		// Add change listener for spinners
		SpinnerControl spnrControl = new SpinnerControl(textData);
		
		spnrMonth = new JSpinner();
		spnrMonth.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spnrMonth.addChangeListener(spnrControl);
		dateSelector.add(spnrMonth);

		lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateSelector.add(lblYear);

		spnrYear = new JSpinner();
		spnrYear.setModel(new SpinnerNumberModel(new Integer(2010), null, null, new Integer(1)));
		spnrYear.addChangeListener(spnrControl);
		dateSelector.add(spnrYear);
		
		textData.append(getStringForProduct(builder, (Integer) spnrMonth.getValue(), (Integer) spnrYear.getValue()));
		JScrollPane scrollPane = new JScrollPane(textData);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
	}

	// Build string for product reviews by month
	private String getStringForProduct(ProductBuilder builder, int month, int year) {

		ArrayList<ProductReview> reviews = builder.getProductListByMonth(month, year);
		List<Integer> productIDsLoaded = new ArrayList<Integer>();
		HashMap<Integer, Integer> totalReviewsPerProduct = new HashMap<>();
		HashMap<Integer, Integer> numOfReviewsPerProduct = new HashMap<>();
		
		String str = "";
		
		if(reviews.isEmpty())
			return "No reviews for this date...";
		
		
		for(ProductReview review : reviews) {
			if(!productIDsLoaded.contains(review.getProductNumber())) {
				productIDsLoaded.add(review.getProductNumber());
				totalReviewsPerProduct.put(review.getProductNumber(), review.getRating());
				numOfReviewsPerProduct.put(review.getProductNumber(), 1);
			}
			else {
				totalReviewsPerProduct.put(review.getProductNumber(), totalReviewsPerProduct.get(review.getProductNumber()) + review.getRating());
				numOfReviewsPerProduct.put(review.getProductNumber(), numOfReviewsPerProduct.get(review.getProductNumber()) + 1);
			}
		}
		
		

		for(Integer productID : productIDsLoaded) {

			double average = totalReviewsPerProduct.get(productID) / numOfReviewsPerProduct.get(productID);
			
			str += "Product " + productID + " - " + builder.getProductNameByID(productID) + "\n";
			str += "Ave:\t" + average + "\n\n" ;

		}

		return str;
	}

	// Action listener for back button
	private class BackButton implements ActionListener {

		private JFrame prevFrame;
		private JFrame currentFrame;

		public BackButton(JFrame prevFrame, JFrame currentFrame) {
			this.prevFrame = prevFrame;
			this.currentFrame = currentFrame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			prevFrame.setVisible(true);
			currentFrame.setVisible(false);
		}

	}
	
	// Action listener for spinners
	private class SpinnerControl implements ChangeListener {
		
		private JTextArea textOutput;
		
		public SpinnerControl(JTextArea textOutput) {
			this.textOutput = textOutput;
		}
		
		@Override
		public void stateChanged(ChangeEvent e) {
			textOutput.setText("");
			textOutput.append(getStringForProduct(builder, (Integer) spnrMonth.getValue(), (Integer) spnrYear.getValue()));
		}
	}

}
