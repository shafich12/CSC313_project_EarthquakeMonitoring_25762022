import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.popupMenu;
import java.popMenu;
public class GalamseyInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GalamseyInfo frame = new GalamseyInfo();
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
	public GalamseyInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton chooseObsBt = new JButton("Choose an Observatory");
		chooseObsBt.addMouseListener(new MouseAdapter() {
			private final JPopupMenu popMenu = new JPopupMenu();
			private JMenuItem menuitem = null;
			@Override
			public void mouseClicked(MouseEvent e) {
				return getObservatoryName();
			}
		});
		chooseObsBt.setBounds(99, 73, 246, 29);
		contentPane.add(chooseObsBt);
	}
	
	//pop up menu method
	
	private void popupMenu(JFrame frame) {
		
	}

}
