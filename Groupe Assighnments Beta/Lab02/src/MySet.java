
/* my array list: an array that behaves like a list 
 * E/14/222
 */

public class MySet<T/* Can we have any T */> { 

    int nextItem; 
    int currentCapacity; 
    T[] data; // DO NOT CHANGE
    T[] newdata;

    private static int defaultSizeToCreate = 10; // how many elements to create 

    public MySet(int elements) { 
	this.nextItem = 0; 
	this.defaultSizeToCreate = elements; 
	this.currentCapacity = elements; 

	this.data = (T[]) new Object[this.defaultSizeToCreate]; 
    }

    public MySet() { 
	this(defaultSizeToCreate); 
    }

    public boolean isEmpty() { return this.nextItem == 0; } 
    public boolean isFull() { return false; /* never get filled */} 

    public boolean add(T item) { 
    try {	
    	data[nextItem] = null; // DO NOT CHANGE
    }	
    catch(ArrayIndexOutOfBoundsException ex) {
    	
    }
	if(nextItem < this.currentCapacity) {
		for(int i = 0; i < this.currentCapacity; i++) {
			if(item == data[i]) {
				return false;
			}
			//System.out.println(data[i]);
		}
		data[nextItem] = item;
		nextItem++;	
	}
	else {
		this.currentCapacity += this.defaultSizeToCreate;
		this.newdata = (T[]) new Object[this.currentCapacity];
		for(int i = 0; i < this.currentCapacity; i++) {
			newdata[i] = data[i];
		}
		newdata[nextItem] = item;
		nextItem++;
		this.data = (T[]) new Object[this.currentCapacity];
		data = newdata;
		
	}
	
	/* if there is any element delete it 
	 * then add the new element. 
	 * How do you handle when the array is full: 
	 * crate a new array with currentCapacity+defaultSizeToCreate, 
	 * copy the old conents into that
	 * Accessing array when full might be a problem
	 */

	/* Add the item to the array if the item is not there */
	return true; // CHANGE ME

    }


    public T remove() { 
	/* remove the first element in the array 
	 * and copy the rest front. 
	 * FIFO structure. 
	 * If the ArrayList is empty return null
	 */
	/* Option 1: */
	/*if(isEmpty()) return null; 
	else {
		T out = data[0];
		for(int i = 0; i < data.length; i++) {
			data[i] = data[i+1];
		}
		return out;
	}
	// IMPLEMENT THE REST 

	/* Option 2: */
	if(!isEmpty()) { 
		T out = data[0];
		for(int i = 0; i < (data.length - 1); i++) {
			data[i] = data[i+1];
		}
		return out;
	    // IMPLEMENT THE REST
	}
	else return null;
	// which option is better? why? 
    }


}
	 

	