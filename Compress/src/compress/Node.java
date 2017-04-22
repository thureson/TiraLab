package compress;

/* Pakollinen osa puu-rakennetta */
public class Node implements Comparable {
    private char key;
    private Node left;
    private Node right;
    private int freq;
    
    public Node(char key, Node left, Node right, int freq){
        this.key = key;
        this.left = left;
        this.right = right;
        this.freq = freq;
    }
    
    /* Tarkistetaan onko solmulla lapsia */
    public boolean isLeaf(){
        if (left == null && right == null){
            return true;
        } else {
            return false;
        }
    }
    
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
