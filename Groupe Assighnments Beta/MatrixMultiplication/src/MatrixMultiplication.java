import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class MatrixMultiplication extends Thread{	
	static int rowsA = 0;
	static int columnsA = 0;
	static int rowsB = 0;
	static int columnsB = 0;
	
	public void run() {
		
	}
	public static void readNoOfRowsnColumns() {
		String line;
		int flag = 0;
		try (
			    InputStream fis = new FileInputStream("A.txt");
			    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			    BufferedReader br = new BufferedReader(isr);
			) {
				int j = 0;
			    while ((line = br.readLine()) != null) {
			    	String AString = line.toString();
			    	String[] elementsString = AString.split(" ");
			    	if (flag == 0) {
			    		flag++;
			    		rowsA = Integer.parseInt(elementsString[0]);
			    		columnsA = Integer.parseInt(elementsString[1]);
			    	}
			    }
			    System.out.println(rowsA + " " + columnsA);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		flag = 0;
		try (
			    InputStream fis = new FileInputStream("B.txt");
			    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			    BufferedReader br = new BufferedReader(isr);
			) {
				int j = 0;
			    while ((line = br.readLine()) != null) {
			    	String AString = line.toString();
			    	String[] elementsString = AString.split(" ");
			    	if (flag == 0) {
			    		flag++;
			    		rowsB = Integer.parseInt(elementsString[0]);
			    		columnsB = Integer.parseInt(elementsString[1]);
			    	}
			    }
			    System.out.println(rowsB + " " + columnsB);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

	public static int[][] readMatrix(String textFile, int rows, int columns) {
		String line;
		int flag = 0;
		int [][] A = new int[rows][columns];
		try (
		    InputStream fis = new FileInputStream(textFile);
		    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
		    BufferedReader br = new BufferedReader(isr);
		) {
			int j = 0;
		    while ((line = br.readLine()) != null) {
		    	String AString = line.toString();
		    	String[] elementsString = AString.split(" ");
		    	if (flag == 0) {
		    		flag++;
		    	}
		    	else {
		    		int [][]elementsint = new int[rowsA][columnsA]; 
		    		for (int i = 0; i < columns; i++) {		    		
		    			elementsint[j][i] = Integer.parseInt(elementsString[i]);
		    			//System.out.println(j +" "+ i);
		    		}
		    		j++;
		    	}
		    }
		    return A;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return A;
	}
	
	
	/*public static void main(String[] args) {
		readNoOfRowsnColumns();
		int[][] A = readMatrix("A.txt", rowsA, columnsA);
		for (int i = 0; i < rowsA; i++) {
			for(int j = 0; j < columnsA; j++) {
				System.out.println(A[i][j]);
			}
		}
	}*/

}
