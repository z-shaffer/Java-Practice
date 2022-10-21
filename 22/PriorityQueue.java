
public class PriorityQueue {
	private Interval [] heap; // An array that encodes a max-heap data structure.
	private int size;	// The size of allocated buffer for the heap.
	private int numElements;	// The number of elements currently stored. 

	/**
		Constructor: s is the initial size of the heap.
	*/
	public PriorityQueue(int s) {
		size = s;
		heap = new Interval[size + 1];	// 1 extra element allows us to use 1-based indexing. The max heap stores intervals keyed on their lengths.
		numElements = 0;
	}

	/**
		Inserts a new Interval k into the heap. Automatically expands the heap if the buffer allocated is full.
	TODO: Please complete this method.
	*/
	public void insert(Interval k) {
		if (numElements == size) {
			// Expand the buffer allocated for the heap to another buffer that is twice as big.
			size *= 2;
			Interval [] temp = new Interval[size+1];
			for (int i = 1; i <= numElements; i++)
			{
				temp[i] = heap[i];
			}
			heap = temp;
		}
		// Insert without buffer expansion here.
		heap[numElements+1] = k;
		//for (int i = 1; i <= numElements; i++) { siftup(i); }
		numElements++;
		siftup(numElements);	
	}

	private void siftup(int x)
	{
		if (heap[x / 2] != null && (heap[x].compareTo(heap[x/2]) > 0))
		{
			Interval temp = heap[x / 2];
			heap[x/2] = heap[x];
			heap[x] = temp;
			siftup(x / 2);
		}  
		return;
	}

	/**
		Returns the maximum Interval from the heap (usually the one with the largest length. See the compareTo function of Interval for more details on the comparison.
	TODO: Please complete this method.
	*/
	public Interval remove_max() {
		if (numElements == 0) return null; // Retuns null if heap is empty.
		// Remove_max code here.
		Interval temp = heap[1];
		heap[1] = heap[numElements];
		heap[numElements] = temp;
		numElements--;
		siftdown(1);
		return temp; // Replace this statement with returning the max element (root) in the heap.
	}

	private void siftdown(int x)
	{
		Interval temp;
		if (2*x > numElements && 2*x+1 > numElements) { return; }
		else if (2*x <= numElements && 2*x+1 > numElements)
		{
			temp = heap[2*x];
			heap[2*x] = heap[x];
			heap[x] = temp;
			siftdown(2*x);
		}
		else if (2*x > numElements && 2*x+1 <= numElements)
		{
			temp = heap[2*x+1];
			heap[2*x+1] = heap[x];
			heap[x] = temp;
			siftdown(2*x+1);
		}
		else if (heap[2*x].compareTo(heap[2*x+1]) < 0) 
		{
			temp = heap[2*x+1];
			heap[2*x+1] = heap[x];
			heap[x] = temp;
			siftdown(2*x+1);
		}
		else
		{
			temp = heap[2*x];
			heap[2*x] = heap[x];
			heap[x] = temp;
			siftdown(2*x);
		}

		/*while ((heap[2*x] != null && heap[x].compareTo(heap[2*x]) < 0) || heap[x].compareTo(heap[(2*x)+1]) < 0))
		{
			if (heap[2*x].compareTo(heap[(2*x)+1]) < 0) 
			{
				temp = heap[2*x];
				heap[2*x] = heap[x];
				heap[x] = temp;	
				x *= 2;	
			}	
			else
			{
				temp = heap[(2*x)+1];
				heap[(2*x)+1] = heap[x];
				heap[x] = temp;	
				x = (x*2) + 1;	
			}
		}*/
	}

	/**
		This function prints the contents of the array that encodes a heap.
	*/
	public void print() {
		System.out.println("Printing heap:");
		for (int i = 1; i < numElements; ++i)
			System.out.println(heap[i]);
	}

//	public int getnumElements() { return numElements; }

/*	public static void main(String [] args) {
		PriorityQueue q = new PriorityQueue(100);
		q.insert(new Interval(1, 2));
		q.insert(new Interval(2, 7));
		q.insert(new Interval(7, 13));
		q.insert(new Interval(13, 15));
		q.insert(new Interval(15, 16));
		q.insert(new Interval(16, 24));
		q.insert(new Interval(24, 31));
		q.insert(new Interval(31, 34));
		q.insert(new Interval(34, 43));
		q.insert(new Interval(43, 55));
		q.print();
		for (int i = 0; i < 10; i++)
		{
			Interval k =  q.remove_max();
			System.out.println("Removed: " + k);
		}
		q.print();
	}*/
}
