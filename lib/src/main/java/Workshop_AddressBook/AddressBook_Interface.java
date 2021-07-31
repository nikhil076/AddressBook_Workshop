package Workshop_AddressBook;

public interface AddressBook_Interface {
	public void addContact();

	public void editContact(String firstname);

	public void deleteContact(String firstname);

	public void searchPersonByCity(String firstname);

	public void searchPersonByState(String firstname);

	public void viewByCity(String city);

	public void viewByState(String state);

	public void CountByCity(String City);
	
	public void display();
	
	public void sortEntryInAddressBookAlphabeticallyByFirstName();
}
