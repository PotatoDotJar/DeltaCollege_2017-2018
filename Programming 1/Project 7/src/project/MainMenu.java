package project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;

/**
 * @author Richard Nader
 * Main menu JFrame.
 */
public class MainMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// Main content pane
	private JPanel contentPane;
	
	// Buttons
	JButton btnView1;
	JButton btnView2;
	JButton btnView3;
	
	// Review storage
	ArrayList<ProductReview> reviews;
	ArrayList<ProductAvg> productAverages;
	
	// Construct the frame.
	public MainMenu(ProductBuilder builder) {
		this.reviews = builder.getProductReviews();
		this.productAverages = builder.getProductAverages();
		// Window initialization
		setFont(new Font("Segoe UI", Font.PLAIN, 14));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Main Menu");
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		// New class to handle button events
		ActionHandler eventHandler = new ActionHandler(this, reviews, builder);
		
		// Buttons
		btnView1 = new JButton("Individual Review Histogram");
		btnView1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnView1.addActionListener(eventHandler);
		contentPane.add(btnView1);
		
		btnView2 = new JButton("Lifetime Product Reviews");
		btnView2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnView2.addActionListener(eventHandler);
		contentPane.add(btnView2);
		
		btnView3 = new JButton("Average Monthly Reviews");
		btnView3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnView3.addActionListener(eventHandler);
		contentPane.add(btnView3);
	}
	
	
	// Class to handle button events.
	private class ActionHandler implements ActionListener {

		private JFrame prevWindow;
		private ArrayList<ProductReview> reviews;
		private ProductBuilder builder;
		
		public ActionHandler(JFrame prevFrame, ArrayList<ProductReview> reviews, ProductBuilder builder) {
			this.prevWindow = prevFrame;
			this.reviews = reviews;
			this.builder = builder;
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == btnView1) {
				new ProductHistogram(prevWindow, reviews, productAverages).setVisible(true);
			}
			else if(event.getSource() == btnView2) {
				new LifetimeProdReviews(prevWindow, reviews, productAverages).setVisible(true);
			}
			else if(event.getSource() == btnView3) {
				new AvgMonthlyProdReviews(prevWindow, builder).setVisible(true);
			}
			
			
		}
		
	}

}



