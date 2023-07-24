package MediCare;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Doctor extends Person implements Serializable {
	private Date dateofjoining;
	private String qualification;
	private String timings;
	private String designation;
	
	public Doctor() {
		super();
	}
	
	public Doctor(String n,String id,int ag,String ph,String e,String gen,Address a,Date d,Date doj,String qual,String time,String des,String pass,String cPass) {
		super(n,id,d,ag,ph,e,gen,pass,cPass,a);
		this.dateofjoining = new Date(doj);
		this.qualification=qual;
		this.timings=time;
		this.designation=des;
	}
	/**
	 * @return the dateofjoining
	 */
	public Date getDateofjoining() {
		return dateofjoining;
	}
	/**
	 * @param dateofjoining the dateofjoining to set
	 */
	public void setDateofjoining(Date dateofjoining) {
		this.dateofjoining = dateofjoining;
	}
	/**
	 * @return the qualification
	 */
	public String getQualification() {
		return qualification;
	}
	/**
	 * @param qualification the qualification to set
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	/**
	 * @return the timings
	 */
	public String getTimings() {
		return timings;
	}
	/**
	 * @param timings the timings to set
	 */
	public void setTimings(String timings) {
		this.timings = timings;
	}
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Doctor [ " + super.toString() + ", Date Of Joining=" + dateofjoining + ", Qualification="
				+ qualification + ", Timings=" + timings + ", Designation=" + designation + "]";
	}

	public static  void  writeToFile(Doctor d){
        try {
            ArrayList<Doctor> list = readFromFile();
            list.add(d);
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Doctor"));
            output.writeObject(list);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public static ArrayList<Doctor> readFromFile(){
        ArrayList<Doctor> list = new ArrayList<Doctor>();
        boolean endoffile=false;
        try{
            ObjectInputStream input=new ObjectInputStream(new FileInputStream("Doctor"));

            list =(ArrayList<Doctor>) input.readObject();
            System.out.println();
        }
        catch(EOFException e){
            endoffile=true;
        }
        catch (ClassCastException e){

        }
        catch (IOException e){

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public static boolean search(String n,int a){
        System.out.println(n);
        ArrayList<Doctor> list=readFromFile();
        if(a==1) {
            for (int i=0;i<list.size();i++) {
                if (list.get(i).getName().equals(n)) {
                    return true;
                }
            }
        }
        else{
            for (int i=0;i<list.size();i++) {
                if (list.get(i).getPassword().equals(n)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static  boolean  updatename(String name1,String name2){
        ArrayList<Doctor> list=readFromFile();
         System.out.println(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            if(list.get(i).getName().equals(name2)) {
                list.get(i).setName(name1);

                try {
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Doctor"));
                    output.writeObject(list);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            }
        }
        return false;

    }
    public static boolean updatepass(String pass1,String pass2){
        ArrayList<Doctor> list=readFromFile();
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            if(list.get(i).getPassword().equals(pass2)) {
                list.get(i).setPassword(pass1);
                try {
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Doctor"));
                    output.writeObject(list);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            }
        }
        return false;

    }

}
