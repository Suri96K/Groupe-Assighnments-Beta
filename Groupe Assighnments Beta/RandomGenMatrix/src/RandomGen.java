import java.util.Arrays;
import java.util.Random;

public class RandomGen {
	public static void main(String [] args) {
		int rows = 10;
		int columns = 10;
		for(int i = 0; i < rows;i++) {
			for(int j = 0; j < columns; j++) {
				Random rand = new Random();
				Double r = rand.nextDouble()*1000;
				System.out.printf("%f ", r);
			}	
			System.out.printf("\n");
		}	
	}
}
