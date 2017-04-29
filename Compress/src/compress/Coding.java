package compress;

import java.util.ArrayList;
import java.util.List;

public class Coding {
    
    private List<List<Integer>> coding;
    private Node root;
    
    public Coding(Node root){
        this.coding = new ArrayList<List<Integer>>();
        this.root = root;
        for (int i = 0; i < 256; i++){
            coding.add(null);
        }
    }
    
    public void build(Node node, List<Integer> bits){
        if (node.isLeaf()){
            coding.set(node.returnKey(), new ArrayList(bits));
        } else {
            bits.add(0);
            build(node.returnLeft(), bits);
            bits.remove(bits.size()-1);
            bits.add(1);
            build(node.returnRight(), bits);
            bits.remove(bits.size()-1);
        }
    }
    
    public List<Integer> returnCode(int c){
        return coding.get(c);
    }
    
    public Node returnRoot(){
        return root;
    }
    
    public List<List<Integer>> returnCodingTable(){
        return this.coding;
    }
}
