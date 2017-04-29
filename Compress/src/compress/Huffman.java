/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compress;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/**
 *
 * @author thureson
 */
public class Huffman {
    
    public void compress(char[] input, InputStream in, OutStream out) throws IOException{
//        ArrayList<Integer> ins = new ArrayList<>();
//        while (true){
//            int r = in.read();
//            if (r == 0){
//                break;
//            }
//            ins.add(r);
//        }
        
        int[] freqTable = freqTable(input);
//        int[] ft = new int[256];
//        for (int i : ins){
//            ft[i]++;
//        }


        Node root = huffmanTree(freqTable);
        Coding coding = new Coding(root);
        coding.build(root, new ArrayList<>());
        Encoder encoder = new Encoder(out, coding);
        List<List<Integer>> cTable = coding.returnCodingTable();
        
        for (int count = 0; count < cTable.size(); count++){
            List<Integer> inner = cTable.get(count);
            System.out.println(inner + " " + (char) count);
        }
        
        /* TESTREA */
        Helper helper = new Helper();
        helper.printNodes(root);
        
        /* header */
        Header header = new Header(out);
        header.writeNodes(root);
        
        /* encoding */
        while (true){
            int c = in.read();
            if (c == -1){
                break;
            }
            encoder.write(c);
        }
        
//        while (true){
//            int c = in.read();
//            encoder.write(c);
//        }
    }
    
    public void decompress(InStream in, OutStream out) throws IOException{
        int[] freqTable = freqTableDecoded(in);
        Node root = huffmanTree(freqTable);
        
        Node temp = root;
        int count = 0;
        while (true){
//            if (count == 17){
//                break;
//            }
            
            if (temp.isLeaf()){
                out.writeChar(temp.returnKey());
                temp = root;
                count++;
            }
            int c = in.read();
            if (c == -1){
                break;
            }
            if (c == 0){
                temp = temp.returnLeft();
            } else if (c == 1){
                temp = temp.returnRight();
            }
            
        
        }
    }
    
    public static Node huffmanTree(int[] freqTable){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (char i = 0; i < 256; i++){
            if (freqTable[i] > 0){
                pq.add(new Node(i, null, null, freqTable[i]));
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
    
    public static int[] freqTable(char[] input){
        int[] freqTable = new int[256];
        for (int i = 0; i < input.length; i++){
            freqTable[input[i]]++;
        }
        return freqTable;
    }
    
    public static int[] freqTableDecoded(InStream in) throws IOException{
        int[] freqTable = new int[256];
        int max = in.readByte();
        for (int count = 0; count < max; count++){
            int character = in.readByte();
            int amount = in.readByte();
            freqTable[character] = amount;
        }
        return freqTable;
    }
}
