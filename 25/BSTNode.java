public class BSTNode {
	
	public String key; 
	public BSTNode left;
	public BSTNode right;
	
	BSTNode (String _key) {
		key = _key;
		left = null;
		right = null;
	}

	BSTNode (BSTNode _node, BSTNode _left, BSTNode _right) {
		key = _node.key;
		left = _left;
		right = _right;
	}

}