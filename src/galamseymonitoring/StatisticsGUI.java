package galamseymonitoring;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatisticsGUI {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatisticsGUI window = new StatisticsGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StatisticsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(300, 300, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Show All Statistics ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ShowAllStats showAllStats = new ShowAllStats();
				showAllStats.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(75, 69, 284, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Show General Statistics ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GeneralStats generalStats = new GeneralStats();
				generalStats.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(75, 103, 284, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Show Specified Statistics");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SpecifiedStats specifiedStats = new SpecifiedStats();
				specifiedStats.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(75, 140, 284, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Statistics");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblNewLabel.setBounds(10, 11, 414, 42);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton_3 = new JButton("Main Menu ");
		btnNewButton_3.setForeground(Color.GREEN);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MonitoringGUI monitoringGUI = new MonitoringGUI();
				monitoringGUI.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(310, 227, 114, 23);
		frame.getContentPane().add(btnNewButton_3);

		JLabel lbl = new JLabel("New label");
		lbl.setIcon(new ImageIcon(getClass().getResource("/resources/images/pic3.jpg")));
		lbl.setBounds(0, 0, 450, 300);
		frame.getContentPane().add(lbl);
	}
	}

