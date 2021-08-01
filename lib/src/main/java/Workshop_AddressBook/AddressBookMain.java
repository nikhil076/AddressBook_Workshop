package Workshop_AddressBook;

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		boolean result = true;
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to addressbook program");
		AddressBook_Interface addressBook = new AddressBook();
		/**
         * switch case for each cases to be performed
         */
        while(result) {
            System.out.println("Enter option to make changes : \n[press 1 to add new Contact" +
                    "\n press 2 to Edit existing contacts" + "\n press 3 to delete a contact detail " + "\n press 4 to search person by city" +
                    "\n press 5 to search person by state" + "\n press 6 to view person by city" +
                    "\n press 7 to view person by state" + "\n press 8 to count persons by city or state" + "\n press 9 to display contacts" +
                    "\n press 10 to sort contacts in alphabetical order by name" + "\n press 11 to sort contact according to city or state" + "\n press 0 to quit ]");
            int option = input.nextInt();
            switch (option) {
                case 1 :
                    addressBook.addContact();
                    break;
                case 2 :
                    System.out.println("Enter your firstname to Edit your details..");
                    String firstname = input.next();
                    addressBook.editContact(firstname);
                    break;
                case 3 :
                    System.out.println("Enter your Firstname to delete your details :");
                    String firstName = input.next();
                    addressBook.deleteContact(firstName);
                    break;
                case 4 :
                    System.out.println("Enter Firstname to search person by city :");
                    String name = input.next();
                    addressBook.searchPersonByCity(name);
                    break;
                case 5 :
                    System.out.println("Enter Firstname to search person by state :");
                    String Name = input.next();
                    addressBook.searchPersonByState(Name);
                    break;
                case 6 :
                    System.out.println("Enter the City Name: ");
                    String city = input.next();
                    addressBook.viewByCity(city);
                    break;
                case 7 :
                    System.out.println("Enter the State name:");
                    String state = input.next();
                    addressBook.viewByState(state);
                    break;
                case 8 :
                    System.out.println("Enter City or State to count Person");
                    String City = input.next();
                    addressBook.CountByCity(City);
                    break;
                case 9 :
                    addressBook.display();
                    break;
                case 10 :
                    addressBook.sortEntryInAddressBookAlphabeticallyByFirstName();
                    break;
                case 11 :
                	addressBook.sortAccordingToCityStateOrZip();
                default:
                    result = false;
            }
        }
    }
}
