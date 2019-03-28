import java.util.ArrayList;

/*********************************************
 * CO322: Data structures and algorithms
 * Implementation of the hashTable
 *
 * E/14/222 - R.C. Medawatte
 *********************************************/
class HashTableImp implements HashTable {

	private ArrayList<HashNode> mainList;
	private int buckets;
	private int size;

    public HashTableImp(int buckets) {  //constructor
    	mainList = new ArrayList<>();
    	this.buckets = buckets;
    	this.size = 0;
    	for(int i = 0; i < buckets; i++) {
    		mainList.add(null);
    	}
    }
    
    //hash function to return the index for a key
    public int HashFunction(String key) {
    	int tempindex = 0;
    	int index = 0;

    	//alphabetical order - hashfunction #1
//    	char firstletter = key.charAt(0);
//
//    	if(firstletter >= 97 && firstletter <= 122) {
//    		index = firstletter - 97;
//    	}
//
//    	return index;


    	//hashfunction #2
//		int tot = 0;
//		for (int i = 0; i < key.length(); i++){
//			tot += key.charAt(i);
//		}
//		index = tot % buckets;
//		return index;


//    	//hashfunction #3
//		int g = 31; //the prime number
//		int n = 71;
//
//		for(int j = 0; j < key.length(); j++){
//			tempindex += g * (n-j) * key.charAt(j);
//		}
//
//		index = tempindex % buckets;
//		return index;


		//hashfunction #4
		int b     = 378551; //large prime number
		int a     = 63689;	//large prime number
		long hash = 0;

		for(int i = 0; i < key.length(); i++)
		{
			hash = hash * a + key.charAt(i);
			a    = a * b;
		}
		index = (int) hash % buckets;
		if (index < 0) index *= -1;
		return index;
    }

	@Override
	public void insert(String key) {              //inserting a new node or incrementing an existing node
		int hashIndex = HashFunction(key);
		HashNode head = mainList.get(hashIndex);
		
		while (head != null) {
			if(head.key.equals(key)) {
				head.value++;
				return;
			}
			head = head.next;
		}
		
		size++;
		head = mainList.get(hashIndex);
		HashNode newNode = new HashNode(key, 1);
		newNode.next = head;
		mainList.set(hashIndex, newNode);
	}

	@Override
	public int search(String key) {				//searching a keyword
		int hashIndex = HashFunction(key);
		HashNode head = mainList.get(hashIndex);
		
		while (head != null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		System.out.println("Keyword not found");
		return -1;
	}
	
	public void fullDetails() { 		//printing details about the hash function and its distribution
		int j = 0;
		int tot = 0;
		int max = 0;
		int min = 10000;
		float mean = 0;
		float variance = 0;
		int[] arr = new int[buckets];
		float stdDiv = 0;

		for(int i = 0; i < buckets; i++) {
			j = 0;
			HashNode head = mainList.get(i);
			
			while (head != null) {
				head = head.next;
				j++;
				tot++;
			}
			arr[i] = j;
			if (j > max) max = j;
			if (j < min) min = j;
		}
		mean = (float)tot/(float)buckets;

		for (int i = 0; i < buckets; i++){
			variance += Math.pow(mean - arr[i],2);
		}
		variance = (float)variance/buckets;
		stdDiv = (float)Math.sqrt(variance);

		System.out.println("no of buckets: "+buckets); 
		System.out.println("mean: "+mean);
		System.out.println("standard deviation: "+stdDiv);
		System.out.println("max: "+max+", min: "+min);
	}

}// end HashTableImp 
