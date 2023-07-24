package MediCare;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainMenu extends JFrame {

	JLabel TitleLabel,MainLabel,NameLabel,PassLabel,UserLabel,CCLabel,PicLabel;
	static JTextField NTF;
	JPasswordField PassTF;
	JComboBox ComboBox;
	JButton SubmitButton,SignUpButton;
	JComboBox comboBox;
	
	public MainMenu() {
		setBackground(new Color(204, 0, 102));
		//Frame
		setTitle("MediCare");
		setBounds(10,10,500,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(0, 153, 153));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Comsats Logo.jpg"));
		
		//Labels
		TitleLabel = new JLabel("----------MEDI CARE----------");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setForeground(Color.RED);
		TitleLabel.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
		TitleLabel.setBounds(100, 10, 300, 20);
		getContentPane().add(TitleLabel);
		
		MainLabel = new JLabel("Main Menu");
		MainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MainLabel.setForeground(Color.BLUE);
		MainLabel.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 15));
		MainLabel.setBounds(260, 40, 110, 20);
		getContentPane().add(MainLabel);
		
		NameLabel = new JLabel("USER Name:");
		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NameLabel.setFont(new Font("Century Gothic", Font.BOLD, 11));
		NameLabel.setBounds(230, 70, 70, 15);
		getContentPane().add(NameLabel);
		
		PassLabel = new JLabel("PASSWORD:");
		PassLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PassLabel.setFont(new Font("Century Gothic", Font.BOLD, 11));
		PassLabel.setBounds(230, 100, 70, 15);
		getContentPane().add(PassLabel);
		
		UserLabel = new JLabel("USER TYPE");
		UserLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UserLabel.setFont(new Font("Century Gothic", Font.BOLD, 11));
		UserLabel.setBounds(230, 130, 70, 15);
		getContentPane().add(UserLabel);
		
		CCLabel = new JLabel("@ MUHAMMAD AMMAR CHEEMA  @ HUZAIFA YASEEN");
		CCLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CCLabel.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 12));
		CCLabel.setBounds(85, 240, 320, 15);
		getContentPane().add(CCLabel);
		
		PicLabel = new JLabel();
		PicLabel.setIcon(new ImageIcon("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Medi Care.jpg"));
		PicLabel.setBounds(0, 40, 220, 180);
		getContentPane().add(PicLabel);
		
		//TextFields
		NTF = new JTextField();
		NTF.setForeground(Color.BLACK);
		NTF.setText("");
		NTF.setBounds(320, 70, 100, 20);
		NTF.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(NTF);
		NTF.setColumns(10);
		
		PassTF = new JPasswordField();
		PassTF.setForeground(Color.BLACK);
		PassTF.setText("");
		PassTF.setBounds(320, 100, 100, 20);
		PassTF.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(PassTF);
		PassTF.setColumns(10);
		
		//ComboBox
		ComboBox = new JComboBox();
		ComboBox.setModel(new DefaultComboBoxModel(new String[] {"---SELECT---", "ADMIN", "DOCTOR", "PATIENT"}));
		ComboBox.setBounds(320, 130, 100, 20);
		getContentPane().add(ComboBox);
		
		//Buttons
		SubmitButton = new JButton("SIGN IN");
		SubmitButton.setForeground(Color.RED);
		SubmitButton.setBounds(280, 160, 80, 30);
		getContentPane().add(SubmitButton);
		
		SignUpButton = new JButton("SIGN UP");
		SignUpButton.setForeground(Color.RED);
		SignUpButton.setBounds(280, 200, 80, 30);
		getContentPane().add(SignUpButton);
		
		//ActionListener
		MyActionListener mal = new MyActionListener();
		SignUpButton.addActionListener(mal);
		ComboBox.addActionListener(mal);
		SubmitButton.addActionListener(mal);
	}
	
	public class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String n = NTF.getText();
			String p = PassTF.getText();
			
			if(e.getActionCommand()==("SIGN IN")) {
				if(ComboBox.getSelectedItem() == ("ADMIN")) {
					boolean user = Admin.search(n, 1);
		            boolean passText = Admin.search(p, 2);
		            System.out.println(user);
		            System.out.println(passText);
		            if (user == true && passText == true) {
		            	dispose();
						AdminPage a = new AdminPage();
		            }
		            else {
		            	JOptionPane.showMessageDialog(null, "Please Enter Correct UserName and Password");
		            }
				}
				else if(ComboBox.getSelectedItem() == ("DOCTOR")) {
					boolean user1 = Doctor.search(n, 1);
		            boolean passText1 = Doctor.search(p, 2);
		            System.out.println(user1);
		            System.out.println(passText1);
		            if (user1 == true && passText1 == true) {
		            	dispose();
						DoctorPage a = new DoctorPage();
		            }
		            else {
		            	JOptionPane.showMessageDialog(null, "Please Enter Correct UserName and Password");
		            }
				}
				else if(ComboBox.getSelectedItem() == ("PATIENT")) {
					boolean user2 = Patient.search(n, 1);
		            boolean passText2 = Patient.search(p, 2);
		            System.out.println(user2);
		            System.out.println(passText2);
		            if (user2 == true && passText2 == true) {
		            	dispose();
						PatientPage a = new PatientPage();
		            }
		            else {
		            	JOptionPane.showMessageDialog(null, "Please Enter Correct UserName and Password");
		            }
				}
				else {
					JOptionPane.showMessageDialog(null, "Please select an Option from the User Type!!");
				}
			}
			
			if(e.getActionCommand()==("SIGN UP")) {
				dispose();
				NewUserType u = new NewUserType();
			}	
		}
	}
}
