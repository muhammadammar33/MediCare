package MediCare;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Appointments implements Serializable{

	String Problem;
	String name;
	String DName;
	Date DOA;
	String TOA;
	
	public Appointments() {
		// TODO Auto-generated constructor stub
	}

	public Appointments(String n, String DN, Date doa, String t, String p) {
		this.name = n;
		this.DName = DN;
		this.DOA = doa;
		this.TOA = t;
		this.Problem = p;
	}

	public Appointments(Appointments a) {
		this.name = a.name;
		this.DName = a.DName;
		this.DOA = a.DOA;
		this.TOA = a.TOA;
		this.Problem = a.Problem;
	}

	public String getDName() {
		return DName;
	}

	public void setDName(String dName) {
		DName = dName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProblem() {
		return Problem;
	}

	public void setProblem(String problem) {
		Problem = problem;
	}

	public Date getDOA() {
		return DOA;
	}

	public void setDOA(Date dOA) {
		DOA = dOA;
	}

	public String getTOA() {
		return TOA;
	}

	public void setTOA(String tOA) {
		TOA = tOA;
	}

	@Override
	public String toString() {
		return "Appointments [name=" + name + ", DName=" + DName + ", DOA=" + DOA + ", TOA=" + TOA + ", Problem="
				+ Problem + "]";
	}

	public static  void  writeToFile(Appointments p){
        try {
            ArrayList<Appointments> list = readFromFile();
            list.add(p);
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Appointment"));
            output.writeObject(list);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public static ArrayList<Appointments> readFromFile(){
        ArrayList<Appointments> list = new ArrayList<Appointments>();
        boolean endoffile=false;
        try{
            ObjectInputStream input=new ObjectInputStream(new FileInputStream("Appointment"));

            list =(ArrayList<Appointments>) input.readObject();
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
    
    public static boolean searchName(String n){
        System.out.println(n);
        ArrayList<Appointments> list=readFromFile();
        for (int i=0;i<list.size();i++) {
        	if (list.get(i).getName().equals(n)) {
        		return true;
            }
        }
        return false;
    }
    
    public static boolean searchDName(String n){
        System.out.println(n);
        ArrayList<Appointments> list=readFromFile();
        for (int i=0;i<list.size();i++) {
        	if (list.get(i).getDName().equals(n)) {
        		return true;
            }
        }
        return false;
    }
	
	public static boolean searchDate(Date d){
        System.out.println(d);
        ArrayList<Appointments> list=readFromFile();
        for (int i=0;i<list.size();i++) {
        	if (list.get(i).getDOA().equals(d)) {
        		return true;
            }
        }
        return false;
    }
	
    public static  boolean  updatetime(String t1,String t2){
        ArrayList<Appointments> list=readFromFile();
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            if(list.get(i).getTOA().equals(t1)) {
                list.get(i).setTOA(t2);;

                try {
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Appointment"));
                    output.writeObject(list);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            }
        }
        return false;

    }
    
    public static  boolean  updateDate(Date d1,Date d2){
        ArrayList<Appointments> list=readFromFile();
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            if(list.get(i).getDOA().equals(d1)) {
                list.get(i).setDOA(d2);;

                try {
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Appointment"));
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
