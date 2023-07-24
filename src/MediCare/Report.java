package MediCare;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Report implements Serializable{

	String Name;
	String Predictions;
	String Medicines;
	String Dosage;
	Date FromDate;
	Date ToDate;
	String DailyUsage;
	
	public Report() {
		
	}
	
	public Report(String n, String p, String m, String d, Date f, Date t, String du) {
		this.Name = n;
		this.Predictions = p;
		this.Medicines = m;
		this.Dosage = d;
		this.FromDate = f;
		this.ToDate = t;
		this.DailyUsage = du;
	}
	
	public Report(Report a) {
		this.Name = a.Name;
		this.Predictions = a.Predictions;
		this.Medicines = a.Medicines;
		this.Dosage = a.Dosage;
		this.FromDate = a.FromDate;
		this.ToDate = a.ToDate;
		this.DailyUsage = a.DailyUsage;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPredictions() {
		return Predictions;
	}

	public void setPredictions(String predictions) {
		Predictions = predictions;
	}

	public String getMedicines() {
		return Medicines;
	}

	public void setMedicines(String medicines) {
		Medicines = medicines;
	}

	public String getDosage() {
		return Dosage;
	}

	public void setDosage(String dosage) {
		Dosage = dosage;
	}

	public Date getFromDate() {
		return FromDate;
	}

	public void setFromDate(Date fromDate) {
		FromDate = fromDate;
	}

	public Date getToDate() {
		return ToDate;
	}

	public void setToDate(Date toDate) {
		ToDate = toDate;
	}

	public String getDailyUsage() {
		return DailyUsage;
	}

	public void setDailyUsage(String dailyUsage) {
		DailyUsage = dailyUsage;
	}

	@Override
	public String toString() {
		return "Report [Name=" + Name + ", Predictions=" + Predictions + ", Medicines=" + Medicines + ", Dosage="
				+ Dosage + ", FromDate=" + FromDate + ", ToDate=" + ToDate + ", DailyUsage=" + DailyUsage + "]";
	}

	public static  void  writeToFile(Report d){
        try {
            ArrayList<Report> list = readFromFile();
            list.add(d);
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Report"));
            output.writeObject(list);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public static ArrayList<Report> readFromFile(){
        ArrayList<Report> list = new ArrayList<Report>();
        boolean endoffile=false;
        try{
            ObjectInputStream input=new ObjectInputStream(new FileInputStream("Report"));

            list =(ArrayList<Report>) input.readObject();
            System.out.println();
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
        ArrayList<Report> list=readFromFile();
        for (int i=0;i<list.size();i++) {
        	if (list.get(i).getName().equals(n)) {
                return true;
            }
        }
        return false;
    }
	
    public static  boolean  updateMedicines(String medicine1,String medicine2){
        ArrayList<Report> list=readFromFile();
         System.out.println(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            if(list.get(i).getMedicines().equals(medicine1)) {
                list.get(i).setMedicines(medicine1);

                try {
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Report"));
                    output.writeObject(list);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            }
        }
        return false;

    }
    public static boolean updateDosage(String dosage1,String dosage2){
        ArrayList<Report> list=readFromFile();
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            if(list.get(i).getDosage().equals(dosage1)) {
                list.get(i).setDosage(dosage2);
                try {
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Report"));
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
