package huffmancompress;

import java.util.ArrayList;
import java.util.List;

public class CodeTable {
    
    private List<List<Integer>> codeTable;
    private Node root;
    
    public CodeTable(Node root){
        this.codeTable = new ArrayList<List<Integer>>();
        this.root = root;
        for (int i = 0; i < 257; i++){
            codeTable.add(null);
        }
    }
    
    public void build(Node node, List<Integer> bits){
        if (node.isLeaf()){
            codeTable.set(node.returnKey(), new ArrayList(bits));
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
        return codeTable.get(c);
    }
    
    public Node returnRoot(){
        return root;
    }
    
    public List<List<Integer>> returnCodeTable(){
        return this.codeTable;
    }
}