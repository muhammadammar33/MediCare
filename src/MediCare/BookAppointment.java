package MediCare;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.*;

public class BookAppointment extends JFrame implements Serializable{

	Appointments App;
	JLabel TitleLabel, PicLabel, PLabel, NameLabel, DNameLabel, DOALabel, TOALabel;
	JButton SubmitButton;
	JTextField PTF, NTF, DNTF, TTF;
	JComboBox DCB,MCB,YCB;
	
	public BookAppointment() {
		setTitle("Book Appointment");
		setBounds(10,10,650,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setLayout(null);
		this.getContentPane().setBackground(new java.awt.Color(153,255,204));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Comsats Logo.jpg"));
		
		TitleLabel = new JLabel("Book Appointment");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setForeground(Color.RED);
		TitleLabel.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 30));
		TitleLabel.setBounds(300, 10, 300, 40);
		getContentPane().add(TitleLabel);
		
		PicLabel = new JLabel();
		PicLabel.setIcon(new ImageIcon("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Appointment.jpg"));
		PicLabel.setBounds(0, 0, 260, 260);
		getContentPane().add(PicLabel);
		
		NameLabel = new JLabel("Patient Name:");
		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NameLabel.setBounds(300, 70, 130, 20);
		getContentPane().add(NameLabel);
		
		DNameLabel = new JLabel("Doctor Name:");
		DNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DNameLabel.setBounds(300, 100, 130, 20);
		getContentPane().add(DNameLabel);
		
		DOALabel = new JLabel("Date Of Appointment:");
		DOALabel.setHorizontalAlignment(SwingConstants.CENTER);
		DOALabel.setBounds(300, 130, 130, 20);
		getContentPane().add(DOALabel);
		
		TOALabel = new JLabel("Time Of Appointment:");
		TOALabel.setHorizontalAlignment(SwingConstants.CENTER);
		TOALabel.setBounds(300, 160, 130, 20);
		getContentPane().add(TOALabel);
		
		PLabel = new JLabel("Problem:");
		PLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PLabel.setBounds(300, 190, 130, 20);
		getContentPane().add(PLabel);
		
		//Buttons
		SubmitButton = new JButton("SUBMIT");
		SubmitButton.setHorizontalAlignment(SwingConstants.CENTER);
		SubmitButton.setBounds(400, 220, 100, 25);
		getContentPane().add(SubmitButton);
		
		//TextFields		
		NTF = new JTextField("");
		NTF.setBounds(440, 70, 140, 20);
		getContentPane().add(NTF);
		
		DNTF = new JTextField("");
		DNTF.setBounds(440, 100, 140, 20);
		getContentPane().add(DNTF);
		
		TTF = new JTextField("");
		TTF.setBounds(440, 160, 140, 20);
		getContentPane().add(TTF);
		
		PTF = new JTextField("");
		PTF.setBounds(440, 190, 140, 20);
		getContentPane().add(PTF);
		
		//JComboBox
		MCB = new JComboBox();
		String[] Month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
		MCB.setModel(new DefaultComboBoxModel(Month));
		MCB.setBounds(482, 130, 40, 20);
		add(MCB);
		
		DCB = new JComboBox();
		String[] Day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		DCB.setModel(new DefaultComboBoxModel(Day));
		DCB.setBounds(440, 130, 40, 20);
		add(DCB);
		
		YCB = new JComboBox();
		String[] Year = {"1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023"};
		YCB.setModel(new DefaultComboBoxModel(Year));
		YCB.setBounds(525, 130, 55, 20);
		add(YCB);
		
		//ActionListener
		MyActionListener mal = new MyActionListener();
		SubmitButton.addActionListener(mal);
		
	}
	
	public static void main(String[] args) {
		BookAppointment d = new BookAppointment();
	}
	
	public class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand()==("SUBMIT")) {
				if(TTF.getText().isEmpty() || PTF.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Date dob = new Date(Integer.parseInt((String) DCB.getSelectedItem()), Integer.parseInt((String) MCB.getSelectedItem()),Integer.parseInt((String) YCB.getSelectedItem()));
				//Patient.readFromFile();
				Appointments a = new Appointments(NTF.getText(), DNTF.getText(), dob,TTF.getText(), PTF.getText());
				Appointments.writeToFile(a);
				JOptionPane.showMessageDialog(null, "Appointment Booked Successfully");
				System.out.println(Appointments.readFromFile());
				dispose();
				PatientPage m = new PatientPage();
				return;
				
			}
		}	
	}
}
