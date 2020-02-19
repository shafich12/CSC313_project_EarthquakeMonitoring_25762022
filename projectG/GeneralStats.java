import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;

public class GeneralStats {

	public JFrame frame;
	private JTable generalStatsTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralStats window = new GeneralStats();
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
	public GeneralStats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 620, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 35, 600, 197);
		frame.getContentPane().add(scrollPane);

		generalStatsTable = new JTable();
		scrollPane.setViewportView(generalStatsTable);
		populateTable();
		
		JLabel lblNewLabel = new JLabel("General Statistics");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(200, 0, 203, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatisticsGUI statisticsGUI = new StatisticsGUI();
				statisticsGUI.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(500, 240, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnPieButton = new JButton("Pie Chart");
		btnPieButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PieChartSample pc = new PieChartSample();
				pc.main(null);

			}
		});
		btnPieButton.setBounds(500, 270, 89, 23);
		frame.getContentPane().add(btnPieButton);
	}

	public void populateTable(){

		try {
			generalStatsTable.setModel(DbUtils.resultSetToTableModel(MonitoringIO.db.showAllRecords()));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
