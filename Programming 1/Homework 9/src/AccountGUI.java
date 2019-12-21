// Delta College - CST 183 - Klingler 
// This application builds a non-functioning GUI for management of
// an account
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AccountGUI extends JFrame 
{
   private JTextField amtField;
   private JButton transactButton, cancelButton;
   private JLabel amtLabel, titleLabel;
   private JComboBox transactType;
   private JRadioButton savings,checking,stocks;
   private ButtonGroup radioGroup;
   private JPanel titlePanel;      // For bank title

   private String transactStrings[] =
      { "Deposit", "Withdrawal", "Balance", "Close" };
      
   private JPanel paneltopLeft,paneltopCenter;
   private JPanel bottomButtonPanel;
   private JPanel topPanel;
   
   public AccountGUI()
   {
      // TOP LEFT panel
      paneltopLeft = new JPanel();
      paneltopLeft.setLayout( new GridLayout(2,1) );

      // Amount entry text field
      amtField = new JTextField( 8 );
      paneltopLeft.add( amtField );

      // Amount label
      amtLabel = new JLabel( "Enter Amount" );
      paneltopLeft.add( amtLabel );

      // TOP CENTER panel
      paneltopCenter = new JPanel();
      paneltopCenter.setLayout( new GridLayout(3,1) );

      // Create radio buttons
      savings = new JRadioButton( "Savings", true );
      paneltopCenter.add( savings );
      checking = new JRadioButton( "Checking", false);
      paneltopCenter.add( checking );
      stocks = new JRadioButton("Stocks", false);
      paneltopCenter.add( stocks );

      // create logical relationship between JRadioButtons
      radioGroup = new ButtonGroup();
      radioGroup.add( savings );
      radioGroup.add( checking );
      radioGroup.add( stocks );

      // Create transaction type list
      transactType = new JComboBox( transactStrings );

      // Build panel at top
      topPanel = new JPanel();
      topPanel.setLayout( new GridLayout(1,3) );
      topPanel.add( transactType );
      topPanel.add( paneltopCenter );
      topPanel.add( paneltopLeft );
 
      // Create logo panel and color/font attributes
      titleLabel = new JLabel("Fildwire Credit Union");
      titleLabel.setFont( new Font( "Monospaced", Font.ITALIC, 24 ) );
      titleLabel.setForeground(Color.LIGHT_GRAY);
      titlePanel = new JPanel();
      titlePanel.setBackground(Color.DARK_GRAY);
      titlePanel.add(titleLabel);
 
      // Create button to perform transaction
      bottomButtonPanel = new JPanel();
      bottomButtonPanel.setLayout( new FlowLayout() );
      transactButton = new JButton( "Make Transaction" );
      bottomButtonPanel.add( transactButton );
      cancelButton = new JButton( "Cancel" );
      bottomButtonPanel.add( cancelButton );

      // Set up frame
      Container container = getContentPane();
      container.setLayout( new GridLayout(3,1) );
      
      container.add(titlePanel);            // Middle drawing panel
      container.add(topPanel);              // Top panel
      container.add(bottomButtonPanel);     // Button at botton
   }

   public static void main( String args[] )
   { 
      AccountGUI app = new AccountGUI();

      // Set application attributes
      app.setSize( 325, 150 );
      app.setVisible( true );
      app.setTitle( "Fildwire Credit Union" );
      app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }
}

