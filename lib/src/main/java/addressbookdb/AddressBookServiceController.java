package addressbookdb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import AddressBookException.AddressBookException;

public class AddressBookServiceController {

	public List<Contact> contactList;

	public enum IOService {
		DB_IO, REST_IO
	}

	public AddressBookServiceController() {
		contactList = new ArrayList<>();
	}

	public AddressBookServiceController(List<Contact> contactList) {
		this();
		contactList.stream().forEach(con -> this.contactList.add(con));
	}

	// reads details from database 
	public void readContacts(IOService ioService) {
		if (ioService.equals(IOService.DB_IO)) {
			try {
				contactList = AddressBookDBService.getInstance().readContactsInAddressBook();
			} catch (AddressBookException e) {
				e.printStackTrace();
			}
		}
	}

	// updates phone details of contact
	public void updatePhoneContact(IOService ioService, String firstName, String lastName, Long phone) {
		Contact contact = getContact(firstName, lastName);
		if (ioService.equals(IOService.DB_IO)) {
			try {
				AddressBookDBService.getInstance().updateContactPhoneInAddressBook(firstName, lastName, phone);
			} catch (AddressBookException e) {
				e.printStackTrace();
			}
			if (contact != null)
				contact.setPhoneNo(phone);
		}
		if (ioService.equals(IOService.REST_IO) && contact != null)
			contact.setPhoneNo(phone);
	}

	// returns contact by name
	public Contact getContact(String firstName, String lastName) {
		return contactList.stream()
				.filter(con -> con.getFirstName().equals(firstName) && con.getLastName().equals(lastName)).findFirst()
				.orElse(null);
	}

	// returns list of contacts added in particular period
	public List<Contact> getContactsAddedInParticularPeriodFromDB(LocalDate start, LocalDate end) {
		try {
			return AddressBookDBService.getInstance().getContactsAddedInParticularPeriod(start, end);
		} catch (AddressBookException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	// returns the count of contacts present in a city from database
	public long getContactsByCityFromDB(String city) {
		try {
			return AddressBookDBService.getInstance().getContactsByCity(city);
		} catch (AddressBookException e) {
			e.printStackTrace();
		}
		return 0l;
	}

	// returns the count of contacts present in a state from database
	public long getContactsByStateFromDB(String state) {
		try {
			return AddressBookDBService.getInstance().getContactsByState(state);
		} catch (AddressBookException e) {
			e.printStackTrace();
		}
		return 0l;
	}
	
	// add contacts to database
		public boolean addContact(Contact contact, IOService ioService) {
			if (ioService.equals(IOService.DB_IO)) {
				try {
					if (AddressBookDBService.getInstance().addContact(contact)) {
						contactList.add(contact);
						return true;
					}
				} catch (AddressBookException e) {
					e.printStackTrace();
				}
			}
			return false;
		}
}
