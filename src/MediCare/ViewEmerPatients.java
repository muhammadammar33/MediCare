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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class ViewEmerPatients extends JFrame {

	JPanel mainPanel, headingPanel, listPanel, gridPanel, ButtonPanel;
    JLabel mainLabel;
    JButton BackButton;
    int count = 0;
	
	public static void main(String[] args) {
	
		ViewEmerPatients vd = new ViewEmerPatients();
	}

	/**
	 * Create the frame.
	 */
	public ViewEmerPatients() {
		setTitle("View Emergency Patients");
		setBounds(10,10,1500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		this.getContentPane().setBackground(new java.awt.Color(153,255,204));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Comsats Logo.jpg"));
		
		//for the grid
        ArrayList<Emergency> r1 = Emergency.readFromFile();
        String[] tempForView = new String[3];
        
        mainPanel = new JPanel(new BorderLayout());
        getContentPane().add(mainPanel);
        headingPanel = new JPanel(new FlowLayout());
        mainPanel.add(headingPanel, BorderLayout.NORTH);
        mainLabel = new JLabel("Emergency Patients");
        headingPanel.add(mainLabel);
        ButtonPanel = new JPanel(new FlowLayout());
        mainPanel.add(ButtonPanel, BorderLayout.SOUTH);
        
        BackButton = new JButton("Back");
        BackButton.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonPanel.add(BackButton);
		
		for(int j = 0; j < r1.size(); j++) {
        	String n = MainMenu.NTF.getText();
        	boolean name = Emergency.searchD(n);
            boolean a = (n.equalsIgnoreCase(r1.get(j).getDName()));
        	if((name == true) && (a == true)) {
        		count++;
        	}
		}
        
        listPanel = new JPanel(new FlowLayout());
        mainPanel.add(listPanel, BorderLayout.CENTER);
        gridPanel = new JPanel(new GridLayout(count+1, 3, 50, 10));
        listPanel.add(gridPanel);
        
        JLabel J1 = new JLabel("Patient Name");
        JLabel J2 = new JLabel("Doctor Name");
        JLabel J3 = new JLabel("Problem");
        
        mainLabel.setFont(new Font("Open Sans ExtraBold", 0, 24));
        J1.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J2.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J3.setFont(new Font("Open Sans ExtraBold", 0, 14));
        
        gridPanel.add(J1);
        gridPanel.add(J2);
        gridPanel.add(J3);
        
        //generating grid
        for(int j = 0; j < r1.size(); j++) {
        	String n = MainMenu.NTF.getText();
        	boolean name = Emergency.searchD(n);
//        	System.out.println(n);
            System.out.println("name = " + name);
//            System.out.println(r1.get(j).getName());
            boolean a = (n.equalsIgnoreCase(r1.get(j).getDName()));
            System.out.println(a);
        	if((name == true) && (a == true)) {
        		String PName = r1.get(j).getPname();
        		String DName = r1.get(j).getDName();
                String Problem = r1.get(j).getProblem();
                    
                //adding in tempForView
                tempForView[0] = PName;
                tempForView[1] = DName;
                tempForView[2] = Problem;
                   
                for (int k = 0; k < 3; k++) {
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
				DoctorPage p = new DoctorPage();
			}
		}
	}	
}
