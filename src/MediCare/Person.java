package MediCare;

import java.io.Serializable;

public class Person implements Serializable{
	String name;
	String id;
	Date date;
	int age;
	String phoneno;
	String email;
	String gender;
	Address address;
	String password;
	String cPassword;
	
	public Person() {
		
	}

	public Person(String n,String id,Date d,int ag,String ph,String e,String gen,String pass,String cPass,Address a) {
		this.name=n;
		this.id=id;
		this.date = d;
		this.age=ag;
		this.phoneno=ph;
		this.email=e;
		this.gender=gen;
		this.password = pass;
		this.cPassword = cPass;
		this.address=new Address(a);
	}
	public Person(Person p) {
		this.name=p.name;
		this.id=p.id;
		this.date=p.date;
		this.age=p.age;
		this.phoneno=p.phoneno;
		this.email=p.email;
		this.gender=p.gender;
		this.password = p.password;
		this.cPassword = p.cPassword;
		this.address=new Address(p.address);
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getcPassword() {
		return cPassword;
	}
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getPhoneno() {
		return phoneno;
	}
	
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=");
		builder.append(name);
		builder.append(", id=");
		builder.append(id);
		builder.append(", Date Of Birth=");
		builder.append(date);
		builder.append(", Age=");
		builder.append(age);
		builder.append(", Phone No=");
		builder.append(phoneno);
		builder.append(", Email=");
		builder.append(email);
		builder.append(", Gender=");
		builder.append(gender);
		builder.append(", Password=");
		builder.append(password);
		builder.append(", Address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}
	

}
