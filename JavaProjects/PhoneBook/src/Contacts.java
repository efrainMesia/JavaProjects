import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Contacts implements Serializable{
	
	private ArrayList<Contact> contacts;
	
	
	/* Contacts class is an Arraylist of Contacts.
	 * Serializable is implemented for getting existing phonebook from file
	 * We will be able to add, remove, update and find contacts in the array list.
	 * Find contacts will be only used to update phone to an existing contact.
	 */
	
	/* Creates an empty ArrayList*/
	public Contacts()
	{
		this.contacts = new ArrayList<Contact>();
	}
	
	
	//add contact to Array list
	public void addContact(String name, String phone)
	{
		Contact temp = new Contact(name,phone);
		this.contacts.add(temp);
	}
	
	
	
	//remove contact to Array List
	public void removeContact(Contact contact)
	{
		for (int i = 0; i < this.contacts.size(); i++) 
		{
			if(contact.getName().equals(this.contacts.get(i).getName()) &&
					contact.getPhone().equals(this.contacts.get(i).getPhone()))
			{
				this.contacts.remove(i);
				break;
			}
		}
	}
	
	
	/* Find the phone by the old phone, if the phone number exists,
	 * we remove and add the contact to the arrayList
	 */
	public void updateContactPhone(String name, String oldPhone, String newPhone)
	{
		Contact temp = this.findContactByPhone(oldPhone);
		if(temp != null)
		{
			this.removeContact(temp);
			temp.setPhone(newPhone);
			this.contacts.add(temp);
		}
	}
	
	public Contact findContactByPhone(String phone)
	{
		for (int i = 0; i < this.contacts.size(); i++) 
		{
			if(phone.equals(this.contacts.get(i).getPhone()))
			{
				return this.contacts.get(i);
			}
		}
		return null;		//if phone doesnt exist
	}
	
	//Sorting contacts in arrayList
	public void sortContacts()
	{
		Collections.sort(this.contacts);
	}
	
	// returns the contacts Arraylist. will be used in GUI
	public ArrayList<Contact> getContacts()
	{
		return this.contacts;
	}

}
