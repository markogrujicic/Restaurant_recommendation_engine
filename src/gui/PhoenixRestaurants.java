package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.SystemColor;

public class PhoenixRestaurants extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhoenixRestaurants frame = new PhoenixRestaurants();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PhoenixRestaurants() {
		setResizable(false);
		setTitle("Phoenix restaurants");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Choose restaurant attributes:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 11, 182, 14);
		contentPane.add(lblNewLabel);

		JPanel pnl_attributes = new JPanel();
		pnl_attributes.setForeground(new Color(255, 255, 255));
		pnl_attributes.setFont(new Font("Tahoma", Font.BOLD, 11));
		pnl_attributes.setBackground(new Color(102, 153, 255));
		pnl_attributes.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Attributes", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		pnl_attributes.setBounds(10, 36, 399, 391);
		contentPane.add(pnl_attributes);
		pnl_attributes.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Stars:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 29, 46, 14);
		pnl_attributes.add(lblNewLabel_1);

		JLabel lblGoodFor = new JLabel("Good for:");
		lblGoodFor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGoodFor.setForeground(new Color(255, 255, 255));
		lblGoodFor.setBounds(10, 59, 71, 14);
		pnl_attributes.add(lblGoodFor);

		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategory.setForeground(new Color(255, 255, 255));
		lblCategory.setBounds(10, 89, 83, 14);
		pnl_attributes.add(lblCategory);

		JLabel lblReservations = new JLabel("Reservations:");
		lblReservations.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReservations.setForeground(new Color(255, 255, 255));
		lblReservations.setBounds(10, 149, 91, 14);
		pnl_attributes.add(lblReservations);

		JLabel lblPriceRange = new JLabel("Price range:");
		lblPriceRange.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPriceRange.setForeground(new Color(255, 255, 255));
		lblPriceRange.setBounds(10, 119, 83, 14);
		pnl_attributes.add(lblPriceRange);

		JLabel lblAmbience = new JLabel("Ambience:");
		lblAmbience.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAmbience.setForeground(new Color(255, 255, 255));
		lblAmbience.setBounds(10, 209, 71, 14);
		pnl_attributes.add(lblAmbience);

		JLabel lblNoiseLevel = new JLabel("Noise level:");
		lblNoiseLevel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNoiseLevel.setForeground(new Color(255, 255, 255));
		lblNoiseLevel.setBounds(10, 239, 71, 14);
		pnl_attributes.add(lblNoiseLevel);

		JLabel lblParking = new JLabel("Parking:");
		lblParking.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblParking.setForeground(new Color(255, 255, 255));
		lblParking.setBounds(10, 179, 59, 14);
		pnl_attributes.add(lblParking);

		JLabel lblWifi = new JLabel("Wi-Fi:");
		lblWifi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWifi.setForeground(new Color(255, 255, 255));
		lblWifi.setBounds(10, 269, 83, 14);
		pnl_attributes.add(lblWifi);

		JLabel lblOutdoorSeating = new JLabel("Outdoor seating:");
		lblOutdoorSeating.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOutdoorSeating.setForeground(new Color(255, 255, 255));
		lblOutdoorSeating.setBounds(10, 299, 124, 14);
		pnl_attributes.add(lblOutdoorSeating);

		JLabel lblAttire = new JLabel("Attire:");
		lblAttire.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAttire.setForeground(new Color(255, 255, 255));
		lblAttire.setBounds(10, 329, 46, 14);
		pnl_attributes.add(lblAttire);
		pnl_attributes.repaint();

		final JComboBox cmb_Category = new JComboBox();
		cmb_Category.setBackground(SystemColor.control);
		cmb_Category.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmb_Category.setForeground(Color.BLUE);
		cmb_Category.setModel(new DefaultComboBoxModel(new String[] {"Thai", "Mexican", "American (Traditional)", "American (New)", "Asian Fusion", "British", "Chinese", "Caribbean", "Cambodian", "Delis", "French", "Greek", "Hawaiian", "Irish", "Japanese", "Latin American", "Mediterranean", "Pakistani", "Polish", "Salvadoran", "Szechuan", "Vietnamese", "Seafood", "Barbeque", "Burgers", "Buffets", "Chicken Wings", "Cheesesteaks", "Fish & Chips", "Gluten-Free", "Hot Dogs", "Ice Cream & Frozen Yogurt", "Pizza", "Steakhouses", "Sandwiches", "Salad", "Soul Food", "Sushi Bars", "Vegetarian"}));
		cmb_Category.setBounds(177, 85, 148, 22);
		pnl_attributes.add(cmb_Category);

		final JComboBox cmb_Reservations = new JComboBox();
		cmb_Reservations.setBackground(SystemColor.control);
		cmb_Reservations.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmb_Reservations.setForeground(Color.BLUE);
		cmb_Reservations.setModel(new DefaultComboBoxModel(new String[] {"Needed", "Not needed"}));
		cmb_Reservations.setBounds(177, 145, 148, 22);
		pnl_attributes.add(cmb_Reservations);

		final JComboBox cmb_Parking = new JComboBox();
		cmb_Parking.setBackground(SystemColor.control);
		cmb_Parking.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmb_Parking.setForeground(Color.BLUE);
		cmb_Parking.setModel(new DefaultComboBoxModel(new String[] {"Available", "Not available"}));
		cmb_Parking.setBounds(177, 175, 148, 22);
		pnl_attributes.add(cmb_Parking);

		final JComboBox cmb_Ambience = new JComboBox();
		cmb_Ambience.setBackground(SystemColor.control);
		cmb_Ambience.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmb_Ambience.setForeground(Color.BLUE);
		cmb_Ambience.setModel(new DefaultComboBoxModel(new String[] {"Romantic", "Intimate", "Touristy", "Hipster", "Divey", "Classy", "Trendy", "Upscale", "Casual"}));
		cmb_Ambience.setBounds(176, 205, 149, 22);
		pnl_attributes.add(cmb_Ambience);

		final JComboBox cmb_NoiseLevel = new JComboBox();
		cmb_NoiseLevel.setBackground(SystemColor.control);
		cmb_NoiseLevel.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmb_NoiseLevel.setForeground(Color.BLUE);
		cmb_NoiseLevel.setModel(new DefaultComboBoxModel(new String[] {"quiet", "average", "loud"}));
		cmb_NoiseLevel.setBounds(177, 235, 148, 22);
		pnl_attributes.add(cmb_NoiseLevel);

		final JComboBox cmb_WiFi = new JComboBox();
		cmb_WiFi.setBackground(SystemColor.control);
		cmb_WiFi.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmb_WiFi.setForeground(Color.BLUE);
		cmb_WiFi.setModel(new DefaultComboBoxModel(new String[] {"No", "Free"}));
		cmb_WiFi.setBounds(176, 265, 149, 22);
		pnl_attributes.add(cmb_WiFi);

		final JComboBox cmb_OutdoorSeating = new JComboBox();
		cmb_OutdoorSeating.setBackground(SystemColor.control);
		cmb_OutdoorSeating.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmb_OutdoorSeating.setForeground(Color.BLUE);
		cmb_OutdoorSeating.setModel(new DefaultComboBoxModel(new String[] {"No", "Yes"}));
		cmb_OutdoorSeating.setBounds(176, 295, 149, 22);
		pnl_attributes.add(cmb_OutdoorSeating);

		final JComboBox cmb_Attire = new JComboBox();
		cmb_Attire.setBackground(SystemColor.control);
		cmb_Attire.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmb_Attire.setForeground(Color.BLUE);
		cmb_Attire.setModel(new DefaultComboBoxModel(new String[] {"Casual", "Dressy"}));
		cmb_Attire.setBounds(176, 325, 149, 22);
		pnl_attributes.add(cmb_Attire);

		final JComboBox cmb_GoodFor = new JComboBox();
		cmb_GoodFor.setBackground(SystemColor.control);
		cmb_GoodFor.setModel(new DefaultComboBoxModel(new String[] {"breakfast", "brunch", "lunch", "dessert ", "dinner", "latenight "}));
		cmb_GoodFor.setForeground(Color.BLUE);
		cmb_GoodFor.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmb_GoodFor.setBounds(177, 56, 148, 22);
		pnl_attributes.add(cmb_GoodFor);
		
		final JComboBox cmb_Stars = new JComboBox();
		cmb_Stars.setBackground(SystemColor.control);
		cmb_Stars.setModel(new DefaultComboBoxModel(new String[] {"*", "**", "***", "****", "*****"}));
		cmb_Stars.setForeground(Color.BLUE);
		cmb_Stars.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmb_Stars.setBounds(177, 24, 148, 22);
		pnl_attributes.add(cmb_Stars);
		
		final JComboBox cmb_PriceRange = new JComboBox();
		cmb_PriceRange.setBackground(SystemColor.control);
		cmb_PriceRange.setModel(new DefaultComboBoxModel(new String[] {"$", "$$", "$$$"}));
		cmb_PriceRange.setForeground(Color.BLUE);
		cmb_PriceRange.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmb_PriceRange.setBounds(177, 114, 148, 22);
		pnl_attributes.add(cmb_PriceRange);

		JLabel lblYourCurrentPosition = new JLabel("You are near:");
		lblYourCurrentPosition.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblYourCurrentPosition.setForeground(new Color(255, 255, 255));
		lblYourCurrentPosition.setBounds(419, 56, 131, 14);
		contentPane.add(lblYourCurrentPosition);


		final JComboBox cmb_Position = new JComboBox();
		cmb_Position.setBackground(SystemColor.control);
		cmb_Position.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmb_Position.setForeground(Color.BLUE);
		cmb_Position.setModel(new DefaultComboBoxModel(new String[] {"Harmon park", "Nuestro park", "Central park", "East Lake park", "Verde park", "Library park", "Civic Space park"}));
		cmb_Position.setBounds(419, 81, 142, 20);
		contentPane.add(cmb_Position);

		JButton btn_Match = new JButton("Match");
		btn_Match.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Match.setForeground(Color.BLUE);
		btn_Match.setBackground(new Color(175, 238, 238));
		btn_Match.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(245, 255, 250)));
		btn_Match.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhoenixRestaurantsControler.matchRestaurants(cmb_Stars,cmb_PriceRange,cmb_Reservations,cmb_Parking,cmb_WiFi,cmb_NoiseLevel,cmb_Attire,cmb_OutdoorSeating,cmb_Category, cmb_GoodFor,cmb_Ambience,cmb_Position);
			}
		});
		btn_Match.setBounds(419, 128, 142, 66);
		contentPane.add(btn_Match);

	}
}
