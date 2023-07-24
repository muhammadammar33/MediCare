package MediCare;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class PatientPage extends JFrame {

	JLabel TitleLabel;
	JButton SPButton, IDButton, GBButton, LOButton, BillButton;
	
	public PatientPage() {
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
		TitleLabel = new JLabel("Welcome Patient " + MainMenu.NTF.getText());
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setForeground(Color.RED);
		TitleLabel.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 30));
		TitleLabel.setBounds(10, 15, 490, 30);
		getContentPane().add(TitleLabel);
		
		//Buttons
		SPButton = new JButton("Show Doctors");
		SPButton.setHorizontalAlignment(SwingConstants.CENTER);
		SPButton.setBounds(150, 70, 200, 25);
		getContentPane().add(SPButton);
		
		IDButton = new JButton("Book Appointment");
		IDButton.setHorizontalAlignment(SwingConstants.CENTER);
		IDButton.setBounds(150, 110, 200, 25);
		getContentPane().add(IDButton);
		
		GBButton = new JButton("View Doctor's Description");
		GBButton.setHorizontalAlignment(SwingConstants.CENTER);
		GBButton.setBounds(150, 150, 200, 25);
		getContentPane().add(GBButton);
		
		BillButton = new JButton("Bill");
		BillButton.setHorizontalAlignment(SwingConstants.CENTER);
		BillButton.setBounds(150, 190, 200, 25);
		getContentPane().add(BillButton);
		
		LOButton = new JButton("Log Out");
		LOButton.setHorizontalAlignment(SwingConstants.CENTER);
		LOButton.setBounds(200, 230, 90, 25);
		getContentPane().add(LOButton);		
		
		//ActionListener
		MyActionListener mal = new MyActionListener();
		SPButton.addActionListener(mal);
		LOButton.addActionListener(mal);
		IDButton.addActionListener(mal);
		GBButton.addActionListener(mal);
		BillButton.addActionListener(mal);
	}
	
	public class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand()==("Show Doctors")) {
				dispose();
				ViewDoctors m = new ViewDoctors();	
			}
			if(e.getActionCommand()==("Book Appointment")) {
				dispose();
				BookAppointment m = new BookAppointment();	
			}
			if(e.getActionCommand()==("View Doctor's Description")) {
				ArrayList<Report> r1 = Report.readFromFile();
				String n = MainMenu.NTF.getText();
		        boolean name = Report.search(n);
//		        System.out.println(n);
//		        System.out.println(name);
//		        System.out.println(r1.get(j).getName());
		        	
				for(int j = 0; j < r1.size(); j++) {
					boolean a = (n.equalsIgnoreCase(r1.get(j).getName()));
		            System.out.println(a);
		        	if((name == true) && (a == true)) {
		        		dispose();
		        		ViewDiagnosticReport m = new ViewDiagnosticReport();
		        	}
				}
			}
			if(e.getActionCommand()==("Bill")) {
				dispose();
				ViewBill m = new ViewBill();	
			}
			if(e.getActionCommand()==("Log Out")) {
				dispose();
				MainMenu m = new MainMenu();
			}
		}
	}
	
	public static void main(String[] args) {
      PatientPage b1 = new PatientPage();
  }
}
