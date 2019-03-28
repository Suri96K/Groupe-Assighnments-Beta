//find the corresponding Complex number for a given pixel

public class Pixels{
	public double xminus;
	public double xplus;
	public double yminus;
	public double yplus;
	
	public Pixels(double xminus, double xplus, double yminus, double yplus) {
		this.xminus = xminus;
		this.xplus = xplus;
		this.yminus = yminus;
		this.yplus = yplus;
	}
	
	public double getXCoordinates(int i) {
		double x = ((double) i * ((Math.abs(this.xminus) + this.xplus)/Panel.width) + (this.xminus));
		return x;
	}
	
	public double getYCoordinates(int j) {
		return ((double) j * ((Math.abs(this.yminus) + this.yplus) * (-1)/Panel.height) + this.yplus);
	}
}
