package iostreams;

public class Contacts {

	public String first;
	public String last;
	public String address;
	public String city;
	public String state;
	public int zip;
	public int phoneNumber;
	public String email;

	public Contacts() {
		super();
	}

	public void readEntry() {
		System.out.println("First Name:" + first);
		System.out.println("Last Name:" + last);
		System.out.println("Address:" + address);
		System.out.println("city :" + city);
		System.out.println("State :" + state);
		System.out.println("Zip :" + zip);
		System.out.println("Phone Number :" + phoneNumber);
		System.out.println("Email:" + email);
	}

	public Contacts(String first, String last, String address, String city, String state, int zip, int phoneNumber,
			String email) {
		super();
		this.first = first;
		this.last = last;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Contacts [first=" + first + ", last=" + last + ", address=" + address + ", city=" + city + ", state="
				+ state + ", zip=" + zip + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
}
