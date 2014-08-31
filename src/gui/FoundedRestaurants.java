package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class FoundedRestaurants extends JDialog {
	JPanel panelFirst;
	JPanel panelSecond;
	JPanel panelThird;
	JPanel panelFourth;
	JPanel panelFifth;
	JPanel panelMap;
	JPanel helpPanel; 
	JLabel lbl_RestaurantName1;
	JLabel lbl_RestaurantName2;
	JLabel lbl_RestaurantName3;
	JLabel lbl_RestaurantName4;
	JLabel lbl_RestaurantName5;
	JLabel lbl_Street1;
	JLabel lbl_Street2;
	JLabel lbl_Street3;
	JLabel lbl_Street4;
	JLabel lbl_Street5;
	JLabel lbl_Stars1; 
	JLabel lbl_Stars2;
	JLabel lbl_Stars3;
	JLabel lbl_Stars4;
	JLabel lbl_Stars5;
	JLabel lbl_StarsRating1;
	JLabel lbl_StarsRating2;
	JLabel lbl_StarsRating3;
	JLabel lbl_StarsRating4;
	JLabel lbl_StarsRating5;
	private JLabel lblDistance;
	private JLabel lbl_DistanceKilomter;
	private JLabel label;
	private JLabel lbl_DistanceKilometer2;
	private JLabel label_2;
	private JLabel lbl_DistanceKilometer3;
	private JLabel label_4;
	private JLabel lbl_DistanceKilometer4;
	private JLabel label_6;
	private JLabel lbl_DistanceKilometer5;

	private final JPanel contentPanel = new JPanel();

	public FoundedRestaurants() {
		setResizable(false);
		setMaximumSize(new Dimension(32767, 32767));
		setTitle("Founded restaurants");
		setBounds(100, 100, 896, 462);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 153, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		panelFirst = new JPanel();
		panelFirst.setBackground(new Color(153, 204, 255));
		panelFirst.setForeground(new Color(0, 0, 0));
		panelFirst.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "1. match", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panelFirst.setBounds(10, 11, 250, 120);
		contentPanel.add(panelFirst);
		panelFirst.setLayout(null);

		lbl_RestaurantName1 = new JLabel("Restaurant name");
		lbl_RestaurantName1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_RestaurantName1.setForeground(new Color(255, 255, 255));
		lbl_RestaurantName1.setBounds(10, 11, 213, 14);
		panelFirst.add(lbl_RestaurantName1);

		lbl_Street1 = new JLabel("Street");
		lbl_Street1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Street1.setForeground(new Color(255, 255, 255));
		lbl_Street1.setBounds(10, 36, 230, 14);
		panelFirst.add(lbl_Street1);

		lbl_Stars1 = new JLabel("Stars");
		lbl_Stars1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Stars1.setForeground(new Color(255, 255, 255));
		lbl_Stars1.setBounds(10, 95, 46, 14);
		panelFirst.add(lbl_Stars1);

		lbl_StarsRating1 = new JLabel("starsRating");
		lbl_StarsRating1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_StarsRating1.setForeground(new Color(255, 255, 255));
		lbl_StarsRating1.setBounds(60, 95, 126, 14);
		panelFirst.add(lbl_StarsRating1);

		lblDistance = new JLabel("Distance");
		lblDistance.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDistance.setForeground(new Color(255, 255, 255));
		lblDistance.setBounds(10, 70, 63, 14);
		panelFirst.add(lblDistance);

		lbl_DistanceKilomter = new JLabel(" distanceKilometer");
		lbl_DistanceKilomter.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_DistanceKilomter.setForeground(new Color(255, 255, 255));
		lbl_DistanceKilomter.setBounds(101, 70, 111, 14);
		panelFirst.add(lbl_DistanceKilomter);

		panelThird = new JPanel();
		panelThird.setBackground(new Color(153, 204, 255));
		panelThird.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "3. match", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panelThird.setBounds(10, 154, 250, 120);
		contentPanel.add(panelThird);
		panelThird.setLayout(null);

		lbl_RestaurantName3 = new JLabel("Restaurant name");
		lbl_RestaurantName3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_RestaurantName3.setForeground(new Color(255, 255, 255));
		lbl_RestaurantName3.setBounds(10, 11, 213, 14);
		panelThird.add(lbl_RestaurantName3);

		lbl_Street3 = new JLabel("Street");
		lbl_Street3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Street3.setForeground(new Color(255, 255, 255));
		lbl_Street3.setBounds(10, 36, 230, 14);
		panelThird.add(lbl_Street3);

		lbl_Stars3 = new JLabel("Stars");
		lbl_Stars3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Stars3.setForeground(new Color(255, 255, 255));
		lbl_Stars3.setBounds(10, 95, 46, 14);
		panelThird.add(lbl_Stars3);

		lbl_StarsRating3 = new JLabel("starsRating");
		lbl_StarsRating3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_StarsRating3.setForeground(new Color(255, 255, 255));
		lbl_StarsRating3.setBounds(66, 95, 122, 14);
		panelThird.add(lbl_StarsRating3);

		label_2 = new JLabel("Distance");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setBounds(10, 73, 63, 14);
		panelThird.add(label_2);

		lbl_DistanceKilometer3 = new JLabel(" distanceKilometer");
		lbl_DistanceKilometer3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_DistanceKilometer3.setForeground(new Color(255, 255, 255));
		lbl_DistanceKilometer3.setBounds(101, 73, 122, 14);
		panelThird.add(lbl_DistanceKilometer3);

		panelFifth = new JPanel();
		panelFifth.setBackground(new Color(153, 204, 255));
		panelFifth.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "5. match", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panelFifth.setBounds(10, 298, 250, 120);
		contentPanel.add(panelFifth);
		panelFifth.setLayout(null);

		lbl_RestaurantName5 = new JLabel("Restaurant name");
		lbl_RestaurantName5.setForeground(new Color(255, 255, 255));
		lbl_RestaurantName5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_RestaurantName5.setBounds(10, 11, 213, 14);
		panelFifth.add(lbl_RestaurantName5);

		lbl_Street5 = new JLabel("Street");
		lbl_Street5.setForeground(new Color(255, 255, 255));
		lbl_Street5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Street5.setBounds(10, 36, 230, 14);
		panelFifth.add(lbl_Street5);

		lbl_Stars5 = new JLabel("Stars");
		lbl_Stars5.setForeground(new Color(255, 255, 255));
		lbl_Stars5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Stars5.setBounds(10, 95, 46, 14);
		panelFifth.add(lbl_Stars5);

		lbl_StarsRating5 = new JLabel("starsRating");
		lbl_StarsRating5.setForeground(new Color(255, 255, 255));
		lbl_StarsRating5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_StarsRating5.setBounds(66, 95, 129, 14);
		panelFifth.add(lbl_StarsRating5);

		label_6 = new JLabel("Distance");
		label_6.setForeground(new Color(255, 255, 255));
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(10, 73, 63, 14);
		panelFifth.add(label_6);

		lbl_DistanceKilometer5 = new JLabel(" distanceKilometer");
		lbl_DistanceKilometer5.setForeground(new Color(255, 255, 255));
		lbl_DistanceKilometer5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_DistanceKilometer5.setBounds(111, 73, 112, 14);
		panelFifth.add(lbl_DistanceKilometer5);

		panelFourth = new JPanel();
		panelFourth.setBackground(new Color(153, 204, 255));
		panelFourth.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "4. match", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panelFourth.setBounds(270, 154, 250, 120);
		contentPanel.add(panelFourth);
		panelFourth.setLayout(null);

		lbl_RestaurantName4 = new JLabel("Restaurant name");
		lbl_RestaurantName4.setForeground(new Color(255, 255, 255));
		lbl_RestaurantName4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_RestaurantName4.setBounds(10, 11, 213, 14);
		panelFourth.add(lbl_RestaurantName4);

		lbl_Street4 = new JLabel("Street");
		lbl_Street4.setForeground(new Color(255, 255, 255));
		lbl_Street4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Street4.setBounds(10, 36, 230, 14);
		panelFourth.add(lbl_Street4);

		lbl_Stars4 = new JLabel("Stars");
		lbl_Stars4.setForeground(new Color(255, 255, 255));
		lbl_Stars4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Stars4.setBounds(10, 95, 46, 14);
		panelFourth.add(lbl_Stars4);

		lbl_StarsRating4 = new JLabel("starsRating");
		lbl_StarsRating4.setForeground(new Color(255, 255, 255));
		lbl_StarsRating4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_StarsRating4.setBounds(62, 95, 122, 14);
		panelFourth.add(lbl_StarsRating4);

		label_4 = new JLabel("Distance");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(10, 73, 63, 14);
		panelFourth.add(label_4);

		lbl_DistanceKilometer4 = new JLabel(" distanceKilometer");
		lbl_DistanceKilometer4.setForeground(new Color(255, 255, 255));
		lbl_DistanceKilometer4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_DistanceKilometer4.setBounds(101, 73, 122, 14);
		panelFourth.add(lbl_DistanceKilometer4);

		panelSecond = new JPanel();
		panelSecond.setBackground(new Color(153, 204, 255));
		panelSecond.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "2. match", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panelSecond.setBounds(270, 11, 250, 120);
		contentPanel.add(panelSecond);
		panelSecond.setLayout(null);

		lbl_RestaurantName2 = new JLabel("Restaurant name");
		lbl_RestaurantName2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_RestaurantName2.setForeground(new Color(255, 255, 255));
		lbl_RestaurantName2.setBounds(10, 11, 213, 14);
		panelSecond.add(lbl_RestaurantName2);

		lbl_Street2 = new JLabel("Street");
		lbl_Street2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Street2.setForeground(new Color(255, 255, 255));
		lbl_Street2.setBounds(10, 36, 230, 14);
		panelSecond.add(lbl_Street2);

		lbl_Stars2 = new JLabel("Stars");
		lbl_Stars2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Stars2.setForeground(new Color(255, 255, 255));
		lbl_Stars2.setBounds(10, 95, 46, 14);
		panelSecond.add(lbl_Stars2);

		lbl_StarsRating2 = new JLabel("starsRating");
		lbl_StarsRating2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_StarsRating2.setForeground(new Color(255, 255, 255));
		lbl_StarsRating2.setBounds(62, 95, 122, 14);
		panelSecond.add(lbl_StarsRating2);

		label = new JLabel("Distance");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(10, 73, 63, 14);
		panelSecond.add(label);

		lbl_DistanceKilometer2 = new JLabel(" distanceKilometer");
		lbl_DistanceKilometer2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_DistanceKilometer2.setForeground(new Color(255, 255, 255));
		lbl_DistanceKilometer2.setBounds(101, 73, 122, 14);
		panelSecond.add(lbl_DistanceKilometer2);

		panelMap = new JPanel();
		panelMap.setBackground(Color.LIGHT_GRAY);
		panelMap.setVisible(false);
		panelMap.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMap.setBounds(530, 11, 350, 412);
		contentPanel.add(panelMap);
		panelMap.setLayout(new BorderLayout(0, 0));

		helpPanel = new JPanel();
		panelMap.add(helpPanel, BorderLayout.SOUTH);
	}
	public JPanel getPanelFirst() {
		return panelFirst;
	}

	public void setPanelFirst(JPanel panelFirst) {
		this.panelFirst = panelFirst;
	}

	public JPanel getPanelSecond() {
		return panelSecond;
	}

	public void setPanelSecond(JPanel panelSecond) {
		this.panelSecond = panelSecond;
	}

	public JPanel getPanelThird() {
		return panelThird;
	}

	public void setPanelThird(JPanel panelThird) {
		this.panelThird = panelThird;
	}

	public JPanel getPanelFourth() {
		return panelFourth;
	}

	public void setPanelFourth(JPanel panelFourth) {
		this.panelFourth = panelFourth;
	}

	public JPanel getPanelFifth() {
		return panelFifth;
	}

	public void setPanelFifth(JPanel panelFifth) {
		this.panelFifth = panelFifth;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}
	public JLabel getLbl_RestaurantName1() {
		return lbl_RestaurantName1;
	}

	public void setLbl_RestaurantName1(JLabel lbl_RestaurantName1) {
		this.lbl_RestaurantName1 = lbl_RestaurantName1;
	}

	public JLabel getLbl_RestaurantName2() {
		return lbl_RestaurantName2;
	}

	public void setLbl_RestaurantName2(JLabel lbl_RestaurantName2) {
		this.lbl_RestaurantName2 = lbl_RestaurantName2;
	}

	public JLabel getLbl_RestaurantName3() {
		return lbl_RestaurantName3;
	}

	public void setLbl_RestaurantName3(JLabel lbl_RestaurantName3) {
		this.lbl_RestaurantName3 = lbl_RestaurantName3;
	}

	public JLabel getLbl_RestaurantName4() {
		return lbl_RestaurantName4;
	}

	public void setLbl_RestaurantName4(JLabel lbl_RestaurantName4) {
		this.lbl_RestaurantName4 = lbl_RestaurantName4;
	}

	public JLabel getLbl_RestaurantName5() {
		return lbl_RestaurantName5;
	}

	public void setLbl_RestaurantName5(JLabel lbl_RestaurantName5) {
		this.lbl_RestaurantName5 = lbl_RestaurantName5;
	}

	public JLabel getLbl_Street1() {
		return lbl_Street1;
	}

	public void setLbl_Street1(JLabel lbl_Street1) {
		this.lbl_Street1 = lbl_Street1;
	}

	public JLabel getLbl_Street2() {
		return lbl_Street2;
	}

	public void setLbl_Street2(JLabel lbl_Street2) {
		this.lbl_Street2 = lbl_Street2;
	}

	public JLabel getLbl_Street3() {
		return lbl_Street3;
	}

	public void setLbl_Street3(JLabel lbl_Street3) {
		this.lbl_Street3 = lbl_Street3;
	}

	public JLabel getLbl_Street4() {
		return lbl_Street4;
	}

	public void setLbl_Street4(JLabel lbl_Street4) {
		this.lbl_Street4 = lbl_Street4;
	}

	public JLabel getLbl_Street5() {
		return lbl_Street5;
	}

	public void setLbl_Street5(JLabel lbl_Street5) {
		this.lbl_Street5 = lbl_Street5;
	}

	public JLabel getLbl_Stars1() {
		return lbl_Stars1;
	}

	public void setLbl_Stars1(JLabel lbl_Stars1) {
		this.lbl_Stars1 = lbl_Stars1;
	}

	public JLabel getLbl_Stars2() {
		return lbl_Stars2;
	}

	public void setLbl_Stars2(JLabel lbl_Stars2) {
		this.lbl_Stars2 = lbl_Stars2;
	}

	public JLabel getLbl_Stars3() {
		return lbl_Stars3;
	}

	public void setLbl_Stars3(JLabel lbl_Stars3) {
		this.lbl_Stars3 = lbl_Stars3;
	}

	public JLabel getLbl_Stars4() {
		return lbl_Stars4;
	}

	public void setLbl_Stars4(JLabel lbl_Stars4) {
		this.lbl_Stars4 = lbl_Stars4;
	}

	public JLabel getLbl_Stars5() {
		return lbl_Stars5;
	}

	public void setLbl_Stars5(JLabel lbl_Stars5) {
		this.lbl_Stars5 = lbl_Stars5;
	}

	public JLabel getLbl_StarsRating1() {
		return lbl_StarsRating1;
	}

	public void setLbl_StarsRating1(JLabel lbl_StarsRating1) {
		this.lbl_StarsRating1 = lbl_StarsRating1;
	}

	public JLabel getLbl_StarsRating2() {
		return lbl_StarsRating2;
	}

	public void setLbl_StarsRating2(JLabel lbl_StarsRating2) {
		this.lbl_StarsRating2 = lbl_StarsRating2;
	}

	public JLabel getLbl_StarsRating3() {
		return lbl_StarsRating3;
	}

	public void setLbl_StarsRating3(JLabel lbl_StarsRating3) {
		this.lbl_StarsRating3 = lbl_StarsRating3;
	}

	public JLabel getLbl_StarsRating4() {
		return lbl_StarsRating4;
	}

	public void setLbl_StarsRating4(JLabel lbl_StarsRating4) {
		this.lbl_StarsRating4 = lbl_StarsRating4;
	}

	public JLabel getLbl_StarsRating5() {
		return lbl_StarsRating5;
	}

	public void setLbl_StarsRating5(JLabel lbl_StarsRating5) {
		this.lbl_StarsRating5 = lbl_StarsRating5;
	}
	public JLabel getLbl_DistanceKilometer2() {
		return lbl_DistanceKilometer2;
	}

	public void setLbl_DistanceKilometer2(JLabel lbl_DistanceKilometer2) {
		this.lbl_DistanceKilometer2 = lbl_DistanceKilometer2;
	}

	public JLabel getLbl_DistanceKilometer3() {
		return lbl_DistanceKilometer3;
	}

	public void setLbl_DistanceKilometer3(JLabel lbl_DistanceKilometer3) {
		this.lbl_DistanceKilometer3 = lbl_DistanceKilometer3;
	}

	public JLabel getLbl_DistanceKilometer4() {
		return lbl_DistanceKilometer4;
	}

	public void setLbl_DistanceKilometer4(JLabel lbl_DistanceKilometer4) {
		this.lbl_DistanceKilometer4 = lbl_DistanceKilometer4;
	}

	public JLabel getLbl_DistanceKilometer5() {
		return lbl_DistanceKilometer5;
	}

	public void setLbl_DistanceKilometer5(JLabel lbl_DistanceKilometer5) {
		this.lbl_DistanceKilometer5 = lbl_DistanceKilometer5;
	}

	public JLabel getLblDistancemeter() {
		return lbl_DistanceKilomter;
	}
	public JPanel getHelpPanel() {
		return helpPanel;
	}
	public JPanel getPanelMap() {
		return panelMap;
	}
}
