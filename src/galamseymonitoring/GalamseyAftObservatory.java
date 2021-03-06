package galamseymonitoring;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GalamseyAftObservatory extends JFrame {

	private JPanel contentPane;
	private JTextField VegColTxt;
	private JTextField ColValTxt;
	private JTextField LatTxt;
	private JTextField LongTxt;
	private JTextField yearStartedTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GalamseyAftObservatory frame = new GalamseyAftObservatory();
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
	public GalamseyAftObservatory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		ColValTxt = new JTextField();
		ColValTxt.setBounds(288, 102, 120, 26);
		contentPane.add(ColValTxt);
		ColValTxt.setColumns(10);
		
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
		
		JButton finishBt = new JButton("FINISH");
		finishBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Create galamseyData
			}
		});
		finishBt.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		finishBt.setBounds(167, 230, 117, 29);
		contentPane.add(finishBt);
		
		JButton backBt = new JButton("Back");
		backBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		backBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				GalamseyInfo galamseyInfo = new GalamseyInfo();
				galamseyInfo.setVisible(true);
			}
		});
		backBt.setBounds(6, 231, 58, 29);
		contentPane.add(backBt);
	}

}