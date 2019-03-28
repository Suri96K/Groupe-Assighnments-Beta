
public class Mandelbrot extends Complex{
	public int iterations;
	
	public Mandelbrot(double real, double img, int iterations) {
		super(real, img);
	}
	
	public int isMandelbrot() {
		double z1real = 0;
		double z1img = 0;
		double z2;
		while (iterations-- > 1000) {
			z1real = super.getSquare(z1real, z1img) + this.real;
			z1img = super.getSquare(z1real, z1img) + this.img;
		}
		
		if(super.getAbsolute(z1real, z1img) < 2) {
			return 1;
		}
		else return -1;
	}
	
	

}
