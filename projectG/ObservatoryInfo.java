import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class ObservatoryInfo extends JFrame {

	private JPanel contentPane;
	private JTextField obsName;
	private JTextField countryLoc;
	private JTextField areaCov;
	private JTextField year;
	private JButton menuBt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObservatoryInfo frame = new ObservatoryInfo();
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
	public ObservatoryInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel countryName = new JLabel("Enter Country Location");
		countryName.setHorizontalAlignment(SwingConstants.LEFT);
		countryName.setBounds(16, 96, 174, 16);
		contentPane.add(countryName);
		
		JLabel areaCovered = new JLabel("Enter Area Covered");
		areaCovered.setHorizontalAlignment(SwingConstants.LEFT);
		areaCovered.setBounds(16, 134, 152, 16);
		contentPane.add(areaCovered);
		
		JLabel yearStarted = new JLabel("Enter Year Observatory Started");
		yearStarted.setHorizontalAlignment(SwingConstants.LEFT);
		yearStarted.setBounds(17, 174, 202, 16);
		contentPane.add(yearStarted);
		
		JLabel obsData = new JLabel("Enter Observatory Name");
		obsData.setHorizontalAlignment(SwingConstants.LEFT);
		obsData.setBounds(17, 58, 152, 16);
		contentPane.add(obsData);
		
		obsName = new JTextField();
		obsName.setBounds(191, 53, 223, 26);
		contentPane.add(obsName);
		obsName.setColumns(10);
		
		countryLoc = new JTextField();
		countryLoc.setBounds(191, 91, 223, 26);
		contentPane.add(countryLoc);
		countryLoc.setColumns(10);
		
		areaCov = new JTextField();
		areaCov.setBounds(191, 129, 223, 26);
		contentPane.add(areaCov);
		areaCov.setColumns(10);
		
		year = new JTextField();
		year.setBounds(221, 169, 130, 26);
		contentPane.add(year);
		year.setColumns(10);
		
		JButton finishBt = new JButton("FINISH");
		finishBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(obsName.getText().isEmpty() || countryLoc.getText().isEmpty() || areaCov.getText().isEmpty() || year.getText().isEmpty()){
					JOptionPane.showMessageDialog(finishBt, "Fields cannot be empty.");
				}else {
					try {
						String name = obsName.getText();
						String country = countryLoc.getText();
						int area = Integer.parseInt(areaCov.getText());
						int yearSt = Integer.parseInt(year.getText());

						Observatory observatory = new Observatory(name, country, area, yearSt);
						observatory.addToDB();
						JOptionPane.showMessageDialog(finishBt, "Observatory Created Successfully!!");
					} catch (SQLException p) {
						p.printStackTrace();
					} catch (NumberFormatException n){
						JOptionPane.showMessageDialog(finishBt, "Wrong values passed into field");
					}

				}

			}
		});
		finishBt.setFont(new Font("SansSerif", Font.PLAIN, 23));
		finishBt.setBounds(104, 229, 117, 29);
		contentPane.add(finishBt);
		
		menuBt = new JButton("Main Menu");
		menuBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                MonitoringGUI monitoringGui = new MonitoringGUI();
                monitoringGui.frame.setVisible(true);
                dispose();
			}
		});
		menuBt.setBounds(332, 229, 112, 29);
		contentPane.add(menuBt);
	}
}

