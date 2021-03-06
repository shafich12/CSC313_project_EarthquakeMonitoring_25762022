package galamseymonitoring;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;


public class GalamseyAftObs extends JFrame {

	private JPanel contentPane;
	private JTextField VegColTxt;
	private JTextField ColValTxt;
	private JTextField LatTxt;
	private JTextField LongTxt;
	private JTextField yearStartedTxt;

	private Observatory observatory;
	private String[] colVals = {"1","2","3"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GalamseyAftObs frame = new GalamseyAftObs();
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
	//public JFrame frame;
	public GalamseyAftObs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel galamseyInfoLb = new JLabel("Galamsey Info");
		galamseyInfoLb.setBounds(5, 5, 440, 25);
		galamseyInfoLb.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		galamseyInfoLb.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(galamseyInfoLb);
		
		JLabel VegColLb = new JLabel("Vegetation Colour (Green/Yellow/Brown)");
		VegColLb.setHorizontalAlignment(SwingConstants.LEFT);
		VegColLb.setBounds(22, 62, 254, 16);
		contentPane.add(VegColLb);
		
		VegColTxt = new JTextField();
		VegColTxt.setBounds(278, 57, 130, 26);
		contentPane.add(VegColTxt);
		VegColTxt.setColumns(10);


		
		JLabel ColValLb = new JLabel("Colour Value[Green(1)/Yellow(2)/Brown(3)]");
		ColValLb.setHorizontalAlignment(SwingConstants.LEFT);
		ColValLb.setBounds(22, 107, 265, 16);
		contentPane.add(ColValLb);

		JComboBox comboBox = new JComboBox(colVals);
		comboBox.setBounds(288, 104, 120, 26);
		contentPane.add(comboBox);
		
//		ColValTxt = new JTextField();
//		ColValTxt.setBounds(288, 102, 120, 26);
//		contentPane.add(ColValTxt);
//		ColValTxt.setColumns(10);
		
		JLabel latLb = new JLabel("Latitude");
		latLb.setBounds(22, 152, 58, 16);
		contentPane.add(latLb);
		
		LatTxt = new JTextField();
		LatTxt.setBounds(77, 147, 120, 26);
		contentPane.add(LatTxt);
		LatTxt.setColumns(10);

		
		JLabel longLb = new JLabel("Longitude");
		longLb.setHorizontalAlignment(SwingConstants.LEFT);
		longLb.setBounds(219, 152, 68, 16);
		contentPane.add(longLb);
		
		LongTxt = new JTextField();
		LongTxt.setBounds(287, 147, 121, 26);
		contentPane.add(LongTxt);
		LongTxt.setColumns(10);
		
		JLabel YearLb = new JLabel("Year Started");
		YearLb.setBounds(22, 197, 81, 16);
		contentPane.add(YearLb);
		
		yearStartedTxt = new JTextField();
		yearStartedTxt.setBounds(106, 192, 91, 26);
		contentPane.add(yearStartedTxt);
		yearStartedTxt.setColumns(10);
		
		JButton finishBt2 = new JButton("FINISH");
		finishBt2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(VegColTxt.getText().isEmpty() || LongTxt.getText().isEmpty()
				|| LatTxt.getText().isEmpty() || yearStartedTxt.getText().isEmpty()){
					JOptionPane.showMessageDialog(finishBt2, "Fields cannot be empty");
				}else {
					try {
						String vegCol = VegColTxt.getText().trim();
						int ColourValue = Integer.parseInt((String) comboBox.getSelectedItem());
						double LongitudeTxt = Double.parseDouble(LongTxt.getText());
						double LatitudeTxt = Double.parseDouble(LatTxt.getText());
						int yearStd = Integer.parseInt(yearStartedTxt.getText());

						if((vegCol.toLowerCase().equals("green") && ColourValue != 1) || (vegCol.toLowerCase().equals("yellow") && ColourValue != 2)
						|| (vegCol.toLowerCase().equals("brown") && ColourValue !=3)){
							JOptionPane.showMessageDialog(finishBt2, "Colour Value does not correspond to colour option");
						}else{
							observatory.createEvent(Galamsey.colour.valueOf(vegCol.toLowerCase()),
									ColourValue, new Position(LatitudeTxt, LongitudeTxt), yearStd);
							JOptionPane.showMessageDialog(finishBt2, "Galamsey Record Created Successfully!!");
						}


					} catch(NumberFormatException n){
						JOptionPane.showMessageDialog(finishBt2, "Wrong values in field.");
					} catch(IllegalArgumentException a){
						JOptionPane.showMessageDialog(finishBt2, "Please choose the right colour option.");
					}
				}

			}
		});
		finishBt2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		finishBt2.setBounds(167, 230, 117, 29);
		contentPane.add(finishBt2);
		
		JButton backBt = new JButton("Back");
		backBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		backBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				GalamseyInfo gInfo = new GalamseyInfo();
				gInfo.setVisible(true);
			}
		});
		backBt.setBounds(6, 231, 58, 29);
		contentPane.add(backBt);

		
		JButton exitBt2 = new JButton("Exit");
		exitBt2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		exitBt2.setBounds(354, 231, 91, 29);
		contentPane.add(exitBt2);
	}

	public void setObservatory(Observatory o ){
		this.observatory = o;
	}
}
	


