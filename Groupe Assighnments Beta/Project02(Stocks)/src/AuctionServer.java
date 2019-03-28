
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AuctionServer{
	static int noOfInput = 0;
	public static final int BASE_PORT = 2000;

	private static ServerSocket serverSocket;
	private static int socketNumber;

	public AuctionServer(int socket) throws IOException{
		serverSocket = new ServerSocket(socket);
		socketNumber = socket;
	}

	public void server_loop() throws IOException{
		while(true){
			Socket socket = serverSocket.accept();
			Client worker = new Client(socket);
			worker.start();
		}
	}
	
	public static void addLabel(Calendar cal, DateFormat dateFormat, String user, String symbol, String price) {
		txtarea.insert(dateFormat.format(cal.getTime()) + " " + user + " : " + symbol + " : " + price+"\n", 0);
		noOfInput++;
		txtarea.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		frame.add(jp);
		frame.pack();
	}	
	
	static JFrame frame;
	static GridBagConstraints c = new GridBagConstraints(); 
	static JTextArea txtarea = new JTextArea();
	static JTextArea searchArea = new JTextArea();
	static JScrollPane jp = new JScrollPane(txtarea);
	static JButton jb = new JButton("OK");
	static JPanel jpa = new JPanel();
	static JLabel currentPrice = new JLabel();
	static String updatingStockItem;
	static JTextArea enterValue = new JTextArea();
	static JButton jb2 = new JButton("UPDATE");
	static JLabel UpdateSuccess = new JLabel();
	static String temp1;
	static double temp2;
	
	public static void main(String [] args) throws IOException{
		NameSet.putStockValues();
		AuctionServer server = new AuctionServer(BASE_PORT);
		NameSet.keysToString();
		final JComboBox<String> jcb = new JComboBox<String>(NameSet.allKeys);
		frame = new JFrame("Stocks Auction");
		frame.setLayout(new GridBagLayout());
		GUI_Action g = new GUI_Action();
		
		c.fill = GridBagConstraints.BOTH; //adding the table
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(g, c);
		
		c.fill = GridBagConstraints.BOTH; //adding the log area
		c.gridx = 0;
		c.gridy = 1;
		txtarea.setFont(new Font("Serif", Font.PLAIN, 15));
		JScrollPane jsp2 = new JScrollPane(txtarea);
		enterValue.setColumns(20);
		frame.add(jp);
		frame.add(txtarea, c);
		
		c.fill = GridBagConstraints.CENTER; //adding the grid beside the table
		c.gridx = 1;
		c.gridy = 0;
		jpa.setLayout(new GridBagLayout());
		frame.add(jpa, c);
		
		c.gridx = 0; //adding the drop down menu
		c.gridy = 2;
		jcb.setFont(new Font("Serif", Font.PLAIN, 15));
		jpa.add(jcb, c);
		
		c.fill = GridBagConstraints.BOTH; //adding the text
		c.gridx = 0;
		c.gridy = 1;
		JLabel update = new JLabel("UPDATE STOCK PRICE:  ");
		update.setFont(new Font("Serif", Font.BOLD, 20));
		jpa.add(update, c);
		
		jcb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.fill = GridBagConstraints.BOTH;
				c.gridx = 0;
				c.gridy = 3;
				currentPrice.setFont(new Font("Serif", Font.PLAIN, 15));
				updatingStockItem = jcb.getSelectedItem().toString();
				currentPrice.setText("Current Price of " + updatingStockItem + " : "+NameSet.getStockPrice(updatingStockItem));
				jpa.add(currentPrice, c);
				frame.pack();
				
				c.fill = GridBagConstraints.BOTH;
				c.gridx = 0;
				c.gridy = 4;
				enterValue.setFont(new Font("Serif", Font.PLAIN, 15));
				enterValue.setText(" ");
				enterValue.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				enterValue.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				jpa.add(enterValue, c);
				frame.pack();

				c.fill = GridBagConstraints.CENTER;
				c.gridx = 1;
				c.gridy = 4;
				jb2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						c.fill = GridBagConstraints.BOTH;
						c.gridx = 0;
						c.gridy = 5;
						updatingStockItem = jcb.getSelectedItem().toString();
						UpdateSuccess.setFont(new Font("Serif", Font.PLAIN, 15));
						try {
							if (Double.parseDouble(enterValue.getText()) < NameSet.getStockPrice(updatingStockItem)) {
								UpdateSuccess.setText("Failed: Bid if lower than the price");
								frame.pack();
							}
							else {
								NameSet.updateStockPrice(updatingStockItem, NameSet.getStockKey(updatingStockItem), Double.parseDouble((enterValue.getText().toString())));
								currentPrice.setText("Current Price of " + updatingStockItem + " : "+NameSet.getStockPrice(updatingStockItem));
								for (int i = 0; i < 8; i++) {
									if (GUI_Action.data[i][0].equals(updatingStockItem)) {
										GUI_Action.stockvalue.setValueAt(String.valueOf(NameSet.getStockPrice(updatingStockItem)), i, 2);
										//System.out.println("hello");
										break;
									}
								}

								DateFormat dateformat;
								Calendar cal;
								dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
								cal = Calendar.getInstance();
								addLabel(cal, dateformat, "Server", updatingStockItem, String.valueOf(NameSet.getStockPrice(updatingStockItem)));
								UpdateSuccess.setText("Updated Successfully");
							}
						} catch(NumberFormatException e) {
							UpdateSuccess.setText("Invalid Input");
						}
						jpa.add(UpdateSuccess, c);
						frame.pack();
							
					}	
				});
				jpa.add(jb2, c);
				frame.pack();
				
			}
		});
		frame.pack();
		frame.setVisible(true);
		server.server_loop();
	}
}