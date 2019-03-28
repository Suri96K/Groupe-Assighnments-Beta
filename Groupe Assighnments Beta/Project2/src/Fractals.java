/*CO225 PROJECT 1 - Main method
 * Coded: R.C. Medawatte E/14/222
 * Last Modified : 01.09.2017
 */
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fractals extends JPanel{
	static JFrame frame;
	public static void main(String[] args) {
		
		// create a frame
		if ((args[0].equals("Mandelbrot") == true) || (args[0].equals("Julia") == true)){
			Panel.passArg(args);
			frame = new JFrame(args[0]); 
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

			// set the content of the frame as one of this panel
			frame.setContentPane(new Panel(800, 800)); 

			frame.pack(); 
			frame.setLocationRelativeTo(null); 
			frame.setVisible(true);
		}
		else if (args.length == 0) {
			System.out.println("Invalid Input");
			return;
		}
	}

}
