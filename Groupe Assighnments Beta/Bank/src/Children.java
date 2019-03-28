
public class Children extends Accounts{
	private String guardian;
	
	public Children(String child, String guardian, int pin, int number, int balance) {
		super(child, pin, number, balance);
	}
		
	public String getType() {
		return "Children";	
	}
}
