
public class Main {
	public static void main(String [] args) {
		Glass<Juice> gJuice = new Glass();
		Juice j = new Juice();
		gJuice.liquid = j;
		
		//retrieve
		//Juice drinkingJruice = gJuice.liquid;
		
		Water w = new Water();
		Glass<Water> gWater = new Glass();
		gWater.liquid = w;
		
		gJuice.getTaste();
		
		Glass.<Juice, Water>mix(j, w);
		
		gWater.getTaste();
		
	}
}
