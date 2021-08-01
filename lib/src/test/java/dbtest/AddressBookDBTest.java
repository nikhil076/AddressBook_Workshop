package dbtest;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import addressbookdb.AddressBookServiceController;
import addressbookdb.AddressBookServiceController.IOService;
import addressbookdb.Contact;

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

	@Test
	public void test2_givenData_WhenUpdated_ShouldBeInSyncWithDB() {
		Long expectedPhone = 9988776654l;
		Long phone = null;
		addressBookDBController.updatePhoneContact(IOService.DB_IO, "Arvind", "Nikhil", expectedPhone);
		Contact contact = addressBookDBController.getContact("Arvind", "Nikhil");
		if (contact != null)
			phone = contact.getPhoneNo();
		assertEquals(expectedPhone, phone);
	}
	
	@Test
	public void test3_givenDatePeriod_WhenContactsRetrievedFromDB_ShouldReturnCorrectCount() {
		Integer count = addressBookDBController
				.getContactsAddedInParticularPeriodFromDB(LocalDate.of(2017, 05, 01), LocalDate.of(2019, 05, 01))
				.size();
		assertEquals(Integer.valueOf(2), count);
	}
	
	@Test
	public void test4_givenCity_WhenContactsRetrievedFromDB_ShouldReturnCorrectCount() {
		Long count = addressBookDBController.getContactsByCityFromDB("Hyderabad");
		assertEquals(Long.valueOf(1), count);
	}

	@Test
	public void test5_givenState_WhenContactsRetrievedFromDB_ShouldReturnCorrectCount() {
		Long count = addressBookDBController.getContactsByStateFromDB("Odisha");
		assertEquals(Long.valueOf(2), count);
	}
}