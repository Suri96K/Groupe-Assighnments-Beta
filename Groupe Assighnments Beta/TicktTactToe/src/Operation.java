import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.text.Font;

public class Operation extends JPanel implements ActionListener{
	JButton[] button = new JButton[9];
	Boolean player = new Boolean(false);
	static int finalresult = 0;
	
	public Operation() {
		super(new GridLayout(3,3));
		for(int i = 0; i < 9; i++) {
			button[i] = new JButton();
			button[i].setText("");
			button[i].setPreferredSize(new Dimension(200,200));
			add(button[i]);
			button[i].addActionListener(this);
		
		}	
	}
	
	
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 9; i++) {			
			if ((e.getSource() == button[i]) && (button[i].getText() == "")) {
				player = !player;
				if(player == true) button[i].setText("1");			
				else button[i].setText("2");
				finalresult =  horizontal(i) + vertical(i) + diagonal(i);
				if (finalresult != 0) {
					JFrame frame = new JFrame("RESULT");
					JPanel panel = new JPanel();
					String whichplayer;
					if (player == true) whichplayer = "Player 1 won!";
					else whichplayer = "Player 2 won!";
					JLabel jlabel = new JLabel(whichplayer);
					frame.setPreferredSize(new Dimension(500,300));
					jlabel.setFont(jlabel.getFont().deriveFont (64.0f));
					panel.add(jlabel);
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        frame.add(panel);
			        //frame.setLocationRelativeTo(null);
			        frame.pack();
			        frame.setVisible(true);
				}
			}	
		}	
	}
	
	public int horizontal(int i){
		int result = 0;
		int f = 1;
		int k = i % 3;
		result = check(i, k, result, f);
		if (result == 0) return 0;
		else return 1;
	}
	
	public int vertical(int i) {
		int result = 0;
		int f = 3;
		int k = i / 3;
		result = check(i, k, result, f);
		if (result == 0) return 0;
		else return 1;
	}
	
	public int diagonal(int i) {
		int result = 0;
		int f = 4;
		int k;
		int LtoR[] = {0, 4, 8};
		int RtoL[] = {2, 4, 6};
		for (int j = 0; j < 3; j++) {
			if(LtoR[j] == i) {
				k = i / 4;
				result = check(i, k, result, f);
				if (result == 1) return result;
			}	
			if (RtoL[j] == i) {
				k = (i - 2)/2;
				f = 2;
				result = check(i, k, result, f);
				if (result == 1) return result;
			}
		}
		return result;
	}
	
	public int check(int i, int k, int result, int f) {
		if (k == 0) {
			if ((button[i].getText() == button[i + f].getText()) && (button[i].getText() == button[i + 2*f].getText())){
				return result = 1;
			}			
		}
		else if (k == 1)	{
			if ((button[i].getText() == button[i - f].getText()) && (button[i].getText() == button[i + f].getText())) {
				return result = 1;
			}
		}
		else if (k == 2) {
			if ((button[i].getText() == button[i - f].getText()) && (button[i].getText() == button[i - 2*f].getText())) {
				return result = 1;
			}
		}
		return result;
	}
	
}
