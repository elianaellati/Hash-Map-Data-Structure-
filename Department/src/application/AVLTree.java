package application;

public class AVLTree {
	private AVLNode root;
	String s=" ";
	public AVLTree( )
	{
		root = null;
	}
	public void makeEmpty( )
	{
		root = null;
	}

	public boolean isEmpty( )
	{
		return root == null;
	}

	public String printTree( )
	{
		if( isEmpty( ) )
			return "Empty departemnets";
		else
			 s=" ";
	
			return printTree( root );

	}
	
	private String printTree( AVLNode t )
	{ 
		
		if( t != null )
		{
			printTree( t.left );
		
			s=s+t.data.departmentname + t.height+"\n";
			printTree( t.right );
		}
		return s;
	}

	
	
	
	
	

	public void insert( Department x )
	{
		root = insert( x, root );
	}


	private AVLNode insert( Department x, AVLNode t )
	{
		if( t == null )
			return new AVLNode( x, null, null );
		if(x.departmentname.compareToIgnoreCase(t.data.departmentname)<0 )
		{
			t.left = insert( x, t.left );
			if( height( t.left ) - height( t.right ) == 2 )
				if( x.departmentname.compareToIgnoreCase(t.left.data.getDepartmentname())< 0 )
					t = rotateLeft( t );
				else
					t = doubleLeft( t );

		}
		else if( x.departmentname.compareToIgnoreCase(t.data.getDepartmentname())>0 )
		{
			t.right = insert( x, t.right );
			if( height( t.right ) - height( t.left ) == 2 )
				if(x.departmentname.compareToIgnoreCase(t.data.getDepartmentname())>0 )
					t = rotateRight( t );
				else
					t = doubleRight( t );

		}
		else
			;
		t.height = Math.max( height( t.left ), height( t.right )) + 1;
		return t;
	}

	/*public boolean search( String x )
	{
		return search( x, root );
	}

	private boolean search( String x, AVLNode t )
	{
		while( t != null )
		{
			if( x.compareToIgnoreCase(t.data.departmentname)<0 )
				t = t.left;
			else
				if( x.compareToIgnoreCase(t.data.departmentname)>0)
					t = t.right;


				else
					return true;
		}
		return false;
	}*/
	
	public AVLNode search( String x )
	{
		return search( x, root );
	}

	private AVLNode search( String x, AVLNode t )
	{
		while( t != null )
		{
			if( x.compareToIgnoreCase(t.data.departmentname)<0 )
				t = t.left;
			else
				if( x.compareToIgnoreCase(t.data.departmentname)>0)
					t = t.right;


				else
					return t;
		}
		return null;
	}


	private int height( AVLNode t )
	{
		if( t == null )
			return -1;
		else
			return t.height;

	}
    
	private AVLNode rotateLeft( AVLNode node2 )
	{
		AVLNode node1 = node2.left;
		node2.left = node1.right;
		node1.right = node2;
		node2.height = Math.max(height(node2.left),

				height(node2.right))+1;

		node1.height = Math.max(height(node1.left), node2.height)+1;
		return node1;
	}

	private AVLNode rotateRight( AVLNode node1 )
	{
		AVLNode node2 = node1.right;
		node1.right = node2.left;
		node2.left = node1;
		node1.height = Math.max(height(node1.left),

				height(node1.right))+1;

		node2.height = Math.max(height(node2.right), node1.height)+1;
		return node2;
	}

	private AVLNode doubleLeft( AVLNode node3 )
	{
		node3.left = rotateRight( node3.left );
		return rotateLeft( node3 );
	}

	private AVLNode doubleRight( AVLNode node1 )
	{
		node1.right = rotateLeft( node1.right );
		return rotateRight( node1 );
	}
	public int height() {
		return heightt(root);
	}
	public int heightt(AVLNode root) {
			   if (root == null)
			        return 0;
			   else
			        return Math.max(height(root.left), height(root.right)) + 1;
	}
public void delete (String data) {
	deleteNode(root,data);
}
public AVLNode deleteNode(AVLNode root, String data)
    {

        if (root == null)
            return root;
 
        if (data.compareToIgnoreCase(root.data.getDepartmentname())< 0)
            root.left = deleteNode(root.left,data);
 
        else if (data.compareToIgnoreCase(root.data.getDepartmentname())> 0)
            root.right = deleteNode(root.right,data);
        else
        {
 
            if ((root.left == null) || (root.right == null))
            {
                AVLNode temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
 
               
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else 
                    root = temp; 
            }
            else
            {
                AVLNode temp = minValueNode(root.right);
                root.data.departmentname = temp.data.departmentname;
                root.right = deleteNode(root.right,temp.data.departmentname);
            }
        }
        if (root == null)
            return root;
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);
 
    
        if (balance > 1 && getBalance(root.left) >= 0)
            return rotateRight(root);
 
     
        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left =rotateLeft(root.left);
            return rotateRight(root);
        }
 
        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return rotateLeft(root);
 
        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }
 
        return root;
    }
public int getBalance(AVLNode N)
{
    if (N == null)
        return 0;
    return height(N.left) - height(N.right);
}
AVLNode minValueNode(AVLNode node)
{
    AVLNode current = node;

    /* loop down to find the leftmost leaf */
    while (current.left != null)
    current = current.left;

    return current;
}

}