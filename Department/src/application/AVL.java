package application;

public class AVL<T extends Comparable<T>> extends BSTree<T> {

	public void insert(Department data)  {
		try {
		if (isEmpty())
			root = new TNode(data);
		else {
			TNode rootNode = root;
			addEntry(data, rootNode);
			root = rebalance(rootNode);
		}
		}catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());

		}
	}
	
	public void addEntry(Department data, TNode rootNode) {
		assert rootNode != null;
		if (data.departmentname.compareTo(((Department) rootNode.data).departmentname) < 0) { // right into left subtree
			if (rootNode.hasLeft()) {
				TNode leftChild = rootNode.left;
				addEntry(data, leftChild);
				rootNode.left = rebalance(leftChild);
			} else
				rootNode.left = new TNode( data);
		} else { // right into right subtree
			if (rootNode.hasRight()) {
				TNode rightChild = rootNode.right;
				addEntry(data, rightChild);
				rootNode.right = rebalance(rightChild);
			} else
				rootNode.right = new TNode( data);
		}
	}

	int maxDepth(TNode node)
	{
		if (node == null)
			return -1;
		else
		{
			/* compute the depth of each subtree */
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}


	public TNode delete(String data) {
		TNode temp = super.delete(data);
		if (temp != null) {
			TNode rootNode = root;
			root = rebalance(rootNode);
		}
		return temp;
	}

    public int height(TNode node){
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int getHeightDifference(TNode root){
		return height(root.left) - height(root.right);
	}

    private TNode rotateRight(TNode root){
    	TNode c = root.left;
    	root.left = c.right;
    	c.right = root;
    	return c;
    }

    private TNode rotateLeft(TNode root){
    	TNode c = root.right;
    	root.right = c.left;
    	c.left = root;
    	return c;
    }

    private TNode rotateRightLeft(TNode root){
    	TNode c = root.right;
    	root.right = rotateRight(c);
    	return rotateLeft(root);
    }

    private TNode rotateLeftRight(TNode root){
    	TNode c = root.left;
    	root.left = rotateLeft(c);
    	return rotateRight(root);
    }

	private TNode rebalance(TNode nodeN) {
		int diff = getHeightDifference(nodeN);
		if (diff > 1) { // addition was in node's left subtree
			if (getHeightDifference(nodeN.left) > 0)
				nodeN = rotateRight(nodeN);
			else
				nodeN = rotateLeftRight(nodeN);
		} else if (diff < -1) { // addition was in node's right subtree
			if (getHeightDifference(nodeN.right) < 0)
				nodeN = rotateLeft(nodeN);
			else
				nodeN = rotateRightLeft(nodeN);
		}
		return nodeN;
	}



}
