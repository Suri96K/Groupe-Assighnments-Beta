/* Lab 01 : CO225 : Software Construction
 * E/14/222 - Medawatte R.C.
 * 07.07.2017
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		BufferedReader descriptor = null; 
		String line = null; 
		Student [] students = new Student[61];
 		try { 
		    descriptor = new BufferedReader(new FileReader("co225-classlist.txt"));

		    for(int i=0; i < students.length; i++) // assume file has 61 lines 
		    	students[i] =new Student(descriptor.readLine()); 

		    descriptor.close(); 

		} catch(IOException e) { 
		    System.out.println("Bad things happen, what do you do!" + e);
		    return; 
		}
 		String studentName = null;
 		float attend = 0;

		// only will run if there are no exceptions 
 		
		for(int i=0; i < students.length; i++) {
			 studentName= students[i].getName();
			 attend = students[i].getAttendance();
			 if (attend < 80) {
				 System.out.printf("%s \t%.2f%%\n",studentName, attend);
			 }
			 
		}
		System.out.printf("Total attendance of the class: %.2f%%\n", Student.getTotalAttendance());

	}

}
