package Workshop_AddressBook;

public interface AddressBook_Interface {
	public void addContact();
	public void editContact(String firstname);
	public void deleteContact(String firstname);
	public void searchPersonByCity(String firstname);
    public void searchPersonByState(String firstname);
}
