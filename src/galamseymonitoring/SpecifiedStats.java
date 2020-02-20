package galamseymonitoring;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SpecifiedStats {

	public JFrame frame;
	private JTextField txtEnterTheObservatory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpecifiedStats window = new SpecifiedStats();
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
	public SpecifiedStats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 300, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtEnterTheObservatory = new JTextField();
		txtEnterTheObservatory.setBounds(103, 54, 204, 35);
		frame.getContentPane().add(txtEnterTheObservatory);
		txtEnterTheObservatory.setColumns(10);
		
		JButton btnNewButton = new JButton("Search ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SpecifiedStatsDisplay.comparingValue = Integer.parseInt(txtEnterTheObservatory.getText());
				SpecifiedStatsDisplay specifiedStatsDisplay = new SpecifiedStatsDisplay();
				specifiedStatsDisplay.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(162, 100, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Search for records greater than:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(39, 11, 356, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Back ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatisticsGUI statisticsGUI = new StatisticsGUI();
				statisticsGUI.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
