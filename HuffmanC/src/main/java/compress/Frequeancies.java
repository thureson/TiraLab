package compress;

import java.util.PriorityQueue;

/**
* Stores the frequency for each character 
*/

public class Frequeancies {
    
    private int[] frequencies;
    
    /**
    * Constructor
    * @param frequencies frequencies for each char (0-255, ASCII)
    */
    
    public Frequeancies(int[] frequencies){
        this.frequencies = frequencies.clone();
    }
    
    public int getLenght(){
        return this.frequencies.length;
    }
    
    public int get(int character){
        return this.frequencies[character];
    }
    
    public void set(int character, int frequency){
        this.frequencies[character] = frequency;
    }
    
    /**
    * Build huffman-tree from frequencies
    * @return Root node of the tree
    */
    
    public Node buildTree(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
                
        for (char i = 0; i < 256; i++){
            if (frequencies[i] > 0){
                pq.add(new Node(i, null, null, frequencies[i]));
            }
        }
        
        while (pq.size() > 1) {
            Node left  = pq.remove();
            Node right  = pq.remove();
            Node parent = new Node('\0', left, right, left.returnFreq() + right.returnFreq());
            pq.add(parent);
        }
        return pq.remove();
    }
}