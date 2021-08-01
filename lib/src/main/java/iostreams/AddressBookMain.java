package iostreams;

import com.opencsv.exceptions.CsvException;

public class AddressBookMain {

	public static void main(String[] args) {
		AddressBookFiles addressBookFiles = new AddressBookFiles();
		addressBookFiles.writeDataIntoFile();
		addressBookFiles.readDataFromFile();
		addressBookFiles.printData();

		AddressBookCSV addressBookCSV = new AddressBookCSV(
				"C:\\Users\\Nikhil Arvind\\Batch307\\Workshop_AddressBook\\lib\\src\\main\\resources\\ContactBook.csv");
		try {
			addressBookCSV.readFromCSVFile();
		} catch (CsvException e) {
			e.printStackTrace();
		}
		
		AddressBookJSON addressBookJSON = new AddressBookJSON();
		addressBookJSON.readaddressBookFromAJSONFile("C:\\Users\\Nikhil Arvind\\Batch307\\Workshop_AddressBook\\lib\\src\\main\\resources\\contact.json");
		addressBookJSON.writeContactDetailsInAFile("C:\\\\Users\\\\Nikhil Arvind\\\\Batch307\\\\Workshop_AddressBook\\\\lib\\\\src\\\\main\\\\resources\\\\ContactBook.json");
	}
}
