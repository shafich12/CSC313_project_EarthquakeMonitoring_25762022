import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

public class SpecifiedStatsDisplay {

	public JFrame frame;
	private JTable table;
	public static int comparingValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpecifiedStatsDisplay window = new SpecifiedStatsDisplay();
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
	public SpecifiedStatsDisplay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Your search results ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(1, 0, 432, 28);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(11, 233, 121, 28);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SpecifiedStats specifiedStats = new SpecifiedStats();
				specifiedStats.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.setBounds(303, 233, 121, 28);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatisticsGUI statisticsGUI = new StatisticsGUI();
				statisticsGUI.frame.setVisible(true);
				frame.setVisible(false);
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1, 36, 432, 186);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		frame.getContentPane().add(btnNewButton_1);
		try{
			populateTable();
		}catch(SQLException p){

		}
	}

//	public void setComparingValue(int comparingValue){
//		this.comparingValue = comparingValue;
//	}

	private void populateTable() throws SQLException {
		table.setModel(DbUtils.resultSetToTableModel(MonitoringIO.db.showRecordsGreaterThanValue(comparingValue)));
	}
}
