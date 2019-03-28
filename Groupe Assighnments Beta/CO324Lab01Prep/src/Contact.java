import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import jdk.nashorn.internal.runtime.regexp.joni.constants.Arguments;

public class Contact {
	public String firstname;
	public String lastname;
	public String phonenumber;
	public String email;
	public String company;
	public static Map<String, Contact>contactAll = new TreeMap<String, Contact>();
	
	public static String[] argument = new String[] {"add", "Mabeesha", "Wijekoon","0772839947","mabeesharj@gmail.com","wso2"};
	
	public Contact(String firstname, String lastname, String phonenumber, String email, String company) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.phonenumber = phonenumber;
		this.email = email;
		this.company = company;
	}
	
	public static void main(String[] args){
		String csvFile = args[0];
		String line = "";
		String csvSplitby = ",";

		try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
			line = br.readLine();
			while ((line = br.readLine())!= null){
				String[] contactnow = line.split(csvSplitby);
				Contact temp = new Contact(contactnow[1], contactnow[2], contactnow[3], contactnow[4], contactnow[5]);
				String fullname;
				fullname = contactnow[1] + " " + contactnow[2];
				contactAll.put(fullname, temp);			
			}
		} catch(IOException e){
			e.printStackTrace();
		}
		
		System.out.println("File read succesfully");
		System.out.println("search <full name separated by space> | add <details> | delete <full name separated by spaced> | insert 'q' to quit");
		
		Scanner scanner = new Scanner(System.in);
		String[] input;
		
		for (String In = scanner.nextLine(); !In.equals("q"); In = scanner.nextLine()) {
			input = In.split(" ");
			//Printall();
			if (input[0].equals("search")) {
				Search(input);
			}
			else if (input[0].equals("add")) {
				add(input);
			}
			else if (input[0].equals("delete")) {
				delete(input);
			}
			System.out.println("Enter another operation: ");
		}
		write(csvFile);
		System.out.println("CSV file updated");
	}
	
	public static void Printall() {
		Set keyset = contactAll.keySet();
		System.out.println(keyset);
	}
	
	public static void Search(String[] argument) {
		String fullname = argument[1] + " " + argument[2];
		System.out.println("Name: " + contactAll.get(fullname).firstname + " " +contactAll.get(fullname).lastname);
		System.out.println("Tel: " + contactAll.get(fullname).phonenumber);
		System.out.println("Email: " + contactAll.get(fullname).email);
		System.out.println("Company: " + contactAll.get(fullname).company);
	}
	
	public static void add(String[] argument) {
		Contact temp = new Contact(argument[1], argument[2], argument[3], argument[4], argument[5]);
		String fullname = argument[1] + " " + argument[2];
		contactAll.put(fullname, temp);
		System.out.println("added successfully");
	}
	
	public static void delete(String[] argument) {
		String fullname = argument[1] + " " + argument[2];
		contactAll.remove(fullname);
	}
	
	public static void write(String csvFile) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
		
			List<String> keys = new ArrayList<>(contactAll.keySet());
			String name;
			for(int i = 0; i < keys.size(); i++) {
				name = keys.get(i);
				String[] firstlastname = name.split(" ");
				writer.write(","+ firstlastname[0] + "," + firstlastname[1] + "," + contactAll.get(name).phonenumber+","+contactAll.get(name).email+","+contactAll.get(name).company+"\n");
			}
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
