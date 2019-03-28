
public class Complex {
	public double real;
	public double img;
	
	public Complex(double real, double img) {
		this.real = real;
		this.img = img;
	}
	
	public double getSquare(double real, double img) {
		return ((real * real) + (img * img));
	}
	
	public double getAbsolute(double real, double img) {
		return Math.sqrt(this.getSquare(real,img));
	}
	
	public void printComplex() {
		System.out.printf("%f + %fi",this.real, this.img);
	}
}
