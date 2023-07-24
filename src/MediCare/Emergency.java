package MediCare;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Emergency implements Serializable{

	String Pname;
	String DName;
	String Problem;
	
	public Emergency() {
		
	}
	
	public Emergency(String pn, String dn, String P) {
		this.Pname = pn;
		this.DName = dn;
		this.Problem = P;
	}
	
	public Emergency(Emergency e) {
		this.Pname = e.Pname;
		this.DName = e.DName;
		this.Problem = e.Problem;
	}

	public String getPname() {
		return Pname;
	}

	public void setPname(String pname) {
		Pname = pname;
	}

	public String getDName() {
		return DName;
	}

	public void setDName(String dName) {
		DName = dName;
	}

	public String getProblem() {
		return Problem;
	}

	public void setProblem(String problem) {
		Problem = problem;
	}

	@Override
	public String toString() {
		return "Emergency [Pname=" + Pname + ", DName=" + DName + ", Problem=" + Problem + "]";
	}
	
	public static  void  writeToFile(Emergency d){
        try {
            ArrayList<Emergency> list = readFromFile();
            list.add(d);
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Emergency"));
            output.writeObject(list);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public static ArrayList<Emergency> readFromFile(){
        ArrayList<Emergency> list = new ArrayList<Emergency>();
        boolean endoffile=false;
        try{
            ObjectInputStream input=new ObjectInputStream(new FileInputStream("Emergency"));

            list =(ArrayList<Emergency>) input.readObject();
            //System.out.println(list.toString());
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
	
	public static boolean search(String n){
        System.out.println(n);
        ArrayList<Emergency> list=readFromFile();
        for (int i=0;i<list.size();i++) {
            if (list.get(i).getPname().equals(n)) {
                return true;
            }
        }
        return false;
    }
	
	public static boolean searchD(String n){
        System.out.println(n);
        ArrayList<Emergency> list=readFromFile();
        for (int i=0;i<list.size();i++) {
            if (list.get(i).getDName().equals(n)) {
                return true;
            }
        }
        return false;
    }
	
    public static  boolean  updatename(String name1,String name2){
        ArrayList<Emergency> list=readFromFile();
         System.out.println(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            if(list.get(i).getDName().equals(name1)) {
                list.get(i).setDName(name2);

                try {
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Emergency"));
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
