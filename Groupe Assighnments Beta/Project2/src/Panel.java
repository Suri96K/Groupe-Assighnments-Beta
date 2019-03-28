//To create the Panel and Painting points

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel extends Fractals{
	public static int width = 800;
	public static int height = 800;
	private static int iteration = 0;
	private static int i = 0;
	private static int j = 0;  
	private static String[] arg = new String[6];
	
	
	public Panel(int width, int height) {
		setPreferredSize(new Dimension(width, height));
	}
	
	public static void passArg(String [] args) {
		arg = args.clone();
	}
	
	private static synchronized void printPoint(Graphics2D frame, Color c, int i, int j) {

		frame.setColor(c); 
		frame.draw(new Line2D.Double(i, j, i, j)); 
	 }
	
	static String [] addElement(String [] a, String newelement) {
		a = Arrays.copyOf(a, a.length + 1);
		a[a.length - 1] = newelement;
		return a;
		
	}
	
	public void paintComponent(Graphics g) { 
		// call paintComponent from parent class
		super.paintComponent(g); 
		//String arg[] = {"Mandelbrot","-1","1", "-1", "1","1000"};
		if(arg[0].equals("Mandelbrot")) {
			if (arg.length == 1) {
				String argtemp[] = {"Mandelbrot","-1","1", "-1", "1","1000"};
				arg = argtemp.clone();
			}
			else if(arg.length == 5) {
				arg = addElement(arg, "1000");
			}
				int ite = Integer.parseInt(arg[5]);
				final Pixels man = new Pixels(Double.parseDouble(arg[1]),Double.parseDouble(arg[2]),Double.parseDouble(arg[3]),Double.parseDouble(arg[4]));
				Thread a = new Thread(new Runnable() {
					public void run() {
						for (j = 0; j < 400; j++) {
							for (i = 0; i < 400; i++) {
								Complex name = new Mandelbrot(man.getXCoordinates(i),man.getYCoordinates(j), ite);
								double x = 0;
								x = ((double) ite) - 1 - name.isMandelbrot();
								if(x != Integer.parseInt(arg[5]))
									printPoint((Graphics2D)g, (new Color((int)((x/(ite - 1)) * 255),0, 0)), i , j);
									//if (x > 999) System.out.println(x);
								else  {
									printPoint((Graphics2D)g, (new Color(0,0,0)), i , j);
								}	
							}
						}	
					}
				});
				Thread b = new Thread(new Runnable() {
					public void run() {
						for (int k = 0; k < 400; k++) {
							for (int l = 400; l < 800; l++) {
								Complex name = new Mandelbrot(man.getXCoordinates(l),man.getYCoordinates(k), ite);
								double x = 0;
								x = ((double) ite) - 1 - name.isMandelbrot();
								if(x != Integer.parseInt(arg[5]))
									printPoint((Graphics2D)g, (new Color((int)((x/(ite - 1)) * 255),0, 0)), l , k);
									//if (x > 999) System.out.println(x);
								else  {
									printPoint((Graphics2D)g, (new Color(0,0,0)), l , k);
								}	
							}
						}	
					}
				});
				Thread c = new Thread(new Runnable() {
					public void run() {
						for (int m = 400; m < 800; m++) {
							for (int n = 0; n < 400; n++) {
								Complex name = new Mandelbrot(man.getXCoordinates(n),man.getYCoordinates(m), ite);
								double x = 0;
								x = ((double) ite) - 1 - name.isMandelbrot();
								if(x != Integer.parseInt(arg[5]))
									printPoint((Graphics2D)g, (new Color((int)((x/(ite - 1)) * 255),0, 0)), n , m);
									//if (x > 999) System.out.println(x);
								else  {
									printPoint((Graphics2D)g, (new Color(0,0,0)), n , m);
								}	
							}
						}	
					}
				});
				Thread d = new Thread(new Runnable() {
					public void run() {
						for (int o = 400; o < 800; o++) {
							for (int p = 400; p < 800; p++) {
								Complex name = new Mandelbrot(man.getXCoordinates(p),man.getYCoordinates(o), ite);
								double x = 0;
								x = ((double) ite) - 1 - name.isMandelbrot();
								if(x != Integer.parseInt(arg[5]))
									printPoint((Graphics2D)g, (new Color((int)((x/(ite - 1)) * 255),0, 0)), p , o);
									//if (x > 999) System.out.println(x);
								else  {
									printPoint((Graphics2D)g, (new Color(0,0,0)), p , o);
								}	
							}
						}	
					}
				});
				a.start();
				b.start();
				c.start();
				d.start();
				try {
					a.join();
					b.join();
					c.join();
					d.join();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
		}
		if(arg[0].equals("Julia")) {
			if (arg.length == 1) {
				String argtemp[] = {"Julia","-0.4","0.6", "1000"};
				arg = argtemp.clone();
			}
			else if(arg.length == 3) {
				arg = addElement(arg, "1000");
			}
				final Pixels man = new Pixels(-1,1,-1,1);
				int ite = Integer.parseInt(arg[3]);
				Thread A = new Thread(new Runnable() {
					public void run() {
						for(int j = 0; j < 400; j++) {
							for(int i = 0; i < 400; i++) {
								Complex name = new Julia(man.getXCoordinates(i),man.getYCoordinates(j), Integer.parseInt(arg[3]),Double.parseDouble(arg[1]),Double.parseDouble(arg[2]));
								
								//System.out.printf("Coordinates for (%d,%d) = (%f,%f)\n",i, j, name.real, name.img);
									double x = 0;
									x = (double)ite - 1 - name.isJulia();
									if(x != ite) {
										printPoint((Graphics2D)g, (new Color(0,(int)((x/(ite - 1)) * 255), 0)), i , j);
									}	
									else  
										printPoint((Graphics2D)g, Color.BLACK, i , j);
							}
						}
					}
				});
				Thread B = new Thread(new Runnable() {
					public void run() {
						for(int m = 0; m < 400; m++) {
							for(int n = 400; n < 800; n++) {
								Complex name = new Julia(man.getXCoordinates(n),man.getYCoordinates(m), Integer.parseInt(arg[3]),Double.parseDouble(arg[1]),Double.parseDouble(arg[2]));
								
								//System.out.printf("Coordinates for (%d,%d) = (%f,%f)\n",i, j, name.real, name.img);
									double x = 0;
									x = (double)ite - 1 - name.isJulia();
									if(x != ite) {
										printPoint((Graphics2D)g, (new Color(0,(int)((x/(ite - 1)) * 255), 0)), n , m);
									}	
									else  
										printPoint((Graphics2D)g, Color.BLACK, n , m);
							}
						}
					}
				});
				Thread C = new Thread(new Runnable() {
					public void run() {
						for(int k = 400; k < 800; k++) {
							for(int l = 0; l < 400; l++) {
								Complex name = new Julia(man.getXCoordinates(l),man.getYCoordinates(k), Integer.parseInt(arg[3]),Double.parseDouble(arg[1]),Double.parseDouble(arg[2]));
								
								//System.out.printf("Coordinates for (%d,%d) = (%f,%f)\n",i, j, name.real, name.img);
									double x = 0;
									x = (double)ite - 1 - name.isJulia();
									if(x != ite) {
										printPoint((Graphics2D)g, (new Color(0,(int)((x/(ite - 1)) * 255), 0)), l , k);
									}	
									else  
										printPoint((Graphics2D)g, Color.BLACK, l , k);
							}
						}
					}
				});
				Thread D = new Thread(new Runnable() {
					public void run() {
						for(int o = 400; o < 800; o++) {
							for(int p = 400; p < 800; p++) {
								Complex name = new Julia(man.getXCoordinates(p),man.getYCoordinates(o), Integer.parseInt(arg[3]),Double.parseDouble(arg[1]),Double.parseDouble(arg[2]));
								
								//System.out.printf("Coordinates for (%d,%d) = (%f,%f)\n",i, j, name.real, name.img);
									double x = 0;
									x = (double)ite - 1 - name.isJulia();
									if(x != ite) {
										printPoint((Graphics2D)g, (new Color(0,(int)((x/(ite - 1)) * 255), 0)), p , o);
									}	
									else  
										printPoint((Graphics2D)g, Color.BLACK, p , o);
							}
						}
					}
				});
				A.start();
				B.start();
				C.start();
				D.start();
				try {
					A.join();
					B.join();
					C.join();
					D.join();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
		}
		//else System.out.println("Invalid Input");
	}
}
