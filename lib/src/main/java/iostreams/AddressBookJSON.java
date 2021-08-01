package iostreams;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AddressBookJSON {

	public AddressBookJSON() {
		super();
	}

	public void writeContactDetailsInAFile(String filePath) {
		try {
			List<Contacts> contactDetailsList = new ArrayList<Contacts>();
			Gson gson = new Gson();
			String json = gson.toJson(contactDetailsList);
			FileWriter fileWriter;
			fileWriter = new FileWriter(filePath);
			fileWriter.write(json);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readaddressBookFromAJSONFile(String filePath) {
		Reader reader;
		try {
			reader = Files.newBufferedReader(Paths.get(filePath));
			List<Contacts> contactDetailsList = new Gson().fromJson(reader, new TypeToken<List<Contacts>>() {
			}.getType());
			contactDetailsList.stream().forEach(singleEntry -> contactDetailsList.add(singleEntry));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
