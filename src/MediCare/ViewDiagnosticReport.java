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

public class ViewDiagnosticReport extends JFrame {

	JPanel mainPanel, headingPanel, listPanel, gridPanel, ButtonPanel;
    JLabel mainLabel;
    JButton BackButton;
    int count = 0;
	
	public static void main(String[] args) {
	
		ViewDiagnosticReport vd = new ViewDiagnosticReport();
	}

	/**
	 * Create the frame.
	 */
	public ViewDiagnosticReport() {
		setTitle("View Appointments");
		setBounds(10,10,1500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		this.getContentPane().setBackground(new java.awt.Color(153,255,204));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ammar Cheema\\eclipse-workspace\\Oop Project\\Comsats Logo.jpg"));
		
		//for the grid
        ArrayList<Report> r1 = Report.readFromFile();
        String[] tempForView = new String[7];
        
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
        	boolean name = Report.search(n);
            boolean a = (n.equalsIgnoreCase(r1.get(j).getName()));
        	if((name == true) && (a == true)) {
        		count++;
        	}
		}
        
        listPanel = new JPanel(new FlowLayout());
        mainPanel.add(listPanel, BorderLayout.CENTER);
        gridPanel = new JPanel(new GridLayout(count+1, 7, 50, 10));
        listPanel.add(gridPanel);
        
        JLabel J1 = new JLabel("Name");
        JLabel J2 = new JLabel("Predictions");
        JLabel J3 = new JLabel("Medicines");
        JLabel J4 = new JLabel("Dosage");
        JLabel J5 = new JLabel("From Date");
        JLabel J6 = new JLabel("To Date");
        JLabel J7 = new JLabel("Daily Usage");
        
        mainLabel.setFont(new Font("Open Sans ExtraBold", 0, 24));
        J1.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J2.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J3.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J4.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J5.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J6.setFont(new Font("Open Sans ExtraBold", 0, 14));
        J7.setFont(new Font("Open Sans ExtraBold", 0, 14));
        
        gridPanel.add(J1);
        gridPanel.add(J2);
        gridPanel.add(J3);
        gridPanel.add(J4);
        gridPanel.add(J5);
        gridPanel.add(J6);
        gridPanel.add(J7);
        
        //generating grid
        for(int j = 0; j < r1.size(); j++) {
        	String n = MainMenu.NTF.getText();
        	boolean name = Report.search(n);
//        	System.out.println(n);
//            System.out.println(name);
//            System.out.println(r1.get(j).getName());
            boolean a = (n.equalsIgnoreCase(r1.get(j).getName()));
            System.out.println(a);
        	if((name == true) && (a == true)) {
        		String Name = r1.get(j).getName();
        		String Prediction = r1.get(j).getPredictions();
        		String Medicine = r1.get(j).getMedicines();
        		String Dosage = r1.get(j).getDosage();
        		String Day = Integer.toString(r1.get(j).getFromDate().getDay());
                String Month = Integer.toString(r1.get(j).getFromDate().getMonth());
                String Year = Integer.toString(r1.get(j).getFromDate().getYear());
                String FromDate = Day+"/"+Month+"/"+Year;
                String Day1 = Integer.toString(r1.get(j).getToDate().getDay());
                String Month1 = Integer.toString(r1.get(j).getToDate().getMonth());
                String Year1 = Integer.toString(r1.get(j).getToDate().getYear());
                String ToDate = Day1+"/"+Month1+"/"+Year1;
                String DailyUsage = r1.get(j).getDailyUsage();
                    
                //adding in tempForView
                tempForView[0] = Name;
                tempForView[1] = Prediction;
                tempForView[2] = Medicine;
                tempForView[3] = Dosage;
                tempForView[4] = FromDate;
                tempForView[5] = ToDate;
                tempForView[6] = DailyUsage;
                   
                for (int k = 0; k < 7; k++) {
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
