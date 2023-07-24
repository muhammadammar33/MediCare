package MediCare;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Admin implements Serializable{

	String Name;
	String ID;
	String Password;
	String CPassword;
	
	public Admin() {
		
	}
	
	public Admin(String n, String id, String p, String cp) {
		this.Name = n;
		this.ID = id;
		this.Password = p;
		this.CPassword = cp;
	}
	
	public Admin(Admin a) {
		this.Name = a.Name;
		this.ID = a.ID;
		this.Password = a.Password;
		this.CPassword = a.CPassword;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCPassword() {
		return CPassword;
	}

	public void setCPassword(String cPassword) {
		CPassword = cPassword;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	@Override
	public String toString() {
		return "Admin [Name=" + Name + ", ID=" + ID + ", Password=" + Password + ", CPassword=" + CPassword + "]";
	}

	public static  void  writeToFile(Admin d){
        try {
            ArrayList<Admin> list = readFromFile();
            list.add(d);
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Admin"));
            output.writeObject(list);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public static ArrayList<Admin> readFromFile(){
        ArrayList<Admin> list = new ArrayList<Admin>();
        boolean endoffile=false;
        try{
            ObjectInputStream input=new ObjectInputStream(new FileInputStream("Admin"));

            list =(ArrayList<Admin>) input.readObject();
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
	
	public static boolean search(String n,int a){
        System.out.println(n);
        ArrayList<Admin> list=readFromFile();
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
        ArrayList<Admin> list=readFromFile();
         System.out.println(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            if(list.get(i).getName().equals(name2)) {
                list.get(i).setName(name1);

                try {
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Admin"));
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
        ArrayList<Admin> list=readFromFile();
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            if(list.get(i).getPassword().equals(pass2)) {
                list.get(i).setPassword(pass1);
                try {
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Admin"));
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
