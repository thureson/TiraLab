package huffmancompress;

import java.util.PriorityQueue;

public class Frequeancies {
    
    private int[] frequencies;
    
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