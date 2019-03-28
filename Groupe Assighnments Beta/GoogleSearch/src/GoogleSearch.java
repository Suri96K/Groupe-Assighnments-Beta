import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class GoogleSearch {

	public static void main(String[] args) {
		String path = args.toString();
		if (args.length == 0) {
			System.err.println("Enter search term!");
			return;
		}
		try {
			//avoid error 403
            System.setProperty("http.agent", "Chrome");

			URLConnection con = new URL(encodePath(path)).openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String encodePath(String path) {
			try {
				path = "https://www.google.lk/search?q="+URLEncoder.encode(path, "UTF-8");
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return path;
	}

}
