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

public class SchedulePatient extends JFrame {

	JPanel mainPanel, headingPanel, listPanel, gridPanel, ButtonPanel;
    JLabel mainLabel;
    JButton BackButton;
    int count = 0;
	
	public static void main(String[] args) {
	
		SchedulePatient SP = new SchedulePatient();
	}

	/**
	 * Create the frame.
	 */
	public SchedulePatient() {
		setTitle("Schedule Patients");
		setBounds(10,10,1500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		this.getContentPane().setBackground(new java.awt.Color(153,255,204));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Comsats Logo.jpg"));
		
		//for the grid
        ArrayList<Appointments> a1 = Appointments.readFromFile();
        ArrayList<Patient> p1 = Patient.readFromFile();
        String[] tempForView = new String[9];
        
        mainPanel = new JPanel(new BorderLayout());
        getContentPane().add(mainPanel);
        headingPanel = new JPanel(new FlowLayout());
        mainPanel.add(headingPanel, BorderLayout.NORTH);
        mainLabel = new JLabel("List of Patients");
        headingPanel.add(mainLabel);
        ButtonPanel = new JPanel(new FlowLayout());
        mainPanel.add(ButtonPanel, BorderLayout.SOUTH);
        
        BackButton = new JButton("Back");
        BackButton.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonPanel.add(BackButton);
		
		for(int j = 0; j < a1.size(); j++) {
			for(int i = 0; i < p1.size(); i++) {
				String aName = a1.get(j).getName();
				String pName = p1.get(i).getName();
				boolean a = Appointments.searchName(pName);
				//boolean a = (aName.equalsIgnoreCase(pName));
				if(a == true) {
	        		count++;
	        	}
			}
		}
        
        listPanel = new JPanel(new FlowLayout());
        mainPanel.add(listPanel, BorderLayout.CENTER);
        gridPanel = new JPanel(new GridLayout(count+1, 9, 50, 10));
        listPanel.add(gridPanel);
        
        JLabel J1 = new JLabel("Patient ID");
        JLabel J2 = new JLabel("Name");
        JLabel J3 = new JLabel("Doctor Name");
        JLabel J4 = new JLabel("Gender");
        JLabel J5 = new JLabel("Age");
        JLabel J6 = new JLabel("Phone No");
        JLabel J7 = new JLabel("Date");
        JLabel J8 = new JLabel("Time");
        JLabel J9 = new JLabel("Problem");
        
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
        
        gridPanel.add(J1);
        gridPanel.add(J2);
        gridPanel.add(J3);
        gridPanel.add(J4);
        gridPanel.add(J5);
        gridPanel.add(J6);
        gridPanel.add(J7);
        gridPanel.add(J8);
        gridPanel.add(J9);
     
        //generating grid
        for (int i = 0; i < p1.size(); i++) {
        	for(int j = 0; j < a1.size(); j++) {
        		String ID = p1.get(i).getId();
        		String Name = p1.get(i).getName();
        		String DName = a1.get(j).getDName();
        		String Gender = p1.get(i).getGender();
        		String Age = Integer.toString(p1.get(i).getAge());
        		String PhoneNo = p1.get(i).getPhoneno();
        		String Problem = a1.get(j).getProblem();
                String Day = Integer.toString(a1.get(j).getDOA().getDay());
                String Month = Integer.toString(a1.get(j).getDOA().getMonth());
                String Year = Integer.toString(a1.get(j).getDOA().getYear());
                String DateOfAppointment = Day+"/"+Month+"/"+Year;
                String Timming = a1.get(j).getTOA();
                    
                //adding in tempForView
                tempForView[0] = ID;
                tempForView[1] = Name;
                tempForView[2] = DName;
                tempForView[3] = Gender;
                tempForView[4] = Age;
                tempForView[5] = PhoneNo;
                tempForView[6] = DateOfAppointment;
                tempForView[7] = Timming;
                tempForView[8] = Problem;
                    
                for (int k = 0; k < 9; k++) {
                    JLabel J0 = new JLabel(tempForView[k]);
                    J0.setFont(new Font("Open Sans", 0, 10));
                    gridPanel.add(J0);
                }
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
				AdminPage p = new AdminPage();
			}
		}
	}	

}
