package MediCare;

import java.io.Serializable;

public class Date implements Serializable{
	private int day;
	private int month;
	private int year;
	
	public Date(int a,int b,int c) {
		if(b<=12) {
		day=a;
		month=b;
		year=c;
		}
	}
	public Date(Date d) {
		this.day=d.getDay();
		this.month=d.getMonth();
		this.year=d.getYear();
	}
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Date [Day=" + day + ", Month=" + month + ", Year=" + year + "]";
	}

}
