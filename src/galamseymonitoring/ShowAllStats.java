package galamseymonitoring;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import net.proteanit.sql.DbUtils;

public class ShowAllStats {

	public JFrame frame;
	private JTable allObsTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAllStats window = new ShowAllStats();
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
	public ShowAllStats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel allObsLabel = new JLabel("Statistics for All Observatories");
		allObsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		allObsLabel.setBounds(0, 0, 434, 38);
		allObsLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		
		JButton backBtn = new JButton("Back ");
		backBtn.setBounds(346, 238, 78, 23);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatisticsGUI statisticsGUI = new StatisticsGUI();
				statisticsGUI.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(allObsLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 38, 434, 189);
		frame.getContentPane().add(scrollPane);
		
		allObsTable = new JTable();
		scrollPane.setViewportView(allObsTable);
		frame.getContentPane().add(backBtn);
		try{
			populateTable();
		}catch (SQLException p){
			p.printStackTrace();
		}
	}

	public void populateTable() throws SQLException {
		allObsTable.setModel(DbUtils.resultSetToTableModel(MonitoringIO.db.showObservatories()));
	}
}
