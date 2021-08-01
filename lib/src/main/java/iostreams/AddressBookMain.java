package iostreams;

public class AddressBookMain {

	public static void main(String[] args) {
		AddressBookFiles addressBookFiles = new AddressBookFiles();
		addressBookFiles.writeDataIntoFile();
		addressBookFiles.readDataFromFile();
		addressBookFiles.printData();
	}

}
