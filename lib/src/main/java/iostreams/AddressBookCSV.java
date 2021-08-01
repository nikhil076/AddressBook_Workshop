package iostreams;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBookCSV {

	public String addressBookCSV;

	public AddressBookCSV(String addressBookCSV) {
		super();
		this.addressBookCSV = addressBookCSV;
	}

	public AddressBookCSV() {
		super();
	}

	public void writeContacatDetailsToFile() throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		List<Contacts> contactDetailsList = new ArrayList<Contacts>();
		try {
			Writer writer = Files.newBufferedWriter(Paths.get(this.addressBookCSV));
			StatefulBeanToCsv<Contacts> beanToCsv = new StatefulBeanToCsvBuilder(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
			beanToCsv.write(contactDetailsList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFromCSVFile() throws CsvException {
		List<Contacts> contactsDetailsList = new ArrayList<Contacts>();
		try {
			Reader reader = Files.newBufferedReader(Paths.get(this.addressBookCSV));
			CSVReader csvReader = new CSVReader(reader);
			List<String[]> contactFileString = csvReader.readAll();
			contactFileString.remove(0);
			contactFileString.stream().forEach(contactRecord -> {
				String firstname = contactRecord[0];
				String lastname = contactRecord[1];
				String address = contactRecord[2];
				String city = contactRecord[3];
				String state = contactRecord[4];
				int zip = Integer.parseInt(contactRecord[5]);
				int phoneNumber = Integer.parseInt(contactRecord[6]);
				String email = contactRecord[7];

				Contacts contacts = new Contacts(firstname, lastname, address, city, state, zip, phoneNumber, email);
				contactsDetailsList.add(contacts);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
