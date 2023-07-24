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

public class AdminSignUp extends JFrame implements Serializable{

	Admin Admin;
	JLabel TitleLabel,PicLabel, IDLabel, NameLabel, PassLabel, CPassLabel;
	JButton SubmitButton;
	JTextField IDTF, NTF;
	JPasswordField PTF, CPTF;
	
	public AdminSignUp() {
		setTitle("Admin Registeration");
		setBounds(10,10,550,250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setLayout(null);
		this.getContentPane().setBackground(new java.awt.Color(153,255,204));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Comsats Logo.jpg"));
		
		TitleLabel = new JLabel("Admin Registeration");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setForeground(Color.RED);
		TitleLabel.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
		TitleLabel.setBounds(210, 10, 300, 30);
		getContentPane().add(TitleLabel);
		
		PicLabel = new JLabel();
		PicLabel.setIcon(new ImageIcon("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Admin.jpg"));
		PicLabel.setBounds(0, -24, 199, 245);
		getContentPane().add(PicLabel);
		
		IDLabel = new JLabel("Admin ID:");
		IDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IDLabel.setBounds(210, 50, 120, 20);
		getContentPane().add(IDLabel);
		
		NameLabel = new JLabel("Name:");
		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NameLabel.setBounds(210, 80, 120, 20);
		getContentPane().add(NameLabel);
		
		PassLabel = new JLabel("Password:");
		PassLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PassLabel.setBounds(210, 110, 120, 20);
		getContentPane().add(PassLabel);
		
		CPassLabel = new JLabel("Confirm Password:");
		CPassLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CPassLabel.setBounds(210, 140, 120, 20);
		getContentPane().add(CPassLabel);
		
		//Buttons
		SubmitButton = new JButton("SUBMIT");
		SubmitButton.setHorizontalAlignment(SwingConstants.CENTER);
		SubmitButton.setBounds(310, 170, 100, 25);
		getContentPane().add(SubmitButton);
		
		//TextFields
		IDTF = new JTextField("");
		IDTF.setBounds(340, 50, 140, 20);
		getContentPane().add(IDTF);
		
		NTF = new JTextField("");
		NTF.setBounds(340, 80, 140, 20);
		getContentPane().add(NTF);
		
		PTF = new JPasswordField("");
		PTF.setBounds(340, 110, 140, 20);
		getContentPane().add(PTF);
		
		CPTF = new JPasswordField("");
		CPTF.setBounds(340, 140, 140, 20);
		getContentPane().add(CPTF);
		
		//ActionListener
		MyActionListener mal = new MyActionListener();
		SubmitButton.addActionListener(mal);
		
	}
	
	public static void main(String[] args) {
		AdminSignUp d = new AdminSignUp();
	}
	
	public class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand()==("SUBMIT")) {
				if(NTF.getText().isEmpty() || IDTF.getText().isEmpty() || PTF.getText().isEmpty() || CPTF.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
//				ArrayList<Admin> a1 = Admin.readFromFile();
//				for(int i = 0; i < a1.size(); i++) {
//					boolean a = a1.get(i).getID() == IDTF.getText();
//					System.out.println(a1.get(i).getID());
//					System.out.println(IDTF.getText());
//					System.out.println(a);
//					if(a == true) {
//						JOptionPane.showMessageDialog(null, "This ID already exists");
//						IDTF.setText("");
//						return;
//					}
//					if(a == false) {
//						i++;
//					}
//					
//				}
				if (PTF.getText().length() >= 8) {
					Admin d = new Admin(NTF.getText(), IDTF.getText(), PTF.getText(),CPTF.getText());
					Admin.writeToFile(d);
					JOptionPane.showMessageDialog(null, "Sign Up Successfully");
					System.out.println(Admin.readFromFile());
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
				
			}
		}	
	}
}
