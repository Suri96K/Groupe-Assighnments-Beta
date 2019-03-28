
public class Main {

	public static void main(String[] args) {
		Accounts [] account = new Accounts[10];
		account[0] = new Accounts("Rahal", 1234, 0, 0);
		account[1] = new Accounts("Hiruna", 2345, 1, 0);
		account[2] = new Children("Hiruna", "Rahal", 7890, 2, 500);
		account[0].deposit(1000);
		account[0].withdraw(1000);
		for (int i = 0; i < 3; i++) {
			account[i].showDetail();
		}
		
	}

}
