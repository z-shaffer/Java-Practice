/**
	This class implements a circular array.
	It expands if the queue becomes full.
**/
public class Queue {
	private QNode [] queue;		// Array that stores the queue elements.
	private int front;				// Index pointing to the front of the queue.
	private int end;					// Index pointing to the element that is one less than the end of the queue.
	private int numElements;	// The number of elements currently stored in the queue.
	private int size;					// The capacity of the allocated array. If the number of elements reaches this capacity, we need to expand.

	/**
		Constructor: Allocates a queue with inital size of 1000.
	**/
	public Queue() {
		numElements = 0;
		size = 1000;
		front = 0;
		end = 0;
		queue = new QNode[size];
	}
	
	/**
		This function enqueues a new element p into the queue. 
		This also expands the array if it is full.
	**/
	public void enqueue(QNode p) {
		if (numElements == size) {
			// TODO: Expand the array, by first creating another one with twice the size and copying the contents of the old array.
			QNode [] temp = new QNode[size * 2];
			for (int i = 0; i < size; i++) temp[i] = queue[i];
			queue = temp;
			size *= 2;
		}
		// TODO: Code for normal enqueue.
		if (numElements == 0)
		{
			queue[front] = p;
		}
		if (end == size-1) 
		{
			queue[0] = p;
			end = 0;
		}
		else 
		{
			end++;
			queue[end] = p;
		}
		numElements++;
	}

	/**
		This funciton removes and returns the end front element in the queue.
	**/
	public QNode dequeue() {
		if (numElements == 0) {
			return null;
		}
		// TODO: Code to remove and return the front element.
		QNode ret = new QNode(queue[front]);
		if (front == size-1) front = 0;
		else front++;
		numElements--;
		return ret;	// remove this line once the funciton is completed.
	}

	/**
		This funciton returns true if the queue is empty, otherwise returns false.
	**/
	public boolean isEmpty() {
		if (numElements == 0) 
			return true;
		return false;
	}

	/**
		This function prints the contents of the queue.
	**/
	public void print() {
        // TODO: print the contents of the queue from front to end. Please print each element on its own line. You may use the toString() method of QNode to print it on a line.
		for (int i = front; i != end; i++)
		{
			System.out.println(queue[i].toString());
		}
		System.out.println(queue[end].toString());
	}
}
