
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


class Client extends Thread{
	private Socket connectionSocket;
	DateFormat dateFormat;
	Calendar cal;
	
	
	public Client(Socket sock){
		this.connectionSocket = sock;
	}

	public void run(){
		try{

			int input = 0;
			String User = "0";
			String biddingOn = "0";
			int row = 1000;
			BufferedReader in = new BufferedReader(new InputStreamReader(this.connectionSocket.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(this.connectionSocket.getOutputStream()));
			String line = "";


			for(line = in.readLine(); line != null && !line.equals("quit"); line = in.readLine()){
				if (input == 0){
					User = line;
					System.out.println("User: "+line+" connected");
					input++;
					line = "Welcome " +User+ "!\nEnter Stock Item: ";
				}
				else if (input == 1){
					try{
						biddingOn = line;
						System.out.println(User +": Bidding on: " + NameSet.getStockKey(biddingOn));
						line = "Current Price = "+String.valueOf(NameSet.getStockPrice(biddingOn)) + "\n";
						if (biddingOn.equals("FB")) row = 0;
						else if (biddingOn.equals("VRTU")) row = 1;
						else if (biddingOn.equals("MSFT")) row = 2;
						else if (biddingOn.equals("GOOGL")) row = 3;
						else if (biddingOn.equals("YHOO")) row = 4;
						else if (biddingOn.equals("XLNX")) row = 5;
						else if (biddingOn.equals("TSLA")) row = 6;
						else if (biddingOn.equals("TXN")) row = 7;
						input++;

					} catch(NullPointerException en){
						line = "-1\nEnter Stock Item: ";
					}
				}
				else {
					try {
						if(Double.parseDouble(line) > NameSet.getStockPrice(biddingOn)) {
							dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							cal = Calendar.getInstance();
							NameSet.updateStockPrice(biddingOn, NameSet.getStockKey(biddingOn) ,Double.parseDouble(line));
							System.out.println(User + " changed the item price of " + biddingOn + " to " + NameSet.getStockPrice(biddingOn));
							//GUI_Action g = new GUI_Action();
							if (row != 1000) GUI_Action.stockvalue.setValueAt(line, row , 2);
							//AuctionServer.refreshTable();
							AuctionServer.addLabel(cal, dateFormat, User, biddingOn, line);
							input++;
							line = "bid placed: current value = " + NameSet.getStockPrice(biddingOn) +"\n";
						}
						else line = "Bid amount is lower than the current value: " + NameSet.getStockPrice(biddingOn) + "\n";
					} catch(NumberFormatException ls) {
						line = "Invalid input\n";
					}
				}
				out.write(line);
				out.flush();
			}
		} catch (IOException e){
			System.out.println(e);
		}
		try{
			this.connectionSocket.close();
		} catch(IOException e) {}
	}
}