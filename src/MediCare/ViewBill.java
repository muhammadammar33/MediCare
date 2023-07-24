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

public class ViewBill extends JFrame {

	JPanel mainPanel, headingPanel, listPanel, gridPanel, ButtonPanel;
    JLabel mainLabel;
    JButton BackButton;
    int count = 0;
	
	public static void main(String[] args) {
	
		ViewBill vd = new ViewBill();
	}

	/**
	 * Create the frame.
	 */
	public ViewBill() {
		setTitle("View Bill");
		setBounds(10,10,1500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		this.getContentPane().setBackground(new java.awt.Color(153,255,204));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Comsats Logo.jpg"));
		
		//for the grid
        ArrayList<Bill> r1 = Bill.readFromFile();
        String[] tempForView = new String[5];
        
        mainPanel = new JPanel(new BorderLayout());
        getContentPane().add(mainPanel);
        headingPanel = new JPanel(new FlowLayout());
        mainPanel.add(headingPanel, BorderLayout.NORTH);
        mainLabel = new JLabel("List of Reports");
        headingPanel.add(mainLabel);
        ButtonPanel = new JPanel(new FlowLayout());
        mainPanel.add(ButtonPanel, BorderLayout.SOUTH);
        
        BackButton = new JButton("Back");
        BackButton.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonPanel.add(BackButton);
		
		for(int j = 0; j < r1.size(); j++) {
        	String n = MainMenu.NTF.getText();
        	boolean name = Bill.search(n);
            boolean a = (n.equalsIgnoreCase(r1.get(j).getPatientName()));
        	if((name == true) && (a == true)) {
        		count++;
        	}
		}
        
        listPanel = new JPanel(new FlowLayout());
        mainPanel.add(listPanel, BorderLayout.CENTER);
        gridPanel = new JPanel(new GridLayout(count+1, 5, 50, 10));
        listPanel.add(gridPanel);
        
        JLabel J1 = new JLabel("Bill ID");
        JLabel J2 = new JLabel("Patient Name");
        JLabel J3 = new JLabel("Doctor Name");
        JLabel J4 = new JLabel("Bill Date");
        JLabel J5 = new JLabel("Amount");
        
        mainLabel.setFont(new Font("Open Sans ExtraBold", 0, 24));
        J1.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J2.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J3.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J4.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J5.setFont(new Font("Open Sans ExtraBold", 0, 14));
        
        gridPanel.add(J1);
        gridPanel.add(J2);
        gridPanel.add(J3);
        gridPanel.add(J4);
        gridPanel.add(J5);
        
        //generating grid
        for(int j = 0; j < r1.size(); j++) {
        	String n = MainMenu.NTF.getText();
        	boolean name = Bill.search(n);
//        	System.out.println(n);
//            System.out.println(name);
//            System.out.println(r1.get(j).getName());
            boolean a = (n.equalsIgnoreCase(r1.get(j).getPatientName()));
            System.out.println(a);
        	if((name == true) && (a == true)) {
        		String ID = r1.get(j).getBillID();
        		String PName = r1.get(j).getPatientName();
        		String DName = r1.get(j).getDoctorName();
        		String Day = Integer.toString(r1.get(j).getBillDate().getDay());
                String Month = Integer.toString(r1.get(j).getBillDate().getMonth());
                String Year = Integer.toString(r1.get(j).getBillDate().getYear());
                String BillDate = Day+"/"+Month+"/"+Year;
                String Amount = Double.toString(r1.get(j).getAmount());
                    
                //adding in tempForView
                tempForView[0] = ID;
                tempForView[1] = PName;
                tempForView[2] = DName;
                tempForView[3] = BillDate;
                tempForView[4] = Amount;
                   
                for (int k = 0; k < 5; k++) {
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
				PatientPage p = new PatientPage();
			}
		}
	}	
}
