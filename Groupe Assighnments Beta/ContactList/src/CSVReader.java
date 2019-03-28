import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
	public static void main(String []args){
		String csvFile = "C:\\Users\\Rahal\\Documents\\Semester 5\\CO324 - Network and Web Application Design\\contacts.csv";
		String line = "";
		String csvSplitby = ",";
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))){
			while ((line = br.readLine()) != null) {
				String[] Contact = line.split(csvSplitby);
				
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
