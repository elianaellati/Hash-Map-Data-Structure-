package application;
public class TNode<T extends Comparable<T>> {

	 Department data;
     TNode left;
     TNode right;
 
    public TNode(Department  data) {
		super();
		this.data = data;
	}
    
    
	


	public Department getData() {
		return data;
	}





	public void setData(Department data) {
		this.data = data;
	}





	public TNode getLeft() { return left; 
	}
    public void setLeft(TNode left) { this.left = left; }
    public TNode getRight() { return right; }
    public void setRight(TNode right) { this.right = right;}
    public boolean isLeaf(){ return (left==null && right==null); }
    public boolean hasLeft(){ return left!=null; }
    public boolean hasRight(){ return right!=null; }
    public String toString() { return "[" + data + "]"; }

}
