package application;



public class Hash<T extends Comparable<T>> {

    private Node [] nodes = new Node[5];
    private int tableSize = 5;
    private int currentSize = 0;

    public Hash() {
        super();
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node (null,0);
        }
    }

    public int hashCode(T data) {
        return data.hashCode() % (tableSize);
    }
    public int hash(String key)
    {
    int hashVal = 0;
    for( int i = 0; i < key.length( ); i++ ) {
    hashVal = (2<<5)* hashVal+ key.charAt(i);
    }
    hashVal %= tableSize;

    if( hashVal < 0 )
    hashVal += tableSize;
    return hashVal;
    }
    public void insert(Student s) {
    	try {
        if(s != null) {
            if (currentSize == tableSize / 2) {
                reHash();
                
            }
            int index = hash(s.getName());
            int currIndex = index;
            int i = 0;
            while (nodes[currIndex].getStatus()== 1) {
                currIndex = (int) (index + Math.pow(i, 2)) % tableSize;
                i++;
            }
            nodes[currIndex].setStatus(1);
            nodes[currIndex].setData(s);
            currentSize++;
        }
    	}catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());

		}
        
    }

    public String find(String s) {
        if(s != null && currentSize > 0) {
            int index = hash(s);
          
            int currIndex = index;
            int i = 0;
            while (nodes[currIndex].getData()!=null && nodes[currIndex].getStatus() == 1 && nodes[currIndex].getData().getName().compareTo(s) != 0 ) {
                currIndex = (int) (index + Math.pow(i, 2)) % tableSize;
                i++;
            }
           
            if(nodes[currIndex].getData()!= null) {
                if(nodes[currIndex].getData().getName().compareTo(s) == 0) {
                   return nodes[currIndex].getData().getName();
                }
            }
        }
        return null;
    }
   /* public String find(String data)
    {
    int i =1 ;
    int hash =hash(data);
    while (((nodes[hash].getData() != null) && (nodes[hash].getStatus() != 0)
    		&& (!nodes[hash].getData().getName().equals(data))) ||
    		((nodes[hash].getData() != null) &&(nodes[hash].getData().getName().equals(data)) &&
    		(nodes[hash].getStatus() ==2)))
    hash = (hash + i*i) % tableSize;
    if ((nodes[hash] == null) || (nodes[hash].getStatus() == 0))
    return null;
    else
    return nodes[hash].getData().getName();
    }*/

    public int getTableSize() {
        return tableSize;
    }

    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }


    // delete method to delete a item from the hash table
    public void remove(String s) {
       
        if(s != null) {
            
            if(currentSize < tableSize / 4) {
                shrink();
                
            }
            int index = hash(s);
            int currIndex = index;
            int i = 0;
            while (nodes[currIndex].getStatus() == 1 && nodes[currIndex].getData().getName().compareTo(s) != 0) {
              
                currIndex = (int) (index + Math.pow(i, 2)) % tableSize;
                i++;
            }

           
            if(nodes[currIndex].getData() != null) {
                if(nodes[currIndex].getData().getName().compareTo(s) == 0) {
                    nodes[currIndex].setStatus(2);
                    currentSize--;
                }
            }
        }
    }



    public void shrink() {
        Node[] oldNodes = nodes;
        nodes = new Node[tableSize / 2];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(null, 0);
        }
        tableSize = nodes.length;
        currentSize = 0;
        for (int i = 0; i < oldNodes.length; i++) {
            if(oldNodes[i].getStatus() == 1) {
                insert(oldNodes[i].getData());
            }
        }
    }


    public void reHash() {
        Node[] oldNodes = nodes;
        nodes = new Node[nextPrime(tableSize * 2)];
        tableSize = nodes.length;
        currentSize = 0;
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(null,0);
        }
        for (int i = 0; i < oldNodes.length; i++) {
            if (oldNodes[i].getStatus() == 1) {
                insert(oldNodes[i].getData());
            }
        }
    }

    private static int nextPrime(int n) {
        if (n % 2 == 0)
            n++;
        for (; !isPrime(n); n += 2)
            ;
        return n;
    }

    public int getHash(T key) {
        return key.hashCode();
    }

    private static boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;
        if (n == 1 || n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n / 2; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }

    public String printHashTable()
    {
    	String H="";
    	H=H+"Table Size : "+tableSize+"\n";
    for( int i = 0; i < nodes.length;  ) {
    if ((nodes[ i ] != null)&& (nodes[i].getStatus() == 1)) {
    	
    	H=H+"Index "+i+"  "+nodes[ i ].getData().getName()+"  "+nodes[i].getData().getId()+"   "+nodes[i].getData().getAverage()+"   "+nodes[i].getData().getGender()+nodes[i].getStatus()+"\n";
    }else {
    	H=H+"Index"+i+"  "+"Empty Spot"+"\n";
    }
    ++i;
    }
    return H;
    }
    public String print()
    {
    	String H="";
    for( int i = 0; i < nodes.length;  ) {
    if ((nodes[ i ] != null)&& (nodes[i].getStatus() == 1)) {
    	
    	H=H+nodes[ i ].getData().getName()+"/"+nodes[i].getData().getId()+"/"+nodes[i].getData().getAverage()+"/"+nodes[i].getData().getGender()+"\n";
    }
    ++i;
    }
    return H;
    }

}



