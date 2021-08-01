package addressbookdb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import AddressBookException.AddressBookException;

public class AddressBookDBService {

	public static AddressBookDBService addressBookDBService;

	// private constructor
	private AddressBookDBService() {

	}

	// ensures singleton property
	public static AddressBookDBService getInstance() {
		if (addressBookDBService == null)
			addressBookDBService = new AddressBookDBService();
		return addressBookDBService;
	}

	// reads address-book from database and returns the list of contacts
	public List<Contact> readContactsInAddressBook() throws AddressBookException {
		List<Contact> contactList = new ArrayList<>();
		try (Connection con = (Connection) DatabaseConnector.getConnection()) {
			String query = "select * from contact";
			PreparedStatement conStatement = (PreparedStatement) con.prepareStatement(query);
			ResultSet resultSet = conStatement.executeQuery();
			contactList = getDataInDB(resultSet);
		} catch (SQLException e) {
			throw new AddressBookException(e.getMessage());
		}
		return contactList;
	}

	// returns list of contacts present in result-set for a query retrieved from DB
	private List<Contact> getDataInDB(ResultSet resultSet) throws AddressBookException {
		List<Contact> contactList = new ArrayList<>();
		try {
			while (resultSet.next()) {
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String address = resultSet.getString("address");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				Integer zipCode = resultSet.getInt("zip");
				Long phoneNo = resultSet.getLong("phone_no");
				String email = resultSet.getString("email_id");
				Integer contactId = resultSet.getInt("contact_id");
				contactList.add(
						new Contact(firstName, lastName, address, city, state, zipCode, phoneNo, email, contactId));
			}
		} catch (SQLException e) {
			throw new AddressBookException(e.getMessage());
		}
		return contactList;
	}
}
