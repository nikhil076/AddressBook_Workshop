package addressbookdb;

import java.time.LocalDate;
import java.util.Objects;

public class Contact {

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private Integer zipCode;
	private Long phoneNo;
	private String email;
	private Integer contactId;
	private LocalDate dateAdded;
	private String addressBookId;
	private String addressBookTypeId;

	public Contact() {
	}

	// parameter constructor 
	public Contact(String firstName, String lastName, String address, String city, String state, int zipCode,
			long phoneNo, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNo = phoneNo;
		this.email = email;
	}

	public Contact(String firstName, String lastName, String address, String city, String state, int zipCode,
			long phoneNo, String email, int contactId) {
		this(firstName, lastName, address, city, state, zipCode, phoneNo, email);
		this.contactId = contactId;
	}

	public Contact(String firstName, String lastName, String address, String city, String state, int zipCode,
			long phoneNo, String email, LocalDate dateAdded, String addressBookId, String addressBookTypeId) {
		this(firstName, lastName, address, city, state, zipCode, phoneNo, email);
		this.dateAdded = dateAdded;
		this.addressBookId = addressBookId;
		this.addressBookTypeId = addressBookTypeId;
	}

	public Contact(int contactId, String firstName, String lastName, String address, String city, String state,
			int zipCode, long phoneNo, String email) {
		this(firstName, lastName, address, city, state, zipCode, phoneNo, email);
		this.contactId = contactId;
	}

	// getters and setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getAddressBookId() {
		return addressBookId;
	}

	public void setAddressBookId(String addressBookId) {
		this.addressBookId = addressBookId;
	}

	public String getAddressBookTypeId() {
		return addressBookTypeId;
	}

	public void setAddressBookTypeId(String addressBookTypeId) {
		this.addressBookTypeId = addressBookTypeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, phoneNo, email);
	}

	@Override
	public boolean equals(Object object) {
		if (object == this)
			return true;
		if (!(object instanceof Contact))
			return false;
		Contact contact = (Contact) object;
		return (this.getFirstName() + " " + this.getLastName())
				.equals(contact.getFirstName() + " " + contact.getLastName());
	}

	@Override
	public String toString() {
		return this.firstName + "," + this.lastName + "," + this.address + "," + this.city + "," + this.state + ","
				+ this.zipCode + "," + this.phoneNo + "," + this.email + "\n";
	}

	public String getString() {
		return "FirstName: " + this.firstName + " LastName: " + this.lastName + " Address: " + this.address + " City: "
				+ this.city + " State: " + this.state + " ZipCode: " + this.zipCode + " PhoneNo: " + this.phoneNo
				+ " Email: " + this.email + "\n";
	}
}
