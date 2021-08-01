package iostreams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressBookFiles {
	public static String ADDRESSBOOK_FILENAME = "./somefile.txt";

	//To write contact details in file 
		public static void writeDataIntoFile()
		{
			List<Contacts> contactsList = new ArrayList<>();
			StringBuffer addressBuffer = new StringBuffer();
			contactsList.forEach(address -> {
				String addressDataString = address.toString().concat("\n");
				addressBuffer.append(addressDataString);
			});
			try 
			{
				Files.write(Paths.get(ADDRESSBOOK_FILENAME), addressBuffer.toString().getBytes());
			} catch (Exception e) 
			{
			}
		}
		
		//to read Contact details from file 
		public static List<Contacts> readDataFromFile()
		{	
			List<Contacts> contactDetailList = new ArrayList<>();
			try 
			{
				Files.lines(new File(ADDRESSBOOK_FILENAME).toPath()).map(line -> line.trim()).forEach(line -> System.out.println(line));
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
			return contactDetailList;
		}
		//to print data in the file
		public static void printData()
		{
			try 
			{
				Files.lines(new File(ADDRESSBOOK_FILENAME).toPath()).forEach(System.out::println);
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
}
