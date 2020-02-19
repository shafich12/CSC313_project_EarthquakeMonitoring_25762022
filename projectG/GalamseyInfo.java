import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;


public class GalamseyInfo extends JFrame {

    private JPanel contentPane;
    private JComboBox<Observatory> comboBox;

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

    // public void initialize(){
    // galamseyFrame = new JFrame();

        public GalamseyInfo() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 450, 300);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);
            
            JLabel ChooseObsLabel = new JLabel("Choose an Observatory");
            ChooseObsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
            ChooseObsLabel.setHorizontalAlignment(SwingConstants.CENTER);
            ChooseObsLabel.setBounds(75, 37, 288, 56);
            contentPane.add(ChooseObsLabel);
            
            comboBox = new JComboBox<Observatory>();
            addToComboBox();
            comboBox.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Object selectedItem = comboBox.getSelectedItem();


                    // for (Observatory m : Monitoring.observatories) {
                    //     String names = m.getObservatoryName();
                    //     comboBox.addItem(names);
                    // }
                    //Observatory.getObservatoryName();
                }
            });
            comboBox.setBounds(100, 89, 222, 40);
            contentPane.add(comboBox);
            
            // JButton MainMenuBt2 = new JButton("Main Menu");
            // MainMenuBt2.addMouseListener(new MouseAdapter() {
            // 	@Override
            // 	public void mouseClicked(MouseEvent e) {
            // 		///To main menu
            // 	}
            // });
            // MainMenuBt2.setBounds(327, 243, 117, 29);
            // contentPane.add(MainMenuBt2);
            
            JButton BackBt = new JButton("Back");
            BackBt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    MonitoringGUI monitoringGui = new MonitoringGUI();
                    monitoringGui.frame.setVisible(true);
                    dispose();
                }
            });
            BackBt.setBounds(6, 243, 117, 29);
            contentPane.add(BackBt);
        
        
        JLabel CreateObsLb = new JLabel("Click The Button Below If There Are No Existing Observatories");
            CreateObsLb.setHorizontalAlignment(SwingConstants.CENTER);
            CreateObsLb.setBounds(21, 154, 393, 56);
            contentPane.add(CreateObsLb);
            
            JButton NewObsBt = new JButton("Create New");
            NewObsBt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ObservatoryInfo observatory = new ObservatoryInfo();
                    observatory.setVisible(true);
                    dispose();
                }
            });
            NewObsBt.setBounds(153, 200, 117, 29);
            contentPane.add(NewObsBt);

            JButton nextBt = new JButton("Next");
            nextBt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (comboBox.getSelectedItem() != null){
                        GalamseyAftObs galamseyAftObs = new GalamseyAftObs();
                        galamseyAftObs.setObservatory((Observatory) comboBox.getSelectedItem());
                        galamseyAftObs.setVisible(true);
                        dispose();
                    }
                }
            });
            nextBt.setBounds(153, 120, 117, 29);
            contentPane.add(nextBt);
        }
        
        //pop up menu method
        
    //	private void popupMenu(JFrame frame) {
    //		
    //	}

        public void addToComboBox(){
            for (Observatory observatory : Monitoring.observatories) {
                comboBox.addItem(observatory);
            }
        }
}
