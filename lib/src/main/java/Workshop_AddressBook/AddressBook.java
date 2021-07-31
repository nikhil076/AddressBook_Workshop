package Workshop_AddressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook implements AddressBook_Interface {

	Scanner input = new Scanner(System.in);
	List<Contact> contact = new ArrayList<>();

	/**
	 * To add contact of a person in Address Book.
	 */
	@Override
	public void addContact() {
		System.out.println("Enter Firstname:");
		String firstname = input.nextLine();

		System.out.println("Enter Lastname:");
		String lastname = input.nextLine();

		/**
         * to check no duplicate firstname or lastname exists.
         */
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

	/**
	 * Performing the operation for edit contact for the existing contact.
	 *
	 * @param firstname
	 *
	 */
	@Override
	public void editContact(String firstname) {
		for (int i = 0; i < contact.size(); ++i) {
			if (contact.get(i).getFirstname().equalsIgnoreCase(firstname)) {
				Contact contactDetail = contact.get(i);
				System.out.println(contactDetail.getFirstname() + "Edit your detail :");
				System.out.println(contactDetail.getFirstname() + "Edit your Address :");
				input.next();
				String address = input.nextLine();
				contactDetail.setAddress(address);
				System.out.println(contactDetail.getFirstname() + " " + "Edit your city :");
				input.next();
				String city = input.nextLine();
				contactDetail.setCity(city);
				System.out.println(contactDetail.getFirstname() + " " + "Edit your State :");
				input.next();
				String state = input.nextLine();
				contactDetail.setState(state);
				System.out.println(contactDetail.getFirstname() + " " + "Edit your Phone Number :");
				input.next();
				String phoneNumber = input.nextLine();
				contactDetail.setPhoneNumber(phoneNumber);
				System.out.println(contactDetail.getFirstname() + " " + "Edit your zipcode :");
				input.next();
				int zipcode = input.nextInt();
				contactDetail.setZipcode(zipcode);
				System.out.println(contactDetail.getFirstname() + " " + "AddressBook Updated Successfully.!");
			}
		}
	}
	
	/**
     *performing the operation for delete contact from the existing contact.
     *
     */
    @Override
    public void deleteContact(String firstname) {
        for (int i = 0; i < contact.size(); i++) {
            if(contact.get(i).getFirstname().equalsIgnoreCase(firstname)) {
                Contact contactDetail = contact.get(i);
                contact.remove(contactDetail);
                System.out.println("Contact Deleted Successfully.!");
            }
        }
    }

    /**
     * Search a person in a city or state across the multiple AddressBook
     *
     * @param firstname
     */
    @Override
    public void searchPersonByCity(String firstname) {
        List<Contact> contactDetailList = contact.stream().filter(person1 -> person1.getFirstname().equalsIgnoreCase(firstname)).collect(Collectors.toList());
        contactDetailList.stream().forEach(System.out::println);
    }

    @Override
    public void searchPersonByState(String firstname) {
        List<Contact> contactDetailList = contact.stream().filter(person1 -> person1.getFirstname().equalsIgnoreCase(firstname)).collect(Collectors.toList());
        contactDetailList.stream().forEach(System.out::println);
    }
}
