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

public class DoctorSignUp extends JFrame implements Serializable{

	Doctor doctor;
	JLabel TitleLabel, PicLabel, IDLabel, NameLabel, PassLabel, CPassLabel, DOBLabel, GenderLabel, AddressLabel, AgeLabel, QLabel, AHomeLabel, AStreetLabel, ACityLabel, BLabel, EmailLabel, DOJLabel, TLabel, DLabel ;
	JButton SubmitButton;
	JTextField IDTF, NTF, GTF, ATF, QTF, HTF, STF, CTF, BTF, ETF, TTF, DTF;
	JPasswordField PTF, CPTF;
	JTextArea ATA;
	JComboBox DCB,MCB,YCB,DCB1,MCB1,YCB1;
	
	public DoctorSignUp() {
		setTitle("Doctor Registeration");
		setBounds(10,10,650,550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setLayout(null);
		this.getContentPane().setBackground(new java.awt.Color(153,255,204));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Comsats Logo.jpg"));
		
		TitleLabel = new JLabel("Doctor Registeration");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setForeground(Color.RED);
		TitleLabel.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
		TitleLabel.setBounds(300, 10, 300, 30);
		getContentPane().add(TitleLabel);
		
		PicLabel = new JLabel();
		PicLabel.setIcon(new ImageIcon("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Doctor.jpg"));
		PicLabel.setBounds(0, 0, 300, 550);
		getContentPane().add(PicLabel);
		
		IDLabel = new JLabel("Doctor ID:");
		IDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IDLabel.setBounds(300, 50, 120, 20);
		getContentPane().add(IDLabel);
		
		NameLabel = new JLabel("Name:");
		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NameLabel.setBounds(300, 75, 120, 20);
		getContentPane().add(NameLabel);
		
		PassLabel = new JLabel("Password:");
		PassLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PassLabel.setBounds(300, 100, 120, 20);
		getContentPane().add(PassLabel);
		
		CPassLabel = new JLabel("Confirm Password:");
		CPassLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CPassLabel.setBounds(300, 125, 120, 20);
		getContentPane().add(CPassLabel);
		
		DOBLabel = new JLabel("DATE OF BIRTH:");
		DOBLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DOBLabel.setBounds(300, 175, 120, 20);
		getContentPane().add(DOBLabel);
		
		GenderLabel = new JLabel("Gender:");
		GenderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GenderLabel.setBounds(300, 150, 120, 20);
		getContentPane().add(GenderLabel);
		
		AddressLabel = new JLabel("Address");
		AddressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AddressLabel.setBounds(300, 200, 120, 20);
		AddressLabel.setFont(new Font("Century", Font.BOLD, 15));
		getContentPane().add(AddressLabel);
		
		AHomeLabel = new JLabel("Home:");
		AHomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AHomeLabel.setBounds(300, 225, 120, 20);
		getContentPane().add(AHomeLabel);
		
		AStreetLabel = new JLabel("Street:");
		AStreetLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AStreetLabel.setBounds(300, 250, 120, 20);
		getContentPane().add(AStreetLabel);
		
		ACityLabel = new JLabel("City:");
		ACityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ACityLabel.setBounds(300, 275, 120, 20);
		getContentPane().add(ACityLabel);
		
		AgeLabel = new JLabel("Age:");
		AgeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AgeLabel.setBounds(300, 300, 120, 20);
		getContentPane().add(AgeLabel);
		
		QLabel = new JLabel("Qualification:");
		QLabel.setHorizontalAlignment(SwingConstants.CENTER);
		QLabel.setBounds(300, 375, 120, 20);
		getContentPane().add(QLabel);
		
		BLabel = new JLabel("Phone No:");
		BLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BLabel.setBounds(300, 350, 120, 20);
		getContentPane().add(BLabel);
		
		EmailLabel = new JLabel("Email:");
		EmailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		EmailLabel.setBounds(300, 325, 120, 20);
		getContentPane().add(EmailLabel);
		
		DOJLabel = new JLabel("Date Of Joinig:");
		DOJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DOJLabel.setBounds(300, 400, 120, 20);
		getContentPane().add(DOJLabel);
		
		TLabel = new JLabel("Timming:");
		TLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TLabel.setBounds(300, 425, 120, 20);
		getContentPane().add(TLabel);
		
		DLabel = new JLabel("Designation:");
		DLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DLabel.setBounds(300, 450, 120, 20);
		getContentPane().add(DLabel);
		
		//Buttons
		SubmitButton = new JButton("SUBMIT");
		SubmitButton.setHorizontalAlignment(SwingConstants.CENTER);
		SubmitButton.setBounds(400, 480, 100, 25);
		getContentPane().add(SubmitButton);
		
		//TextFields
		IDTF = new JTextField("");
		IDTF.setHorizontalAlignment(SwingConstants.CENTER);
		IDTF.setBounds(430, 50, 140, 20);
		getContentPane().add(IDTF);
		
		NTF = new JTextField("");
		NTF.setHorizontalAlignment(SwingConstants.CENTER);
		NTF.setBounds(430, 75, 140, 20);
		getContentPane().add(NTF);
		
		PTF = new JPasswordField("");
		PTF.setHorizontalAlignment(SwingConstants.CENTER);
		PTF.setBounds(430, 100, 140, 20);
		getContentPane().add(PTF);
		
		CPTF = new JPasswordField("");
		CPTF.setHorizontalAlignment(SwingConstants.CENTER);
		CPTF.setBounds(430, 125, 140, 20);
		getContentPane().add(CPTF);
		
		GTF = new JTextField("");
		GTF.setHorizontalAlignment(SwingConstants.CENTER);
		GTF.setBounds(430, 150, 140, 20);
		getContentPane().add(GTF);
		
		HTF = new JTextField("");
		HTF.setHorizontalAlignment(SwingConstants.CENTER);
		HTF.setBounds(430, 225, 140, 20);
		getContentPane().add(HTF);
		
		STF = new JTextField("");
		STF.setHorizontalAlignment(SwingConstants.CENTER);
		STF.setBounds(430, 250, 140, 20);
		getContentPane().add(STF);
		
		CTF = new JTextField("");
		CTF.setHorizontalAlignment(SwingConstants.CENTER);
		CTF.setBounds(430, 275, 140, 20);
		getContentPane().add(CTF);
		
		ATF = new JTextField("");
		ATF.setHorizontalAlignment(SwingConstants.CENTER);
		ATF.setBounds(430, 300, 140, 20);
		getContentPane().add(ATF);
		
		QTF = new JTextField("");
		QTF.setHorizontalAlignment(SwingConstants.CENTER);
		QTF.setBounds(430, 375, 140, 20);
		getContentPane().add(QTF);
		
		BTF = new JTextField("");
		BTF.setHorizontalAlignment(SwingConstants.CENTER);
		BTF.setBounds(430, 350, 140, 20);
		getContentPane().add(BTF);
		
		ETF = new JTextField("");
		ETF.setHorizontalAlignment(SwingConstants.CENTER);
		ETF.setBounds(430, 325, 140, 20);
		getContentPane().add(ETF);
		
		TTF = new JTextField("");
		TTF.setHorizontalAlignment(SwingConstants.CENTER);
		TTF.setBounds(430, 425, 140, 20);
		getContentPane().add(TTF);
		
		DTF = new JTextField("");
		DTF.setHorizontalAlignment(SwingConstants.CENTER);
		DTF.setBounds(430, 450, 140, 20);
		getContentPane().add(DTF);
		
		//ComboBox
		MCB = new JComboBox();
		String[] Month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
		MCB.setModel(new DefaultComboBoxModel(Month));
		MCB.setBounds(472, 175, 40, 20);
		getContentPane().add(MCB);
		
		DCB = new JComboBox();
		String[] Day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		DCB.setModel(new DefaultComboBoxModel(Day));
		DCB.setBounds(430, 175, 40, 20);
		getContentPane().add(DCB);
		
		YCB = new JComboBox();
		String[] Year = {"1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023"};
		YCB.setModel(new DefaultComboBoxModel(Year));
		YCB.setBounds(515, 175, 55, 20);
		getContentPane().add(YCB);
		
		MCB1 = new JComboBox();
		MCB1.setModel(new DefaultComboBoxModel(Month));
		MCB1.setBounds(472, 400, 40, 20);
		getContentPane().add(MCB1);
		
		DCB1 = new JComboBox();
		DCB1.setModel(new DefaultComboBoxModel(Day));
		DCB1.setBounds(430, 400, 40, 20);
		getContentPane().add(DCB1);
		
		YCB1 = new JComboBox();
		YCB1.setModel(new DefaultComboBoxModel(Year));
		YCB1.setBounds(515, 400, 55, 20);
		getContentPane().add(YCB1);
		
		//ActionListener
		MyActionListener mal = new MyActionListener();
		SubmitButton.addActionListener(mal);
		
	}
	
	public static void main(String[] args) {
		DoctorSignUp d = new DoctorSignUp();
	}
	
	public class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand()==("SUBMIT")) {
				if(NTF.getText().isEmpty() || IDTF.getText().isEmpty() || PTF.getText().isEmpty() || CPTF.getText().isEmpty() || GTF.getText().isEmpty() || ATF.getText().isEmpty() || QTF.getText().isEmpty() || HTF.getText().isEmpty() || STF.getText().isEmpty() || CTF.getText().isEmpty() || BTF.getText().isEmpty() || ETF.getText().isEmpty() || TTF.getText().isEmpty() || DTF.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (ETF.getText().contains("@") && ETF.getText().contains(".com") && PTF.getText().length() >= 8 && BTF.getText().matches("[0]{1}[3]{1}[0-9]{9}")) {
					Address a = new Address(Integer.parseInt(HTF.getText()), Integer.parseInt(STF.getText()), CTF.getText());
					Date dob = new Date(Integer.parseInt((String) DCB.getSelectedItem()), Integer.parseInt((String) MCB.getSelectedItem()),Integer.parseInt((String) YCB.getSelectedItem()));
					Date doj = new Date(Integer.parseInt((String) DCB1.getSelectedItem()),Integer.parseInt((String) MCB1.getSelectedItem()),Integer.parseInt((String) YCB1.getSelectedItem()));
					Doctor d = new Doctor(NTF.getText(), IDTF.getText(), Integer.parseInt(ATF.getText()), BTF.getText(), ETF.getText(), GTF.getText(), a, dob, doj,QTF.getText(),TTF.getText(),DTF.getText(),PTF.getText(),CPTF.getText());
					Doctor.writeToFile(d);
					JOptionPane.showMessageDialog(null, "Sign Up Successfully");
					System.out.println(Doctor.readFromFile());
					dispose();
					MainMenu m = new MainMenu();
					return;
				} 
				if (!(PTF.getText().length() >= 8) && !(PTF.getText() == CPTF.getText())){
					JOptionPane.showMessageDialog(null, "Sign Up unsuccessful!! Please enter Same Password in both fields!!");
					PTF.setText("");
					CPTF.setText("");
					return;
				}
				if (!ETF.getText().contains("@") || !(ETF.getText().contains(".com"))) {
					JOptionPane.showMessageDialog(null, "Sign Up unsuccessful!! Please enter valid Email!!");
					ETF.setText("");
					return;
				} 
				if (!(BTF.getText().matches("[0]{1}[3]{1}[0-9]{9}"))) {
					JOptionPane.showMessageDialog(null, "Sign Up unsuccessful!! Please enter valid Phone Number!!");
					BTF.setText("");
					return;
				}
			}
		}	
	}
}
