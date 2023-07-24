package MediCare;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Patient extends Person implements Serializable{
	
	public Patient(String n,String id,Date d,int ag,String ph,String e,String gen,Address a,String pass, String cPass) {
		super(n,id,d,ag,ph,e,gen,pass, cPass, a);
	}

	public Patient() {
		// TODO Auto-generated constructor stub
	}


	public String toString() {
		return "Patient [" + super.toString() + "]";
	}
	
	public static  void  writeToFile(Patient p){
        try {
            ArrayList<Patient> list = readFromFile();
            list.add(p);
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Patient"));
            output.writeObject(list);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public static ArrayList<Patient> readFromFile(){
        ArrayList<Patient> list = new ArrayList<Patient>();
        boolean endoffile=false;
        try{
            ObjectInputStream input=new ObjectInputStream(new FileInputStream("Patient"));

            list =(ArrayList<Patient>) input.readObject();
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
        ArrayList<Patient> list=readFromFile();
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
        ArrayList<Patient> list=readFromFile();
         System.out.println(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            if(list.get(i).getName().equals(name2)) {
                list.get(i).setName(name1);

                try {
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Patient"));
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
        ArrayList<Patient> list=readFromFile();
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            if(list.get(i).getPassword().equals(pass2)) {
                list.get(i).setPassword(pass1);
                try {
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Patient"));
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
