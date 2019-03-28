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
	public static int width = 2000;
	public static int height = 2000;
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
	
	private static void printPoint(Graphics2D frame, Color c, int i, int j) {

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
			try {
				int ite = Integer.parseInt(arg[5]);
				Pixels man = new Pixels(Double.parseDouble(arg[1]),Double.parseDouble(arg[2]),Double.parseDouble(arg[3]),Double.parseDouble(arg[4]));
				for (j = 0; j < Panel.width; j++) {
					for (i = 0; i < Panel.width; i++) {
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
			} catch (Exception e) {
				System.out.println(e);
				frame.dispose();
				return;
				
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
			try {
				Pixels man = new Pixels(-1,1,-1,1);
				int ite = Integer.parseInt(arg[3]);
				for(j = 0; j < Panel.width; j++) {
					for(i = 0; i < Panel.width; i++) {
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
			}catch(Exception e) {
				System.out.println(e);
				frame.dispose();
				return;
			}
		}
		//else System.out.println("Invalid Input");
	}
}
