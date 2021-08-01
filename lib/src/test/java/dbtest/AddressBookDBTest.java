package dbtest;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import addressbookdb.AddressBookServiceController;
import addressbookdb.AddressBookServiceController.IOService;

public class AddressBookDBTest {

	private static AddressBookServiceController addressBookDBController;

	@BeforeClass
	public static void initialize() {
		addressBookDBController = new AddressBookServiceController();
	}

	@Test
	public void test1_readDataFromDB_shouldreturnCorrectCOunt() {
		addressBookDBController.readContacts(IOService.DB_IO);
		Integer count = addressBookDBController.contactList.size();
		assertEquals(Integer.valueOf(4), count);
	}
}