import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class NameSet{
	//private String symbol;
	public String key;
	public double price;
	public static Map<String, NameSet>stocks = new TreeMap<String, NameSet>();
	public static String [] allKeys;

	public NameSet(String key, double price){
		this.key = key;
		this.price = price;
	}

	public static void putStockValues(){
		String csvFile = "stocks.csv";
		String line = "";
		String csvSplitby = ",";

		try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
			line = br.readLine();
			while ((line = br.readLine())!= null){
				String[] stockall = line.split(csvSplitby);
				try{
					NameSet temp = new NameSet(stockall[1], Double.parseDouble(stockall[6]));
					stocks.put(stockall[0], temp);
				} catch (NumberFormatException et){
					try{
					NameSet temp = new NameSet(stockall[1] + stockall[2], Double.parseDouble(stockall[7]));
					stocks.put(stockall[0], temp);
					} catch (NumberFormatException ets){
						NameSet temp = new NameSet(stockall[1] + stockall[2] + stockall[3], Double.parseDouble(stockall[8]));
						stocks.put(stockall[0], temp);
					}
				}			
			}
		} catch(IOException e){
			e.printStackTrace();
		}
	}

	public static String getStockKey(String symbol){
		return stocks.get(symbol).key;
	}

	public static double getStockPrice(String symbol){
		return stocks.get(symbol).price;
	}

	public static void updateStockPrice(String symbol, String key, double price){
		NameSet temp1 = new NameSet(key, price);
		stocks.put(symbol, temp1);
	}
	
	public static void keysToString() {
		allKeys = stocks.keySet().toArray(new String[stocks.size()]);
	}
}