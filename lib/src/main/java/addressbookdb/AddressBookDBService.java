package addressbookdb;

import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
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

	// updates contact details in database
	public void updateContactPhoneInAddressBook(String fisrtName, String lastName, Long phone)
			throws AddressBookException {
		try (Connection con = (Connection) DatabaseConnector.getConnection()) {
			String query = "update contact set phone_no=? where first_name=? and last_name=?";
			PreparedStatement conStatement = (PreparedStatement) con.prepareStatement(query);
			conStatement.setLong(1, phone);
			conStatement.setString(2, fisrtName);
			conStatement.setString(3, lastName);
			int status = conStatement.executeUpdate();
		} catch (SQLException e) {
			throw new AddressBookException(e.getMessage());
		}
	}

	// returns the list of contacts added in particular period
	public List<Contact> getContactsAddedInParticularPeriod(LocalDate start, LocalDate end)
			throws AddressBookException {
		List<Contact> contactList = new ArrayList<>();
		try (Connection con = (Connection) DatabaseConnector.getConnection()) {
			String query = "select * from contact where date_added between ? and ?";
			PreparedStatement conStatement = (PreparedStatement) con.prepareStatement(query);
			conStatement.setDate(1, Date.valueOf(start));
			conStatement.setDate(2, Date.valueOf(end));
			ResultSet resultSet = conStatement.executeQuery();
			contactList = getDataInDB(resultSet);
		} catch (SQLException e) {
			throw new AddressBookException(e.getMessage());
		}
		return contactList;
	}

	// returns the count of contacts present in a city
	public long getContactsByCity(String city) throws AddressBookException {
		long count = 0l;
		try (Connection con = (Connection) DatabaseConnector.getConnection()) {
			String query = "select count(contact_id) from contact where city=?";
			PreparedStatement conStatement = (PreparedStatement) con.prepareStatement(query);
			conStatement.setString(1, city);
			ResultSet resultSet = conStatement.executeQuery();
			if (resultSet.next())
				count = resultSet.getLong(1);
		} catch (SQLException e) {
			throw new AddressBookException(e.getMessage());
		}
		return count;
	}

	// returns the count of contacts present in a state
	public long getContactsByState(String state) throws AddressBookException {
		long count = 0l;
		try (Connection con = (Connection) DatabaseConnector.getConnection()) {
			String query = "select count(contact_id) from contact where state=?";
			PreparedStatement conStatement = (PreparedStatement) con.prepareStatement(query);
			conStatement.setString(1, state);
			ResultSet resultSet = conStatement.executeQuery();
			if (resultSet.next())
				count = resultSet.getLong(1);
		} catch (SQLException e) {
			throw new AddressBookException(e.getMessage());
		}
		return count;
	}
}
