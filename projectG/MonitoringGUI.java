import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MonitoringGUI {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonitoringGUI window = new MonitoringGUI();
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
	public MonitoringGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 690, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton observatoryDataBt = new JButton("Enter Observatory Data");
		observatoryDataBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ObservatoryInfo observatory = new ObservatoryInfo();
				observatory.setVisible(true);
			}
		});
		observatoryDataBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		observatoryDataBt.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		frame.getContentPane().add(observatoryDataBt, BorderLayout.WEST);
		
		JButton galamseyBt = new JButton("Enter Galamsey Data");
		galamseyBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				GalamseyInfo galamsey = new GalamseyInfo();
				galamsey.setVisible(true);
			}
		});
		galamseyBt.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		frame.getContentPane().add(galamseyBt, BorderLayout.CENTER);
		
		JButton showStatsBt = new JButton("Show Statistics");
		showStatsBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MonitoringIO.statsController();
			}
		});
		showStatsBt.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		frame.getContentPane().add(showStatsBt, BorderLayout.EAST);
		
		JButton exitBt = new JButton("Exit");
		exitBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 System.exit(0);
			}
		});
		exitBt.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		frame.getContentPane().add(exitBt, BorderLayout.SOUTH);
		
		JLabel labelBt = new JLabel("PENTAGON GALAMSEY MONITOR");
		labelBt.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(labelBt, BorderLayout.NORTH);
	}

}
