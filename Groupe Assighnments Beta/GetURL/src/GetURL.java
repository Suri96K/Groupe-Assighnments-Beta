import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class GetURL {
	
	
	public static void main(String[] args){
		try {
			URL myURL = new URL(args[0]);
			URLConnection openCon = myURL.openConnection();
			openCon.connect();
			
			System.out.printf("------------------------------- HTTP headers-------------------------------\n");
    	    Map<String, List<String>> map = openCon.getHeaderFields();
    	    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
    	    	System.out.println("Key : " + entry.getKey() +
    	                     ",\tValue : " + entry.getValue());
    	    }
    	    System.out.printf("---------------------------------Content-----------------------------------------\n\n");
			
			
			BufferedReader in = new BufferedReader(new InputStreamReader(myURL.openStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();
			
		} catch (MalformedURLException e) {
			System.err.println("Invalid URL");
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("enter URL!");
		}
	}

}
