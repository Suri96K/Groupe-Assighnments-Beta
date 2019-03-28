// To find out whether a given complex number is in the Julia set or not

public class Julia extends Complex{
	public int iterations;
	public double creal;
	public double cimg;
	
	public Julia(double real, double img, int iterations, double creal, double cimg) {
		super(real, img);
		this.iterations = iterations;
		this.creal = creal;
		this.cimg = cimg;
	}
	
	public synchronized int isJulia() {
		double z1real = this.real;
		double z1img = this.img;
		double z2real = 0;
		double z2img = 0;
		while (this.iterations-- > 0) {
			z2real = super.getSquareReal(z1real, z1img) + this.creal;
			z2img = super.getSquareImag(z1real, z1img) + this.cimg;
			z1real = z2real;
			z1img = z2img;
			//System.out.printf("%f + %fi\n",z1real, z1img);
			//System.out.printf("square is %f\n", super.getSquare(0, 0) + super.real);
		
		//System.out.printf("%f\n", super.getAbsolute(z1real, z1img));
		
			if(super.getAbsolute(z1real, z1img) > 2) {
			//System.out.printf("%f + %fi\n",z1real, z1img);
				return iterations;
			}
		}
		return -1;
	}
	

}
