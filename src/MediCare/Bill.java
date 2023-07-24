package MediCare;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Bill implements Serializable{
	
	String billID;
	String PatientName;
	String DoctorName;
	Date BillDate;
	double amount;

	public Bill() {
		
	}
	
	public Bill(String ID,String PName,String DName, Date BDate, double A) {
		this.billID = ID;
		this.PatientName = PName;
		this.DoctorName = DName;
		this.BillDate = BDate;
		this.amount = A;
	}

	public String getBillID() {
		return billID;
	}

	public void setBillID(String billID) {
		this.billID = billID;
	}

	public String getPatientName() {
		return PatientName;
	}

	public void setPatientName(String patientName) {
		PatientName = patientName;
	}

	public String getDoctorName() {
		return DoctorName;
	}

	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}

	public Date getBillDate() {
		return BillDate;
	}

	public void setBillDate(Date billDate) {
		BillDate = billDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Bill [billID=" + billID + ", PatientName=" + PatientName + ", DoctorName=" + DoctorName + ", BillDate="
				+ BillDate + ", amount=" + amount + "]";
	}
	
//	public static void discount() {
//		Date d1 = 
//	}
	
	public static void writeToFile(Bill d){
        try {
            ArrayList<Bill> list = readFromFile();
            list.add(d);
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Bill"));
            output.writeObject(list);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public static ArrayList<Bill> readFromFile(){
        ArrayList<Bill> list = new ArrayList<Bill>();
        boolean endoffile=false;
        try{
            ObjectInputStream input=new ObjectInputStream(new FileInputStream("Bill"));

            list =(ArrayList<Bill>) input.readObject();
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
        ArrayList<Bill> list=readFromFile();
        for (int i=0;i<list.size();i++) {
            if (list.get(i).getPatientName().equals(n)) {
                return true;
            }
        }
        return false;
    }
	
    public static  boolean  updatename(String name,double ammount){
        ArrayList<Bill> list=readFromFile();
         System.out.println(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            if(list.get(i).getPatientName().equals(name)) {
                list.get(i).setAmount(ammount);

                try {
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Bill"));
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
