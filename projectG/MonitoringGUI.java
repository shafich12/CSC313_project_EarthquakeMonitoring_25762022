import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class MonitoringGUI {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MonitoringIO.db.initialLoad();
			MonitoringIO.db.loadGalamseys();
		}catch(SQLException e){
			e.printStackTrace();
		}
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
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 690, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton observatoryDataBt = new JButton("Enter Observatory Data");
		observatoryDataBt.setBounds(230, 65, 225, 53);
		observatoryDataBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		observatoryDataBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				ObservatoryInfo observatory = new ObservatoryInfo();
				observatory.setVisible(true);
			}
		});
		frame.getContentPane().setLayout(null);
		observatoryDataBt.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		frame.getContentPane().add(observatoryDataBt);
		
		JButton galamseyBt = new JButton("Enter Galamsey Data");
		galamseyBt.setBounds(252, 138, 183, 46);
		galamseyBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GalamseyInfo galamsey = new GalamseyInfo();
				galamsey.setVisible(true);
			}
		});
		galamseyBt.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		frame.getContentPane().add(galamseyBt);
		
		JButton showStatsBt = new JButton("Show Statistics");
		showStatsBt.setBounds(275, 196, 142, 46);
		showStatsBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StatisticsGUI statisticsGUI = new StatisticsGUI();
				statisticsGUI.frame.setVisible(true);
				frame.dispose();
			}
		});
		showStatsBt.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		frame.getContentPane().add(showStatsBt);
		
		JButton exitBt = new JButton("Exit");
		exitBt.setBounds(287, 284, 122, 31);
		exitBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 System.exit(0);
			}
		});
		exitBt.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		frame.getContentPane().add(exitBt);
		
		JLabel labelBt = new JLabel("PENTAGON GALAMSEY MONITOR");
		labelBt.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		labelBt.setBounds(0, 0, 690, 53);
		labelBt.setHorizontalAlignment(SwingConstants.CENTER);

		frame.getContentPane().add(labelBt, BorderLayout.NORTH);

		frame.getContentPane().add(labelBt);
	}
}

