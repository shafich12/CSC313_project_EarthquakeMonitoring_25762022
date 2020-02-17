import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class SpecifiedStats {

	private JFrame frame;
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtEnterTheObservatory = new JTextField();
		txtEnterTheObservatory.setText("Enter the observatory...");
		txtEnterTheObservatory.setBounds(103, 54, 204, 35);
		frame.getContentPane().add(txtEnterTheObservatory);
		txtEnterTheObservatory.setColumns(10);
		
		JButton btnNewButton = new JButton("Search ");
		btnNewButton.setBounds(162, 100, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Search for specific Statistics");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(39, 11, 356, 32);
		frame.getContentPane().add(lblNewLabel);
	}

}
