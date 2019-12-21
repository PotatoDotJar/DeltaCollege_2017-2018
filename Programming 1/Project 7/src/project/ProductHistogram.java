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

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
/**
 * @author Richard Nader
 * JFrame for the Product Histogram Window.
 */
public class ProductHistogram extends JFrame {
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
	private JTextArea textData;

	// Window constructor
	public ProductHistogram(JFrame prevView, ArrayList<ProductReview> reviews, ArrayList<ProductAvg> productAverages) {
		this.reviews = reviews;
		this.productAverages = productAverages;
		prevView.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		lblIndividualProductReview = new JLabel("Individual Product Review");
		lblIndividualProductReview.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndividualProductReview.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblIndividualProductReview, BorderLayout.NORTH);

		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.addActionListener(new BackButton(prevView, this));
		contentPane.add(btnBack, BorderLayout.SOUTH);
		
		textData = new JTextArea();
		textData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		for(ProductAvg prouduct : productAverages) {
			textData.append(getStringForProduct(prouduct));
		}
		JScrollPane scrollPane = new JScrollPane(textData);
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}
	
	// Build string for 
	private String getStringForProduct(ProductAvg product) {
		
		String str = "";
		str += "Product " + product.getProductID() + " - " + product.getProductName() + "\n";
		
		int p5 = (int) (((double) product.getNumRate5() / (double) product.getSurveySize()) * 100);
		int p4 = (int) (((double) product.getNumRate4() / (double) product.getSurveySize()) * 100);
		int p3 = (int) (((double) product.getNumRate3() / (double) product.getSurveySize()) * 100);
		int p2 = (int) (((double) product.getNumRate2() / (double) product.getSurveySize()) * 100);
		int p1 = (int) (((double) product.getNumRate1() / (double) product.getSurveySize()) * 100);
		
		p5 = ((p5+5)/10)*10;
		p4 = ((p4+5)/10)*10;
		p3 = ((p3+5)/10)*10;
		p2 = ((p2+5)/10)*10;
		p1 = ((p1+5)/10)*10;

		str += "5 ";
		for(int i = 0; i < p5; i+=10) {
			str += "*";
		}
		str += "\n";
		
		str += "4 ";
		for(int i = 0; i < p4; i+=10) {
			str += "*";
		}
		str += "\n";
		
		str += "3 ";
		for(int i = 0; i < p3; i+=10) {
			str += "*";
		}
		str += "\n";
		
		str += "2 ";
		for(int i = 0; i < p2; i+=10) {
			str += "*";
		}
		str += "\n";
		
		str += "1 ";
		for(int i = 0; i < p1; i+=10) {
			str += "*";
		}
		str += "\n";
		
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

}
