
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//int totalwords = 0;
		HashTableImp hashtable = new HashTableImp(83);
		
		Scanner sc = new Scanner(new File("sample-text2.txt"));
	    while(sc.hasNext()){
	        String s = sc.next();
			s = s.replaceAll("[^a-zA-Z0-9]", "");
			s = s.toLowerCase();
			//totalwords++;
			if (s.length() > 0) hashtable.insert(s);
	    }
	    
	    hashtable.fullDetails();
	    //System.out.println(hashtable.search("the"));
	    //System.out.println("total = " + totalwords);
	}

}
