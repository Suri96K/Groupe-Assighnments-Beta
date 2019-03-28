
public class Accounts {
	private float balance = 0;
	protected int pin;
	private String name;
	protected int number;
	
	public Accounts(String name, int pin, int number, float balance){
		this.pin = pin;
		this.name = name;
		this.number = number;
		this.balance = balance;
	}
	
	public void deposit(int value){
		this.balance += value;
	}
	
	public void showDetail() {
		System.out.printf("Acc. no: %d\nName: %s\nBalance: %.2f\nType: %s\n---\n", this.number, this.name, this.balance, this.getType());
	}
	
	public void withdraw(int value) {
		this.balance -= value;
	}
	
	public String getType() {
		return "Unknown";
	}
}
