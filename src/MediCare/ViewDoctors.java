package MediCare;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewDoctors extends JFrame {

	JPanel mainPanel, headingPanel, listPanel, gridPanel, ButtonPanel;
    JLabel mainLabel;
    JButton BackButton;
	
	public static void main(String[] args) {
	
		ViewDoctors vd = new ViewDoctors();
	}

	/**
	 * Create the frame.
	 */
	public ViewDoctors() {
		setTitle("View Doctors");
		setBounds(10,10,1500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		this.getContentPane().setBackground(new java.awt.Color(153,255,204));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Comsats Logo.jpg"));
		
		//for the grid
        ArrayList<Doctor> d1 = Doctor.readFromFile();
        String[] tempForView = new String[12];
        
        mainPanel = new JPanel(new BorderLayout());
        getContentPane().add(mainPanel);
        headingPanel = new JPanel(new FlowLayout());
        mainPanel.add(headingPanel, BorderLayout.NORTH);
        mainLabel = new JLabel("List of Doctors");
        headingPanel.add(mainLabel);
        ButtonPanel = new JPanel(new FlowLayout());
        mainPanel.add(ButtonPanel, BorderLayout.SOUTH);
        
        BackButton = new JButton("Back");
        BackButton.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonPanel.add(BackButton);
        
        listPanel = new JPanel(new FlowLayout());
        mainPanel.add(listPanel, BorderLayout.CENTER);
        gridPanel = new JPanel(new GridLayout(d1.size()+1, 12, 10, 10));
        listPanel.add(gridPanel);
        
        JLabel J1 = new JLabel("ID");
        JLabel J2 = new JLabel("Name");
        JLabel J3 = new JLabel("Gender");
        JLabel J4 = new JLabel("Date Of Birth");
        JLabel J5 = new JLabel("Address");
        JLabel J6 = new JLabel("Age");
        JLabel J7 = new JLabel("Email");
        JLabel J8 = new JLabel("Phone No");
        JLabel J9 = new JLabel("Qualification");
        JLabel J10 = new JLabel("Date of Joining");
        JLabel J11 = new JLabel("Timming");
        JLabel J12 = new JLabel("Designation");
        
        mainLabel.setFont(new Font("Open Sans ExtraBold", 0, 24));
        J1.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J2.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J3.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J4.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J5.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J6.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J7.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J8.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J9.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J10.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J11.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J12.setFont(new Font("Open Sans ExtraBold", 0, 14));
        
        gridPanel.add(J1);
        gridPanel.add(J2);
        gridPanel.add(J3);
        gridPanel.add(J4);
        gridPanel.add(J5);
        gridPanel.add(J6);
        gridPanel.add(J7);
        gridPanel.add(J8);
        gridPanel.add(J9);
        gridPanel.add(J10);
        gridPanel.add(J11);
        gridPanel.add(J12);
//        //generating grid
        for (int i = 0; i < d1.size(); i++) {
        	String ID = d1.get(i).getId();
            String Name = d1.get(i).getName();
            String Gender = d1.get(i).getGender();
            String Day = Integer.toString(d1.get(i).getDate().getDay());
            String Month = Integer.toString(d1.get(i).getDate().getMonth());
            String Year = Integer.toString(d1.get(i).getDate().getYear());
            String DateOfBirth = Day+"/"+Month+"/"+Year;
            String Home = Integer.toString(d1.get(i).getAddress().getHome());
            String Street = Integer.toString(d1.get(i).getAddress().getStreet());
            String City = d1.get(i).getAddress().getCity();
            String CompleteAddress = Home+", "+Street+", "+City;
            String Age = Integer.toString(d1.get(i).getAge());
            String Email = d1.get(i).getEmail();
            String PhoneNo = d1.get(i).getPhoneno();
            String Qualification = d1.get(i).getQualification();
            String Day1 = Integer.toString(d1.get(i).getDateofjoining().getDay());
            String Month1 = Integer.toString(d1.get(i).getDateofjoining().getMonth());
            String Year1 = Integer.toString(d1.get(i).getDateofjoining().getYear());
            String DateOfJoining = Day+"/"+Month+"/"+Year;
            String Timming = d1.get(i).getTimings();
            String Designation = d1.get(i).getDesignation();
            
            //adding in tempForView
            tempForView[0] = ID;
            tempForView[1] = Name;
            tempForView[2] = Gender;
            tempForView[3] = DateOfBirth;
            tempForView[4] = CompleteAddress;
            tempForView[5] = Age;
            tempForView[6] = Email;
            tempForView[7] = PhoneNo;
            tempForView[8] = Qualification;
            tempForView[9] = DateOfJoining;
            tempForView[10] = Timming;
            tempForView[11] = Designation;
            
            for (int j = 0; j < 12; j++) {
                JLabel J0 = new JLabel(tempForView[j]);
                J0.setFont(new Font("Open Sans", 0, 10));
                gridPanel.add(J0);
            }
        }
      //ActionListener
      MyActionListener mal = new MyActionListener();
      BackButton.addActionListener(mal);
	}
	
	public class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand() == "Back") {
				dispose();
				PatientPage p = new PatientPage();
			}
		}
	}	

}
