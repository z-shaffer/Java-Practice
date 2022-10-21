
public class BST {
	private Node root; // The root node of the tree.

	public BST() {
		root = null;
	}

	/**
		Inserts a time, along with the req_id. The tree is keyed on time, while req_id provides a pointer to the request.
		This is a public wrapper function that calls the recursive insert method.
		Note that the insert method should return the root node of the subtree in which we insert the key (and its value).
	**/
	public void insert(int time, int req_index) {
		root = insert(time, req_index, root);		
	}

	/**
		Returns a pointer to the Node that is the predecessor of time. The predecessor element is the largest
		element within the tree that is smaller or equal to time. This is the deepest ancestor with this property.
		Please return the predecessor element. You may return null if time does not have a predecessor.
	**/
	public Node pred(int time) {
		Node curr = root;
		Node pred = null;
		while (curr != null)
		{
			if (curr.getTime() > time)
			{
				curr = curr.getLeft();
			}
			else
			{
				pred = curr;
				curr = curr.getRight();
			}
		}
		return pred;
	}

	/**
		Returns a pointer to the Node that is the successor of time. The successor element is the largest
		element within the tree that is larger or equal to time. This is the deepest ancestor with this property.
		Please return the successor element. You may return null if time does not have a successor.
	**/
	public Node succ(int time) {
		Node curr = root;
		Node succ = null;
		while (curr != null)
		{
			if (curr.getTime() < time)
			{
				curr = curr.getRight();
			}
			else
			{
				succ = curr;
				curr = curr.getLeft();
			}
		}
		return succ;
	}

	/**
		Returns the minimum element in the binary search tree or null if the tree is empty.
	**/
	public Node min() {	
		Node curr = root;
		if (curr == null)
		{
			return null;
		}
		return min(curr);
	}

	/**
		Returns the maximum element in the binary search tree or null if the tree is empty.
	**/
	public Node max() {
		Node curr = root;
		if (curr == null)
		{
			return null;
		}
		return max(curr);
	}

	/**
		Remove the node that contains this time. If this time is not present in the structure, this method does nothing.
	**/
	public void delete(int time) {
		root = delete(time, root);
	}

	/**
		Prints the contents of the tree in sorted order.
	**/
	public void print() {
		print(root);		
	}

	private Node insert(int time, int req_index, Node curr)
	{
		if (curr == null) return new Node(time, req_index);
		if (time <= curr.getTime())
			curr.setLeft(insert(time, req_index, curr.getLeft()));
		else 
			curr.setRight(insert(time, req_index, curr.getRight()));
		return curr;
	}

	private Node delete(int time, Node curr)
	{
		if (curr.getTime() < time)
		{
			if (curr.getRight() != null)
			{
				curr.setRight(delete(time, curr.getRight()));
			}
			else 
			{
				return null;
			}
		}
		else if (curr.getTime() > time)
		{
			if (curr.getLeft() != null)
			{
				curr.setLeft(delete(time, curr.getLeft()));
			}
			else
			{
				return null;
			}
		}
		else
		{
			if (curr.getLeft() == null && curr.getRight() == null)
			{
				return null;
			}	
			else if (curr.getLeft() == null)
			{
				Node n = curr.getRight();
				curr = null;
				return n;
			}
			else if (curr.getRight() == null)
			{
				Node n = curr.getLeft();
				curr = null;
				return n;
			}
			else
			{
				Node n = pred(curr.getTime());
				curr = delete(pred(curr.getTime()).getTime(), curr);
				curr.setTime(n.getTime());
				curr.setReq_index(n.getReq_index());
				n = null;
				return curr;
			}

		}
		return curr;
	}

	private void print(Node curr)
	{
		if (curr == null)
		{
			return;
		}
		print(curr.getLeft());
		System.out.println(curr.getTime());
		print(curr.getRight());
	}

	private Node max(Node curr)
	{
		if (curr.getRight() != null)
		{
			return min(curr.getRight());
		}
		else
		{
			return curr;
		}
	}

	private Node min(Node curr)
	{
		if (curr.getLeft() != null)
		{
			return min(curr.getLeft());
		}
		else
		{
			return curr;
		}	
	}
}
