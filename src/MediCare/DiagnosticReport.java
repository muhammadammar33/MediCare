package MediCare;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.*;

public class DiagnosticReport extends JFrame implements Serializable{

	Admin Admin;
	JLabel TitleLabel, PicLabel, NameLabel, PreLabel, MedLabel, DosLabel, FromLabel, ToLabel, DailyLabel;
	JButton SubmitButton;
	JTextField NTF,PTF,MTF,DTF,DUTF;
	JComboBox DCB,MCB,YCB,DCB1,MCB1,YCB1;
	
	public DiagnosticReport() {
		setTitle("Diagnostic Report");
		setBounds(10,10,650,350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setLayout(null);
		this.getContentPane().setBackground(new java.awt.Color(153,255,204));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Comsats Logo.jpg"));
		
		TitleLabel = new JLabel("Diagnostic Report");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setForeground(Color.RED);
		TitleLabel.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
		TitleLabel.setBounds(300, 10, 300, 30);
		getContentPane().add(TitleLabel);
		
		PicLabel = new JLabel();
		PicLabel.setIcon(new ImageIcon("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Report.jpg"));
		PicLabel.setBounds(0, 0, 300, 300);
		getContentPane().add(PicLabel);
		
		NameLabel = new JLabel("Name:");
		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NameLabel.setBounds(300, 50, 120, 20);
		getContentPane().add(NameLabel);
		
		PreLabel = new JLabel("Predictions:");
		PreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PreLabel.setBounds(300, 80, 120, 20);
		getContentPane().add(PreLabel);
		
		MedLabel = new JLabel("Medicines:");
		MedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MedLabel.setBounds(300, 110, 120, 20);
		getContentPane().add(MedLabel);
		
		DosLabel = new JLabel("Dosage:");
		DosLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DosLabel.setBounds(300, 140, 120, 20);
		getContentPane().add(DosLabel);
		
		FromLabel = new JLabel("From Date:");
		FromLabel.setHorizontalAlignment(SwingConstants.CENTER);
		FromLabel.setBounds(300, 170, 120, 20);
		getContentPane().add(FromLabel);
		
		ToLabel = new JLabel("To Date:");
		ToLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ToLabel.setBounds(300, 200, 120, 20);
		getContentPane().add(ToLabel);
		
		DailyLabel = new JLabel("Daily Usage:");
		DailyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DailyLabel.setBounds(300, 230, 120, 20);
		getContentPane().add(DailyLabel);
		
		//ComboBox
		MCB = new JComboBox();
		String[] Month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
		MCB.setModel(new DefaultComboBoxModel(Month));
		MCB.setBounds(472, 170, 40, 20);
		getContentPane().add(MCB);
			
		DCB = new JComboBox();
		String[] Day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		DCB.setModel(new DefaultComboBoxModel(Day));
		DCB.setBounds(430, 170, 40, 20);
		getContentPane().add(DCB);
			
		YCB = new JComboBox();
		String[] Year = {"1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023"};
		YCB.setModel(new DefaultComboBoxModel(Year));
		YCB.setBounds(515, 170, 55, 20);
		getContentPane().add(YCB);
			
		MCB1 = new JComboBox();
		MCB1.setModel(new DefaultComboBoxModel(Month));
		MCB1.setBounds(472, 200, 40, 20);
		getContentPane().add(MCB1);
				
		DCB1 = new JComboBox();
		DCB1.setModel(new DefaultComboBoxModel(Day));
		DCB1.setBounds(430, 200, 40, 20);
		getContentPane().add(DCB1);
				
		YCB1 = new JComboBox();
		YCB1.setModel(new DefaultComboBoxModel(Year));
		YCB1.setBounds(515, 200, 55, 20);
		getContentPane().add(YCB1);
		
		//Buttons
		SubmitButton = new JButton("SUBMIT");
		SubmitButton.setHorizontalAlignment(SwingConstants.CENTER);
		SubmitButton.setBounds(400, 270, 100, 25);
		getContentPane().add(SubmitButton);
		
		//TextFields		
		NTF = new JTextField("");
		NTF.setBounds(430, 50, 140, 20);
		getContentPane().add(NTF);
		
		PTF = new JTextField("");
		PTF.setBounds(430, 80, 140, 20);
		getContentPane().add(PTF);
		
		MTF = new JTextField("");
		MTF.setBounds(430, 110, 140, 20);
		getContentPane().add(MTF);
		
		DTF = new JTextField("");
		DTF.setBounds(430, 140, 140, 20);
		getContentPane().add(DTF);
		
		DUTF = new JTextField("");
		DUTF.setBounds(430, 230, 140, 20);
		getContentPane().add(DUTF);
		
		//ActionListener
		MyActionListener mal = new MyActionListener();
		SubmitButton.addActionListener(mal);
		
	}
	
	public static void main(String[] args) {
		DiagnosticReport d = new DiagnosticReport();
	}
	
	public class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand()==("SUBMIT")) {
				if(NTF.getText().isEmpty() || PTF.getText().isEmpty() || MTF.getText().isEmpty() || DTF.getText().isEmpty() || DUTF.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Date FDate = new Date(Integer.parseInt((String) DCB.getSelectedItem()), Integer.parseInt((String) MCB.getSelectedItem()),Integer.parseInt((String) YCB.getSelectedItem()));
				Date TDate = new Date(Integer.parseInt((String) DCB1.getSelectedItem()),Integer.parseInt((String) MCB1.getSelectedItem()),Integer.parseInt((String) YCB1.getSelectedItem()));
				Report r = new Report(NTF.getText(),PTF.getText(),MTF.getText(),DTF.getText(),FDate, TDate, DUTF.getText());
				
//				ArrayList<Patient> p1 = Patient.readFromFile();
//				for(int i = 0; i < p1.size(); i++) {
//					boolean a = p1.get(i).getName() == NTF.getText();
//					if(a == false) {
//						JOptionPane.showMessageDialog(null, "This Patient do not Exist int the record.");
//						return;
//					}
//				}
				Report.writeToFile(r);
				JOptionPane.showMessageDialog(null, "Sign Up Successfully");
				System.out.println(Report.readFromFile());
				dispose();
				DoctorPage d = new DoctorPage();
				return;
			}
		}	
	}
}
