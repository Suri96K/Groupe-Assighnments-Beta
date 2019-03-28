//Manipulating Complex numbers

public class Complex {
	public double real;
	public double img;
	
	public Complex(double real, double img) {
		this.real = real;
		this.img = img;
	}
	
	public double getSquareReal(double real, double img) {
		return ((real * real) - (img * img));
	}
	
	public double getSquareImag(double real, double img) {
		return (real * img * 2);
	}
	
	public double getAbsolute(double real, double img) {
		return ((real * real) + (img * img));
	}
	
	public void printComplex() {
		System.out.printf("%f + %fi",this.real, this.img);
	}
	
	public int isMandelbrot() {
		return 0;
	}
	
	public int isJulia() {
		return 0;
	}
}
