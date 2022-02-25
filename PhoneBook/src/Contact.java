import java.io.Serializable;

public class Contact implements Comparable<Contact>,Serializable{
	
	private String name;
	private String phone;
	
	/* Contact - short class, we have setters and getters. 
	 * Serializable and Comparable are implemented.
	 * Comparable is implemented so we will be able to do Contact sorting in class Contacts
	 * */
	
	public Contact(String name,String phone)
	{
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	//Comparing names, better have a phonebook sorted by names and not by numbers
	@Override
	public int compareTo(Contact o) {
		return this.name.compareTo(o.getName());
	}
	
}
