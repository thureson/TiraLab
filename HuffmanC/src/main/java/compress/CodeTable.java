package compress;

import java.util.ArrayList;
import java.util.List;

/**
* Operations for table that contains encoding for 
* each char as list of Integers (bits)
*/

public class CodeTable {
    
//    private OwnArrayList<OwnArrayList<Integer>> codeTable;
    private List<List<Integer>> codeTable;
    private Node root;
    
    /**
    * Constructor
    * @param root Root of the huffman-tree
    */
    
    public CodeTable(Node root){
//        this.codeTable = new OwnArrayList<OwnArrayList<Integer>>();
        this.codeTable = new ArrayList<List<Integer>>();
        this.root = root;
        for (int i = 0; i < 257; i++){
            codeTable.add(null);
        }
    }
    
    /**
    * Create encoding for each char going through huffman-tree
    * @param node Node being used
    * @param bits List of bits, filled more each recursion.
    */
    
    public void build(Node node, ArrayList<Integer> bits) throws Exception{
        if (node.isLeaf()){
//            OwnArrayList array = new OwnArrayList<>();
            ArrayList<Integer> array = new ArrayList<>(bits);
//            array.add(bits);
            codeTable.set(node.returnKey(), array);
        } else {
            bits.add(0);
            build(node.returnLeft(), bits);
            bits.remove(bits.size()-1);
            bits.add(1);
            build(node.returnRight(), bits);
            bits.remove(bits.size()-1);
        }
    }
    
    public List<Integer> returnCode(int c) throws Exception{
        return codeTable.get(c);
    }
    
    public Node returnRoot(){
        return root;
    }
    
    public List<List<Integer>> returnCodeTable(){
        return this.codeTable;
    }
}