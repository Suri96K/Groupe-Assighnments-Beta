// To find out whether a given complex number is in the Mandelbrot set or not

public class Mandelbrot extends Complex{
	public int iterations;
	
	public Mandelbrot(double real, double img, int iterations) {
		super(real, img);
		this.iterations = iterations;
	}
	
	public synchronized int isMandelbrot() {
		double z1real = 0;
		double z1img = 0;
		double z2real = 0;
		double z2img = 0;
		while (this.iterations-- > 0) {
			z2real = super.getSquareReal(z1real, z1img) + super.real;
			z2img = super.getSquareImag(z1real, z1img) + super.img;
			z1real = z2real;
			z1img = z2img;
			//System.out.printf("%f + %fi\n",z1real, z1img);
			//System.out.printf("square is %f\n", super.getSquare(0, 0) + super.real);

		//System.out.printf("%f\n", super.getAbsolute(z1real, z1img));
		
			if (super.getAbsolute(z1real, z1img) > 2){
				//< 2) && (iterations < 900)) {
				//System.out.printf("%f + %fi\n",z1real, z1img);
				return iterations;
			}
		}
		return -1;
	}
	
	
}
