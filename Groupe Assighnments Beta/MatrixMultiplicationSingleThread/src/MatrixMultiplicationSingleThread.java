import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MatrixMultiplicationSingleThread{
	static int rowsA = 0;
	static int rowsB = 0;
	static int columnsA = 0;
	static int columnsB = 0;
	
	public static void sizeOfA() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("A.txt"));
		String[] rc = br.readLine().trim().split(" ");
		rowsA = Integer.parseInt(rc[0]);
		columnsA = Integer.parseInt(rc[1]);
		//System.out.println(rowsA +" "+ columnsA);
	}
	
	public static void sizeOfB() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("B.txt"));
		String[] rc = br.readLine().trim().split(" ");
		rowsB = Integer.parseInt(rc[0]);
		columnsB = Integer.parseInt(rc[1]);
		//System.out.println(rowsA +" "+ columnsA);
	}
	
	public static int[][] matrixA() throws IOException{
		int[][] a = new int[rowsA][columnsA];
		   BufferedReader br = new BufferedReader(new FileReader("A.txt"));
		   br.readLine();
		   for (int i = 0; i < rowsA; i++) {
		        String[] st = br.readLine().trim().split(" ");
		        for (int j = 0;j < columnsA; j++) {
		            a[i][j] = Integer.parseInt(st[j]);
		        }
		   }
		return a;   
	}
	
	public static int[][] matrixB() throws IOException{
		int[][] a = new int[rowsB][columnsB];
		   BufferedReader br = new BufferedReader(new FileReader("B.txt"));
		   br.readLine();
		   for (int i = 0; i < rowsB; i++) {
		        String[] st = br.readLine().trim().split(" ");
		        for (int j = 0;j < columnsB; j++) {
		            a[i][j] = Integer.parseInt(st[j]);
		        }
		   }
		return a;   
	}
	
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		sizeOfA();
		sizeOfB();
		int[][] B = matrixB();
		int[][] A = matrixA();
		int[][] C = new int[rowsA][columnsB];
		int temp = 0;
		
		for (int i = 0; i < rowsA; i++) {
			for (int j = 0; j < columnsB; j++) {
					for(int q = 0; q < rowsB; q++) {
						C[i][j] += A[i][q] * B[q][j];
					}
				
				System.out.printf("%d ", C[i][j]);
			}
			System.out.printf("\n");
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
	}
}


