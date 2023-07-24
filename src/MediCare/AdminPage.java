package MediCare;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import MediCare.AdminSignUp.MyActionListener;

public class AdminPage extends JFrame {

	JLabel TitleLabel;
	JButton SPButton, EButton, GBButton, LOButton;
	
	public AdminPage() {
		//Frame
		setTitle("Admin Page");
		setBounds(10,10,500,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setLayout(null);
		this.getContentPane().setBackground(new java.awt.Color(153,255,204));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Comsats Logo.jpg"));
		
		//Labels
		TitleLabel = new JLabel("Welcome Admin");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setForeground(Color.RED);
		TitleLabel.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 30));
		TitleLabel.setBounds(100, 15, 300, 30);
		getContentPane().add(TitleLabel);
		
		//Buttons
		SPButton = new JButton("Scheduled Patients");
		SPButton.setHorizontalAlignment(SwingConstants.CENTER);
		SPButton.setBounds(180, 70, 150, 25);
		getContentPane().add(SPButton);
		
		EButton = new JButton("Emergency");
		EButton.setHorizontalAlignment(SwingConstants.CENTER);
		EButton.setBounds(180, 110, 150, 25);
		getContentPane().add(EButton);
		
		GBButton = new JButton("Generate Bill");
		GBButton.setHorizontalAlignment(SwingConstants.CENTER);
		GBButton.setBounds(180, 150, 150, 25);
		getContentPane().add(GBButton);
		
		LOButton = new JButton("Log Out");
		LOButton.setHorizontalAlignment(SwingConstants.CENTER);
		LOButton.setBounds(210, 190, 90, 25);
		getContentPane().add(LOButton);
		
		//ActionListener
		MyActionListener mal = new MyActionListener();
		LOButton.addActionListener(mal);
		SPButton.addActionListener(mal);
		GBButton.addActionListener(mal);
		EButton.addActionListener(mal);
	}
	
	public class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand()==("Scheduled Patients")) {
				dispose();
				SchedulePatient m = new SchedulePatient();
			}
			if(e.getActionCommand()==("Emergency")) {
				dispose();
				EmergencyPage m = new EmergencyPage();
			}
			if(e.getActionCommand()==("Generate Bill")) {
				dispose();
				GenerateBill m = new GenerateBill();
			}
			if(e.getActionCommand()==("Log Out")) {
				dispose();
				MainMenu m = new MainMenu();
			}	
		}
	}
	
	public static void main(String[] args) {
      AdminPage b1 = new AdminPage();
  }
}
