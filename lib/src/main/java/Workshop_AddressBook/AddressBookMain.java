package Workshop_AddressBook;

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to addressbook program");
		AddressBook addressBook = new AddressBook();
		addressBook.addContact();
		
		System.out.println("Enter your firstname to Edit your details..");
        String firstname = input.next();
        addressBook.editContact(firstname);
        
        System.out.println("Enter your Firstname to delete your details :");
        String firstName = input.next();
        addressBook.deleteContact(firstName);
	}
}
