package project;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;

/**
 * @author Richard Nader
 * JFrame for the Lifetime Product Average Window.
 */
public class LifetimeProdReviews extends JFrame {
	private static final long serialVersionUID = 1L;


	// Primary panel
	private JPanel contentPane;

	// Labels
	JLabel lblIndividualProductReview;

	// Back button
	JButton btnBack;

	// Reviews
	ArrayList<ProductReview> reviews;
	ArrayList<ProductAvg> productAverages;
	
	// Data table
	JTable tblProducts;

	// Main constructor
	public LifetimeProdReviews(JFrame prevView, ArrayList<ProductReview> reviews, ArrayList<ProductAvg> productAverages) {
		this.reviews = reviews;
		this.productAverages = productAverages;
		
		// Sort product averages
		Collections.sort(this.productAverages, new Comparator<ProductAvg>() {
			@Override
			public int compare(ProductAvg o1, ProductAvg o2) {
				if(o2.getAverageRating() > o1.getAverageRating()) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		
		// Set up window
		prevView.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		lblIndividualProductReview = new JLabel("Lifetime Product Reviews");
		lblIndividualProductReview.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndividualProductReview.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblIndividualProductReview, BorderLayout.NORTH);

		// Add button
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.addActionListener(new BackButton(prevView, this));
		contentPane.add(btnBack, BorderLayout.SOUTH);
		
		// Setup table
		String[] columnNames = {
			"Product ID", "Product", "Average Rating"
		};
		Object[][] rowData = new Object[productAverages.size()][3];
		for(int i = 0; i < productAverages.size(); i++) {
			rowData[i][0] = productAverages.get(i).getProductID();
			rowData[i][1] = productAverages.get(i).getProductName();
			rowData[i][2] = productAverages.get(i).getAverageRating();
		}
		tblProducts = new JTable();
		tblProducts.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tblProducts.setModel(new DefaultTableModel(rowData, columnNames));
		tblProducts.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JScrollPane scrollPane = new JScrollPane(tblProducts);
		contentPane.add(scrollPane, BorderLayout.CENTER);
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

}
