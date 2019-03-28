import java.math.*;
import java.util.Random;
import java.io.*;

public class Student {
	private static int totAttendance = 0;
	private String name;
	private int attendance;
	
	public Student(String name) {   //constructor
		this.name = name;
		this.attendance  = (int)(Math.random() * 46);
		totAttendance +=this.attendance;
	}		
	public float getAttendance() {
		return (((float)this.attendance * 100) / 45);
	}
	
	public static float getTotalAttendance() {
		return (((float)totAttendance / (61 * 45)) * 100); 
	}
	
	public String getName() {
		return (this.name);
	}
}
