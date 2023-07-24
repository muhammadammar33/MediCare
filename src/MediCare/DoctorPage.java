package MediCare;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DoctorPage extends JFrame {

	JLabel TitleLabel;
	JButton SAButton, EPButton, DPButton, LOButton;
	
	public DoctorPage() {
		//Frame
		setTitle("Doctor Page");
		setBounds(10,10,500,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setLayout(null);
		this.getContentPane().setBackground(new java.awt.Color(153,255,204));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Comsats Logo.jpg"));
		
		//Labels
		TitleLabel = new JLabel("Welcome Doctor " + MainMenu.NTF.getText());
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setForeground(Color.RED);
		TitleLabel.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 30));
		TitleLabel.setBounds(10, 15, 490, 40);
		getContentPane().add(TitleLabel);
		
		//Buttons
		SAButton = new JButton("Show Appointments");
		SAButton.setHorizontalAlignment(SwingConstants.CENTER);
		SAButton.setBounds(150, 80, 200, 25);
		getContentPane().add(SAButton);
		
		EPButton = new JButton("Emergency Patients");
		EPButton.setHorizontalAlignment(SwingConstants.CENTER);
		EPButton.setBounds(150, 115, 200, 25);
		getContentPane().add(EPButton);
		
		DPButton = new JButton("Description of Patient");
		DPButton.setHorizontalAlignment(SwingConstants.CENTER);
		DPButton.setBounds(150, 150, 200, 25);
		getContentPane().add(DPButton);
		
		LOButton = new JButton("Log Out");
		LOButton.setHorizontalAlignment(SwingConstants.CENTER);
		LOButton.setBounds(200, 190, 90, 25);
		getContentPane().add(LOButton);
		
		//ActionListener
		MyActionListener mal = new MyActionListener();
		SAButton.addActionListener(mal);
		LOButton.addActionListener(mal);
		EPButton.addActionListener(mal);
		DPButton.addActionListener(mal);
	}
	
	public class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand()==("Show Appointments")) {
				dispose();
				ViewAppointments m = new ViewAppointments();
			}
			if(e.getActionCommand() == ("Emergency Patients")) {
				dispose();
				ViewEmerPatients ep = new ViewEmerPatients();
			}
			if(e.getActionCommand()==("Description of Patient")) {
				dispose();
				DiagnosticReport m = new DiagnosticReport();
			}
			if(e.getActionCommand()==("Log Out")) {
				dispose();
				MainMenu m = new MainMenu();
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
      DoctorPage b1 = new DoctorPage();
  }
}
