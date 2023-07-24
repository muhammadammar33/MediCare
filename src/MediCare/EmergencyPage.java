package MediCare;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import MediCare.AdminSignUp.MyActionListener;

public class EmergencyPage extends JFrame {

	JLabel TitleLabel, PicLabel, PNLabel, DNLabel, PLabel;
	JTextField PNTF,DNTF,PTF;
	JButton SBButton;
	
	public EmergencyPage() {
		//Frame
		setTitle("Emergency Page");
		setBounds(10,10,550,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setLayout(null);
		this.getContentPane().setBackground(new java.awt.Color(153,255,204));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Comsats Logo.jpg"));
		
		//Labels
		TitleLabel = new JLabel("Emergency Registeration");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setForeground(Color.RED);
		TitleLabel.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 30));
		TitleLabel.setBounds(10, 15, 540, 40);
		getContentPane().add(TitleLabel);
		
		PicLabel = new JLabel();
		PicLabel.setIcon(new ImageIcon("emerg.jpg"));
		PicLabel.setBounds(0, 65, 245, 196);
		getContentPane().add(PicLabel);
		
		PNLabel = new JLabel("Patient Name:");
		PNLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PNLabel.setBounds(230, 80, 120, 20);
		getContentPane().add(PNLabel);
		
		DNLabel = new JLabel("Doctor Name:");
		DNLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DNLabel.setBounds(230, 120, 120, 20);
		getContentPane().add(DNLabel);
		
		PLabel = new JLabel("Problem:");
		PLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PLabel.setBounds(230, 160, 120, 20);
		getContentPane().add(PLabel);
		
		//TextFields
		PNTF = new JTextField("");
		PNTF.setBounds(360, 80, 140, 20);
		getContentPane().add(PNTF);
		
		DNTF = new JTextField("");
		DNTF.setBounds(360, 120, 140, 20);
		getContentPane().add(DNTF);
		
		PTF = new JTextField("");
		PTF.setBounds(360, 160, 140, 20);
		getContentPane().add(PTF);
		
		//Buttons		
		SBButton = new JButton("SUBMIT");
		SBButton.setHorizontalAlignment(SwingConstants.CENTER);
		SBButton.setBounds(350, 210, 90, 25);
		getContentPane().add(SBButton);
		
		//ActionListener
		MyActionListener mal = new MyActionListener();
		SBButton.addActionListener(mal);
		
	}
	
	public class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand()==("SUBMIT")) {
				if(PNTF.getText().isEmpty() || DNTF.getText().isEmpty() || PTF.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Emergency em = new Emergency(PNTF.getText(), DNTF.getText(), PTF.getText());
				Emergency.writeToFile(em);
				JOptionPane.showMessageDialog(null, "Entry Successfull");
				System.out.println(Emergency.readFromFile());
				dispose();
				AdminPage m = new AdminPage();
				return;
			}	
		}
	}
	
	public static void main(String[] args) {
      EmergencyPage b1 = new EmergencyPage();
  }
}
