package MediCare;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.*;

import MediCare.MainMenu.MyActionListener;

public class NewUserType extends JFrame implements Serializable {

	
	public NewUserType() {
		//Frame
		setTitle("New User Type");
		setBounds(100,100,500,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		this.getContentPane().setBackground(new java.awt.Color(153,255,204));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Comsats Logo.jpg"));
		
		//Labels
		JLabel TypeLabel = new JLabel("Select User Type");
		TypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TypeLabel.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
		TypeLabel.setBounds(150, 30, 180, 25);
		add(TypeLabel);
		
		//Buttons
		JButton AdminButton = new JButton("Admin");
		AdminButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		AdminButton.setBounds(200, 90, 100, 25);
		add(AdminButton);
		
		JButton DoctorButton = new JButton("Doctor");
		DoctorButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		DoctorButton.setBounds(200, 140, 100, 25);
		add(DoctorButton);
		
		JButton PatientButton = new JButton("Patient");
		PatientButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		PatientButton.setBounds(200, 190, 100, 25);
		add(PatientButton);
		
		//ActionListener
		MyActionListener mal = new MyActionListener();
		AdminButton.addActionListener(mal);
		DoctorButton.addActionListener(mal);
		PatientButton.addActionListener(mal);
	}
	
	public class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand()==("Admin")) {
				dispose();
				AdminSignUp a = new AdminSignUp();
			}
			if(e.getActionCommand()==("Doctor")) {
				dispose();
				DoctorSignUp a = new DoctorSignUp();
			}
			if(e.getActionCommand()==("Patient")) {
				dispose();
				PatientSignUp a = new PatientSignUp();
			}
			
		}
		
	}
}
