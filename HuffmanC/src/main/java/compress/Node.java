package compress;

/**
* Node for huffman-tree
*/

public class Node implements Comparable {
    private char key;
    private Node left;
    private Node right;
    private int freq;

    /**
    * Constructor
    * @param key Character value of the node
    * @param left Left child node
    * @param right Right child node
    * @param freq Sum of the child node frequencies, for leafs nodes keys frequency 
    */
    
    public Node(char key, Node left, Node right, int freq){
        this.key = key;
        this.left = left;
        this.right = right;
        this.freq = freq;
    }
    
    /**
    * Checks if the node is a leaf node
    * @return true if no children
    * @return false if children
    */
    
    public boolean isLeaf(){
        if (left == null && right == null){
            return true;
        } else {
            return false;
        }
    }
    
    /**
    * Compare nodes frequency to another nodes frequency 
    * and sort accordingly
    * @param o Object to be compared to
    */
    
    @Override
    public int compareTo(Object o){
        Node n = (Node) o;
        if (this.returnFreq() == n.returnFreq()){
            return -1;
        } else {
            return this.returnFreq() - n.returnFreq();
        }
    }
    
    public char returnKey(){
        return this.key;
    }
    
    public Node returnLeft(){
        return this.left;
    }
    
    public Node returnRight(){
        return this.right;
    }
    
    public int returnFreq(){
        return this.freq;
    }
}