package addressbookdb;

import java.util.ArrayList;
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

	// reads details from database or json-server and stores to cntactList
	public void readContacts(IOService ioService) {
		if (ioService.equals(IOService.DB_IO)) {
			try {
				contactList = AddressBookDBService.getInstance().readContactsInAddressBook();
			} catch (AddressBookException e) {
				e.printStackTrace();
			}
		}
	}
}
