import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class GetMultiURL extends Thread{
	
	public String myURL;
	public static StringBuffer strbuffer = new StringBuffer();
	
	public GetMultiURL(String myURL) {
		this.myURL = myURL;
	}
	
	public void run() {
		URL tryURL = null;
		try {
			tryURL = new URL(this.myURL);
		
			BufferedReader in = null;
			in = new BufferedReader(new InputStreamReader(tryURL.openStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				strbuffer.append(inputLine);
				strbuffer.append("\n------------------------\n");
			in.close();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
		ArrayList<String> URLstringArr = new ArrayList<String>();
		if (args.length == 0) {
			System.err.println("Enter URLs!");
			return;
		}
		for(int i = 0; i < args.length; i++) {
			URLstringArr.add(args[i]);
		}
		
		GetMultiURL[] getmulti = new GetMultiURL[URLstringArr.size()];
		for (int i = 0; i < URLstringArr.size(); i++) {
			getmulti[i] = new GetMultiURL(URLstringArr.get(i));
			getmulti[i].start();
		}
		for (int i = 0; i < URLstringArr.size(); i++) {
			getmulti[i].join();
		}
		System.out.println(strbuffer.toString());
	}

}
