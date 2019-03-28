import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 implements Runnable{

    public static final int BASE_PORT = 1250;     
    private Thread t;
    private ServerSocket serverSocket; 
    
    public Server1(int socket) throws IOException { 
	serverSocket = new ServerSocket(socket); 
	// create a new server socket 
    }

    public void run() { 
	while(true) { 
	    Socket socket = null;
		try {
			socket = serverSocket.accept();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 	    
	    try { 
		handle(socket); 
	    } catch (IOException e) { 
		System.out.println(e); 
	    } finally { 
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	}
    }
    

    public void start(){
    	if (t == null) {
    		t = new Thread ();
    		t.start();
    
    	}
    } 	

    private void handle(Socket socket) throws IOException { 
	
	BufferedReader in = new 
	    BufferedReader(new InputStreamReader(socket.getInputStream()));
	PrintWriter out = new 
	    PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	String line; 
	for(line = in.readLine(); 
	    line != null && !line.equals("quit"); 
	    line = in.readLine()) { 
	    System.out.println(line); 
	    out.print(line + "\n"); 
	    out.flush();	     
	} 
    }

    public static void main(String [] args) throws IOException { 
	Server1 server = new Server1(BASE_PORT);
	server.start(); 
    }
}
