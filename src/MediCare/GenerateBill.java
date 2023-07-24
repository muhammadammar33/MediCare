 package MediCare;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.*;

public class GenerateBill extends JFrame implements Serializable{

	Admin Admin;
	JLabel TitleLabel, PicLabel, IDLabel, NameLabel, DNameLabel, DateLabel, AmmountLabel;
	JButton SubmitButton;
	JTextField IDTF, NTF, DNTF, ATF;
	JComboBox DCB,MCB,YCB;
	
	public GenerateBill() {
		setTitle("Bill Generation");
		setBounds(10,10,600,270);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setLayout(null);
		this.getContentPane().setBackground(new java.awt.Color(153,255,204));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Comsats Logo.jpg"));
		
		TitleLabel = new JLabel("Bill Generation");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setForeground(Color.RED);
		TitleLabel.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
		TitleLabel.setBounds(250, 10, 300, 30);
		getContentPane().add(TitleLabel);
		
		PicLabel = new JLabel();
		PicLabel.setIcon(new ImageIcon("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Bill.jpg"));
		PicLabel.setBounds(0, -21, 225, 270);
		getContentPane().add(PicLabel);
		
		IDLabel = new JLabel("Bill ID:");
		IDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IDLabel.setBounds(250, 50, 120, 20);
		getContentPane().add(IDLabel);
		
		NameLabel = new JLabel("Patient Name:");
		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NameLabel.setBounds(250, 80, 120, 20);
		getContentPane().add(NameLabel);
		
		DNameLabel = new JLabel("Doctor Name:");
		DNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DNameLabel.setBounds(250, 110, 120, 20);
		getContentPane().add(DNameLabel);
		
		DateLabel = new JLabel("Bill Date:");
		DateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DateLabel.setBounds(250, 140, 120, 20);
		getContentPane().add(DateLabel);
		
		AmmountLabel = new JLabel("Ammount:");
		AmmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AmmountLabel.setBounds(250, 170, 120, 20);
		getContentPane().add(AmmountLabel);
		
		//Buttons
		SubmitButton = new JButton("SUBMIT");
		SubmitButton.setHorizontalAlignment(SwingConstants.CENTER);
		SubmitButton.setBounds(350, 200, 100, 25);
		getContentPane().add(SubmitButton);
		
		//TextFields
		IDTF = new JTextField("");
		IDTF.setBounds(380, 50, 140, 20);
		getContentPane().add(IDTF);
		
		NTF = new JTextField("");
		NTF.setBounds(380, 80, 140, 20);
		getContentPane().add(NTF);
		
		DNTF = new JTextField("");
		DNTF.setBounds(380, 110, 140, 20);
		getContentPane().add(DNTF);
		
		ATF = new JTextField("");
		ATF.setBounds(380, 170, 140, 20);
		getContentPane().add(ATF);
		
		//ComboBox
		MCB = new JComboBox();
		String[] Month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
		MCB.setModel(new DefaultComboBoxModel(Month));
		MCB.setBounds(422, 140, 40, 20);
		getContentPane().add(MCB);
		
		DCB = new JComboBox();
		String[] Day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		DCB.setModel(new DefaultComboBoxModel(Day));
		DCB.setBounds(380, 140, 40, 20);
		getContentPane().add(DCB);
		
		YCB = new JComboBox();
		String[] Year = {"1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023"};
		YCB.setModel(new DefaultComboBoxModel(Year));
		YCB.setBounds(465, 140, 55, 20);
		getContentPane().add(YCB);
		
		//ActionListener
		MyActionListener mal = new MyActionListener();
		SubmitButton.addActionListener(mal);
		
	}
	
	public static void main(String[] args) {
		GenerateBill d = new GenerateBill();
	}
	
	public class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand()==("SUBMIT")) {
				if(NTF.getText().isEmpty() || IDTF.getText().isEmpty() || DNTF.getText().isEmpty() || ATF.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Date dob = new Date(Integer.parseInt((String) DCB.getSelectedItem()), Integer.parseInt((String) MCB.getSelectedItem()),Integer.parseInt((String) YCB.getSelectedItem()));
				Bill d = new Bill(IDTF.getText(),NTF.getText(), DNTF.getText(), dob, Double.parseDouble(ATF.getText()));
				Bill.writeToFile(d);
				JOptionPane.showMessageDialog(null, "Bill Generated");
				System.out.println(Bill.readFromFile());
				dispose();
				AdminPage a = new AdminPage();
				return;		
			}
		}	
	}
}
