package Workshop_AddressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook implements AddressBook_Interface {

	Scanner input = new Scanner(System.in);
	List<Contact> contact = new ArrayList<>();

	//To add contact of person ino the address book
	@Override
	public void addContact() {
		System.out.println("Enter Firstname:");
		String firstname = input.nextLine();

		System.out.println("Enter Lastname:");
		String lastname = input.nextLine();

		for (int check = 0; check < contact.size(); check++) {
			if (contact.get(check).getFirstname().equalsIgnoreCase(firstname)) {
				if (contact.get(check).getLastname().equalsIgnoreCase(lastname)) {
					System.out.println("Name Already Exist.! Please try again.. : ");
					return;
				}
			}
		}

		System.out.println("Enter Address:");
		String address = input.nextLine();

		System.out.println("Enter City:");
		String city = input.nextLine();

		System.out.println("Enter State:");
		String state = input.nextLine();

		System.out.println("Enter PhoneNumber:");
		String phoneNumber = input.nextLine();

		System.out.println("Enter ZipCode:");
		int zipcode = input.nextInt();

		Contact contactDetail = new Contact(firstname, lastname, address, city, state, phoneNumber, zipcode);
		contact.add(contactDetail);
		System.out.println(" Firstname=" + firstname + ", Lastname=" + lastname + ", city=" + city + ", state=" + state
				+ ", PhoneNumber=" + phoneNumber + ", zipcode=" + zipcode);
		System.out.println("Contact Added Successfully");
	}

}
