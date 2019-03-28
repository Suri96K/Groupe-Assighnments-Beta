import java.io.IOException;

public class RAM implements MemInterface{
	int[] memory;
	
	public RAM(int size) {
		memory = new int[size/4];
	}

	public int lw(String addr1) throws IOException{
		// TODO Auto-generated method stub
		return memory[Integer.parseInt(addr1)];
		
	}

	public void sw(String addr2, int val) throws IOException{
		// TODO Auto-generated method stub
		memory[Integer.parseInt(addr2)] = val;
	}

}
