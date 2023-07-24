package MediCare;

import java.io.Serializable;

public class Address implements Serializable{
	private int home;
	private int street;
	private String city;
	
	public Address() {
		home=123;
		street=12;
		city="Lahore";
	}
	public Address(int a,int b,String c) {
		home=a;
		street=b;
		city=c;
	}
	public Address(Address a) {
		this.home=a.getHome();
		this.street=a.getStreet();
		this.city=a.getCity();
	}
	public int getHome() {
		return home;
	}
	public void setHome(int home) {
		this.home = home;
	}
	public int getStreet() {
		return street;
	}
	public void setStreet(int street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [home=" + home + ", street=" + street + ", city=" + city + "]";
	}
}

