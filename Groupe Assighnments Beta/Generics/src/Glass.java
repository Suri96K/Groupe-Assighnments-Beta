
public class Glass<T extends Liquid> {
	public T liquid;
	
	static <J extends Liquid, W extends Liquid> void mix(J juice, W Water) {
		System.out.println("mixed");
	}
	
	public void  getTaste() {
		liquid.taste();
	}
	
	public static <T extends Liquid> Glass<T> returnGlass(T g) {
		Glass<T> g2 = new Glass();		
		return g2;
	}
}
    