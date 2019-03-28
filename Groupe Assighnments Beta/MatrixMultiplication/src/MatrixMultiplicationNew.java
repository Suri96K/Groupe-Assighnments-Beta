import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MatrixMultiplicationNew extends Thread{
	static int rowsA = 0;
	static int rowsB = 0;
	static int columnsA = 0;
	static int columnsB = 0;
	static double[][] Ad;
	static double[][] Bd;
	static float [][] Af;
	static float [][] Bf;
	static int [][] Ai;
	static int [][] Bi;
	private int rowPortion;
	private int rowStart;
	private int type;    //0-double 1-float 2-int
	private double [][] Cd;
	private float [][] Cf;
	private int [][] Ci;

	
	
	public MatrixMultiplicationNew(int rowStart, int rowPortion, double[][] C, int type) {
		this.rowStart = rowStart;
		this.rowPortion = rowPortion;
		this.Cd = C;
		this.type = type; 
	}
	
	public MatrixMultiplicationNew(int rowStart, int rowPortion, float[][] C, int type) {
		this.rowStart = rowStart;
		this.rowPortion = rowPortion;
		this.Cf = C;
		this.type = type; 
	}

	public MatrixMultiplicationNew(int rowStart, int rowPortion, int[][] C, int type) {
		this.rowStart = rowStart;
		this.rowPortion = rowPortion;
		this.Ci = C;
		this.type = type; 
	}

	public void run() {
		for (int i = rowStart; i < (rowPortion + rowStart); i++) {
			for (int j = 0; j < columnsB; j++) {
					for(int q = 0; q < rowsB; q++) {
						if(type == 0) {
							Cd[i][j] = 0;
							Cd[i][j] += Ad[i][q] * Bd[q][j];
						}
						//System.out.println(i + " " + q);
						if(type == 1) {
							Cf[i][j] = 0;
							Cf[i][j] += Af[i][q] * Bf[q][j];
						}
						//else if (type == 2) Ci[i][j] += Ai[i][q] * Bi[q][j];
					}
				
				//System.out.printf("%d ", C[i][j]);
			}
			//System.out.printf("\n");
		}
		//System.out.printf("%d %d\n", rowStart, rowPortion+rowStart);

	}
	
	public static void sizeOfA() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("A.txt"));
		String[] rc = br.readLine().trim().split(" ");
		rowsA = (int)Double.parseDouble(rc[0]);
		columnsA = (int)Double.parseDouble(rc[1]);
		//System.out.println(rowsA +" "+ columnsA);
	}
	
	public static void sizeOfB() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("B.txt"));
		String[] rc = br.readLine().trim().split(" ");
		rowsB = (int)Double.parseDouble(rc[0]);
		columnsB = (int)Double.parseDouble(rc[1]);
		//System.out.println(rowsA +" "+ columnsA);
	}
	
	public static double[][] matrixAd() throws IOException{
		double[][] a = new double[rowsA][columnsA];
		   BufferedReader br = new BufferedReader(new FileReader("A.txt"));
		   br.readLine();
		   for (int i = 0; i < rowsA; i++) {
		        String[] st = br.readLine().trim().split(" ");
		        for (int j = 0;j < columnsA; j++) {
		            a[i][j] = Double.parseDouble(st[j]);
		        }
		   }
		return a;   
	}
	
	public static double[][] matrixBd() throws IOException{
		double[][] a = new double[rowsB][columnsB];
		   BufferedReader br = new BufferedReader(new FileReader("B.txt"));
		   br.readLine();
		   for (int i = 0; i < rowsB; i++) {
		        String[] st = br.readLine().trim().split(" ");
		        for (int j = 0;j < columnsB; j++) {
		            a[i][j] = Double.parseDouble(st[j]);
		        }
		   }
		return a;   
	}

	public static float[][] matrixAf() throws IOException{
		float[][] a = new float[rowsA][columnsA];
		   BufferedReader br = new BufferedReader(new FileReader("A.txt"));
		   br.readLine();
		   for (int i = 0; i < rowsA; i++) {
		        String[] st = br.readLine().trim().split(" ");
		        for (int j = 0;j < columnsA; j++) {
		            a[i][j] = (float)Double.parseDouble(st[j]);
		        }
		   }
		return a;   
	}
	
	public static float[][] matrixBf() throws IOException{
		float[][] a = new float[rowsB][columnsB];
		   BufferedReader br = new BufferedReader(new FileReader("B.txt"));
		   br.readLine();
		   for (int i = 0; i < rowsB; i++) {
		        String[] st = br.readLine().trim().split(" ");
		        for (int j = 0;j < columnsB; j++) {
		            a[i][j] = (float)Double.parseDouble(st[j]);
		        }
		   }
		return a;   
	}

	public static int[][] matrixAi() throws IOException{
		int[][] a = new int[rowsA][columnsA];
		   BufferedReader br = new BufferedReader(new FileReader("A.txt"));
		   br.readLine();
		   for (int i = 0; i < rowsA; i++) {
		        String[] st = br.readLine().trim().split(" ");
		        for (int j = 0;j < columnsA; j++) {
		            a[i][j] = (int)Double.parseDouble(st[j]);
		        }
		   }
		return a;   
	}
	
	public static int[][] matrixBi() throws IOException{
		int[][] a = new int[rowsB][columnsB];
		   BufferedReader br = new BufferedReader(new FileReader("B.txt"));
		   br.readLine();
		   for (int i = 0; i < rowsB; i++) {
		        String[] st = br.readLine().trim().split(" ");
		        for (int j = 0;j < columnsB; j++) {
		            a[i][j] = (int)Double.parseDouble(st[j]);
		        }
		   }
		return a;   
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		sizeOfA();
		sizeOfB();
		Bd = matrixBd();
		Ad = matrixAd();
		Af = matrixAf();
		Bf = matrixBf();
		Ai = matrixAi();
		Bi = matrixBi();
		double[][] Cd = new double[rowsA][columnsB];
		double[][] Cf = new double[rowsA][columnsB];
		double[][] Ci = new double[rowsA][columnsB];
		int NoOfThreads = Integer.parseInt(args[0]);
		int rowPort = rowsA/NoOfThreads;
		int remT = NoOfThreads;
		MatrixMultiplicationNew[] t = new MatrixMultiplicationNew[NoOfThreads];
		
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < NoOfThreads; i++) {
			if (i == (NoOfThreads - 1)) {
				t[i] = new MatrixMultiplicationNew(i*rowPort, rowsA - (i*rowPort), Cd, 0);
			}
			else t[i] = new MatrixMultiplicationNew(i*rowPort, rowPort, Cd, 0);
			t[i].start();
		}
		for(int i = 0; i < NoOfThreads; i++) {
			t[i].join();
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("time taken for double: "+totalTime);

		startTime = System.currentTimeMillis();
		for(int i = 0; i < NoOfThreads; i++) {
			if (i == (NoOfThreads - 1)) {
				t[i] = new MatrixMultiplicationNew(i*rowPort, rowsA - (i*rowPort), Cf, 1);
			}
			else t[i] = new MatrixMultiplicationNew(i*rowPort, rowPort, Cf, 1);
			t[i].start();
		}
		for(int i = 0; i < NoOfThreads; i++) {
			t[i].join();
		}
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("time taken for float: "+totalTime);

		startTime = System.currentTimeMillis();
		for(int i = 0; i < NoOfThreads; i++) {
			if (i == (NoOfThreads - 1)) {
				t[i] = new MatrixMultiplicationNew(i*rowPort, rowsA - (i*rowPort), Ci, 2);
			}
			else t[i] = new MatrixMultiplicationNew(i*rowPort, rowPort, Ci, 2);
			t[i].start();
		}
		for(int i = 0; i < NoOfThreads; i++) {
			t[i].join();
		}
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("time taken for int: "+totalTime);

		//MatrixMultiplicationNew t = new MatrixMultiplicationNew(2, rowPort, 2, C);
		//t.start();
		//t.join();
		
	}
}