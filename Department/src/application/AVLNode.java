package application;

public class AVLNode
{
	Department data; // Data in the node
	AVLNode left; // Left child
	AVLNode right; // right child
	int height; // Height
	public boolean isLeaf() {
		return (left == null && right == null);
	}
	
	public AVLNode (Department d)
	{
		this(d, null, null);
	}
	public AVLNode (Department d, AVLNode lt, AVLNode rt)
	{
		data = d;
		left = lt;
		right = rt;
		
	}

	public AVLNode getLeft() {
		return left;
	}

	public void setLeft(AVLNode left) {
		this.left = left;
	}

	public AVLNode getRight() {
		return right;
	}

	public void setRight(AVLNode right) {
		this.right = right;
	}
	
	public boolean hasLeft() {
				return left != null;
			}

			public boolean hasRight() {
				return right != null;
			}
	
}